package com.example.wordrng.bo;

import androidx.lifecycle.LiveData;
import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class NiveauWithMots {


    @Embedded
    private Niveau niveau;

    @Relation(parentColumn = "id",
            entityColumn = "niveauId")
    private List<Mot> motList;

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public List<Mot> getMotList() {
        return motList;
    }

    public void setMotList(List<Mot> motList) {
        this.motList = motList;
    }
}
