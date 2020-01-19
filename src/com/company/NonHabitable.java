package com.company;

import java.util.Date;

public abstract class NonHabitable extends Bien {
    private int nbr_facades;
    private String etat_juridique;

    public NonHabitable(String adresse, Wilaya wilaya, float surface, Proprietaire proprietaire, TypeDeTransaction transaction, float prix, boolean negociable, String descriptif, Date date, String photos, int nbr_facades, String etat_juridique) {
        super(adresse, wilaya, surface, proprietaire, transaction, prix, negociable, descriptif, date, photos);
        this.nbr_facades = nbr_facades;
        this.etat_juridique = etat_juridique;
    }

    public NonHabitable(String adresse, Wilaya wilaya) {
        super(adresse,wilaya);
    }

    @Override
    public void afficherDetail() {
        super.afficherDetail();
        System.out.println("Nombre de facades "+nbr_facades);
        System.out.println("Etat juridique "+etat_juridique);
    }

    public int getNbr_facades() {
        return nbr_facades;
    }
}
