/**
 * @author nmtl_ygw
 * @Description syncchronized可重入
 * @date 5/7/2020 下午 3:54
 */
public class Demo3 {
    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();

    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        synchronized (MyThread.class){
            System.out.println("外层");
            synchronized (MyThread.class){
                System.out.println("内层");
            }
        }
    }
}