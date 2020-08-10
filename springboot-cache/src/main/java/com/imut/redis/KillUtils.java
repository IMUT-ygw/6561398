package com.imut.redis;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.Set;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/6/25 10:34
 */
public class KillUtils {
    public boolean result(String prodId,String userId){
        String kill_prod = prodId;
        String kill_user = "kill_user"+userId+"kc";
        //仓库没货
        Jedis jedis = new Jedis("127.0.0.1",6379);
        String s = jedis.get(kill_prod);
        if(s == null){
            System.out.println("秒杀没开始");
            jedis.close();
            return false;
        }
        //仓库有货
        if(Integer.parseInt(s) <= 0){
            System.out.println("没货了");
            return false;
        }
        if(jedis.exists(kill_user)){
            System.out.println("已经秒杀成功！不能重复秒杀");
            jedis.close();
            return false;
        }
        Transaction multi = jedis.multi();
        multi.decr(kill_prod);
        multi.set(kill_user,userId);
        List<Object> exec = multi.exec();
        //null 指事务执行失败
        if(exec==null || exec.size()==0){
            System.out.println("秒杀失败");
            jedis.close();
            return false;
        }

        System.out.println("用户："+kill_user + "秒杀成功");
        jedis.close();
        return true;
    }
}
