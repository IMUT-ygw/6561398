import com.imut.config.MainConfig;
import com.imut.pojo.MyFactorBean;
import com.sun.org.apache.xpath.internal.objects.XObject;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.imut.pojo.Person;
import org.springframework.core.env.Environment;

import java.util.Arrays;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/4/24 19:16
 */
public class Demo {
    @Test
    public void method(){
        ApplicationContext ioc = new AnnotationConfigApplicationContext(MainConfig.class);
        //获取的所有容器中的bean
        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        for (String bean : beanDefinitionNames){
            System.out.println(bean);
        }
        Object myFactoryBean = ioc.getBean("&myFactorBean");
        System.out.println(myFactoryBean.getClass());

    }

    @Test
    public void method01(){
        ApplicationContext ioc = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = ioc.getBeanDefinitionNames();

    }


}
