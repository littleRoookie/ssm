import cn.uestc.config.SpringConfig;
import cn.uestc.transaction.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Zhengxing Guan
 * @create 2021-02-02 0:56
 */
public class TestTX {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("transaction.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.changeMoney();
    }
    @Test
    public void test2(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = applicationContext.getBean("userService", UserService.class);
        //class cn.uestc.transaction.service.UserService$$EnhancerBySpringCGLIB$$93ed20b9
        System.out.println(userService.getClass());
//        userService.changeMoney();
    }

}
