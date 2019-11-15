package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "homeFilter",urlPatterns = "/home.jsp")
public class homeFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest r1=(HttpServletRequest)req;
        HttpServletResponse r2=(HttpServletResponse)resp;
        HttpSession session=r1.getSession();
        String sesIsNull = (String) session.getAttribute("key");
        if (sesIsNull != null && session.getAttribute("key").equals("normalUser")){
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
