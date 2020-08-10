/**
 * @author nmtl_ygw
 * @Description
 * @date 4/7/2020 下午 7:44
 */
public class Demo  {
    private static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        //创建一个不断读取的线程
        new Thread(() ->{
                while(flag){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("1 + :");

                }
        }).start();

        Thread.sleep(2000);

        //创建修改变量的线程
        new Thread(()->{
            flag = false;
            System.out.println("线程修改变量");
        }).start();
    }
}
