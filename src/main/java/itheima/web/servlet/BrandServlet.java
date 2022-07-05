package itheima.web.servlet;

import com.alibaba.fastjson.JSON;
import itheima.pojo.Brand;
import itheima.pojo.PageBean;
import itheima.service.BrandService;
import itheima.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {
    private BrandService brandService = new BrandServiceImpl();
    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用Service
        List<Brand> brands = brandService.selectAll();
        //转为json
        String jsonString = JSON.toJSONString(brands);
        //写数据
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收品牌数据
        BufferedReader br = req.getReader();
        String params = br.readLine();
        //转为brand对象
        Brand brand = JSON.parseObject(params, Brand.class);
        //调用service添加
        brandService.add(brand);
        //成功标识
        resp.getWriter().write("success");

    }
    public void deleteByIds(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收数据
        BufferedReader br = req.getReader();
        String params = br.readLine();
        //转为Int[]
        int[] ids = JSON.parseObject(params, int[].class);
        //调用service添加
        brandService.deleteByIds(ids);
        //成功标识
        resp.getWriter().write("success");
    }
    public void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收数据 当前页码 每页展示数 url?currentPage=1&pageSize=5
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");
        //转为int
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        //调用service查询
        PageBean<Brand> pageBean = brandService.selectByPage(currentPage, pageSize);
        //转为json
        String jsonString = JSON.toJSONString(pageBean);
        //写数据
        resp.setContentType("text/json,charset=utf-8");
        resp.getWriter().write(jsonString);
    }
    //分页条件查询
    public void selectByPageAndCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收数据 当前页码 每页展示数 url?currentPage=1&pageSize=5
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");
        //转为int
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        //获取查询条件
        BufferedReader br = req.getReader();
        String params = br.readLine();
        Brand brand = JSON.parseObject(params, Brand.class);
        //调用service查询
        PageBean<Brand> pageBean = brandService.selectByPageAndCondition(currentPage, pageSize,brand);
        //转为json
        String jsonString = JSON.toJSONString(pageBean);
        //写数据
        resp.setContentType("text/json,charset=utf-8");
        resp.getWriter().write(jsonString);
    }




}
