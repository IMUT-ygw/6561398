import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author nmtl_ygw
 * @Description  不可中断特性
 * @date 5/7/2020 下午 4:07
 */
public class Demo4 {
    private static Lock l = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        method3();
    }

    public static void method() throws InterruptedException {
        Runnable runnable = () ->{
            synchronized (Demo4.class){
                String name = Thread.currentThread().getName();
                System.out.println(name+"进入同步代码块");
                try {
                    Thread.sleep(8888888);
                } catch (InterruptedException e) {


                }
            }
        };

        Thread t = new Thread(runnable);
        t.start();
        t.sleep(1000);


        Thread t1 = new Thread(runnable);
        t1.start();

        System.out.println("停止前~~~~~~~~~~~");

        t1.interrupt();//停止线程

        System.out.println("停止后~~~~~~~~~~~");


        System.out.println(t.getState());
        System.out.println(t1.getState());
    }
    public static void method2() throws InterruptedException {
        Runnable runnable = () ->{
            l.lock();
            String name = Thread.currentThread().getName();
            System.out.println(name+"进入同步代码块");
            try {
                Thread.sleep(8888888);
            } catch (InterruptedException e) {
            }finally {
                l.unlock();
            }

        };

        Thread t = new Thread(runnable);
        t.start();
        t.sleep(1000);


        Thread t1 = new Thread(runnable);
        t1.start();

        System.out.println("停止前~~~~~~~~~~~");

        t1.interrupt();//停止线程

        System.out.println("停止后~~~~~~~~~~~");


        System.out.println(t.getState());
        System.out.println(t1.getState());
    }

    public static void method3() throws InterruptedException {
        Runnable runnable = () ->{
            String name = Thread.currentThread().getName();
            boolean b = false;
            try {
                b = l.tryLock(3, TimeUnit.SECONDS);
                if(b){
                    System.out.println(name+"进入同步代码块");
                    Thread.sleep(8888888);
                }else {
                    System.out.println(name+ "没有拿到锁在指定时间");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                if(b){
                    l.unlock();
                    System.out.println("释放锁");
                }

            }



        };

        Thread t = new Thread(runnable);
        t.start();
        t.sleep(1000);


        Thread t1 = new Thread(runnable);
        t1.start();

//        System.out.println("停止前~~~~~~~~~~~");
//
//        t1.interrupt();//停止线程
//
//        System.out.println("停止后~~~~~~~~~~~");
//
//
//        System.out.println(t.getState());
//        System.out.println(t1.getState());
    }
}
