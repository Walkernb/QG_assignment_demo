/**
 * User的数据库操作类
 */
package dao;

import entity.User;
import util.JDBCutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class daoUser {
    /**
     * 登录功能
     * @param loginUser 封装用户输入的登录信息
     * @return          user表中对应的数据
     */
    public User Login(User loginUser){
        User user=null;
        Connection cn=null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            cn = JDBCutil.getConnection();
            String sql="select * from user where name = ? and password = ?;";
            pstmt = cn.prepareStatement(sql);
            pstmt.setString(1,loginUser.getName());
            pstmt.setString(2,loginUser.getPassword());
            rs = pstmt.executeQuery();
            if(rs.next()==false){
                return null;
            }else{
                String name = rs.getString("name");
                String password = rs.getString("password");
                user=new User();
                user.setName(name);
                user.setPassword(password);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            //System.out.println("用户名或密码错误！");
        }finally{
            JDBCutil.Close(cn,pstmt,rs);
        }
        return user;
    }

    /**
     * 注册功能
     * @param user  封装用户输入的登录信息
     * @return      boolean值，若注册成功，返回true,若注册失败，返回false
     */
    public boolean Regiser(User user){
        Connection cnn = null;
        PreparedStatement pstmt = null;
        try {
            cnn = JDBCutil.getConnection();
            cnn.setAutoCommit(false);
            String sql="INSERT INTO user VALUES(NULL, ? , ? )";
            pstmt = cnn.prepareStatement(sql);
            pstmt.setString(1, user.getName());
            pstmt.setString(2,user.getPassword());
            int i = pstmt.executeUpdate();
            cnn.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            if(cnn!=null){
                try {
                    cnn.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return false;
        }
        return true;
    }
}
