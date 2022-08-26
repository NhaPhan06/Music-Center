/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.DAO;

/**
 *
 * @author PhongNha
 */
public class Order {
    private String orderID;
    private String courseID;
    private int quantity;
    private String dateBuy;
    private String status;

    public Order(String orderID, String courseID, int quantity, String dateBuy, String status) {
        this.orderID = orderID;
        this.courseID = courseID;
        this.quantity = quantity;
        this.dateBuy = dateBuy;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDateBuy() {
        return dateBuy;
    }

    public void setDateBuy(String dateBuy) {
        this.dateBuy = dateBuy;
    }
    
}
