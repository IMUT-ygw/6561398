package com.imut.springbootconfig;

import com.imut.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootConfigApplicationTests {
    @Autowired
    User u;
    @Test
   public void text(){
       System.out.println(u);
   }

}
