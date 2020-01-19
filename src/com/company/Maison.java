package com.company;

import java.util.Date;

public class Maison extends Habitable {
    private int nbr_etages;
    private boolean garage;
    private boolean jardin;
    private boolean piscine;
    private float surface_habitable;

    public Maison(String adresse, Wilaya wilaya, float surface, Proprietaire proprietaire, TypeDeTransaction transaction, float prix, boolean negociable, String descriptif, Date date, String photos, int nbr_pieces, Boolean meuble, int nbr_etages, boolean garage, boolean jardin, boolean piscine, float surface_habitable)  {
        super(adresse, wilaya, surface, proprietaire, transaction, prix, negociable, descriptif, date, photos, nbr_pieces, meuble);
        this.nbr_etages = nbr_etages;
        this.garage = garage;
        this.jardin = jardin;
        this.piscine = piscine;
        this.surface_habitable = surface_habitable;

    }

    public Maison(String adresse, Wilaya wilaya, float surface, Proprietaire proprietaire, TypeDeTransaction transaction, float prix, boolean negociable, String descriptif, Date date, String photos, int nbr_etages, boolean garage, boolean jardin, boolean piscine, float surface_habitable) {
        super(adresse, wilaya, surface, proprietaire, transaction, prix, negociable, descriptif, date, photos);
        this.nbr_etages = nbr_etages;
        this.garage = garage;
        this.jardin = jardin;
        this.piscine = piscine;
        this.surface_habitable = surface_habitable;
    }


    public void afficher(){
        super.afficher();
        System.out.println("Surface habitable (en m²)" +surface_habitable);
    }

    @Override
    public void afficherDetail() {
        super.afficherDetail();
        System.out.println("Nombre d'etages "+nbr_etages);
        if (jardin) System.out.print("Avec jardin- ");
        if(piscine)
            System.out.println("Avec piscine-  ");

        if(garage) System.out.println("Avec garage- ");
    }

    public float calculerprix(){
        float money=0;
        if (getTransaction() == TypeDeTransaction.vente){
            if ( getPrix() <= 5000000 ){
                if (getWilaya().prixMetreCarre <= 50000){
                    money = getPrix() + (getPrix()*3)/100;
                }
                else if (getWilaya().prixMetreCarre > 50000){
                    money = getPrix() + (getPrix()*35)/1000;
                }
            }
            else if ( (getPrix() > 5000000) && ( getPrix() <= 15000000) ){
                if (getWilaya().prixMetreCarre <= 50000){
                    money = getPrix() + (getPrix()*2)/100;
                }
                else if (getWilaya().prixMetreCarre > 50000){
                    money = getPrix() + (getPrix()*25)/1000;
                }
            }
            else if ( getPrix() > 15000000 ){
                if (getWilaya().prixMetreCarre <= 70000){
                    money = getPrix() + (getPrix()*1)/100;
                }
                else if (getWilaya().prixMetreCarre> 70000){
                    money = getPrix() + (getPrix()*2)/100;
                }
            }
            if (garage || jardin || piscine){
                money = money + getPrix()*5/1000 ;
            }
        }

        else if (getTransaction() == TypeDeTransaction.location){
            if(getSurface() <= 60){
                if (getWilaya().prixMetreCarre<= 50000){
                    money = getPrix() + (getPrix()*1)/100;
                }
                else if (getWilaya().prixMetreCarre > 50000){
                    money = getPrix() + (getPrix()*15)/1000;
                }
            }
            else if((getSurface() > 60) && (getSurface() < 150)){
                if (getWilaya().prixMetreCarre <= 50000){
                    money = getPrix() + (getPrix()*3)/100;
                }
                else if (getWilaya().prixMetreCarre > 50000) {
                    money = getPrix() + (getPrix() * 35) / 1000;
                }
            }
            else if(getSurface() >= 150){
                if (getWilaya().prixMetreCarre <= 50000){
                    money = getPrix() + (getPrix()*3)/100;
                }
                else if (getWilaya().prixMetreCarre > 50000){
                    money = getPrix() + (getPrix()*35)/1000;
                }
            }
            if (piscine){money = money  + 50000;}
        }

        else if (getTransaction() == TypeDeTransaction.echange){
            if ( getPrix() <= 5000000 ){
                if (getWilaya().prixMetreCarre <= 50000){
                    money = getPrix() + (getPrix()*3)/100;
                }
                else if (getWilaya().prixMetreCarre > 50000){
                    money = getPrix() + (getPrix()*35)/1000;
                }
            }
            else if ( (getPrix() > 5000000) && ( getPrix() <= 15000000) ){
                if (getWilaya().prixMetreCarre <= 50000){
                    money = getPrix() + (getPrix()*2)/100;
                }
                else if (getWilaya().prixMetreCarre > 50000){
                    money = getPrix() + (getPrix()*25)/1000;
                }
            }
            else if ( getPrix() > 15000000 ){
                if (getWilaya().prixMetreCarre <= 70000){
                    money = getPrix() + (getPrix()*1)/100;
                }
                else if (getWilaya().prixMetreCarre > 70000){
                    money = getPrix() + (getPrix()*2)/100;
                }
            }
            if (garage || jardin || piscine){
                money = money + getPrix()*5/1000 ;
            }
        }
        return money;
    }

}
