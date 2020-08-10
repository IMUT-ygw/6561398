package topic;

import Utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/7/2 10:54
 */
public class ProDemo {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("topics","topic");
        String toutKey = "user.save";
        channel.basicPublish("topics",toutKey,null,"topic模型".getBytes());

        RabbitMqUtils.closeConnection(connection,channel);
    }
}
