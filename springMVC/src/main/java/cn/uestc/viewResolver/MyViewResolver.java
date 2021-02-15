package cn.uestc.viewResolver;

import cn.uestc.view.MyView;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * @author: Zhengxing Guan
 * @time: 2021-02-06 16:04
 * @description:
 */
public class MyViewResolver implements ViewResolver, Ordered {


    private int order;

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        if (viewName.contains("gzx")){
            return new MyView();
        }
        return null;
    }

    @Override
    public int getOrder() {
        return order;

    }
    public void setOrder(int order) {
        this.order = order;
    }
}
