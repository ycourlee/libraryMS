package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "signUpFilter",urlPatterns = "/signUpServlet")
public class signUpFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest r1 = (HttpServletRequest) req;
        HttpServletResponse r2=(HttpServletResponse)resp;
        HttpSession session=r1.getSession();
        String idCard= (String) session.getAttribute("wantSignUp");
        if(idCard!=null&&idCard.equals("ok")){
            chain.doFilter(req,resp);
        }else{
            r1.getRequestDispatcher("nonLogicAccess.html").forward(r1,r2);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
