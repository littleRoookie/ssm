package cn.uestc.dao;

import cn.uestc.bean.Employee;

/**
 * @author: Zhengxing Guan
 * @time: 2021-02-08 22:53
 * @description:
 */
public interface EmployeeDao {

    Employee getEmpById(Integer id);
    int addEmployee(Employee employee);
    int updateEmployee(Employee employee);
    boolean deleteEmployee(Integer id);
}
