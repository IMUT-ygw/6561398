package com.imut;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/2/29 9:54
 */
public class Demo {
    public static void main(String[] args) {
        A a = new A();
        a.ygw(new B());
    }

}

interface Ygw{
    void method1();
    void method2();
    void method3();
    void method4();
}

class B implements Ygw{

    @Override
    public void method1() {
        System.out.println("1");
    }

    @Override
    public void method2() {
        System.out.println("2");
    }

    @Override
    public void method3() {
        System.out.println("3");
    }

    @Override
    public void method4() {
        System.out.println("4");
    }
}
class A{
    public void ygw(Ygw y){
        y.method1();
    }
}
