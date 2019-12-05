package DAO;

import DBUtils.DBUtil;
import beans.BorrowRecord;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @description: 返回借阅记录表
 * @author: YG
 * @date: 2019/12/5 15:57
 */
public class BorrowList {
    public ArrayList<BorrowRecord> getBRList(){
        ArrayList<BorrowRecord> brlist;
        brlist=new ArrayList<>();
        String sql="select recordId, bookName, user.stuNo, username, borrowDays, deadline from " +
                "library.borrowrecord inner join library.user inner join library.book " +
                "where borrowrecord.stuNo=user.stuNo and borrowrecord.bookNo=book.bookNo";
        Connection conn = DBUtil.getConn();
        Statement stmt = null;
        ResultSet rs=null;

        try {
            stmt = conn.createStatement();
            rs=stmt.executeQuery(sql);
            BorrowRecord br = null;

            while(rs.next()){
                br=new BorrowRecord();
                br.setRecordId(rs.getInt(1));
                br.setBookName(rs.getString(2));
                br.setStuNo(rs.getString(3));
                br.setUsername(rs.getString(4));
                br.setBorrowDays(rs.getInt(5));
                br.setDeadline(rs.getDate(6));
                brlist.add(br);
            }
        } catch (SQLException e) {
            System.out.println("BorrowList-getBRList()-line: 42    "+e);
        }finally {
            DBUtil.closed(rs, stmt, conn);
        }

    return brlist;
    }
}
