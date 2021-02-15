package cn.uestc.bean;

/**
 * @author Zhengxing Guan
 * @time 2021-02-10 0:18
 * @description
 */
public class Teacher {
    private Integer id;
    private String name;
    private String lesson;

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lesson='" + lesson + '\'' +
                '}';
    }

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

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public Teacher() {
    }

    public Teacher(Integer id, String name, String lesson) {
        this.id = id;
        this.name = name;
        this.lesson = lesson;
    }
}
