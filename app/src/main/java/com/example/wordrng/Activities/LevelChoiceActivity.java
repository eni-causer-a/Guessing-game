package com.example.wordrng.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.wordrng.R;
import com.example.wordrng.adapter.NiveauAdapter;
import com.example.wordrng.bo.NiveauWithMots;
import com.example.wordrng.view_model.NiveauWithMotsViewModel;

import java.util.List;

public class LevelChoiceActivity extends AppCompatActivity {
    private Context context;
    private NiveauWithMotsViewModel niveauWithMotsViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_choice);
        context =this;
        niveauWithMotsViewModel = ViewModelProviders.of(this).get(NiveauWithMotsViewModel.class);

        final NiveauAdapter adpater = new
                NiveauAdapter(context);
        final RecyclerView listView = (RecyclerView) findViewById(R.id.listNiveaux);
        listView.setHasFixedSize(true);
        listView.setLayoutManager(new LinearLayoutManager(this));
        listView.setAdapter(adpater);

        niveauWithMotsViewModel.get().observe(this, new Observer<List<NiveauWithMots>>() {
            @Override
            public void onChanged(@Nullable List<NiveauWithMots> niveaux) {
                adpater.setNiveaux(niveaux);

            }
        });


    }
}
