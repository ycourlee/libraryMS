package DAO;

import DBUtils.DBUtil;
import beans.UserBR;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * @description: 返回某一用户的借阅记录表
 * @author: YG
 * @date: 2019/12/19 17:26
 */
public class UserBRList {
    /**
     * @param key is the primary key
     * @return
     */
    public ArrayList<UserBR> getUserBRList(String key) {
        Connection conn = DBUtil.getConn();
        Statement stmt = null;
        ResultSet rs = null;

        ArrayList<UserBR> list = new ArrayList<>();
        String sql = "select borrowrecord.bookNo,bookName,author,version,deadline,borrowDays,BComment,price " +
                "from library.book inner join library.borrowrecord " +
                "where borrowrecord.stuNo='" + key + "' and book.bookNo=borrowrecord.bookNo";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            UserBR ubr;
            while (rs.next()) {
                ubr = new UserBR();
                ubr.setBookNo(rs.getInt(1));
                ubr.setBookName(rs.getString(2));
                ubr.setAuthor(rs.getString(3));
                ubr.setVersion(rs.getString(4));
                ubr.setDeadline(rs.getDate(5));
                ubr.setBrDays(rs.getInt(6));
                ubr.setbCmt(rs.getString(7));
                ubr.setPrice(rs.getDouble(8));
                list.add(ubr);
            }
        } catch (SQLException e) {
            System.out.println("UserBRList-getUserBRList()-line: 48    " + e);
        } finally {
            DBUtil.closed(rs, stmt, conn);
        }
        return list;
    }
}
