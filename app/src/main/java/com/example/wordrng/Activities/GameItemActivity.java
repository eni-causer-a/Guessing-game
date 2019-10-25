package com.example.wordrng.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wordrng.R;
import com.example.wordrng.bo.Mot;
import com.example.wordrng.bo.Niveau;
import com.example.wordrng.bo.NiveauWithMots;
import com.example.wordrng.view_model.NiveauViewModel;
import com.example.wordrng.view_model.NiveauWithMotsViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GameItemActivity extends AppCompatActivity {
    private NiveauWithMotsViewModel niveauWithMotsViewModel;
    private NiveauWithMots niveauSelected;
    private int index ;
    private Context context;
    Mot motSelected;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_item);
        id = getIntent().getIntExtra("niveau", 0);
        index = getIntent().getIntExtra("index", 0);
        niveauWithMotsViewModel = ViewModelProviders.of(this).get(NiveauWithMotsViewModel.class);
        context = this;

        niveauWithMotsViewModel.get(id).observe(this, new Observer<NiveauWithMots>() {
            @Override
            public void onChanged(@Nullable NiveauWithMots niveau) {
                niveauSelected = niveau;
                if (niveau == null){
                    Intent i = new Intent(context, LevelChoiceActivity.class);
                    startActivity(i);
                }
                if(niveauSelected.getMotList().get(index).isReponse()){
                    index++;

                }

                motSelected = niveauSelected.getMotList().get(index);

                TextView textLevel = findViewById(R.id.textGameLevelName);
                String libelle = getResources().getString(R.string.level) + " " + niveau.getNiveau().getNumero();
                textLevel.setText(libelle);


                List<Character> list = new ArrayList<>();

                for (char c : motSelected.getLibelle().toCharArray()) {
                    list.add(c);
                }
                Collections.shuffle(list);
                for(char c: list){
                    TextView textLettre = new TextView(context);
                    TextView textv = new TextView(context);
                    textv.setTextSize(60);
                    textv.setText(" ");
                    textLettre.setText(String.valueOf(c).toUpperCase());
                    textLettre.setGravity(Gravity.CENTER);
                    //textLettre.setBackgroundResource(R.drawable.bouton_vert_1);
                    textLettre.setTextSize(60);
                    LinearLayout linearLayout = findViewById(R.id.linearGameLayout);

                    linearLayout.addView(textLettre);
                    linearLayout.addView(textv);


                }
                ImageView image = findViewById(R.id.imageViewGame);
                image.setAdjustViewBounds(true);

                final Bitmap bitmap = BitmapFactory.decodeByteArray(motSelected.getImage(), 0, motSelected.getImage().length);
                image.setImageBitmap(Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), false));
                Button next = findViewById(R.id.buttonNextGame);

                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(index >= niveauSelected.getMotList().size()) {
                                Intent i = new Intent(context, LevelChoiceActivity.class);
                                startActivity(i);
                            }

                            if((index+1) < niveauSelected.getMotList().size()) {
                                if(niveauSelected.getMotList().get(index+1).isReponse() && (index+2) >= niveauSelected.getMotList().size()){
                                    Intent i = new Intent(context, LevelChoiceActivity.class);
                                    startActivity(i);
                                }
                                else {
                                    Intent i = new Intent(context, GameItemActivity.class);
                                    i.putExtra("index", index + 1);
                                    i.putExtra("niveau", id);
                                    startActivity(i);
                                }

                            }else{
                                Intent i = new Intent(context, LevelChoiceActivity.class);
                                startActivity(i);
                            }

                        }
                    });



            }
        });


    }
}
