package com.example.newfinanceapp;

public class Reminder {
    public int id;
    public String type, amount, date;

<<<<<<< HEAD
    public Reminder(int id, String type, String amount, String date){
=======
    public Income(int id, String type, String amount, String date){
>>>>>>> 04e8260 (Add all files again)
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Reminder(){

    }
}
