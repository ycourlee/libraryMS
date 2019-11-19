package DAO;

import DBUtils.DBUtil;
import beans.Info;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InfoAdd {
    public int infoAdd(Info i){
        String sql = "";
        Connection conn = DBUtil.getConn();
        Statement stmt = null;
        int success=0;

        try{
            stmt = conn.createStatement();
            success = stmt.executeUpdate(sql);

        } catch (SQLException e) {
            System.out.println("InfoAdd-infoAdd()-line: 22    "+e);
        }finally {
            DBUtil.closed(null, stmt, conn);
        }

        return success;
    }
}
