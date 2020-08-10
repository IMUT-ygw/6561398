package rides入门;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/2/28 16:57
 */
public class RidesDemo {

    @Test
    public void test1(){
        Jedis jedis = new Jedis("localhost",6379);
        jedis.set("username","ygw");
        //设置存活时间10s
        jedis.setex("active",10,"aaa");
    jedis.close();
    }
}
