import cn.uestc.dao.impl.Customer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Zhengxing Guan
 * @create 2021-02-02 23:40
 */
public class testBeans {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
//        UserDaoImpl userDao = context.getBean("userDao", UserDaoImpl.class);
//        System.out.println(userDao);
        Customer customer = context.getBean("customer", Customer.class);
        System.out.println(customer);
    }
}
