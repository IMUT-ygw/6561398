package com.imut.dao;

import com.imut.entities.Customer;
import com.imut.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/4/28 11:45
 */
@Mapper
public interface LoginDao {

        @Select("select * from customer where customer_telephone = #{username} and customer_password = #{password}")
        Customer login(String username, String password);

}
