package com.example.moneytracking.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.moneytracking.entities.Spending;

import java.util.List;

@Dao
public interface SpendingDao {
    // get a spending in price range
    @Query("SELECT * FROM spending WHERE cost BETWEEN :lowPrice AND :highPrice")
    List<Spending> getSpendingsInCostRange(int lowPrice, int highPrice);

    // get all spendings
    @Query("SELECT * FROM spending")
    List<Spending> getAll();

    // insert a spending
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSpendings(Spending... spendings);
}
