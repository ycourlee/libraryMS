package servlets;

import DAO.LoggingChecked;
import beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet", urlPatterns = "/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        User loggingUser = new User();
        loggingUser.setStuNo(request.getParameter("stuNo"));
        loggingUser.setPassword(request.getParameter("password"));

        HttpSession session=request.getSession();
        session.setAttribute("loggingUser",loggingUser);

        LoggingChecked check=new LoggingChecked();
        int allowAccessed = check.checked(loggingUser);
        if(allowAccessed==-1){
            session.removeAttribute("loggingUser");

            response.sendRedirect("loginServlet");

        }else if(allowAccessed==1){
            session.setAttribute("key","normalUser");
            response.sendRedirect("home.jsp");
        }else if(allowAccessed==2){
            session.setAttribute("key","administrator");
            response.sendRedirect("backHome.jsp");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        if(uri.contains("index.html")||uri.contains("loginServlet")||uri.contains("WEB-INF")){
            request.getRequestDispatcher("index.html").forward(request, response);//请求转发至index.html, 服务端运行,  url不变
        }
    }
}
