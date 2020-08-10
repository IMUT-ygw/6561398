package fanout;

import Utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/7/2 9:09
 */
public class ProDemo {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqUtils.getConnection();
        Channel channel = connection.createChannel();
        //声明交换机  参数一：交换机名   参数二：广播类型
        channel.exchangeDeclare("log","fanout");
        channel.basicPublish("log","",null,"fanout".getBytes());

        RabbitMqUtils.closeConnection(connection,channel);
    }
}
