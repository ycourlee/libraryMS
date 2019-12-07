package servlets;

import DAO.InsertBR;
import beans.BorrowRecord;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: ${TODO}
 * @author: YG
 * @date: 2019/12/7 11:41
 */

public class InsertBrServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BorrowRecord br = new BorrowRecord();
        br.setStuNo(request.getParameter("stuNo"));
        br.setBorrowDays(Integer.parseInt(request.getParameter("brDays")));
        br.setBookNo(request.getParameter("bookNo"));

        InsertBR inst = new InsertBR();
        int success=inst.insertBR(br);
        if (success==1) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("添加成功！");
        }
        else{
            response.getWriter().write("操作失败！");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
