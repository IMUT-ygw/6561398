
import domain.Customer;
import org.junit.Test;
import utils.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTests {
    /**
     * jpa操作步骤：
     *      1.加载配置文件创建工厂对象
     *      2.通过实体管理类工厂获取实体管理器
     *      3.获取事务对象开启事务
     *      4.完成crud
     *      5.提交事务（回滚事务）
     *      6.释放资源
     *
     */
    @Test
    public void testSave(){
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myJpa");
        EntityManager entityManager = JpaUtils.getEntityManager();
        //2.创建EntityManager
        //3.开启事务处理
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //完成操作
        Customer c = new Customer();
        c.setCustName("ygw");
        c.setCustIndustry("教育");
        entityManager.persist(c);//保存
        //提交操作
        transaction.commit();
        //释放资源
        entityManager.close();
    }

    @Test
    public void testFind(){
        //1.通过工具类创建EntityManager对象
        EntityManager entityManager = JpaUtils.getEntityManager();
        //2.创建事务对象并开启
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //3.根据id查询数据
        /*
         * find查询方法方法
         *      参数1：用于封装结果的字节码文件
         *      参数2：查询的主键取值（id的值）
         */
        Customer customer = entityManager.find(Customer.class, 1L);
        System.out.println(customer);
        //4.提交事务
        transaction.commit();
        //5.关闭资源
        entityManager.close();
    }

    /**
     * reference:与find一样都是根据id查询结果，但是reference是延迟加载，
     *          当程序中
     */
    @Test
    public void testReference(){
        //1.通过工具类创建EntityManager对象
        EntityManager entityManager = JpaUtils.getEntityManager();
        //2.创建事务对象并开启
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //3.根据id查询数据
        /*
         * find查询方法方法
         *      参数1：用于封装结果的字节码文件
         *      参数2：查询的主键取值（id的值）
         */
        Customer customer = entityManager.getReference(Customer.class, 1L);
        System.out.println(customer);
        //4.提交事务
        transaction.commit();
        //5.关闭资源
        entityManager.close();
    }

    @Test
    public void testRemove(){
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Customer customer = entityManager.find(Customer.class, 1l);
        entityManager.remove(customer);
        transaction.commit();
        entityManager.close();
    }

    @Test
    public void testUpdate(){
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Customer customer = entityManager.find(Customer.class, 2l);
        customer.setCustIndustry("it");
        Customer merge = entityManager.merge(customer);
        transaction.commit();
        entityManager.close();
    }



}
