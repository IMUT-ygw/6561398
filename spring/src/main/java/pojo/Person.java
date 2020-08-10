package pojo;

import java.util.List;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/3/15 8:41
 */
public class Person {
    private Integer id;
    private String name;

    public Person() {
        System.out.println("1、创建实例");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        System.out.println("2、为属性赋值");
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        System.out.println("4、对象被使用");
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    public void init(){
        System.out.println("3、对象初始化");
    }
    public void destroy(){
        System.out.println("5、对象被销毁");
    }
}
