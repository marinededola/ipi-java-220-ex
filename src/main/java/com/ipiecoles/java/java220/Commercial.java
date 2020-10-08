package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

//#201
public class Commercial extends Employe{
    //#204
    public Commercial(){

    }
    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
    }

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire,
                      Double caAnnuel, Integer performance) {
        this(nom, prenom, matricule, dateEmbauche, salaire, caAnnuel);
        this.performance = performance;
    }
    //#202
    private Double caAnnuel = 0d;

    public Double getCaAnnuel() {
        return caAnnuel;
    }

    public void setCaAnnuel(Double caAnnuel) {
        this.caAnnuel = caAnnuel;
    }

    //#206
    private Integer performance;

    public Integer getPerformance() {
        return performance;
    }

    public void setPerformance(Integer performance) {
        this.performance = performance;
    }

    public boolean performanceEgale (Integer perf){
        if (perf.equals(performance)){
            return true;
        } else{
            return false;
        }
    }

    //#203
    @Override
    public Double getPrimeAnnuelle() {
        Double prime = 0.05 * caAnnuel;
        if(prime < 500d ){
            prime = 500d;
        }
        return Math.ceil(prime);
    }

    //#205
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Commercial that = (Commercial) o;
        return Objects.equals(caAnnuel, that.caAnnuel);
    }

    //#207
    public Note equivalenceNote (){
        switch(performance){
            case 50:
            case 0:
                return Note.INSUFFISANT;
            case 100:
                return Note.PASSABLE;
            case 150:
                return Note.BIEN;

            case 200:
                return Note.TRES_BIEN;
            default:
                return null;
        }
    }
}
