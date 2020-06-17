package com.example.todomvvm.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;

import com.example.todomvvm.LoginEntry;

import java.util.List;

public class Repository {

    TaskDao dao;

    public Repository(AppDatabase appDatabase){
        dao = appDatabase.taskDao();
    }

    public LiveData<List<TaskEntry>> getTasks(){
       return dao.loadAllTasks();
    }

    public LiveData<TaskEntry> getTaskById(int taskId){
        return dao.loadTAskById(taskId);
    }

    public void updateTask(final TaskEntry task){
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dao.update(task);
            }
        });
    }

    public void deleteTask(final TaskEntry task){
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
               dao.deleteTask(task);
            }
        });
    }

    public  void  insertTask(final TaskEntry task){
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dao.insertTask(task);
            }
        });
    }

    public void deleteAll()
    {
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dao.deleteAllTask();
            }
        });

    }

    //Login code section

    public void insertPattern(final LoginEntry pattern)
    {
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dao.insertPattern(pattern);
            }
        });
    }

    public LiveData<String> getPatternById()
    {
        return dao.loadPatternById();
    }

    public LiveData<Integer> getPatternCount()
    {
        return dao.getLoginCount();
    }
}
