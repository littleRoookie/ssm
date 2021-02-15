package cn.uestc.aop.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Zhengxing Guan
 * @time 2021-02-15 20:08
 * @description
 */
@Component
@Aspect  //生成代理对象
@Order(2)
public class UserAspect2 {
        //相同切入点抽取
        @Pointcut(value = "execution(* cn.uestc.aop.anno.User.add(..))")
        public void pointdemo() {

        }

        //前置通知
        //@Before注解表示作为前置通知
        @Before(value = "pointdemo()")//相同切入点抽取使用！
        public void before() {
            System.out.println("【UserAspect2】before.........");
        }

        //后置通知（返回通知）
        @AfterReturning(value = "execution(* cn.uestc.aop.anno.User.add(..))")
        public void afterReturning() {
            System.out.println("【UserAspect2】afterReturning.........");
        }

        //最终通知
        @After(value = "execution(* cn.uestc.aop.anno.User.add(..))")
        public void after() {
            System.out.println("【UserAspect2】after.........");
        }

        //异常通知
        @AfterThrowing(value = "execution(* cn.uestc.aop.anno.User.add(..))")
        public void afterThrowing() {
            System.out.println("【UserAspect2】afterThrowing.........");
        }

        //环绕通知
        @Around(value = "execution(* cn.uestc.aop.anno.User.add(..))")
        public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
            System.out.println("【UserAspect2】环绕之前.........");

            //被增强的方法执行
            Object res = proceedingJoinPoint.proceed();

            System.out.println("【UserAspect2】环绕之后.........");
            return null;
//        return res;
        }
}
