package cn.uestc.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: Zhengxing Guan
 * @time: 2021-02-07 19:53
 * @description:
 */
@Controller
public class Test {
    @RequestMapping("/test1")
    public String test1() {
        System.out.println("执行目标方法···");
        return "success";
    }
}
