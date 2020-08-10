package workQueue;

import Utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;

import javax.rmi.CORBA.Util;
import java.io.IOException;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/7/1 9:29
 */
public class PMod {
    public static void main(String[] args) throws IOException {
        //创建链接
        Connection connection = RabbitMqUtils.getConnection();
        //创建通道
        Channel channel = connection.createChannel();
        //创建队列
        channel.queueDeclare("work",true,false,false,null);
        //生产消息
        for (int i = 0; i < 20; i++) {
            channel.basicPublish("","work", MessageProperties.PERSISTENT_TEXT_PLAIN,(i + " : hello work queue").getBytes());
        }
        //关闭资源
        RabbitMqUtils.closeConnection(connection,channel);
    }
}
