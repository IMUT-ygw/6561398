package method;

import serivce.FactoryBeanDemo;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/3/26 10:41
 */
public class Main {
}
class Father{
    //非虚方法--静态方法
    public static void showStatic(String string){
        System.out.println("father:" + string);
    }
    //非虚方法--final方法
    public void showFinal(String string){
        System.out.println("father:" + string);
    }
    //非虚方法--私有方法
    private void showPrivate(String string){
        System.out.println("father:" + string);
    }
}
class Son extends Father{
    public Son() {
        super();
    }
    public Son(String name){
        this();
    }

    //非虚方法--静态方法
    public static void showStatic(String string){
        System.out.println("son:" + string);
    }


    //非虚方法--私有方法
    private void showPrivate(String string){
        System.out.println("son:" + string);
    }
    public void show(){
        showPrivate("私有方法");
        showStatic("静态");
        super.showFinal("父类final");
        super.showStatic("父类静态");
        showFinal("父类");
    }
}
