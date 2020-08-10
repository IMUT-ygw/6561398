package model01;

import Utils.RabbitMqUtils;
import com.rabbitmq.client.*;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/30 18:09
 */
public class Customer {
    public static void main(String[] args) throws IOException, TimeoutException {
        test();
    }

    public static void test() throws IOException, TimeoutException {
        //通过工具类获取对象
        Connection connection = RabbitMqUtils.getConnection();
        //获取链接通道
        Channel channel = connection.createChannel();
        channel.queueDeclare("aa",true,false,true,null);
        //每次只消费一个队列中的一个消息
        channel.basicQos(1);
        //消费者队列
        //参数一：消费队列的名称
        //参数二：开始消息的自动确认
        //参数三：消费时的回调接口
        channel.basicConsume("aa",false,new DefaultConsumer(channel){
            //最后一个参数是队列中取出的消息
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(new String(body));
            }
        });
    }
}
