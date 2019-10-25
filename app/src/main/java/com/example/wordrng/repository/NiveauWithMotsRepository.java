package com.example.wordrng.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.wordrng.bo.NiveauWithMots;
import com.example.wordrng.dal.AppDatabase;
import com.example.wordrng.dal.NiveauWithMotsDAO;

import java.util.List;

public class NiveauWithMotsRepository {
    private NiveauWithMotsDAO niveauWithMotsDAO;

    public NiveauWithMotsRepository(Application application) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        niveauWithMotsDAO = appDatabase.niveauWithMotsDAO();

    }

    public LiveData<List<NiveauWithMots>> getNiveauWithMots() {
        return niveauWithMotsDAO.getNiveauWithMots();
    }

    public LiveData<NiveauWithMots> getNiveauWithMotsById(int id) {
        return niveauWithMotsDAO.getNiveauWithMotsById(id);
    }
}

