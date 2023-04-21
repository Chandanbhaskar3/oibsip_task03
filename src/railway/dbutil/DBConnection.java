/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railway.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ck835
 */
public class DBConnection {
    private static Connection conn;
    static {
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-BC3C5VE:1521/xe","railwayproject","5045");
        }
        catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null,"can't load the class :"+ex.getMessage(), "ERROR!!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        catch(SQLException ex){
              JOptionPane.showMessageDialog(null,"DBConnection error :"+ex.getMessage(), "ERROR!!",JOptionPane.ERROR_MESSAGE);  
              ex.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return conn;
    }
    public static void closeConnection(){
        try {
             conn.close();
               JOptionPane.showMessageDialog(null,"DB Connection Disconnected", "Success!!",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null,"DB Error!! " +e.getMessage(), "ERROR!!",JOptionPane.ERROR_MESSAGE);
              e.printStackTrace();
        }
    }
    
}
