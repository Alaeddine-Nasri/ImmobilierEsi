package com.company;

import java.util.Iterator;
import java.util.Objects;
import java.util.TreeSet;

public class Proprietaire implements Comparable<Proprietaire> {
    protected String nom;
    private String num_tel;
    private String prenom;
    private String mail;
    private String adresse;
    protected TreeSet<Bien> liste_proprietees =new TreeSet<Bien>();

    public Proprietaire(String nom, String num_tel, String prenom, String mail, String adresse, TreeSet<Bien> liste_proprietees) {
        this.nom = nom;
        this.num_tel = num_tel;
        this.prenom = prenom;
        this.mail = mail;
        this.adresse = adresse;
        this.liste_proprietees = liste_proprietees;
    }
    public Proprietaire(String nom, String num_tel, String prenom, String mail, String adresse) {
        this.nom = nom;
        this.num_tel = num_tel;
        this.prenom = prenom;
        this.mail = mail;
        this.adresse = adresse;

    }
    public void afficher_biens_proprietaires(){
        Iterator<Bien> iterator= liste_proprietees.iterator();
        while (iterator.hasNext()){
            Bien it=iterator.next();
            it.afficher();
            System.out.println("------------------------------");
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proprietaire that = (Proprietaire) o;
        return nom.equals(that.nom) &&
                prenom.equals(that.prenom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom);
    }

    @Override
    public int compareTo(Proprietaire proprietaire) {
        return 0;
    }
}
