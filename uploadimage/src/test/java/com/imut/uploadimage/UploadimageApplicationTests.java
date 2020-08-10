package com.imut.uploadimage;

import com.imut.UpLoadImageApplication;
import com.imut.pojo.TextUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {UpLoadImageApplication.class})
class UploadimageApplicationTests {

    @Test
    void contextLoads() {
        TextUser t1 = new TextUser("ygw",1);
        TextUser t2 = new TextUser("ygw",1);
        System.out.println(t1 == t2);

    }

}
