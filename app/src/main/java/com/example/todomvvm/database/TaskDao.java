package com.example.todomvvm.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.todomvvm.LoginEntry;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("select * from task order by priority")
    LiveData<List<TaskEntry>> loadAllTasks();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTask(TaskEntry task);

    @Update
    void update(TaskEntry task);

    @Delete
    void deleteTask(TaskEntry task);

    @Query("Select * from task where id =:taskId")
    LiveData<TaskEntry> loadTAskById(int taskId);


    //Query for login

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPattern(LoginEntry pattern);

    @Query("select pattern from login where id = 1")
    LiveData<String> loadPatternById();

    @Query("select count(*) from login")
    LiveData<Integer> getLoginCount();

}
