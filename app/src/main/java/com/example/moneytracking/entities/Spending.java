package com.example.moneytracking.entities;

import java.util.Calendar;
import java.util.Date;

public class Spending {
    private int cost;
    private String title;
    private Date buyDate;

    public Spending(int cost, String title, Date buyDate) {
        this.cost = cost;
        this.title = title;
        this.buyDate = buyDate;
    }

    public Spending(int cost, String title) {
        this.cost = cost;
        this.title = title;
        this.buyDate = Calendar.getInstance().getTime();;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }
}
