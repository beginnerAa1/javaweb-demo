package itheima.oldServlet;

import com.alibaba.fastjson.JSON;
import itheima.pojo.Brand;
import itheima.pojo.PageBean;
import itheima.service.BrandService;
import itheima.service.impl.BrandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/selectByPageAndConditionServlet")
public class selectByPageAndConditionServlet extends HttpServlet {
    private BrandService brandService = new BrandServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        PageBean<Brand> pageBean = brandService.selectByPageAndCondition(currentPage, pageSize, brand);
        //转为json
        String jsonString = JSON.toJSONString(pageBean);
        //写数据
        resp.setContentType("text/json,charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
