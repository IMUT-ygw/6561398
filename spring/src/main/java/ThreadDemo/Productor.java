package ThreadDemo;

/**
 * @author nmtl_ygw
 * @Description 生产者
 * @date 2020/3/25 21:09
 */
public class Productor extends Thread {
    private ProductPool productPool;
    public Productor(ProductPool productPool){
        this.productPool = productPool;
    }
    @Override
    public void run(){
        while(true){
            String name = (int)(Math.random() *100) + "号产品";
            System.out.println("生产了一件"+name);
            Product p = new Product(name);
            try {
                this.productPool.push(p);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
