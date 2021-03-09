package org.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 14495
 * Date: 2021-03-07
 * Time: 21:01
 */
@WebServlet("/loginUseSession")
public class LoginUseSessionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");//响应头Content-Type，告诉对端响应体的解析方式

        //getParameter可以获取url中的queryString请求数据，及请求体表单数据类型格式的请求数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.printf("username=%s, password=%s%n", username, password);

        PrintWriter pw = resp.getWriter();
        //伪代码：用户登录的jdbc校验
        //作业：完成用户登录Servlet+JDBC的代码，返回数据要求是JSON格式的数据
//        if(LoginDAO.query(username, password)){
//            pw.println("登录成功");
//        }else{
//            pw.println("登录失败");
//        }
//        ObjectMapper
        //模拟用户名密码登录：登录成功
        if("abc".equals(username) && "123".equals(password)){
            // 获取session对象（从服务端），无参和传一个true意思一样
            // 如果方法参数为true，表示如果没有，就创建一个
            // 如果为false，没有就返回null
            HttpSession session = req.getSession();
            session.setAttribute("user", String.format("username=%s, password=%s", username, password));
            pw.println("登录成功");
        }else{
            pw.println("登录失败");
        }
        pw.flush();
        pw.close();
    }
}
