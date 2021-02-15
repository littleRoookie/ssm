package cn.uestc.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * @author: Zhengxing Guan
 * @time: 2021-02-06 16:36
 * @description:
 */
@Controller
public class TestController {

    @RequestMapping("/hello")
    public String testHello(){
        return "success";
    }

    @RequestMapping("/download")
    public void testFileDownload(HttpServletRequest request,HttpServletResponse response,@RequestParam("name") String fileName) throws Exception {
        System.out.println(request);
        //1.得到文件路径
        ServletContext servletContext = request.getServletContext();
//        String realPath = servletContext.getRealPath("/picture/" + fileName);
        String filePath="/WEB-INF/picture/" + fileName;
        //2.得到文件流
        InputStream inputStream = servletContext.getResourceAsStream(filePath);
        //3.回传之前告诉浏览器文件类型
        response.setContentType(servletContext.getMimeType(filePath));
        //4.设置响应头告诉浏览器接受到的文件是怎么处理的
        response.setHeader("Content-Disposition","attachment;filename="+fileName);
        //5.使用IOUtils工具包将文件回传到客户端
        ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.copy(inputStream,outputStream);
    }

    @RequestMapping("/upload")
    public String testFileUpload(@RequestParam(value = "username",required = false) String username,
                                 @RequestParam(value = "headerImg",required = false) MultipartFile multipartFile, Model model){
//        System.out.println(username);
//        System.out.println(multipartFile.getName()); //是得到属性名 headerImg
//        System.out.println(multipartFile.getOriginalFilename());//是得到文件名 1.jpg
        Date date = new Date();
        long time = date.getTime();
        String name =time+""+multipartFile.getOriginalFilename();//避免重名
        System.out.println(name);
        try {
            multipartFile.transferTo(new File("D:\\workspace_idea\\ssm\\RESR_CRUD\\src\\main\\webapp\\WEB-INF\\picture\\"+name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("msg","文件上传成功了！");
        return "forward:/WEB-INF/pages/success.jsp";
    }
    @RequestMapping("toUploadPage")
    public String toUploadPage(){
        return "upload";
    }
}
