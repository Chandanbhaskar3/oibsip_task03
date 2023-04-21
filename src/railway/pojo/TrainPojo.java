/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package railway.pojo;

/**
 *
 * @author ck835
 */
public class TrainPojo {
    public TrainPojo(){
    
    }

    public TrainPojo(int tno, String tname, String startPlace, String destination, double price) {
        this.tno = tno;
        this.tname = tname;
        this.startPlace = startPlace;
        this.destination = destination;
        this.price = price;
    }

    public int getTno() {
        return tno;
    }

    public void setTno(int tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    private int tno;
    private String tname;
    private String startPlace;
    private String destination;
    private double price;
}
