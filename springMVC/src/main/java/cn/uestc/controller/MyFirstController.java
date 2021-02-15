package cn.uestc.controller;

import cn.uestc.pojo.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author: Zhengxing Guan
 * @time: 2021-02-03 16:23
 * @description:
 */
@Controller/*这个注解不要乱和其它bean的用，要根据其来找哪个方法来执行对应的请求的哦*/

public class MyFirstController {
    @RequestMapping(value = "/hello")
    public String method1( String username){
        System.out.println("接受到了前端传来的参数"+username);
        //直接return就是请求转发到了对应的页面
//        return "/WEB-INF/pages/success.jsp";
        return "success";
        //路径书写太麻烦的话可以配置一个视图解析器（在springMVC.xml中）来默认加上前缀和后缀

    }
    @RequestMapping("/testPojo")
    public String test(Book book){
        System.out.println(book);
        return "success";
    }
    @RequestMapping("/test1")
    public String test1(Map<String,Object> map){
        map.put("name", "gzx");
        return "success";
    }
    @RequestMapping("/testCode")
    public String testCode(){
        System.out.println("执行了目标方法中的内容");
        return "success";

    }
    @RequestMapping("/testView")
    public String testViewResolver(){
        System.out.println("```````````");
        return "gzx:/sdasad";
    }
}
