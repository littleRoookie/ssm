package cn.uestc.dao.impl;

import cn.uestc.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author Zhengxing Guan
 * @create 2021-01-28 22:26
 */
@Repository(value = "userDaoImpl1")
public class UserDaoImpl implements UserDao {
    @Override
    public void updateUser() {
        System.out.println("UserDaoImpl1 update user···");
    }
}
