package com.imut.testRabbitmq;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author nmtl_ygw
 * @Description
 * @date 7/7/2020 上午 11:21
 */
@Component
public class RoutingDemo {
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "routing",type = "direct"),
                    key = {"info","ygw"}
            )
    })
    private void recive01(String message){
        System.out.println("路由01：" + message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "routing",type = "direct"),
                    key = {"info"}
            )
    })
    private void recive02(String message){
        System.out.println("路由02：" + message);
    }
}
