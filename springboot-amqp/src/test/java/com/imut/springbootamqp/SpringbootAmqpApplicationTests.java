package com.imut.springbootamqp;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootAmqpApplicationTests {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
        //点对点
        rabbitTemplate.convertAndSend("hello","hello word");
    }

    @Test
    void contextLoads2() {
        //work模型  平均分配 多消费者
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work","work 模型");
        }
    }

    @Test
    void contextLoad3() {
        //广播 Fanout
        rabbitTemplate.convertAndSend("logs","" ,"广播");
    }


    @Test
    void contextLoad4() {
        //路由模式 Routing
        rabbitTemplate.convertAndSend("routing","info" ,"发送info的路由信息");
    }


    @Test
    void contextLoad5() {
        //动态路由 订阅模式
        rabbitTemplate.convertAndSend("topics" ,"user.ygw" ,"发送info的路由信息");
    }


}
