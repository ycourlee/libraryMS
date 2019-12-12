package servlets;

import DAO.UptBR;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 修改借阅天数
 * @author: YG
 * @date: 2019/12/12 22:15
 */

public class UpdateBrServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int key = Integer.parseInt(request.getParameter("key"));
        int newBrDays = Integer.parseInt(request.getParameter("newBrDays"));
        UptBR upt = new UptBR();
        int success = upt.uptBR(key, newBrDays);
        response.setContentType("text/html;charset=utf-8");
        if (success > 0) {
            response.getWriter().write("修改成功");
        } else {
            response.getWriter().write("修改失败");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }
}
