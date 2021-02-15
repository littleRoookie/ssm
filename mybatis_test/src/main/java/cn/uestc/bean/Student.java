package cn.uestc.bean;

/**
 * @author Zhengxing Guan
 * @time 2021-02-10 0:19
 * @description
 */
public class Student {
    private Integer id;
    private String name;
    private Integer teacherId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacherId=" + teacherId +
                '}';
    }

    public Student(Integer id, String name, Integer teacherId) {
        this.id = id;
        this.name = name;
        this.teacherId = teacherId;
    }

    public Student() {
    }
}
