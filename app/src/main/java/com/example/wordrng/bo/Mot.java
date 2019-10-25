package com.example.wordrng.bo;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "Mot")
public class Mot {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int niveauId;
    private  String libelle;
    private byte[] image;
    private boolean reponse;

    public Mot(int niveauId, String libelle, byte[] image, boolean reponse) {
        this.niveauId = niveauId;
        this.libelle = libelle;
        this.image = image;
        this.reponse = reponse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNiveauId() {
        return niveauId;
    }

    public void setNiveauId(int niveauId) {
        this.niveauId = niveauId;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public boolean isReponse() {
        return reponse;
    }

    public void setReponse(boolean reponse) {
        this.reponse = reponse;
    }
}
