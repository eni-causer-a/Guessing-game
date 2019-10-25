package com.example.wordrng.dal;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.wordrng.bo.NiveauWithMots;

import java.util.List;

@Dao
public interface NiveauWithMotsDAO {

    @Transaction
    @Query("SELECT * from Niveau")
    public LiveData<List<NiveauWithMots>> getNiveauWithMots();

    @Transaction
    @Query("SELECT * from Niveau WHERE id =:id")
    LiveData<NiveauWithMots> getNiveauWithMotsById(int id);

}