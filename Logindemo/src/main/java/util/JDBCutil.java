/**
 * 工具类
 */
package util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public  class JDBCutil {
    private static String url;
    private static String user;
    private static String password;
    static{
        Properties pro=new Properties();
        try {
            pro.load(new FileReader("D:\\ideaCode\\Logindemo\\src\\JDBC.properties"));

            url=pro.getProperty("url");
            user=pro.getProperty("user");
            password=pro.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    public static void Close(Connection cn, Statement stmt){
        if(cn!=null){
            try {
                cn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void Close(Connection cn, Statement stmt, ResultSet rs){
        if(cn!=null){
            try {
                cn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
