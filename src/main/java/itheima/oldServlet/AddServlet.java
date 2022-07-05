package itheima.oldServlet;

import com.alibaba.fastjson.JSON;
import itheima.pojo.Brand;
import itheima.service.BrandService;
import itheima.service.impl.BrandServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    private BrandService brandService = new BrandServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req, resp);
    }
}
