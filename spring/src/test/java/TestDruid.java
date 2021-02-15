import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Zhengxing Guan
 * @create 2021-01-29 16:59
 */
public class TestDruid {
    @Test
    public void test1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("databaseConnectionPool.xml");
        DruidDataSource dataSource = context.getBean("dataSource", DruidDataSource.class);
        try {
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
