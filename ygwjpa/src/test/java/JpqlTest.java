import org.junit.Test;
import utils.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * @author nmtl_ygw
 * @Description
 * @date 2020/5/21 11:04
 */
public class JpqlTest {
    /**
     * 查询全部
     */
    @Test
    public void testFindAll(){
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        //查询全部
        String sql = "from domain.Customer";
        //Query才是执行jpql得对象
        Query query = entityManager.createQuery(sql);
        List list = query.getResultList();
        for(Object obj : list){
            System.out.println(obj);
        }

        transaction.commit();
        entityManager.close();
    }
}
