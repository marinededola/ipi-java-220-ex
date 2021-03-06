package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

/**
 * Created by pjvilloud on 21/09/17.
 */
public abstract class Employe {

    //#101
    private String nom;
    private String prenom;
    private String matricule;
    private LocalDate dateEmbauche;
    private Double salaire;

    //#102
    public Employe(){

    };

    public Employe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire){
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.salaire = salaire;
    };

    //#103
    public final Integer getNombreAnneeAnciennete(){
        return LocalDate.now().getYear() - dateEmbauche.getYear();
    };

    //#105
    public Integer getNbConges(){
        return Entreprise.NB_CONGES_BASE;
    };

    //#101
    public String getNom(){
        return this.nom;
    };
    public void setNom(String nom) {
        this.nom = nom;
    };
    public String getPrenom(){
        return this.prenom;
    };
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    };
    public String getMatricule(){
        return this.matricule;
    };
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    };
    public LocalDate getDateEmbauche(){
        return this.dateEmbauche;
    };
    public void setDateEmbauche(LocalDate dateEmbauche) throws Exception {
        this.dateEmbauche = dateEmbauche;

        //#104
        if(LocalDate.now().isBefore(dateEmbauche)){
            throw new Exception("La date d'embauche ne peut être postérieure à la date courante");
        }
    };
    public Double getSalaire(){
        return this.salaire;
    };
    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    };

    //#106
    @Override
    public String toString() {
        return "Employe{nom='"+ nom + "', prenom='" + prenom + "', matricule='" + matricule + "', dateEmbauche=" + dateEmbauche + ", salaire=" + salaire + "}";
    };

    //#107
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return Objects.equals(nom, employe.nom) &&
                Objects.equals(prenom, employe.prenom) &&
                Objects.equals(matricule, employe.matricule) &&
                Objects.equals(dateEmbauche, employe.dateEmbauche) &&
                Objects.equals(salaire, employe.salaire);
    }

    //#108
    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, matricule, dateEmbauche, salaire);
    }

    //#109
    public Double augmenterSalaire (Double pourcentage){
        salaire = salaire + (salaire * pourcentage);
        return salaire;
    };

    //#110
    public abstract Double getPrimeAnnuelle();
}

