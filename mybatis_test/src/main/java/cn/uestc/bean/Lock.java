package cn.uestc.bean;

import java.util.List;

/**
 * @author Zhengxing Guan
 * @time 2021-02-10 1:44
 * @description
 */
public class Lock {
    private int id;
    private String name;
    private List<Key> keys;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Key> getKeys() {
        return keys;
    }

    public void setKeys(List<Key> keys) {
        this.keys = keys;
    }

    @Override
    public String toString() {
        return "Lock{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", keys=" + keys +
                '}';
    }

    public Lock(int id, String name, List<Key> keys) {
        this.id = id;
        this.name = name;
        this.keys = keys;
    }

    public Lock() {
    }
}
