package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author nmtl_ygw
 * @Description  实体管理器工厂浪费资源问题，创建一个公共的实体管理器工厂对象
 * @date 2020/5/21 9:31
 */
public class JpaUtils {
    private static  EntityManagerFactory myJpa;
    static{
        //1.加载配置文件，创建entityManagerFactory
         myJpa = Persistence.createEntityManagerFactory("myJpa");
    }

    /**
     *获取entityManager对象
     */
    public static EntityManager getEntityManager(){
        return myJpa.createEntityManager();
    }
}
