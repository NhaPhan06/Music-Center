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
public class Item {

    private Course course;
    private int quantity;
    private float price;

    public float getPrice() {
        return this.course.getTuitionFee() * this.quantity;
    }

    public Item(Course course, int quantity) {
        this.course = course;
        this.quantity = quantity;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
