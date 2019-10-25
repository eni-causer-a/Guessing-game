package com.example.wordrng.repository;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;


import com.example.wordrng.bo.Niveau;
import com.example.wordrng.dal.AppDatabase;
import com.example.wordrng.dal.NiveauDAO;

import java.util.List;


public class NiveauRepository {
    private NiveauDAO niveauDao;
    private LiveData<List<Niveau>> niveaux;

    public NiveauRepository(Application application) {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        niveauDao = appDatabase.niveauDao();
        niveaux = niveauDao.get();

    }

    public void insert(Niveau niveau) {
        Log.wtf("XXX", "NiveauRepository - public LiveData<List<Niveau>> insert()");
        new InsertNiveauAsync(niveauDao).execute(niveau);
    }

    public LiveData<List<Niveau>> get() {
        Log.wtf("XXX", "NiveauRepository - public LiveData<List<Niveau>> get()");
        return niveaux;
    }

    public void update(Niveau niveau) {
        new UpdateNiveauAsync(niveauDao).execute(niveau);
    }

    public void delete(Niveau niveau) {
        new DeleteNiveauAsync(niveauDao).execute(niveau);
    }

    public void delete() {
        new DeleteNiveauxAsync(niveauDao).execute();
    }

    public LiveData<Niveau> selectById(int id) {
        return niveauDao.selectById(id);
    }


    private static class InsertNiveauAsync extends AsyncTask<Niveau, Void, Void> {
        NiveauDAO dao;

        public InsertNiveauAsync(NiveauDAO dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Niveau... niveaux) {
            this.dao.insert(niveaux[0]);
            return null;
        }
    }

    private static class UpdateNiveauAsync extends AsyncTask<Niveau, Void, Void> {
        NiveauDAO dao;

        public UpdateNiveauAsync(NiveauDAO dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Niveau... niveaux) {
            this.dao.update(niveaux[0]);
            return null;
        }
    }

    private static class DeleteNiveauAsync extends AsyncTask<Niveau, Void, Void> {
        NiveauDAO dao;

        public DeleteNiveauAsync(NiveauDAO dao) {
            this.dao = dao;
        }


        @Override
        protected Void doInBackground(Niveau... niveaux) {
            this.dao.delete(niveaux[0]);
            return null;
        }
    }

    private static class DeleteNiveauxAsync extends AsyncTask<Void, Void, Void> {
        NiveauDAO dao;

        public DeleteNiveauxAsync(NiveauDAO dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            this.dao.delete();
            return null;
        }
    }

}
