package com.imut.mapper;

import com.imut.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/22 15:56
 */
@Mapper
public interface UserMapper {

    @Select("select * from user where useId = 1")
    User findAll();

}
