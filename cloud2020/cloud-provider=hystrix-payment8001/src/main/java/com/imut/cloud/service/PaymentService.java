package com.imut.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.stereotype.Service;

/**
 * @author nmtl_ygw
 * @Description
 * @date 24/7/2020 上午 9:11
 */
@Service
public class PaymentService {

    /*
    正常访问方法
     */
    public String paymentInfo_ok(Integer id){
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_ok id:" + id + "\t" + "haha~~~";
    }

    /*
   模拟出错
   */
    //配置出错后的兜底方法
    @HystrixCommand(fallbackMethod = "paymentInfo_errorHandler" , commandProperties = {
            //3s内反应是正常的业务逻辑
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_error(Integer id){
        //运行异常或超时异常 都会出发服务降级
//        int i= 10/0;
        try {
            //睡眠 模拟超时
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_TimeOut id:" + id + "\t" + "成功！超时，耗时3s";
    }

    //上面的方法出现问题这个方法兜底
    public String paymentInfo_errorHandler(Integer id){
        return "兜底方法： \t" + Thread.currentThread().getName();
    }

}
