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
import java.util.ArrayList;
import java.util.List;

import railway.dbutil.DBConnection;
import railway.pojo.BookingPojo;
import railway.pojo.TrainPojo;

/**
 *
 * @author ck835
 */
public class TrainDao {
    public static boolean addTrain(TrainPojo tr) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into traindetails values(?,?,?,?,?)");
        ps.setInt(1,tr.getTno());
        ps.setString(2, tr.getTname());
        ps.setString(3, tr.getStartPlace());
        ps.setString(4, tr.getDestination());
        ps.setDouble(5, tr.getPrice());
        return ps.executeUpdate() == 1;
    
}
    public static TrainPojo getTrainDetailsByTrainNo(TrainPojo pr) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from traindetails where train_no = ?");
        ps.setInt(1, pr.getTno());
        ResultSet rs = ps.executeQuery();
        rs.next();
        TrainPojo details = new TrainPojo();
        details.setTno(rs.getInt(1));
        details.setTname(rs.getString(2));
        details.setStartPlace(rs.getString(3));
        details.setDestination(rs.getString(4));
        details.setPrice(rs.getDouble(5));
        return details;
    }
//    public static TrainPojo getTrainDetailsBySourceAndDestination(BookingPojo pr) throws SQLException{
//        Connection conn = DBConnection.getConnection();
//        PreparedStatement ps = conn.prepareStatement("select * from traindetails where startplace=? and destination=?");
//        System.out.println("hey");
//        ps.setString(1, pr.getBoarding());
//        ps.setString(2, pr.getDestination());
//        ResultSet rs = ps.executeQuery();
//        rs.next();
//        TrainPojo details = new TrainPojo();
//        details.setTno(rs.getInt(1));
//        details.setTname(rs.getString(2));
////        details.setStartPlace(rs.getString(3));
////        details.setDestination(rs.getString(4));
////        details.setPrice(rs.getDouble(5));
//        return details;
//    }
    public static List<Integer> getTrainIds()throws SQLException{
      Connection conn = DBConnection.getConnection();
       Statement st = conn.createStatement();
       ResultSet rs = st.executeQuery("select tno from traindetails");
        ArrayList<Integer> listOfTrainNo = new ArrayList<>();
        while(rs.next()){
           listOfTrainNo.add(rs.getInt(1));
        }
        return listOfTrainNo;
    }
    public static TrainPojo getTrainDetailsByTrainNo(int pr) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from traindetails where tno = ?");
        ps.setInt(1,pr);
        ResultSet rs = ps.executeQuery();
        rs.next();
        TrainPojo details = new TrainPojo();
        details.setTno(rs.getInt(1));
        details.setTname(rs.getString(2));
        details.setStartPlace(rs.getString(3));
        details.setDestination(rs.getString(4));
        details.setPrice(rs.getDouble(5));
        return details;
    } 
}
