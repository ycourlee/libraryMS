package DAO;

import DBUtils.DBUtil;
import beans.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @description: 获取图书列表
 * @author: YG
 * @date: 2019/12/5 17:03
 */
public class BookList {
    public ArrayList<Book> getBookList(){
        ArrayList<Book> books = null;
        books=new ArrayList<>();
        String sql="select bookNo, bookName, author,volumes, version, BComment, price, pubHouse, pubDate " +
                "from library.book";
        Connection conn = DBUtil.getConn();
        Statement stmt=null;
        ResultSet rs=null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            Book b;
            while (rs.next()) {
                b = new Book();
                b.setBookNo(rs.getString(1));
                b.setBookName(rs.getString(2));
                b.setAuthor(rs.getString(3));
                b.setVolumes(rs.getInt(4));
                b.setVersion(rs.getString(5));
                b.setBComment(rs.getString(6));
                b.setPrice(rs.getDouble(7));
                b.setPubHouse(rs.getString(8));
                b.setPubDate(rs.getDate(9));
                books.add(b);
            }
        } catch (SQLException e) {
            System.out.println("BookList-getBookList()-line: 45    " + e);
        }finally {
            DBUtil.closed(rs, stmt, conn);
        }
        return books;
    }
}
