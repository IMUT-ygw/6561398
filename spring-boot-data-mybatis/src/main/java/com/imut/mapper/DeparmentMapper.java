package com.imut.mapper;

import com.imut.pojo.Department;
import org.apache.ibatis.annotations.*;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/5/15 10:02
 */
//@Mapper 启动类已经声明改包下的所有类都是mapper类，所以在类下不用单独指定
public interface DeparmentMapper {
    @Select("select * from department where id = #{id}")
    Department findById(Integer id);

    @Delete("delete from department where id = #{id}")
    void  deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true , keyColumn = "id") //id是自增主键，返回插入数据时id为null,增加这个注解就会返回增长后的id了
    @Insert("insert into department(departmentName)values(#{departmentName})")
    Integer insertDept(Department department);

    @Update("update department set departmentName = #{departmentName} where id = #{id}")
    Integer updateDept(Department department);
}
