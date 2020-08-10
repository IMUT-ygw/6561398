package model01;

import Utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.TimeoutException;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/30 17:27
 */
public class Provider {
    @Test
    public void testSendMsg() throws IOException, TimeoutException {
        //通过工具类获取对象
        Connection connection = RabbitMqUtils.getConnection();
        //获取链接通道
        Channel channel = connection.createChannel();
        //通道绑定消息队列,不存在自动创建
        //参数一：通道名称
        //参数二：队列是否要持久化
        //参数三：是否独占队列
        //参数四：是否先消费完成删除
        //参数五：
        channel.queueDeclare("aa",true,false,true,null);
        //发布消息
        //参数一：交换机名称
        //参数二：队列名称
        //参数三：传递消息额外设置，可配置数据持久化
        //参数四：消息具体内容
        channel.basicPublish("","aa", MessageProperties.PERSISTENT_TEXT_PLAIN,"hello rabbitmq aa".getBytes());
        //关闭链接
        RabbitMqUtils.closeConnection(connection,channel);
    }
}
