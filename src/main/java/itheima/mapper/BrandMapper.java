package itheima.mapper;

import itheima.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(Brand brand);
    void deleteByIds(@Param("ids") int[] ids);
    //分页查询

    List<Brand> selectByPage(@Param("begin") int begin, @Param("size") int size);

    //查询总记录数
    @Select("select count(*) from tb_brand")
    int selectTotalCount();

    //分页条件查询

    List<Brand> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size,@Param("brand") Brand brand);

    //查询总记录数
    int selectTotalCountByCondition(Brand brand);


}
