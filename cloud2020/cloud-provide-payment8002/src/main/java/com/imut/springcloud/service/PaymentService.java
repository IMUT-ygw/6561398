package com.imut.springcloud.service;

import com.imut.springcloud.entities.Payment;

/**
 * @author nmtl_ygw
 * @Description
 * @date 11/7/2020 下午 4:22
 */
public interface PaymentService {

    public int creat(Payment payment);
    public  Payment getById(Long id);
}
