package cn.uestc.dao;

import cn.uestc.bean.Teacher;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Zhengxing Guan
 * @time 2021-02-10 0:21
 * @description
 */
public interface TeacherDao {
    int addTeacher(Teacher teacher);

    boolean deleteTeacher(Integer id);

    int updateTeacher(Teacher teacher);

    Teacher getTeacher(Integer id);
    Teacher getTeacherByIdAndName(Integer id,String name);
    Teacher getTeacherByMap(Map<String,Object> map);

    List<Teacher> getTeachers();

    Map<String,Teacher> getTeacherByIdReturnMap(Integer id);

    @MapKey("name")
    Map<String,Teacher> getTeachersReturnMap();

    Teacher getTeacherByCondition(Teacher teacher);

    List<Teacher> getTeacherIn(@Param("idList") List<Integer> idList);

    List<Teacher> getTeacherByConditionChoose(Teacher teacher);

    int updateTeacherLabelSet(Teacher teacher);

}
