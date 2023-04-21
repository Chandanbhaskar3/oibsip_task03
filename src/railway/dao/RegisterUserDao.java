/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railway.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import railway.dbutil.DBConnection;
import railway.pojo.RegisterUserPojo;


/**
 *
 * @author ck835
 */
public class RegisterUserDao {
    
    public static String getNewUserId() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select max(login_id) from register_user");
        rs.next();
        int loginId = 101;
        String id = rs.getString(1);
        if (id != null) {
            String num = id.substring(4);
            loginId = Integer.parseInt(num) + 1;
        }
        return "User" + loginId ;

    }
    public static boolean registerNewUser(RegisterUserPojo reg) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into register_user values(?,?,?,?)");
        ps.setString(1,reg.getLoginId());
        ps.setString(2, reg.getUserName());
        ps.setString(3, reg.getPassword());
        ps.setString(4, reg.getMobileNo());
        return ps.executeUpdate() == 1 ;
    }
    public static String validateUser(RegisterUserPojo ru) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select user_name from register_user where login_id=? and password=?");
        ps.setString(1, ru.getLoginId());
        ps.setString(2, ru.getPassword());
        ResultSet rs = ps.executeQuery();
        String name = null;
        if(rs.next()){
           name = rs.getString("user_name");  
        }
        else{
            System.out.println("not get name");
        }
        System.out.println("name:"+name);
        return name;
                
    }
    
    
}
