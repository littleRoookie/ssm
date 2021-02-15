import cn.uestc.config.SpringConfig;
import cn.uestc.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Zhengxing Guan
 * @create 2021-01-29 20:24
 */
public class TestAN {
    @Test
    public void test1(){
        ApplicationContext context = new  ClassPathXmlApplicationContext("ano.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.updateUserInfo();
    }

    @Test
    public void test2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);  //这里是不同的
        UserService userService = context.getBean("userService", UserService.class);
        userService.updateUserInfo();
    }

}
