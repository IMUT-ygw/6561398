package serivce;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.sql.DriverManager;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/3/21 16:36
 */
public class ClassLoaderDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        //通过反射获取类加载器
        ClassLoader classLoader = Class.forName("java.lang.String").getClassLoader();
        System.out.println(classLoader);

        //通过当前线程上下文Thread.currentThread
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader);

        //获取当前系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader().getParent();
        System.out.println(systemClassLoader);

    }
}
