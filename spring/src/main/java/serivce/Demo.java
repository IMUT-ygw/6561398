package serivce;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/3/24 20:02
 */
public class Demo {
    public static void main(String[] args) {
        Runnable r1 = () -> {
            for (int i = 0; i <10 ; i++) {
                Boss.getBoss();
            }
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);

        t1.start();
        t2.start();


    }

}
class Boss{
    private  Boss(){
        System.out.println("对象被实例化一次");
    }
    private static Boss b = null;
    public static Boss getBoss() {
        synchronized ("") {
            if (b == null) {
                b = new Boss();
            }
            return b;
        }
    }
}


