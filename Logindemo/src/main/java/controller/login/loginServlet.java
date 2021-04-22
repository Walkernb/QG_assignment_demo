/**
 * 实现登录的servlet
 */
package controller.login;

import dao.daoUser;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class loginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User loginUser=new User();
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        loginUser.setName(name);                    //获取用户名和密码
        loginUser.setPassword(password);
        User user = new daoUser().Login(loginUser);
        if(user==null){
            req.getRequestDispatcher("/failLogin").forward(req,resp);   //登录失败
        }else{
            req.setAttribute("user",user);                                  //存储User数据
            req.getRequestDispatcher("/successLogin").forward(req,resp);    //登录成功
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
