package com.company;

import java.util.Date;

public abstract class Habitable extends Bien {
    private int nbr_pieces;
    private Boolean meuble;

    public Habitable(String adresse, Wilaya wilaya, float surface, Proprietaire proprietaire, TypeDeTransaction transaction, float prix, boolean negociable, String descriptif, Date date, String photos, int nbr_pieces, Boolean meuble) {
        super(adresse, wilaya, surface, proprietaire, transaction, prix, negociable, descriptif, date, photos);
        this.nbr_pieces = nbr_pieces;
        this.meuble = meuble;
    }

    public Habitable(String adresse, Wilaya wilaya, float surface, Proprietaire proprietaire, TypeDeTransaction transaction, float prix, boolean negociable, String descriptif, Date date, String photos) {
        super(adresse, wilaya, surface, proprietaire, transaction, prix, negociable, descriptif, date, photos);
    }
    public Habitable(String adresse, Wilaya wilaya) {
        super(adresse,wilaya);
    }

    public Habitable(String adresse) {
        super(adresse);
    }
    public void afficherDetail(){
        super.afficherDetail();
        System.out.println("Nombre de pieces "+nbr_pieces);
        if(meuble)
            System.out.println("Ce bien est meuble");
        else System.out.println("Ce bien est non-meuble");
    }
}
