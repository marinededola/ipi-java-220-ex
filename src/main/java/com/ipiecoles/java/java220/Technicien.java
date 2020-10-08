package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

//#301
public class Technicien extends Employe implements Comparable<Technicien>{
    public Technicien(){

    }
    public Technicien(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.setGrade(grade);
    }

    //#302
    private Integer grade;

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    //#303
    public void setSalaire(Double salaire){
        super.setSalaire(salaire + (salaire * grade * 0.1));
    }

    //#304
    public Integer getNbConges(){
        return super.getNbConges() + this.getNombreAnneeAnciennete();
    }

    //#306
    @Override
    public Double getPrimeAnnuelle() {
        Double primeBase = super.getPrimeAnnuelle();
        return primeBase + (primeBase * grade * 0.1) + Entreprise.PRIME_ANCIENNETE * this.getNombreAnneeAnciennete();
    }

    //#307
    @Override
    public int compareTo(Technicien o) {
        Integer compare = Integer.compare(this.grade, o.getGrade());
        return compare;
    }

}
