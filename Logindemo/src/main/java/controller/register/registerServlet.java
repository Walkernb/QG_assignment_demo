/**
 * 实现注册的servlet
 */
package controller.register;

import dao.daoUser;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/register")
public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");             //获取数据
        String password = req.getParameter("password");
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        boolean b = new daoUser().Regiser(user);
        resp.setContentType("text/html;charset=utf-8");
        if(b){
            resp.getWriter().write("注册成功！");
        }else{
            resp.getWriter().write("注册失败！输入的用户名重复，输入用户名或密码");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
