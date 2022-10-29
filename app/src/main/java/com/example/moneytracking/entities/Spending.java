package com.example.moneytracking.entities;

import java.util.Calendar;
import java.util.Date;

public class Spending {

    private int cost;
    private String title;
    private Date buyDate;

    public Spending(String title, int cost, Date buyDate) throws InvalidSpendingException {
        if (title == null || buyDate == null) {
            throw new InvalidSpendingException("title or cost are null");
        }

        if (title.equals("")) {
            throw new InvalidSpendingException("title cannot be an empty string");
        }

        this.cost = cost;
        this.title = title;
        this.buyDate = buyDate;
    }

    public Spending(String title, int cost) throws InvalidSpendingException {
        this(title, cost, Calendar.getInstance().getTime());
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

    @Override
    public String toString() {
        return "Spending{" +
                "cost=" + cost +
                ", title='" + title + '\'' +
                ", buyDate=" + buyDate +
                '}';
    }

    public static class InvalidSpendingException extends Exception {
        public InvalidSpendingException(String message) {
            super(message);
        }
    }
}
