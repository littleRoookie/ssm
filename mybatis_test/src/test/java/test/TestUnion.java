package test;

import cn.uestc.bean.Key;
import cn.uestc.bean.Lock;
import cn.uestc.dao.KeyDao;
import cn.uestc.dao.LockDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Zhengxing Guan
 * @time 2021-02-10 2:07
 * @description
 */
public class TestUnion {
    SqlSessionFactory sqlSessionFactory;
    @Before
    public void initFactory() throws IOException {
        String resource="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    
    @Test
    public void testReturnObject(){
        try(SqlSession openSession=sqlSessionFactory.openSession(true)){
            KeyDao keyDao = openSession.getMapper(KeyDao.class);
            Key key = keyDao.getKeyById(1);
            System.out.println(key);
        }
    }

    @Test
    public void testReturnObjectList(){
        try(SqlSession openSession=sqlSessionFactory.openSession(true)){
            LockDao lockDao = openSession.getMapper(LockDao.class);
            Lock lock = lockDao.getLockById(1);
            System.out.println(lock);

        }
    }
}
