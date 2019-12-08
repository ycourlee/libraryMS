package servlets;

import DAO.DelBR;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: YG
 * @date: 2019/12/7 9:14
 */
public class DeleteBrServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println("将要删除的键"+id);
        DelBR del=new DelBR();
        int success=del.delBR(Integer.parseInt(id));
        resp.setContentType("text/html;charset=utf-8");
        if(success==1)
        {
            resp.getWriter().write("删除成功!");
        }else {
            resp.getWriter().write("删除失败！");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}
