package com.example.newfinanceapp;

public class ExpenseModelRecord {

    //variables
    String id ,note, amount, pay_method, category;
    byte [] image;

    //constructor


    public ExpenseModelRecord() {

    }

    public ExpenseModelRecord(String id, String note, byte [] image, String amount, String pay_method, String category) {
        this.id = id;
        this.note = note;
        this.image = image;
        this.amount = amount;
        this.pay_method = pay_method;
        this.category = category;
    }

    //getters and setters


    public String getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    public byte[] getImage() {
        return image;
    }

    public String getAmount() {
        return amount;
    }

    public String getPay_method() {
        return pay_method;
    }

    public String getCategory() {
        return category;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setPay_method(String pay_method) {
        this.pay_method = pay_method;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
