import java.util.ArrayList;

/**
 * @author nmtl_ygw
 * @Description
 * @date 15/7/2020 上午 10:24
 */

public class MainDemo {
    private static String name;
    private String gender;
    public void memberInner(){
         String name = "ygw";
        class Student{
            public void method(){
                System.out.println("局部内部类" + name);
            }
        }
        new Student().method();
    }
}
