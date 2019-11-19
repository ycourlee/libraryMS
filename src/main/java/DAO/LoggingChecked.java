package DAO;

import DBUtils.DBUtil;
import beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoggingChecked {
    /**
     api: .checked
     return: int
     description: 登录检查接口，不匹配返回-1，管理员返回2，普通用户返回1
     parameter: [loggingUser]
     data: 2019/11/15
     **/
    public int checked(User loggingUser) {
        String sql="select stuNo,password from library.user where stuNo='"+loggingUser.getStuNo()+"'";
        Connection conn=DBUtil.getConn();
        Statement stmt = null;
        ResultSet rs=null;
        int success=-1;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            String ps=rs.getString("password");
            if (ps.equals(loggingUser.getPassword())) {
                success=1;
                if(loggingUser.getStuNo().equals("1000214136")){
                    success=2;
                }
            }
        } catch (SQLException e) {
            System.out.println("LoggingChecked-checked()-line: 38    "+e);
        }finally {
            DBUtil.closed(rs, stmt, conn);
        }
        return success;
    }
}
