package workQueue;

import Utils.RabbitMqUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/7/1 9:41
 */
public class CMod2 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("work",true,false,false,null);
        channel.basicConsume("work", false,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费二 : "+new String(body));
                //手动确认消息，每次执行完一个任务，进行手动确认
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });
    }
}
