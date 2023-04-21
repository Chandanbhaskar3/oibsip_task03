/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railway.pojo;

import java.sql.Date;

/**
 *
 * @author ck835
 */
public class BookingPojo {

    

    public BookingPojo(String name, Date date, String boarding, String destination, int trainNo, String trainName, int age, String gender, double price,String pnr) {
        this.name = name;
        this.date = date;
        this.boarding = boarding;
        this.destination = destination;
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.age = age;
        this.gender = gender;
        this.price = price;
        this.pnr = pnr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBoarding() {
        return boarding;
    }

    public void setBoarding(String boarding) {
        this.boarding = boarding;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(int trainNo) {
        this.trainNo = trainNo;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public BookingPojo() {
    }
 private String name;
 private Date date;
 private String boarding;
 private String destination;
 private int trainNo;
 private String trainName;
 private int age;
 private String gender;
 private double price;
 private String pnr;
    
 
 
}
