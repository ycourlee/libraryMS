package servlets;

import DAO.affairs.Register;
import beans.Info;
import beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet(name = "signUpServlet",urlPatterns = "/signUpServlet")
public class signUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        out.print("Hello");
        //这里要把凭证销毁，确保这个页面一次只会对应一个凭证
        HttpSession session=request.getSession();
        session.removeAttribute("wantSignUp");

        Register sign = new Register();
        User u = new User();
        Info i = new Info();
        u.setStuNo(request.getParameter("stuNo"));
        u.setPassword(request.getParameter("password"));
        u.setUsername("username");
        i.setStuNo(request.getParameter("stuNo"));
        i.setAcademy(request.getParameter("academy"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
