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

@WebServlet(name = "signUpServlet", urlPatterns = "/signUpServlet")
public class signUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();

//        String idCard = (String) session.getAttribute("wantSignUp");
        request.setCharacterEncoding("UTF-8");//加上这句，academy参数就没有在乱码。
        Register sign = new Register();
        User u = new User();
        Info i = new Info();
        u.setStuNo(request.getParameter("stuNo"));
        u.setPassword(request.getParameter("password"));
        u.setUsername("username");
        i.setStuNo(request.getParameter("stuNo"));
        i.setAcademy(request.getParameter("academy"));

        System.out.println(u.toString());
        System.out.println(i.toString());

//        sign.register(u,i);


        session.setAttribute("signSuccess", "yes");
        response.sendRedirect("signSuccess.html");






        //这里要把凭证销毁，确保这个页面一次只会对应一个凭证
        session.removeAttribute("wantSignUp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
