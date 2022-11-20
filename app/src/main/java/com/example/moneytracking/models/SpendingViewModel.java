package com.example.moneytracking.models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.moneytracking.data.ApplicationDatabase;
import com.example.moneytracking.entities.Spending;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SpendingViewModel extends AndroidViewModel {
    private ApplicationDatabase appDatabase;
    private MutableLiveData<List<Spending>> spendings;
    private final Executor executor = Executors.newSingleThreadExecutor();
    private Semaphore semaphore; // used to lock the methods (load/add) which interact with the db

    public SpendingViewModel(@NonNull Application application) {

        super(application);
        spendings = new MutableLiveData<>();
        this.appDatabase = ApplicationDatabase.getInstance(application.getApplicationContext());
        this.semaphore = new Semaphore(1);

        this.loadSpending();

    }
    public LiveData<List<Spending>> getSpendings() {
        return spendings;
    }
    public void loadSpending() {
        // load spendings from database
        executor.execute(() -> {
            try {
                semaphore.acquire();
                spendings.postValue(appDatabase.SpendingDao().getAll());
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public void addSpending(Spending spending) {
        // add spending to the database
        executor.execute(() -> {
            try {
                semaphore.acquire();
                appDatabase.SpendingDao().insertSpendings(spending);
                List<Spending> spendingsList = spendings.getValue();
                if (spendingsList == null) {
                    spendingsList = new ArrayList<Spending>();
                }
                spendingsList.add(spending);
                spendings.postValue(spendingsList);
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
