package com.example.wordrng.view_model;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.wordrng.bo.Niveau;
import com.example.wordrng.repository.NiveauRepository;

import java.util.List;


public class NiveauViewModel extends AndroidViewModel
{
    /**
     * Repository necessaire au ViewModel
     */
    NiveauRepository niveauRepository;

    /**
     * Données pour la vue
     */
    private LiveData<List<Niveau>> niveaux;

    public NiveauViewModel(@NonNull Application application)
    {
        super(application);
        niveauRepository = new NiveauRepository(application);
        init();
    }

    private void init()
    {
        niveaux = niveauRepository.get();
    }

    public void insert(Niveau niveau)
    {
        Log.wtf("XXX","UtilisateursViewModel - public void insert(Utilisateur utilisateur)");
        niveauRepository.insert(niveau);
    }

    public LiveData<List<Niveau>> get()
    {
        Log.wtf("XXX","UtilisateursViewModel - public LiveData<List<Utilisateur>> get()");
        return niveaux;
    }

    public LiveData<Niveau> selectById(int id){ return niveauRepository.selectById(id);}

    public void update(Niveau niveau)
    {
        niveauRepository.update(niveau);
    }

    public void delete(Niveau niveau)
    {
        niveauRepository.delete(niveau);
    }

    public void delete()
    {
        niveauRepository.delete();
    }
}
