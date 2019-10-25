package com.example.wordrng.repository;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.wordrng.bo.Mot;
import com.example.wordrng.dal.AppDatabase;
import com.example.wordrng.dal.MotDAO;

import java.util.List;

public class MotRepository {

    private MotDAO motDao;
    private LiveData<List<Mot>> mots;

    public MotRepository(Application application)
    {
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        motDao = appDatabase.motDao();
        mots = motDao.get();
    }

    public void insert(Mot mot)
    {
        Log.wtf("XXX","MotRepository - public LiveData<List<Mot>> insert()");
        new MotRepository.InsertMotAsync(motDao).execute(mot);
    }

    public LiveData<List<Mot>> get()
    {
        Log.wtf("XXX","MotRepository - public LiveData<List<Mot>> get()");
        return mots;
    }

    public void update(Mot mot)
    {
        new MotRepository.UpdateMotAsync(motDao).execute(mot);
    }

    public void delete(Mot mot){
        new MotRepository.DeleteMotAsync(motDao).execute(mot);
    }

    public void delete()
    {
        new MotRepository.DeleteMotsAsync(motDao).execute();
    }

    public LiveData<Mot> selectById(int id){ return motDao.selectById(id);}



    private static class InsertMotAsync extends AsyncTask<Mot,Void,Void>
    {
        MotDAO dao;

        public InsertMotAsync(MotDAO dao)
        {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Mot... mots) {
            this.dao.insert(mots[0]);
            return null;
        }
    }

    private static class UpdateMotAsync extends AsyncTask<Mot,Void,Void>
    {
        MotDAO dao;

        public UpdateMotAsync(MotDAO dao)
        {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Mot... mots) {
            this.dao.update(mots[0]);
            return null;
        }
    }

    private static class DeleteMotAsync extends AsyncTask<Mot,Void,Void>
    {
        MotDAO dao;

        public DeleteMotAsync(MotDAO dao)
        {
            this.dao = dao;
        }


        @Override
        protected Void doInBackground(Mot... mots) {
            this.dao.delete(mots[0]);
            return null;
        }
    }

    private static class DeleteMotsAsync extends AsyncTask<Void,Void,Void>
    {
        MotDAO dao;

        public DeleteMotsAsync(MotDAO dao)
        {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids)
        {
            this.dao.delete();
            return null;
        }
    }
}
