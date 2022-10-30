package com.example.moneytracking.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.moneytracking.entities.Spending;

@Database(entities = {Spending.class}, version = 1)
public abstract class ApplicationDatabase extends RoomDatabase {
    public abstract SpendingDao SpendingDao();
}