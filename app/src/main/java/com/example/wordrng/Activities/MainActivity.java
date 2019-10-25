package com.example.wordrng.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.wordrng.R;
import com.example.wordrng.bo.Niveau;
import com.example.wordrng.bo.NiveauWithMots;
import com.example.wordrng.view_model.NiveauViewModel;
import com.example.wordrng.view_model.NiveauWithMotsViewModel;
import com.facebook.stetho.Stetho;

import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private NiveauViewModel niveauViewModel;
    private NiveauWithMotsViewModel niveauWithMotsViewModel;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Stetho.initializeWithDefaults(this);
        niveauWithMotsViewModel = ViewModelProviders.of(this).get(NiveauWithMotsViewModel.class);
        niveauViewModel = ViewModelProviders.of(this).get(NiveauViewModel.class);
        Button playButton = findViewById(R.id.PlayAccueil);
        context = this;
        niveauWithMotsViewModel = ViewModelProviders.of(this).get(NiveauWithMotsViewModel.class);


        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, LevelChoiceActivity.class);
                startActivity(i);
            }
        });

        niveauWithMotsViewModel.get().observe(this, new Observer<List<NiveauWithMots>>() {
            @Override
            public void onChanged(@Nullable List<NiveauWithMots> niveaux) {
                List<NiveauWithMots> zebi = niveaux;

            }
        });

        niveauViewModel.get().observe(this, new Observer<List<Niveau>>() {
            @Override
            public void onChanged(@Nullable List<Niveau> articles) {
                List<Niveau> zebi = articles;

            }
        });
    }
}
