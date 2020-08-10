package com.imut.testRabbitmq;

import javafx.scene.chart.ValueAxis;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author nmtl_ygw
 * @Description
 * @date 7/7/2020 上午 11:14
 */
@Component
public class FinoutDemo {
    @RabbitListener(bindings = {
            @QueueBinding(
                    value=@Queue, //创建临时队列（可指定名）
                    exchange = @Exchange(value = "logs",type = "fanout") //绑定交换机 及类型
            )})
    public void recive01(String message){
        System.out.println("fanout01" + message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value=@Queue, //创建临时队列（可指定名）
                    exchange = @Exchange(value = "logs",type = "fanout") //绑定交换机 及类型
            )})
    public void recive02(String message){
        System.out.println("fanout02" + message);
    }
}
