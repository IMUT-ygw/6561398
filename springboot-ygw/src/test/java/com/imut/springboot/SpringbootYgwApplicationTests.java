package com.imut.springboot;

import com.imut.springboot.pojo.Person;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
class SpringbootYgwApplicationTests {
    //记录器
    Logger logger =  LoggerFactory.getLogger(getClass());
    @Test
    public void contextLoads(){
        //日志级别由低到高
        logger.trace("跟踪轨迹，这是trace日志");
        logger.debug("这是debug日志");
        //Springboot默认输出info及以后的内容
        logger.info("这是info日志");
        logger.warn("这是警告日志");
        logger.error("这是error日志");
    }

}
