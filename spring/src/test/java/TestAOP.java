import cn.uestc.aop.anno.IUser;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Zhengxing Guan
 * @create 2021-01-31 23:05
 */
public class TestAOP {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("springAOP.xml");
        //Bean named 'user' is expected to be of type 'cn.uestc.aop.anno.User' but was actually of type 'com.sun.proxy.$Proxy37'
//        IUser user = context.getBean("user", User.class);
        IUser user = context.getBean("user", IUser.class);
//        System.out.println(user); //cn.uestc.aop.anno.User@34c01041
//        System.out.println(user.getClass()); //class com.sun.proxy.$Proxy37
        user.add();
    }
}
