package cn.uestc.aop.anno;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Zhengxing Guan
 * @create 2021-01-31 22:36
 */
@Configuration
@ComponentScan(value = {"cn.uestc.aop.anno"})
@EnableAspectJAutoProxy()
public class SpringConfig {
}
