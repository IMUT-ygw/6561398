package fanout;

import Utils.RabbitMqUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/7/2 9:39
 */
public class CusDemo02 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("log","fanout");

        //创建临时通道
        String queue = channel.queueDeclare().getQueue();

        //队列绑定交换机  参数一  ：队列名  参数二 ： 交换机名
        channel.queueBind(queue,"log","");

        channel.basicConsume(queue,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("广播02： " + new String(body));
            }
        });
    }
}
