package cn.uestc.aop.anno;

import org.springframework.stereotype.Component;

/**
 * @author Zhengxing Guan
 * @create 2021-01-31 22:32
 */
//目标类（被增强类）
@Component
public class User implements IUser{
    public void add() {
        System.out.println("add.......");
//        int i=1/0;
    }
}
