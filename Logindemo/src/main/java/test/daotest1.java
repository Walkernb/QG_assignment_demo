package test;

import dao.daoUser;
import entity.User;
import util.JDBCutil;

import java.sql.Connection;
import java.sql.SQLException;

public class daotest1 {
    public static void main(String[] args) throws NoClassDefFoundError, SQLException {
        /*daoUser du=new daoUser();
        User loginUser=new User();
        loginUser.setName("Linda");
        loginUser.setPassword("12345");
        User user = du.Login(loginUser);*/
        Connection cnn = JDBCutil.getConnection();
        JDBCutil.Close(cnn,null);
        System.out.println(cnn);
    }
}
