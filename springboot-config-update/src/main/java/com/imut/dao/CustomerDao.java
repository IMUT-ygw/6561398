package com.imut.dao;

import com.imut.entities.Customer;
import com.imut.entities.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.Collection;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/4/29 8:45
 */
@Mapper
public interface CustomerDao {

    @Select("select * from customer order by id")
    @Results(id = "customer",value = {
            @Result(column = "id" , property = "id" , id = true ,jdbcType = JdbcType.INTEGER),
            @Result(column = "customer_name" , property = "customerName",jdbcType = JdbcType.VARCHAR),
            @Result(column = "customer_telephone",property ="customerTelephone",jdbcType = JdbcType.VARCHAR),
            @Result(column = "customer_password",property ="customerPassword",jdbcType = JdbcType.VARCHAR),
            @Result(column = "customer_gender",property = "customerGender",jdbcType = JdbcType.INTEGER),
            @Result(column = "customer_address",property = "customerAddress",jdbcType = JdbcType.VARCHAR)
    })
    Collection<Customer> findAll();


    @Select("select * from customer where customer_telephone = #{customerTelephone}")
    @ResultMap("customer")
    Customer findByTelephone(String customerTelephone);


    @Insert("insert into customer(customer_name,customer_telephone,customer_password,customer_gender,customer_address)" +
            "values(#{customerName},#{customerTelephone},#{customerPassword},#{customerGender},#{customerAddress})")
    @Options(keyProperty = "id" , keyColumn = "id" , useGeneratedKeys = true)
    Integer addCustomer(Customer customer);

    @Delete("delete from customer where customer_telephone = #{telephone}")
    void deleteCustomer(String telephone);



}
