package test;

import cn.uestc.bean.Teacher;
import cn.uestc.dao.TeacherDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zhengxing Guan
 * @time 2021-02-10 0:33
 * @description
 */
public class Test1 {
    SqlSessionFactory sqlSessionFactory;
    @Before
    public void initFactory() throws IOException {
        String resource="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testAdd(){

        try(SqlSession openSession = sqlSessionFactory.openSession()) {
            TeacherDao teacherDao = openSession.getMapper(TeacherDao.class);
            Teacher teacher = new Teacher(null, "zzz22x", "Maths");
            System.out.println(teacher);
            int i = teacherDao.addTeacher(teacher);
            System.out.println(teacher);
            System.out.println(i);
            openSession.commit();
            System.out.println(teacher);

        }

    }

    @Test
    public void testDelete(){
        try(SqlSession openSession= sqlSessionFactory.openSession(true)){
            TeacherDao teacherDao = openSession.getMapper(TeacherDao.class);
            boolean b = teacherDao.deleteTeacher(5);
            System.out.println(b);
        }
    }

    @Test
    public void testUpdate(){

        try(SqlSession sqlSession=sqlSessionFactory.openSession(true)) {
            TeacherDao teacherDao = sqlSession.getMapper(TeacherDao.class);
            int i = teacherDao.updateTeacher(new Teacher(6, "zmt", "yuwen"));
            System.out.println(i);
        }
    }

    @Test
    public void testGet(){

        try(SqlSession sqlSession=sqlSessionFactory.openSession(true)) {
            TeacherDao teacherDao = sqlSession.getMapper(TeacherDao.class);
            Teacher teacher = teacherDao.getTeacherByIdAndName(6,"zmt");
            System.out.println(teacher);
        }
    }

    @Test
    public void testGetByMap(){

        try(SqlSession sqlSession=sqlSessionFactory.openSession(true)) {
            TeacherDao teacherDao = sqlSession.getMapper(TeacherDao.class);
            Map<String,Object> map= new HashMap<>();
            map.put("name","zmt");
            map.put("id",6);
            Teacher teacher = teacherDao.getTeacherByMap(map);
            System.out.println(teacher);
        }
    }

    @Test
    public void testGetList(){

        try(SqlSession sqlSession=sqlSessionFactory.openSession(true)) {
            TeacherDao teacherDao = sqlSession.getMapper(TeacherDao.class);
            List<Teacher> list = teacherDao.getTeachers();
            for (Teacher teacher : list) {
                System.out.println(teacher);
            }
        }
    }

    @Test
    public void testGetTeacherByIdReturnMap(){

        try(SqlSession sqlSession=sqlSessionFactory.openSession(true)) {
            TeacherDao teacherDao = sqlSession.getMapper(TeacherDao.class);
            Map<String, Teacher> teacherByIdReturnMap = teacherDao.getTeacherByIdReturnMap(6);
            for (Map.Entry<String,Teacher> entry:teacherByIdReturnMap.entrySet()){
                System.out.println("key:"+entry.getKey());
                System.out.println("value:"+entry.getValue());
            }
        }
    }

    @Test
    public void getTeachersReturnMap(){

        try(SqlSession sqlSession=sqlSessionFactory.openSession(true)) {
            TeacherDao teacherDao = sqlSession.getMapper(TeacherDao.class);
            Map<String, Teacher> teacherByIdReturnMap = teacherDao.getTeachersReturnMap();
            for (Map.Entry<String,Teacher> entry:teacherByIdReturnMap.entrySet()){
                System.out.println("key:"+entry.getKey());
                System.out.println("value:"+entry.getValue());
            }
        }
    }

    @Test
    public void getTeachersByCondition(){

        try(SqlSession sqlSession=sqlSessionFactory.openSession(true)) {
            TeacherDao teacherDao = sqlSession.getMapper(TeacherDao.class);
            Teacher teacher = new Teacher();
            teacher.setId(1);
            teacher.setName("aaaa");
//            teacher.setLesson("AAAA");
            Teacher teacher1 = teacherDao.getTeacherByCondition(teacher);
            System.out.println(teacher1);
        }
    }

    @Test
    public void getTeachersIn(){

        try(SqlSession sqlSession=sqlSessionFactory.openSession(true)) {
            TeacherDao teacherDao = sqlSession.getMapper(TeacherDao.class);
            List<Teacher> teacherList = teacherDao.getTeacherIn(Arrays.asList(1, 2, 3, 4, 5));
            for (Teacher teacher : teacherList) {
                System.out.println(teacher);
            }
        }
    }

    @Test
    public void getTeachersByConditionChoose(){

        try(SqlSession sqlSession=sqlSessionFactory.openSession(true)) {
            TeacherDao teacherDao = sqlSession.getMapper(TeacherDao.class);
            Teacher teacher = new Teacher();
//            teacher.setId(1);
//            teacher.setName("aaaa");
//            teacher.setLesson("AAAA");
            List<Teacher> teacher1 = teacherDao.getTeacherByConditionChoose(teacher);
            for (Teacher teacher2 : teacher1) {
                System.out.println(teacher2);
            }
        }
    }

    @Test
    public void updateTeacherLabelSet(){

        try(SqlSession sqlSession=sqlSessionFactory.openSession(true)) {
            TeacherDao teacherDao = sqlSession.getMapper(TeacherDao.class);
            Teacher teacher = new Teacher();
            teacher.setId(8);
//            teacher.setName("aaaadfsd");
            teacher.setLesson("AAAsdf豆腐干sdA");
            int i = teacherDao.updateTeacherLabelSet(teacher);
            System.out.println(i);
        }
    }

}
