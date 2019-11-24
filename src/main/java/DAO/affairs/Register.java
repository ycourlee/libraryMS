package DAO.affairs;

import DBUtils.DBUtil;
import beans.Info;
import beans.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Register {
    public boolean register(User u, Info i){
        String sql="insert into library.user(stuNo, username, password)" +
                "values('" + u.getStuNo()+"','"+ u.getUsername()+"','"+ u.getPassword()+ "')";
        String sql2 = "insert into library.info(stuNo,academy,grade,majorClass)" +
                "value('"+i.getStuNo()+"','"+i.getAcademy()+"','"+
                i.getGrade()+"','"+i.getMajorClass()+"')";

        Connection conn = DBUtil.getConn();
        Statement stmt = null;
        boolean defCommit=false;
        boolean success=false;

        try {
            defCommit=conn.getAutoCommit();
            conn.setAutoCommit(false);
            stmt=conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql2);
            conn.commit();
            success=true;
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                System.out.println("Register-register()-line: 35    "+e);
            }
        }finally {
            try {
//                置为默认
                conn.setAutoCommit(defCommit);
            } catch (SQLException e) {
                System.out.println("Register-register()-line: 41    "+e);
            }
            DBUtil.closed(null, stmt, conn);
        }
        return success;
    }
}
