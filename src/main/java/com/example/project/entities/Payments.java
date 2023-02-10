package com.example.project.entities;

import com.example.project.entities.services.Box;

import java.time.LocalDate;

public class Payments {
    private int paymentID;
    private String paymentDate;
    private final LocalDate expDate;
    private String month;
    private String year;
    private final double amountPaid;
    private final String paidBy;
    private final double discount;
    private final boolean poxing;
    private Box box;
    private final String customerFK;
    private boolean online;
    private boolean pending;

    public Payments(int paymentID, String paymentDate, LocalDate expDate, String month, String year, double amountPaid, String paidBy, double discount, boolean poxing, String customerFK, boolean online, boolean pending) {
        this.paymentID = paymentID;
        this.paymentDate = paymentDate;
        this.expDate = expDate;
        this.month = month;
        this.year = year;
        this.amountPaid = amountPaid;
        this.paidBy = paidBy;
        this.discount = discount;
        this.poxing = poxing;
        this.customerFK = customerFK;
        this.online = online;
        this.pending = pending;
    }

    public Payments(LocalDate expDate, double amountPaid, String paidBy, double discount, boolean poxing, String customerFK) {
        this.expDate = expDate;
        this.amountPaid = amountPaid;
        this.paidBy = paidBy;
        this.discount = discount;
        this.poxing = poxing;
        this.customerFK = customerFK;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public String getPaidBy() {
        return paidBy;
    }

    public double getDiscount() {
        return discount;
    }

    public boolean isPoxing() {
        return poxing;
    }

    public String getCustomerFK() {
        return customerFK;
    }

    public boolean isOnline() {
        return online;
    }

    public boolean isPending() {
        return pending;
    }

    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    @Override
    public String toString() {
        return "--paymentDate: " + paymentDate + " expDate: " + expDate + " is_online: " + isOnline() + "";
    }
}
