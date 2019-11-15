package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(filterName = "loginFilter", urlPatterns = {"/index.html"})
/**    暂时不使用    */
public class loginFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest r1=(HttpServletRequest)req;
        HttpServletResponse r2=(HttpServletResponse)resp;
        HttpSession session=r1.getSession();
        if(session.getAttribute("loggingUser")==null){///刚开始，无登录状态，跳转至loginServlet,但它的url映射到了index.jsp
            r2.sendRedirect("loginServlet");
        }else if(((String)session.getAttribute("key")).equals("normalUser")){
            r2.sendRedirect("home.jsp");
        }else if(((String)session.getAttribute("key")).equals("administrator")){
            r2.sendRedirect("backHome.jsp");
        }
    }
    public void init(FilterConfig config) throws ServletException {
    }

}
