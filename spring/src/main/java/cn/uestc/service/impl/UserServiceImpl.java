package cn.uestc.service.impl;

import cn.uestc.dao.UserDao;
import cn.uestc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;



/**
 * @author Zhengxing Guan
 * @create 2021-01-28 22:29
 */

//在注解中，value可以省略不写
//默认值是类名称，首字母小写

@Service(value = "userService") //和<bean id="" class="" /> 是一样的
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier(value = "userDaoImpl2")
    private UserDao userDao;


    /*public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/

    @Override
    public void updateUserInfo() {
        System.out.println("userService完成了业务···");
        userDao.updateUser();
    }
}
