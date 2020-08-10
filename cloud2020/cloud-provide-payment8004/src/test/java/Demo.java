import java.util.ArrayList;
import java.util.Stack;

/**
 * @author nmtl_ygw
 * @Description
 * @date 15/7/2020 上午 9:30
 */
public interface Demo {
    String name = "ygw";

    public  abstract String method();

    public static String m(){
        return "www";
    }

    public default void m1(){
        System.out.println("aasd");
    }

}
