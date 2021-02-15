import cn.uestc.dao.UserDao;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * @author Zhengxing Guan
 * @create 2021-01-28 22:34
 */
public class TestDI {

    @Test
    public void test1(){
        BeanFactory applicationContext = new ClassPathXmlApplicationContext("bean1.xml");
        for (int i = 0; i < 5; i++) {
            int z=i;
            new Thread(()->{

                UserDao userDao = (UserDao) applicationContext.getBean("userDao");
                int j = userDao.hashCode();
                System.out.println("第"+z+"次获取到的对象hash值是： "+j);
            }).start();
        }
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }


    }
}
