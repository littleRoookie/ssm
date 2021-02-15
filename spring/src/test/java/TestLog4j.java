import cn.uestc.aop.anno.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author Zhengxing Guan
 * @create 2021-02-02 17:37
 */
public class TestLog4j {
    @Test
    public void test1(){
        Logger abc = LoggerFactory.getLogger("abc");
        abc.info("你好啊");
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info("你好啊");
    }

    //函数式风格创建对象，在Spring中进行注册，交给Spring管理
    @Test
    public void testGenericApplicationContext(){
        //1.创建GenericApplicationContext对象
        GenericApplicationContext context = new GenericApplicationContext();
        //2.调用context的方法对象注册
        context.refresh();
        context.registerBean("user1",User.class, User::new);
        //3.获取在spring中注册的对象
        User user = (User) context.getBean("user1");
        System.out.println(user);
    }
}
