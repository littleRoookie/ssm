package cn.uestc.dao;

import cn.uestc.bean.Lock;

/**
 * @author Zhengxing Guan
 * @time 2021-02-10 1:57
 * @description
 */
public interface LockDao {
    Lock getLockById(Integer id);
}
