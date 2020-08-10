package ThreadDemo;

import java.util.LinkedList;
import java.util.List;

/**
 * @author nmtl_ygw
 * @Description  生产池
 * @date 2020/3/25 21:01
 */
public class ProductPool {
    /**
     * 存储所有产品的集合
     */
    private List<Product> productList;
    private int maxSize = 0;

    public ProductPool(int maxSize){
        //对集合进行实例化
        this.productList = new LinkedList<Product>();
        //限定产品最大值
        this.maxSize = maxSize;
    }

    /**
     * 生产者将生产的商品放到生产池
     * @param product
     */
    public synchronized void push(Product product) throws InterruptedException {
        //判断是否再生产
        if(this.productList.size() == maxSize){
            this.wait();
        }
        //将产品放入池中
        this.productList.add(product);
        //唤醒资源
        this.notifyAll();
    }

    /**
     * 消费者取出商品
     * @return
     */
    public synchronized Product pop() throws InterruptedException {
        if(this.productList.size() ==0){
            this.wait();
        }
        //取出商品
        Product remove = this.productList.remove(0);
        //通知其他人
        this.notifyAll();

        return remove;
    }


}
