package com.imut.testRabbitmq;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author nmtl_ygw
 * @Description
 * @date 7/7/2020 上午 10:58
 */
@Component
public class WorkRabbit {

    //创建了一个消费者
    @RabbitListener(queuesToDeclare = @Queue("work"))
    private void receive1(String message){
        System.out.println("work01" + message);
    }

    @RabbitListener(queuesToDeclare = @Queue("work"))
    private void receive2(String message){
            System.out.println("work02" + message);
    }


}
