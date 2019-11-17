package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "nonLogicFilter",urlPatterns = "/*")
public class nonLogicFilter implements Filter {
    private static String[] pass={"loginServlet","index.html","resources","signUp.html"};
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest r1=(HttpServletRequest)req;
        HttpServletResponse r2=(HttpServletResponse)resp;
        HttpSession session=r1.getSession();
        String keySes=(String)session.getAttribute("key");
        String uri=r1.getRequestURI();

        if(session.getAttribute("loggingUser")!=null){
//            System.out.println("nonLogicFilter-doFilter()-line: 24");
            if(keySes.equals("normalUser")||keySes.equals("administrator")){
//                System.out.println("nonLogicFilter-doFilter()-line: 26");
                if(uri.contains(pass[0])){
//                    System.out.println("nonLogicFilter-doFilter()-line: 28");
                    if(keySes.equals("normalUser"))
                        r2.sendRedirect("home.jsp");
                    else
                        r2.sendRedirect("backHome.jsp");
                }else
                    chain.doFilter(req,resp);
            }
        }
        else if(uri.contains(pass[0])||uri.contains(pass[2])||uri.contains(pass[3])){
//            System.out.println("nonLogicFilter-doFilter()-line: 38");
            chain.doFilter(req,resp);
        }
        else{
//            System.out.println("nonLogicFilter-doFilter()-line: 42");
            r2.sendRedirect(pass[0]);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
