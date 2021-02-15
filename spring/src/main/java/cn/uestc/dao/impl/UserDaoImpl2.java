package cn.uestc.dao.impl;

import cn.uestc.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author Zhengxing Guan
 * @create 2021-01-29 22:01
 */
@Repository(value = "userDaoImpl2")
public class UserDaoImpl2 implements UserDao {
    @Override
    public void updateUser() {
        System.out.println("UserDaoImpl2 实现业务");
    }
}
