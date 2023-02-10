package com.example.project.models;

import com.example.project.entities.Customers;
import com.example.project.entities.Payments;
import com.example.project.entities.services.Box;
import com.example.project.helpers.IConnection;
import com.example.project.helpers.Repo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;
import java.util.Arrays;

public class PaymentModel {

    public static final Connection connection = IConnection.getConnection();


    public void insertPayment(String customerPhone, String customerGender, Payments payment) throws SQLException {
        connection.setAutoCommit(false);
        try {
            String insertPaymentQuery = "INSERT INTO payments(exp_date, amount_paid, paid_by," + "discount,poxing,box_fk, customer_phone_fk) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(insertPaymentQuery);
            ps.setString(1, payment.getExpDate().toString());
            ps.setDouble(2, payment.getAmountPaid());
            ps.setString(3, payment.getPaidBy());
            ps.setDouble(4, payment.getDiscount());
            ps.setBoolean(5, payment.isPoxing());

            if (payment.getBox() == null) {
                ps.setString(6, null);
            } else {
                ps.setInt(6, payment.getBox().getBoxId());
                setTookBoxIsReadyFalse(payment.getBox());
            }

            ps.setString(7, customerPhone);
            ps.executeUpdate();

            System.out.println("Payment inserted");

            //-------------make the payment's report-------------
            makeReport(payment, customerGender);
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
        }
    }


    public ObservableList<Payments> fetchAllOnlinePayment(String customerPhone) throws SQLException {

        ObservableList<Payments> payments = FXCollections.observableArrayList();
        Statement statement = connection.createStatement();

        Payments payment = null;
        ResultSet rs = statement.executeQuery("SELECT * FROM payments LEFT JOIN box b on payments.box_fk = b.box_id " + "WHERE customer_phone_fk=" + customerPhone + " AND is_online=true AND pending=false");

        while (rs.next()) {
            Box box = null;
            if (rs.getString("box_fk") != null) {
                box = new Box(rs.getInt("box_id"), rs.getString("box_name"), rs.getBoolean("is_ready"));
            }

            payment = new Payments(rs.getInt("payment_id"), rs.getString("payment_date"), LocalDate.parse(rs.getString("exp_date")), rs.getString("month"), rs.getString("year"), rs.getDouble("amount_paid"), rs.getString("paid_by"), rs.getDouble("discount"), rs.getBoolean("poxing"), rs.getString("customer_phone_fk"), rs.getBoolean("is_online"), rs.getBoolean("pending"));
            payment.setBox(box);
            payments.add(payment);

        }
        statement.close();
        rs.close();
        return payments;
    }

    //-----------------------Fetch customer's payments---------------------
    public ObservableList<Payments> fetchAllCustomersPayments(String phone) throws SQLException {
        //-------Fetch payments according to customer that belongs--------tested......
        ObservableList<Payments> payments = FXCollections.observableArrayList();
        Statement statement = connection.createStatement();

        Payments payment = null;
        ResultSet rs = statement.executeQuery("SELECT * FROM payments LEFT JOIN box b on payments.box_fk = b.box_id " +
                "WHERE customer_phone_fk=" + phone + " ORDER BY exp_date DESC");

        while (rs.next()) {
            Box box = null;
            if (rs.getString("box_fk") != null) {
                box = new Box(rs.getInt("box_id"), rs.getString("box_name"), rs.getBoolean("is_ready"));
            }

            payment = new Payments(rs.getInt("payment_id"), rs.getString("payment_date"),
                    LocalDate.parse(rs.getString("exp_date")), rs.getString("month"),
                    rs.getString("year"), rs.getDouble("amount_paid"),
                    rs.getString("paid_by"), rs.getDouble("discount"),
                    rs.getBoolean("poxing"), rs.getString("customer_phone_fk"),
                    rs.getBoolean("is_online"), rs.getBoolean("pending"));
            payment.setBox(box);
            payments.add(payment);
        }
        statement.close();
        rs.close();

        return payments;
    }


    //------------------helper methods---------------
    private static void makeReport(Payments payment, String customerGender) throws SQLException {
        Statement st = connection.createStatement();
        if (customerGender.equals("Male") && payment.getBox() != null) {
            DailyReportDTO.dailyReportMaleWithBox(st);
        } else if (customerGender.equals("Female") && payment.getBox() != null) {
            DailyReportDTO.dailyReportFemaleWithBox(st);
        } else if (payment.getBox() == null && customerGender.equals("Male")) {
            DailyReportDTO.dailyReportMaleWithOutBox(st);
        } else if (payment.getBox() == null && customerGender.equals("Female")) {
            DailyReportDTO.dailyReportFemaleWithOutBox(st);
        }
        int arr[] = st.executeBatch();
        System.out.println(Arrays.toString(arr));
        st.close();
    }

    private static void setTookBoxIsReadyFalse(Box box) throws SQLException {
        String boxFalseQuery = "UPDATE box SET is_ready=false WHERE box_id=" + box.getBoxId();
        Statement statement = connection.createStatement();
        statement.executeUpdate(boxFalseQuery);
        box.setReady(false);
        System.out.println(box.getBoxName() + " made false");
    }

    public static void setTookBoxIsReadyTrue(Box box) throws SQLException {
        String boxFalseQuery = "UPDATE box SET is_ready=true WHERE box_id=" + box.getBoxId();
        Statement statement = connection.createStatement();
        statement.executeUpdate(boxFalseQuery);
        //set the box off
        box.setReady(true);
        System.out.println(box.getBoxName() + " made false");
    }
}
