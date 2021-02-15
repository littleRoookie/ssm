package cn.uestc.bean;

/**
 * @author: Zhengxing Guan
 * @time: 2021-02-08 1:16
 * @description:
 */

public class Employee {
    private Integer id;
    private String username;
    private Integer gender;
    private String email;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                '}';
    }

    public Employee() {
    }

    public Employee( String username, Integer gender, String email) {
        this.username = username;
        this.gender = gender;
        this.email = email;
    }
}
