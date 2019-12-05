package DAO;

import DBUtils.DBUtil;
import beans.Info;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @description: 获取用户列表
 * @author: YG
 * @date: 2019/12/5 17:27
 */
public class userList {
    public ArrayList<Info> getUserList(){
        ArrayList<Info> infos;
        infos = new ArrayList<>();
        String sql = "select info.stuNo, username, BWNum, grade, academy, majorClass,userComment from library.info inner join library.user";
        Connection conn = DBUtil.getConn();
        Statement stmt=null;
        ResultSet rs=null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            Info i;
            while (rs.next()) {
                i = new Info();
                i.setStuNo(rs.getString(1));
                i.setUsername(rs.getString(2));
                i.setBWNum(rs.getInt(3));
                i.setGrade(rs.getString(4));
                i.setAcademy(rs.getString(5));
                i.setMajorClass(rs.getString(6));
                i.setUserComment(rs.getString(7));
                infos.add(i);
            }
        } catch (SQLException e) {
            System.out.println("userList-getUserList()-line: 41    "+e);
        }finally {
            DBUtil.closed(rs, stmt, conn);
        }
        return infos;
    }
}
