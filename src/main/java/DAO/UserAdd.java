package DAO;

import DBUtils.DBUtil;
import beans.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UserAdd {
    /**
     api: .userAdd
     return: boolean
     description: 单个添加用户，适用于注册的场景
     parameter: [u]
     data: 2019/11/16
     **/
    public int userAdd(User u){
        String sql="insert into library.user(stuNo, username, password)" +
                "values('" + u.getStuNo()+"','"+ u.getUsername()+"','"+ u.getPassword()+ "')";
        Connection conn = DBUtil.getConn();
        Statement stmt = null;
        int success=0;
        try{
            stmt = conn.createStatement();
            /**    方法executeUpdate()方法返回影响到的条数    */
            success = stmt.executeUpdate(sql);
        }catch (SQLException e) {
            System.out.println("UserAdd-userAdd()-line: 30    "+e);
        } finally {
            DBUtil.closed(null, stmt, conn);
        }
        return  success;
    }
}
