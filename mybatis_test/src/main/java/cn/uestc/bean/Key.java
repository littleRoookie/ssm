package cn.uestc.bean;

/**
 * @author Zhengxing Guan
 * @time 2021-02-10 1:46
 * @description
 */
public class Key {
    private int id;
    private String name;
    private Lock lock;

    public Key() {
    }

    @Override
    public String toString() {
        return "Key{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lock=" + lock +
                '}';
    }

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

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public Key(int id, String name, Lock lock) {
        this.id = id;
        this.name = name;
        this.lock = lock;
    }
}
