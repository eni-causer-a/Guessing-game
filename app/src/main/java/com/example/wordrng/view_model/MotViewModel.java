package com.example.wordrng.view_model;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.wordrng.bo.Mot;
import com.example.wordrng.repository.MotRepository;
import com.example.wordrng.repository.NiveauRepository;


import java.util.List;

public class MotViewModel extends AndroidViewModel {
    /**
     * Repository necessaire au ViewModel
     */
    MotRepository motRepository;

    /**
     * Données pour la vue
     */
    private LiveData<List<Mot>> mots;

    public MotViewModel(@NonNull Application application)
    {
        super(application);
        motRepository = new MotRepository(application);
        init();
    }

    private void init()
    {
        mots = motRepository.get();
    }

    public void insert(Mot mot)
    {
        Log.wtf("XXX","MotViewModel - public void insert(Mot mot)");
        motRepository.insert(mot);
    }

    public LiveData<List<Mot>> get()
    {
        Log.wtf("XXX","MotViewModel - public LiveData<List<Mot>> get()");
        return mots;
    }

    public LiveData<Mot> selectById(int id){ return motRepository.selectById(id);}

    public void update(Mot mot)
    {
        motRepository.update(mot);
    }

    public void delete(Mot mot)
    {
        motRepository.delete(mot);
    }

    public void delete()
    {
        motRepository.delete();
    }
}
