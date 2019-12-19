package filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "nonLogicFilter",urlPatterns = "/*")
public class nonLogicFilter implements Filter {
    private static String[] pass={"loginServlet","signUp.html","index.html","resources","signUpServlet","signSuccess.html","logoutServlet"};
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
        else if(uri.contains(pass[0])||uri.contains(pass[3])||uri.contains(pass[4])){
            /**    loginServlet resources signUpServlet 这里先放行signUpServlet, 使用精准filter拦截    */

//            System.out.println("nonLogicFilter-doFilter()-line: 38");
            chain.doFilter(req,resp);
        }
        else if(uri.contains(pass[2])){//index.html
            r2.sendRedirect(pass[0]);
        }
        else if(uri.contains(pass[1])){//signUp.html
//            System.out.println("nonLogicFilter-doFilter()-line: 42");
            session.setAttribute("wantSignUp","ok");//为访问signUpServlet 制作凭证
            chain.doFilter(req, resp);
        }
        else if(uri.contains(pass[5])){//signSuccess
            String signSes=(String) session.getAttribute("signSuccess");
            if(signSes!=null&&signSes.equals("yes")){
                chain.doFilter(req,resp);
            }
        }else if(uri.contains("Servlet")||uri.contains(pass[6])){
            System.out.println("kk");
            chain.doFilter(req, resp);
        }
        else{
            r2.sendRedirect(pass[0]);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
