package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.HashSet;

//#501
public class Manager extends Employe{
    @Override
    public Double getPrimeAnnuelle() {
        return null;
    }
    public Manager(){

    }

    public Manager(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, HashSet<Technicien> equipe) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.equipe = equipe;
    }
    //502
    private HashSet<Technicien> equipe = new HashSet();


    public HashSet<Technicien> getEquipe() {
        return equipe;
    }

    public void setEquipe(HashSet<Technicien> equipe) {
        this.equipe = equipe;
    }

    //#502
    public void ajoutTechnicienEquipe (Technicien tech){
        this.equipe.add(tech);
    }
}
