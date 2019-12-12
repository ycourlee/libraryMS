package DAO;

import DBUtils.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @description: 更新借阅记录的天数
 * @author: YG
 * @date: 2019/12/12 22:20
 */
public class UptBR {
    public int uptBR(int key, int newBrDays){
        String sql="update library.borrowrecord set borrowDays="+newBrDays+" where recordId="+key+"";
        System.out.println(sql);
        Connection conn = DBUtil.getConn();
        Statement stmt=null;
        int success=0;
        try {
            stmt = conn.createStatement();
            success = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("UptBR-uptBR()-line: 25    "+e);
        }finally {
            DBUtil.closed(null, stmt, conn);
        }
        return success;
    }
}
