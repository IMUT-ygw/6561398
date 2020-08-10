package com.imut.springcloud.dao;

import com.imut.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author nmtl_ygw
 * @Description
 * @date 11/7/2020 下午 4:11
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public  Payment getById(Long id);
}
