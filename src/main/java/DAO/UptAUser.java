package DAO;

import DBUtils.DBUtil;
import beans.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UptAUser {
    /**
     api: .uptAUser
     return: int
     description: key is the stuNo
     parameter: [key]
     data: 2019/11/16
     **/
    public int uptAUser(User u){
        String sql="update library.user set username='"+u.getUsername()+"',password='"+u.getPassword()+"'where stuNo='"+u.getStuNo()+"'";
        Connection conn = DBUtil.getConn();
        Statement stmt=null;
        int success=0;
        try{
            stmt=conn.createStatement();
            success = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("UptAUser-uptAUser()-line: 21    "+e);
        }finally {
            DBUtil.closed(null, stmt, conn);
        }
        return success;
    }
}
