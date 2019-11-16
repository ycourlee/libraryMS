package DAO;

import DBUtils.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DelAUser {
    /**
     api: .delAUser
     return: int
     description: key also is the stuNo.
     parameter: [key]
     data: 2019/11/16
     **/
    public int delAUser(String key){
        String sql="delete from library.user where stuNo='"+key+"'";
        Connection conn = DBUtil.getConn();
        Statement stmt=null;
        int success=0;
        try{
            stmt = conn.createStatement();
            success = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("DelAUser-delAUser()-line: 26    "+e);
        }finally {
            DBUtil.closed(null, stmt, conn);
        }
        return success;
    }
}
