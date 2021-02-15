package cn.uestc.controller;

import cn.uestc.dao.DepartmentDao;
import cn.uestc.dao.EmployeeDao;
import cn.uestc.entities.Department;
import cn.uestc.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * @author: Zhengxing Guan
 * @time: 2021-02-06 17:07
 * @description:
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping(value = "/emp/{id}",method = RequestMethod.DELETE)
    public String deleteEmp(@PathVariable("id") int id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp/{id}",method = RequestMethod.PUT)
    public String updateEmp(@ModelAttribute("employee") Employee employee){
        //更新保存二合一的方法
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @ModelAttribute
    public void myModelAttribute(@RequestParam(value = "id",required = false) Integer id, Model model){
        //注意区分请求参数和路径变量哦
        if (id!=null){
            //这个判断是必须要加的，因为这个方法是执行到所有方法的前面，有些没有请求参数id，那么查出来就是null值，就会出现空指针异常
            Employee employee = employeeDao.get(id);
            model.addAttribute("employee",employee);
        }

    }

    @RequestMapping(value = "/emp/{id}",method = RequestMethod.GET)
    public String getEmp(@PathVariable("id") int id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "edit";
    }

    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    public String addEmp(@Valid Employee employee, BindingResult bindingResult,Model model){ //过来就自动封装上了
        System.out.println(employee);
        //定义一个Map来存储错误信息
        HashMap<String, Object> errorshMap = new HashMap<>();
        boolean result = bindingResult.hasErrors();
        if (result){
            //通过bindingResult获得所有的错误属性的信息
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                System.out.println("属性名："+fieldError.getField());
                System.out.println("属性错误信息："+fieldError.getDefaultMessage());
                //将错误属性和信息以key-value放到Map中去
                errorshMap.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            //放到隐含模型，带到前端页面去
            model.addAttribute("errorsMap",errorshMap);
            System.out.println("有校验错误！");
            Collection<Department> departments = departmentDao.getDepartments();
            model.addAttribute("depts",departments);
            return "add";
        }else {
            employeeDao.save(employee);
            return "redirect:/emps";
        }
    }

    @RequestMapping("/emps")
    public String getEmps(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "list";
    }

    @RequestMapping("/toAddPage")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
//        model.addAttribute("command",new Employee());
        model.addAttribute("employee",new Employee());
        return "add";
    }
}
