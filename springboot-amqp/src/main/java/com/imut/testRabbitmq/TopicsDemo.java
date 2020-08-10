package com.imut.testRabbitmq;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author nmtl_ygw
 * @Description
 * @date 7/7/2020 上午 11:32
 */
@Component
public class TopicsDemo {
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "topics",type = "topic"),
                    key = {"user.*"}
            )
    })
    private void receice01(String message){
        System.out.println("动态路由！" + message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "topics",type = "topic"),
                    key = {"user.#"}
            )
    })
    private void receice02(String message){
        System.out.println("动态路由！" + message);
    }
}
