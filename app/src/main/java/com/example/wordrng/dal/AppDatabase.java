package com.example.wordrng.dal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.wordrng.R;
import com.example.wordrng.bo.Mot;
import com.example.wordrng.bo.Niveau;
import com.example.wordrng.bo.NiveauWithMots;

import java.io.ByteArrayOutputStream;

@Database(entities = {Niveau.class, Mot.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;
    private static Context contexte;
    public abstract NiveauDAO niveauDao();
    public abstract MotDAO motDao();
    public abstract NiveauWithMotsDAO niveauWithMotsDAO();

    public static synchronized AppDatabase getInstance(Context context) {
        contexte = context;
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "ggbdd.db")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }
        return INSTANCE;
    }

    private static Callback roomCallBack = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            new PopulateBddAsync().execute(INSTANCE);

        }
    };

    private static class PopulateBddAsync extends AsyncTask<AppDatabase, Void, Void> {
        @Override
        protected Void doInBackground(AppDatabase... voids) {
            NiveauDAO daoNivo = voids[0].niveauDao();
            Niveau nivo1 = new Niveau(1,"4 lettres",1,0);
            Niveau nivo2 = new Niveau(2,"5 lettres",2,0);
            Niveau nivo3 = new Niveau(3,"6 lettres",3,0);
            Niveau nivo4 = new Niveau(4,"7 lettres",4,0);
            Niveau nivo5 = new Niveau(5,"8 lettres",5,0);
            daoNivo.insert(nivo1);
            daoNivo.insert(nivo2);
            daoNivo.insert(nivo3);
            daoNivo.insert(nivo4);
            daoNivo.insert(nivo5);
            MotDAO daoMot = voids[0].motDao();
            daoMot.insert(new Mot(nivo1.getId(),"pain",getBytesFromBitmap(BitmapFactory.decodeResource(contexte.getResources(), R.drawable.pain)), false));
            daoMot.insert(new Mot(nivo1.getId(),"juge",getBytesFromBitmap(BitmapFactory.decodeResource(contexte.getResources(), R.drawable.juge)), false));
            daoMot.insert(new Mot(nivo1.getId(),"veau",getBytesFromBitmap(BitmapFactory.decodeResource(contexte.getResources(), R.drawable.veau)), false));

            daoMot.insert(new Mot(nivo2.getId(),"singe",getBytesFromBitmap(BitmapFactory.decodeResource(contexte.getResources(), R.drawable.singe)), false));
            daoMot.insert(new Mot(nivo2.getId(),"nakim",getBytesFromBitmap(BitmapFactory.decodeResource(contexte.getResources(), R.drawable.singe)), false));
            daoMot.insert(new Mot(nivo2.getId(),"chips",getBytesFromBitmap(BitmapFactory.decodeResource(contexte.getResources(), R.drawable.chips)), false));
            daoMot.insert(new Mot(nivo2.getId(),"blanc",getBytesFromBitmap(BitmapFactory.decodeResource(contexte.getResources(), R.drawable.blan)), false));
            daoMot.insert(new Mot(nivo2.getId(),"rouge",getBytesFromBitmap(BitmapFactory.decodeResource(contexte.getResources(), R.drawable.rouge)), false));
            daoMot.insert(new Mot(nivo2.getId(),"panda",getBytesFromBitmap(BitmapFactory.decodeResource(contexte.getResources(), R.drawable.panda)), false));
            daoMot.insert(new Mot(nivo2.getId(),"tente",getBytesFromBitmap(BitmapFactory.decodeResource(contexte.getResources(), R.drawable.tente)), false));



            daoMot.insert(new Mot(nivo3.getId(),"banane",getBytesFromBitmap(BitmapFactory.decodeResource(contexte.getResources(), R.drawable.banane)), false));
            daoMot.insert(new Mot(nivo3.getId(),"tennis",getBytesFromBitmap(BitmapFactory.decodeResource(contexte.getResources(), R.drawable.tennis)), true));

            daoMot.insert(new Mot(nivo4.getId(),"macaque",getBytesFromBitmap(BitmapFactory.decodeResource(contexte.getResources(), R.drawable.macaque)), false));
            daoMot.insert(new Mot(nivo4.getId(),"capucin",getBytesFromBitmap(BitmapFactory.decodeResource(contexte.getResources(), R.drawable.capucin)), false));
            daoMot.insert(new Mot(nivo4.getId(),"sapajou",getBytesFromBitmap(BitmapFactory.decodeResource(contexte.getResources(), R.drawable.sapajou)), false));
            daoMot.insert(new Mot(nivo4.getId(),"babouin",getBytesFromBitmap(BitmapFactory.decodeResource(contexte.getResources(), R.drawable.babouin)), false));
            daoMot.insert(new Mot(nivo4.getId(),"tamarin",getBytesFromBitmap(BitmapFactory.decodeResource(contexte.getResources(), R.drawable.tamarin)), false));
            daoMot.insert(new Mot(nivo4.getId(),"ouakari",getBytesFromBitmap(BitmapFactory.decodeResource(contexte.getResources(), R.drawable.ouakari)), false));
            daoMot.insert(new Mot(nivo4.getId(),"gorille",getBytesFromBitmap(BitmapFactory.decodeResource(contexte.getResources(), R.drawable.gorille)), false));

            daoMot.insert(new Mot(nivo5.getId(),"singerie",getBytesFromBitmap(BitmapFactory.decodeResource(contexte.getResources(), R.drawable.macaque)), false));



            return null;
        }
    }
    public static byte[] getBytesFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
        return stream.toByteArray();
    }


}