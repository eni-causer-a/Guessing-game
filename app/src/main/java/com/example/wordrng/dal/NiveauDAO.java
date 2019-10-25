package com.example.wordrng.dal;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.wordrng.bo.Niveau;

import java.util.List;

@Dao
public interface NiveauDAO {
    @Insert
    void insert(Niveau niveau);

    @Query("SELECT * FROM Niveau WHERE id=:id")
    LiveData<Niveau> selectById(int id);

    @Query("SELECT * FROM Niveau")
    LiveData<List<Niveau>> get();

    @Update
    void update(Niveau niveau);

    @Delete
    void delete(Niveau niveau);

    @Query("DELETE FROM Niveau")
    void delete();
}
