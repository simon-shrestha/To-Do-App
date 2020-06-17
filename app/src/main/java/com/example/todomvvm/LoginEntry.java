package com.example.todomvvm;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "login")
public class LoginEntry {
    @NonNull
    @PrimaryKey
    private int id;
    private String pattern;

    public LoginEntry(int id, String pattern)
    {
        this.id = id;
        this.pattern = pattern;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getPattern()
    {
        return pattern;
    }

    public void setPattern(String pattern)
    {
        this.pattern = pattern;
    }
}
