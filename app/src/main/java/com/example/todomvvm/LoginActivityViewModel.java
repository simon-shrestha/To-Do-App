package com.example.todomvvm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.todomvvm.database.AppDatabase;
import com.example.todomvvm.database.Repository;

public class LoginActivityViewModel extends AndroidViewModel {

    AppDatabase database;
    Repository repo;


    public LoginActivityViewModel(@NonNull Application application) {
        super(application);
        database = AppDatabase.getInstance(application);
        repo = new Repository(database);
    }

    public LiveData<String> getPatternValue()
    {
        return repo.getPatternById();
    }

    public void insertPattern(LoginEntry pattern)
    {
        repo.insertPattern(pattern);
    }

    public LiveData<Integer> getTotalCount()
    {
        return repo.getPatternCount();
    }
}
