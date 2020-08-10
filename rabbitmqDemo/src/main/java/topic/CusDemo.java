package topic;

import Utils.RabbitMqUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/7/2 10:57
 */
public class CusDemo {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqUtils.getConnection();
        Channel channel = connection.createChannel();
        //声明交换机
        channel.exchangeDeclare("topics","topic");
        //创建临时队列
        String queue = channel.queueDeclare().getQueue();
        //绑定队列和交换机
        channel.exchangeBind(queue,"topics","user.*");

        channel.basicConsume(queue,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(new String(body));
            }
        });
    }
}
