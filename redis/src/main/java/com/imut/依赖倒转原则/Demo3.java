package com.imut.依赖倒转原则;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/2/29 16:26
 */
public class Demo3 {
    public static void main(String[] args) {
        Person p = new Person();
        p.recive(new Aa());
        p.recive(new Bb());
    }
}
/**
 * 接口
 */
interface IRecive{
    public String getInfo();
}

/**
 * 接口实现类
 */
class Aa implements IRecive{
    @Override
    public String getInfo() {
        return "获取A消息";
    }
}

/**
 * 接口实现类(当我们邢增具体实现方法时，不需要改变person，只是在获取方法上进行改进)
 */
class Bb implements IRecive{
    @Override
    public String getInfo() {
        return "获取B消息";
    }
}

/**
 * 依赖接口，不依赖具体实现
 */
class Person{
    public void recive(IRecive iRecive){
        System.out.println( iRecive.getInfo());
    }
}

/**
 * 此类依赖了具体实现，看似方便快捷，当扩展时麻烦
 */
class PersonDemo{
    public void recive(Aa aa){
        System.out.println(aa.getInfo());
    }
}
