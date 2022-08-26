/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import sample.Utils.DBUtils;

/**
 *
 * @author ADMIN
 */
public class DAO {

    Connection conn = null;
    PreparedStatement ptm = null;
    ResultSet rs = null;

    private static final String LOGIN = "SELECT FullName, UserEmail, Role FROM tblUser WHERE UserID=? AND Password=?";
    private static final String ORDER = "SELECT * FROM tblOrder WHERE OrderID=?";
    private static final String List_ORDER = "SELECT * FROM tblOrder";
    private static final String COURSE = " SELECT * FROM tblCourse";
    private static final String SEARCH_CATEGORY = " SELECT * FROM tblCourse WHERE Category= ?";
    private static final String SEARCH_TEXT = " SELECT * FROM tblCourse WHERE [Name] LIKE ?";
    private static final String SEARCH = " SELECT * FROM tblCourse WHERE [Name] LIKE ? AND Category= ?";
    private static final String UPDATE_COURSE = "UPDATE tblCourse SET Name = ?, Description = ?, TuitionFee = ?, EndDate = ?, Category = ?, Quantity = ?, UpdateDate = ? WHERE ID = ?";
    private static final String UPDATE_ORDER = "UPDATE tblOrder SET status = ? WHERE OrderID = ? AND CourseID = ?";
    private static final String CREATE_COURSE = "INSERT INTO tblCourse(ID,Name,Image,Description,TuitionFee,StartDate,EndDate,Category,Quantity) VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String CREATE_ORDER = "INSERT INTO tblOrder(OrderID,CourseID,Quantity,DateBuy) VALUES (?,?,?,?)";
    private static final String COURSE_BY_ID = "SELECT * FROM tblCourse WHERE ID = ?";
    private static final String TOTAL_PAGE = "SELECT COUNT(*) FROM tblCourse";
    private static final String List_PAGE = "SELECT * FROM tblCourse ORDER BY ID OFFSET ? ROWS FETCH NEXT 3 ROWS ONLY";

    public User checkLogin(String userID, String password) throws SQLException {
        User user = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(LOGIN);
            ptm.setString(1, userID);
            ptm.setString(2, password);
            rs = ptm.executeQuery();
            if (rs.next()) {
                String fullName = rs.getString("FullName");
                String role = rs.getString("Role");
                String userEmail = rs.getString("UserEmail");
                user = new User(userID, fullName, userEmail, " ", role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return user;
    }

    public List<Order> order(String orderID) throws SQLException {
        List<Order> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(ORDER);
            ptm.setString(1, orderID);
            rs = ptm.executeQuery();
            while (rs.next()) {
                list.add(new Order(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<Order> listOrder() throws SQLException {
        List<Order> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(List_ORDER);
            rs = ptm.executeQuery();
            while (rs.next()) {
                list.add(new Order(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<Course> getListCourse() throws SQLException {
        List<Course> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(COURSE);
            rs = ptm.executeQuery();

            while (rs.next()) {
                list.add(new Course(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getFloat(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getString(10)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<Course> serchAll(String key, String cate) throws SQLException {
        List<Course> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(SEARCH);
            ptm.setString(1, "%" + key + "%");
            ptm.setString(2, cate);
            rs = ptm.executeQuery();
            while (rs.next()) {
                list.add(new Course(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getFloat(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getString(10)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<Course> serchByText(String key) throws SQLException {
        List<Course> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(SEARCH_TEXT);
            ptm.setString(1, "%" + key + "%");
            rs = ptm.executeQuery();
            while (rs.next()) {
                list.add(new Course(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getFloat(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getString(10)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public List<Course> serchByCate(String cate) throws SQLException {
        List<Course> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(SEARCH_CATEGORY);
            ptm.setString(1, cate);
            rs = ptm.executeQuery();
            while (rs.next()) {
                list.add(new Course(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getFloat(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getString(10)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public boolean updateCourse(String courseID, String courseName, String description, float tuitionFee,
            String endDate, String category, int quantity, String update) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_COURSE);
                ptm.setString(1, courseName);
                ptm.setString(2, description);
                ptm.setFloat(3, tuitionFee);
                ptm.setString(4, endDate);
                ptm.setString(5, category);
                ptm.setInt(6, quantity);
                ptm.setString(7, update);
                ptm.setString(8, courseID);
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
    
    public boolean updateOrder(String orderID, String courseID, String status) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_ORDER);
                ptm.setString(1, status);
                ptm.setString(2, orderID);
                ptm.setString(3, courseID);
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean createProduct(String courseID, String courseName, String image, String description, float tuitionFee, String starDate,
            String endDate, String category, int quantity) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE_COURSE);
                ptm.setString(1, courseID);
                ptm.setString(2, courseName);
                ptm.setString(3, image);
                ptm.setString(4, description);
                ptm.setFloat(5, tuitionFee);
                ptm.setString(6, starDate);
                ptm.setString(7, endDate);
                ptm.setString(8, category);
                ptm.setInt(9, quantity);

                check = ptm.executeUpdate() > 0 ? true : false;
            }

        } catch (Exception e) {

        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public Course getCourseByID(String ID) throws SQLException {
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(COURSE_BY_ID);
            ptm.setString(1, ID);
            rs = ptm.executeQuery();
            while (rs.next()) {
                return new Course(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getFloat(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getString(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return null;
    }

    public boolean createOrder(String orderID, String CourseID, int Quantity, String DateBuy) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CREATE_ORDER);
                ptm.setString(1, orderID);
                ptm.setString(2, CourseID);
                ptm.setInt(3, Quantity);
                ptm.setString(4, DateBuy);
                check = ptm.executeUpdate() > 0 ? true : false;
            }

        } catch (Exception e) {

        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public int getTotalCourse() {
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(TOTAL_PAGE);
            rs = ptm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {

        }
        return 0;
    }

    public List<Course> pagingCourse(int index) throws SQLException {
        List<Course> list = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DBUtils.getConnection();
            ptm = conn.prepareStatement(List_PAGE);
            ptm.setInt(1, (index - 1) * 3);
            rs = ptm.executeQuery();
            while (rs.next()) {
                list.add(new Course(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getFloat(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getString(10)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static void main(String[] args) throws SQLException {
        DAO dao = new DAO();
        boolean check = dao.updateOrder("SA147852", "PIA001", "Payment completed");
        System.out.println(check);
    }

}
