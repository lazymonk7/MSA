package com.example.moneytracking.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.moneytracking.entities.Spending;

@Database(entities = {Spending.class}, version = 1)
public abstract class ApplicationDatabase extends RoomDatabase {
    private static ApplicationDatabase instance;
    public abstract SpendingDao SpendingDao();

    public static synchronized ApplicationDatabase getInstance(Context context) {
        if (ApplicationDatabase.instance == null) {
            ApplicationDatabase.instance = Room.databaseBuilder(context,
                    ApplicationDatabase.class, "spendings-db").build();
        }
        return instance;
    }
}