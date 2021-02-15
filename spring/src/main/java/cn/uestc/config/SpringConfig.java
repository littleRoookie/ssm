package cn.uestc.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author Zhengxing Guan
 * @create 2021-01-29 22:44
 */
@Configuration //配置类，替代xml文件
@ComponentScan(basePackages = {"cn.uestc.transaction"})  //等价于：<context:component-scan base-package="cn.uestc"/>
@EnableTransactionManagement //开启事务管理
public class SpringConfig {
    //设置数据源
    @Bean  //返回的对象直接放入到了容器中
    public DruidDataSource getDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql:///springs?useSSL=false");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("gzx5320414");
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return druidDataSource;
    }
    //创建jdbcTemplate对象
    @Bean  //参数对象直接到容器中去取了
    public JdbcTemplate getJdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
    //设置事务管理对象
    @Bean
    public TransactionManager getTransactionManager(DataSource dataSource){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }

}
