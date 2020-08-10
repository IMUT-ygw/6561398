package com.imut.springcloud.service.impl;

import com.imut.springcloud.dao.PaymentDao;
import com.imut.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author nmtl_ygw
 * @Description
 * @date 11/7/2020 下午 4:23
 */
@Service
public class PaymentImpl {
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        int creat = paymentDao.create(payment);
        return creat;
    }

    public  Payment getById(Long id){
        return paymentDao.getById(id);
    }

}
