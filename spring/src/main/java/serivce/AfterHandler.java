package serivce;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import pojo.Person;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/3/18 17:21
 */
public class AfterHandler implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("执行后置处理器111111");
        Person p = (Person) o;
        if(p.getId().equals(1)){
            p.setName("刘刘刘");
        }else{
            p.setName("圆圆圆");
        }
        return p;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("执行后置处理器222222");
        return o;
    }
}
