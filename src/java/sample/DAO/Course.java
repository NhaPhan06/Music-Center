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
public class Course {
    private String courseID;
    private String courseName;
    private String description;
    private float tuitionFee;
    private String image;
    private String createDate;
    private String endDate;
    private String category;
    private int quantity;
    private String update;

    public Course(String courseID, String courseName, String image, String description, float tuitionFee,  String createDate, String endDate, String category, int quantity, String update) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.description = description;
        this.tuitionFee = tuitionFee;
        this.image = image;
        this.createDate = createDate;
        this.endDate = endDate;
        this.category = category;
        this.quantity = quantity;
        this.update = update;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(float tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
}
