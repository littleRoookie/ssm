package cn.uestc.transaction.service;

import cn.uestc.transaction.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Zhengxing Guan
 * @create 2021-02-02 0:59
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ) //默认
public class UserService {
    @Autowired
    private UserDao userDao;


    public void changeMoney(){
            //1.开启事务操作


            //2.进行业务操作
            userDao.reduceMoney();
            //模拟异常
            int i=1/0;
            userDao.addMoney();
            //3.没有发生异常，提交事务

            //4.出现异常，事务回滚


    }
}
