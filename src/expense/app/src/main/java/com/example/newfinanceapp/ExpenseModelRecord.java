package com.example.newfinanceapp;

public class ExpenseModelRecord {

    //variables
    String note, amount, pay_method, category;

    //constructor


    public ExpenseModelRecord(String note, String amount, String pay_method, String category) {
        this.note = note;
        this.amount = amount;
        this.pay_method = pay_method;
        this.category = category;
    }

    //getters and setters

    public String getNote() {
        return note;
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
