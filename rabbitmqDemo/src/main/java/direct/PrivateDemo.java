package direct;

import Utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/7/2 10:17
 */
public class PrivateDemo {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqUtils.getConnection();
        Channel channel = connection.createChannel();
        //设置交换机类型  参数二 ： 路由模式
        channel.exchangeDeclare("logs_direct","direct");
        //设置RoutingKey
        String rountingKey = "info";
        channel.basicPublish("logs_direct",rountingKey,null,"这是direct模式".getBytes());
        //关闭资源
        RabbitMqUtils.closeConnection(connection,channel);

    }
}
