package itheima.service;

import itheima.pojo.Brand;
import itheima.pojo.PageBean;

import java.util.List;

public interface BrandService{
    //查询所有
    List<Brand> selectAll();
    void add(Brand brand);
    void deleteByIds(int[] ids);
    PageBean<Brand> selectByPage(int currentPage, int pageSize);
    //分页条件查询
    PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand);

}
