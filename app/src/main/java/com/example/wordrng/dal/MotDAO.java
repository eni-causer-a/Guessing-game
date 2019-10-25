package com.example.wordrng.dal;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.wordrng.bo.Mot;

import java.util.List;

@Dao
public interface MotDAO {
    @Insert
    void insert(Mot mot);

    @Query("SELECT * FROM Mot WHERE id=:id")
    LiveData<Mot> selectById(int id);

    @Query("SELECT * FROM Mot")
    LiveData<List<Mot>> get();

    @Update
    void update(Mot mot);

    @Delete
    void delete(Mot mot);

    @Query("DELETE FROM Mot")
    void delete();
}
