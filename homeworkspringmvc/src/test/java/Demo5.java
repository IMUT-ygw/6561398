/**
 * @author nmtl_ygw
 * @Description  反汇编
 * @date 5/7/2020 下午 4:37
 */
public class Demo5 {
    private static Object obj = new Object();
    public static void main(String[] args) {
        synchronized (obj){
            System.out.println("1");
        }
    }
    public static synchronized  void method(){
        System.out.println("a");
    }
}
