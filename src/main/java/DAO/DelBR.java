package DAO;

import DBUtils.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @description: 删除一条借阅记录
 * @author: YG
 * @date: 2019/12/7 9:53
 */
public class DelBR {
    public int delBR(int key){
        String sql="delete from library.borrowrecord where recordId="+key;
        Connection conn = DBUtil.getConn();
        Statement stmt=null;
        int success=0;

        try {
            stmt=conn.createStatement();
            success=stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("DelBR-delBR()-line: 27    "+e);
        }finally {
            DBUtil.closed(null, stmt, conn);
        }
        return success;
    }
}
