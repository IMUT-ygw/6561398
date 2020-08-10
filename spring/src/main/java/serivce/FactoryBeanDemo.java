package serivce;

import org.springframework.beans.factory.FactoryBean;
import pojo.Car;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/3/18 15:35
 */
public class FactoryBeanDemo implements FactoryBean<Car> {
    @Override
    public Car getObject() throws Exception {
        Car c = new Car();
        c.setName("奥迪");
        c.setPrice(200.0);
        return c;
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
