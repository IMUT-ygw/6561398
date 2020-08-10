package ThreadDemo;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/3/25 21:13
 */
public class Consumer extends Thread {
    private ProductPool productPool;
    public Consumer(ProductPool productPool){
        this.productPool = productPool;
    }
    @Override
    public void run(){
            while(true){
            try {
                Product p = this.productPool.pop();
                System.out.println("消费了一件产品：" + p.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


