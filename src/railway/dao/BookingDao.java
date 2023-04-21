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
public class BookingDao {

    public static List<String> loadboarding() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select startplace from traindetails");
        ArrayList<String> list = new ArrayList<>();
        while (rs.next()) {
            list.add(rs.getString(1));
        }
        return list;
    }

    public static List<String> loadDestination() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select destination from traindetails");
        ArrayList<String> list = new ArrayList<>();
        while (rs.next()) {
            list.add(rs.getString(1));
        }
        return list;
    }

    public static boolean addBooking(BookingPojo bk) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into booking values(?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1, bk.getName());
        ps.setInt(2, bk.getAge());
        ps.setString(3, bk.getGender());
        ps.setString(4, bk.getBoarding());
        ps.setString(5, bk.getDestination());
        ps.setDate(6, bk.getDate());
        ps.setInt(7, bk.getTrainNo());
        ps.setString(8, bk.getTrainName());
        ps.setDouble(9, bk.getPrice());
        ps.setString(10, bk.getPnr());
        return ps.executeUpdate() == 1;
    }

    public static String generatePNR() throws SQLException {
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select max(pnr_no) from booking");
        rs.next();
        int pn1 = 67573;
        int pn2 = 10000;
//         String pnr_no = pn1 + String.valueOf(pn2);

        String pnr_no = pn1 + "" + pn2;

        String no = rs.getString(1);
//        System.out.println("pnr: " + no);
        if (no != null) {
            pn2 = Integer.parseInt(no.substring(no.length() - 5, no.length()));
            pn1 = Integer.parseInt(no.substring(0, 5));
            pn2 += 1;
            pn1 += pn2 / 100000;
            pn2 %= 100000;
            String pn2Str = pn2 + "";
            String zero = "";
            for (int i = pn2Str.length(); i < 5; i++) zero += "0";
            
            return (pn1 + zero + String.valueOf(pn2));

        }
        return pnr_no;
    }

    public static BookingPojo getTicketDetails(String pnr) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from booking where pnr_no =?");
        ps.setString(1, pnr);
        ResultSet rs = ps.executeQuery();
        rs.next();
        BookingPojo bp = new BookingPojo();
        bp.setName(rs.getString("name"));
        bp.setAge(rs.getInt("age"));
        bp.setBoarding(rs.getString("boarding_station"));
        bp.setDestination(rs.getString("destination"));
        bp.setGender(rs.getString("gender"));
        bp.setPrice(rs.getDouble("price"));
        bp.setTrainNo(rs.getInt("train_no"));
        bp.setTrainName(rs.getString("train_name"));
        bp.setDate(rs.getDate("booking_date"));
        return bp;
    }
    public static boolean deleteTicket(String pnr) throws SQLException{
      Connection conn = DBConnection.getConnection();
       PreparedStatement ps = conn.prepareStatement("Delete booking where pnr_no = ?");
       ps.setString(1, pnr);
       int result = ps.executeUpdate();
        return result == 1; 
  }

}
