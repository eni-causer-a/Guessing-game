package com.example.wordrng.bo;


import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import static androidx.room.ForeignKey.CASCADE;


@Entity(tableName = "Niveau")
public class Niveau {
    @PrimaryKey
    private int id;
    private String libelle;
    private int numero;
    private int progression;

    public Niveau(int id, String libelle, int numero, int progression) {
        this.id = id;
        this.libelle = libelle;
        this.numero = numero;
        this.progression = progression;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getProgression() {
        return progression;
    }

    public void setProgression(int progression) {
        this.progression = progression;
    }


}
