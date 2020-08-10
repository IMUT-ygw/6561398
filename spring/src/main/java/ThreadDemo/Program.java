package ThreadDemo;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/3/25 21:09
 */
public class Program {
    public static void main(String[] args) {
        ProductPool pool = new ProductPool(15);
        new Productor(pool).start();
        new Consumer(pool).start();
    }
}
