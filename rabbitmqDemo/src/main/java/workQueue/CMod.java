package workQueue;

import Utils.RabbitMqUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/7/1 9:29
 */
public class CMod {
    public static void main(String[] args) throws IOException {

        Connection connection = RabbitMqUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("work",true,false,false,null);
        channel.basicQos(1);
        channel.basicConsume("work", false,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费一 : "+new String(body));
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });
    }
}
