package Utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/30 18:31
 */
public class RabbitMqUtils {
    //重量级工厂，只希望加载一次
    private static ConnectionFactory connectionFactory;
    static{
        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("49.235.35.249");
        connectionFactory.setPort(5672);
        //设置连接的虚拟主机
        connectionFactory.setVirtualHost("/ems");
        //只有有权限的用户才能访问，设置用户
        connectionFactory.setUsername("ems");
        connectionFactory.setPassword("123");
    }
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = connectionFactory.newConnection();
        } catch (Exception e) {
            return null;
        }
        return connection;
    }

    public static void closeConnection(Connection connection, Channel channel){
        try {
            if(channel !=null){
                channel.close();
            }
            if(connection != null){
                connection.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
