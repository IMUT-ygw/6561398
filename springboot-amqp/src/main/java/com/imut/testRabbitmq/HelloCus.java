package com.imut.testRabbitmq;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author nmtl_ygw
 * @Description
 * @date 7/7/2020 上午 10:27
 */
@Component
@RabbitListener(queuesToDeclare =@Queue("hello"))  //持久化 非独占
public class HelloCus {
    @RabbitHandler
    public void receivel(String message){
        System.out.println("消息："+message);
    }


}
