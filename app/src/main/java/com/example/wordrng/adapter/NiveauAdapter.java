package com.example.wordrng.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wordrng.Activities.GameItemActivity;
import com.example.wordrng.R;
import com.example.wordrng.bo.NiveauWithMots;

import java.util.ArrayList;
import java.util.List;


public class NiveauAdapter extends RecyclerView.Adapter<NiveauAdapter.ViewHolder> {

    private Context context;
    private List<NiveauWithMots> niveaux;

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Context context;
        List<NiveauWithMots> niveaux;
        TextView numero;
        TextView libelle;
        ProgressBar progression;

        ViewHolder(@NonNull View itemView, Context context, List<NiveauWithMots> niveaux, TextView numero, TextView libelle, ProgressBar progression) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.context = context;
            this.niveaux = niveaux;
            this.numero = numero;
            this.libelle = libelle;
            this.progression = progression;
        }

        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();
//Vers le niveau
            Intent intent = new Intent(context, GameItemActivity.class);
            intent.putExtra("niveau", niveaux.get(position).getNiveau().getId());
            context.startActivity(intent);
        }
    }

    public NiveauAdapter(Context context) {
        this.context = context;
        this.niveaux = new ArrayList<>();
    }

    @Override
    public NiveauAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ligne, parent, false);

        TextView numero = view.findViewById(R.id.numeroTextLigne);
        TextView libelle = view.findViewById(R.id.libelleTextLigne);
        ProgressBar progressBar = view.findViewById(R.id.progressBarLigne);

        return new ViewHolder(view, context, niveaux, numero, libelle, progressBar);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String msg= " " + String.valueOf(niveaux.get(position).getNiveau().getNumero());
        holder.numero.setText(msg);
        String libelleAndMots = niveaux.get(position).getNiveau().getLibelle()
                + " (" + niveaux.get(position).getMotList().size() + " mots)";
        holder.libelle.setText(libelleAndMots);
        holder.progression.setProgress(niveaux.get(position).getNiveau().getProgression());

    }

    public void setNiveaux(List<NiveauWithMots> liste) {
        this.niveaux = liste;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return niveaux.size();
    }
}
