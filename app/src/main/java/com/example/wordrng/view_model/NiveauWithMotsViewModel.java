package com.example.wordrng.view_model;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.wordrng.bo.Niveau;
import com.example.wordrng.bo.NiveauWithMots;
import com.example.wordrng.repository.NiveauRepository;
import com.example.wordrng.repository.NiveauWithMotsRepository;

import java.util.List;

public class NiveauWithMotsViewModel extends AndroidViewModel {
    /**
     * Repository necessaire au ViewModel
     */
    NiveauWithMotsRepository niveauWithMotsRepository;

    /**
     * Données pour la vue
     */
    private LiveData<List<NiveauWithMots>> niveaux;

    public NiveauWithMotsViewModel(@NonNull Application application)
    {
        super(application);
        niveauWithMotsRepository = new NiveauWithMotsRepository(application);
        init();
    }

    private void init()
    {
        niveaux = niveauWithMotsRepository.getNiveauWithMots();
    }

    public LiveData<List<NiveauWithMots>> get()
    {
        Log.wtf("XXX","UtilisateursViewModel - public void insert(Utilisateur utilisateur)");
        return niveaux;
    }

    public LiveData<NiveauWithMots> get(int id)
    {
        Log.wtf("XXX","UtilisateursViewModel - public void insert(Utilisateur utilisateur)");
        return niveauWithMotsRepository.getNiveauWithMotsById(id);
    }
}
