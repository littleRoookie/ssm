package cn.uestc.transaction.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author Zhengxing Guan
 * @create 2021-02-02 0:58
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void reduceMoney() {
        String sql="update transactions set money=money-? where name=?";
        jdbcTemplate.update(sql,100,"gzx");
    }

    @Override
    public void addMoney() {
        String sql="update transactions set money=money+? where name=?";
        jdbcTemplate.update(sql,100,"zmt");
    }


}
