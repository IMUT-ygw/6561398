package direct;

import Utils.RabbitMqUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/7/2 10:17
 */
public class CustomerDemo {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("logs_direct","direct");

        //创建零食队列
        String queue = channel.queueDeclare().getQueue();
        //路由绑定队列 唯一标识 参数三
        channel.queueBind(queue,"logs_direct","error");

        channel.basicConsume(queue,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者一： error : "+new String(body));

            }
        });
    }


}
