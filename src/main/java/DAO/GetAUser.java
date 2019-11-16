package DAO;

import DBUtils.DBUtil;
import beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetAUser {
    /**
     api: .getAUser
     return: beans.User
     description: User的key是stuNo字符串
     parameter: [key]
     data: 2019/11/16
     **/
    public User getAUser(String key){
        String sql="select stuNo,username,password from library.user where stuNo='"+key+"'";
        Connection conn = DBUtil.getConn();
        Statement stmt=null;
        ResultSet rs=null;
        User u=null;
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            u = new User();
            u.setStuNo(rs.getString("stuNo"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
        } catch (SQLException e) {
            System.out.println("GetAUser-getAUser()-line: 36    "+e);
        }finally {
            DBUtil.closed(rs, stmt, conn);
        }
        return u;
    }
}
