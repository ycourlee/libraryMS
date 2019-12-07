package DAO;

import DBUtils.DBUtil;
import beans.BorrowRecord;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @description: 插入一条借阅记录
 * @author: YG
 * @date: 2019/12/7 11:36
 */
public class InsertBR {
    public int insertBR(BorrowRecord br){
        String sql="insert into library.borrowrecord(stuNo, borrowDays, bookNo) values ("+br.getStuNo()+","+br.getBorrowDays()+","+br.getBookNo()+")";
        Connection conn = DBUtil.getConn();
        Statement stmt=null;
        int success=0;
        try {
            stmt = conn.createStatement();
            success = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("InsertBR-insertBR()-line: 26    "+e);
        }finally {
            DBUtil.closed(null, stmt, conn);
        }
        return success;
    }
}
