import java.util.ArrayList;
import java.util.List;

/**
 * @author nmtl_ygw
 * @Description
 * @date 4/7/2020 下午 8:00
 */
public class Demo2 {
    private static int number = 0;
    public static void main(String[] args) {
        //线程要执行的方法
        Runnable runnable = ()->{
            for (int i = 0; i < 1000; i++) {
                number++;
            }  
        };
        //创建一个线程集合
        List<Thread> list = new ArrayList<>();
        //创建五个线程
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(runnable);
            t.start();
            list.add(t);
        }
        //遍历每个线程
        list.forEach(i ->{
            try {
                i.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(number);

    }
}
