package cn.uestc.pojo;

/**
 * @author: Zhengxing Guan
 * @time: 2021-02-04 1:10
 * @description:
 */
//这个POJO甚至都不用放入容器中
public class Book {
    private String username;
    private String password;

    @Override
    public String toString() {
        return "Book{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Book(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Book() {
    }
}
