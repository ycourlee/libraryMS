package DBUtils;

import java.sql.*;

public class DBUtil {
    private static String DbURL="jdbc:mysql://localhost:3306/library?uerUnicode=true&characterEncoding=UTF-8&useSSL=false";
    private static String DbUSER="root";
    private static String DbPASSWORD="rootjy";

    /**
     description:
     parameter:
     api: DBUtil.getConn()
     data: 2019/11/6
     **/
    public static Connection getConn(){
        Connection conn=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(DbURL,DbUSER,DbPASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("DBUtil: "+e);
        }
        return conn;
    }

    /**
     description: 关闭是有顺序的，先rs，后stmt，最后是conn
     parameter:
     data: 2019/11/6
     **/
    public static void closed(ResultSet resultSet, Statement statement, Connection connection){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println("DBUtil-closed"+e);
            }
        }
        if (statement!=null) {
            try{
                statement.close();
            } catch (SQLException e) {
                System.out.println("DBUtil-closed()"+e);
            }
        }
        if (connection!=null) {
            try{
                connection.close();
            } catch (SQLException e) {
                System.out.println("DBUtil-closed()-line: 51"+e);
            }
        }
    }
}
