import cn.uestc.bean.Teacher;
import cn.uestc.bean.TeacherExample;
import cn.uestc.dao.TeacherMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Zhengxing Guan
 * @time 2021-02-14 22:35
 * @description
 */
public class MBGtest {
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }


    @Test
    public void testPage() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        try(SqlSession sqlSession=sqlSessionFactory.openSession(true)) {
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            //紧跟这句话的一个查询就是分页查询，开始页码，每页数量
            PageHelper.startPage(1,10);
            List<Teacher> list = mapper.selectAll();
            //可以将分页查询到的结果保存到pageInfo中，里面可以统计很多的信息
            PageInfo<Teacher> teacherPageInfo = new PageInfo<>(list);
            int endRow = teacherPageInfo.getEndRow();
            System.out.println("endRow:"+endRow);
            int navigateFirstPage = teacherPageInfo.getNavigateFirstPage();
            System.out.println("navigateFirstPage:"+navigateFirstPage);
            int navigateLastPage = teacherPageInfo.getNavigateLastPage();
            System.out.println("navigateLastPage:"+navigateLastPage);
            int[] navigatepageNums = teacherPageInfo.getNavigatepageNums();
            for (int navigatepageNum : navigatepageNums) {
                System.out.print(navigatepageNum+"-----");
            }
            int nextPage = teacherPageInfo.getNextPage();
            System.out.println("nextPage:"+nextPage);
            int pageNum = teacherPageInfo.getPageNum();
            System.out.println("pageNum:"+pageNum);
            int pages = teacherPageInfo.getPages();
            System.out.println("pages:"+pages);
            int pageSize = teacherPageInfo.getPageSize();
            System.out.println("pageSize:"+pageSize);
            int prePage = teacherPageInfo.getPrePage();
            System.out.println("prePage:"+prePage);
            int size = teacherPageInfo.getSize();
            System.out.println("size:"+size);
            int startRow = teacherPageInfo.getStartRow();
            System.out.println("startRow:"+startRow);
            for (Teacher teacher : list) {
                System.out.println(teacher);
            }
        }
    }

    @Test
    public void testAddBatch() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        try(SqlSession sqlSession=sqlSessionFactory.openSession(true)) {
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            List<Teacher> list=new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                Teacher teacher = new Teacher();
                teacher.setName(UUID.randomUUID().toString().substring(0,5));
                teacher.setLesson(UUID.randomUUID().toString().substring(0,5));
                list.add(teacher);
            }
            mapper.addBatch(list);

        }
    }

    @Test
    public void test1() throws Exception {
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        File configFile = new File("mbg.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
   @Test
    public void testComplex() throws IOException {
       SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
       try(SqlSession sqlSession=sqlSessionFactory.openSession(true)){
           TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
           /*xxxExample就是封装查询条件的*/
           /*查询所有*/
           List<Teacher> teachers = mapper.selectByExample(null);
           /*查询老师名字中带有z字母的，和课程是yuwen的*/
           //封装查询条件的example
           TeacherExample teacherExample = new TeacherExample();
           //创建一个Criteria，这个Criteria就是拼装查询条件的
           TeacherExample.Criteria criteria = teacherExample.createCriteria();
           criteria.andNameLike("%z%");
           criteria.andLessonEqualTo("yuwen");

           TeacherExample.Criteria criteria1 = teacherExample.createCriteria();
           criteria1.andNameLike("%z%");
           criteria1.andLessonEqualTo("maths");

           //想要表示or的关系，整两个查询条件
           teacherExample.or(criteria1);

           //降序表示
           teacherExample.setOrderByClause("id DESC");
            //得到时怎么排序的
           String orderByClause = teacherExample.getOrderByClause();
           System.out.println("orderByClause:"+orderByClause);
            //得到Criteria的集合
           List<TeacherExample.Criteria> oredCriteria = teacherExample.getOredCriteria();
           for (TeacherExample.Criteria oredCriterion : oredCriteria) {
               System.out.println("oredCriterion:"+oredCriterion);
           }

           List<Teacher> teachers1 = mapper.selectByExample(teacherExample);
           for (Teacher teacher : teachers) {
               System.out.println(teacher);
           }
           System.out.println("================");
           for (Teacher teacher1 : teachers1) {
               System.out.println(teacher1);
           }
       }
   }
}
