package com.company;

import java.util.Date;

public class Appartement extends Habitable{
    private int etage;
    private boolean duplex;
    private boolean simplexe;
    private boolean studio;
    private boolean ascenseur;

    public Appartement(String adresse, Wilaya wilaya, float surface, Proprietaire proprietaire, TypeDeTransaction transaction, float prix, boolean negociable, String descriptif, Date date, String photos, int nbr_pieces, Boolean meuble, int etage, boolean duplex) {
        super(adresse, wilaya, surface, proprietaire, transaction, prix, negociable, descriptif, date, photos, nbr_pieces, meuble);
        this.etage = etage;
        this.duplex = duplex;
    }
    public Appartement(String adresse, Wilaya wilaya, float surface, Proprietaire proprietaire, TypeDeTransaction transaction, float prix, boolean negociable, String descriptif, Date date, String photos, int nbr_pieces, Boolean meuble, int etage, boolean duplex,boolean ascenseur,boolean studio) {
        super(adresse, wilaya, surface, proprietaire, transaction, prix, negociable, descriptif, date, photos, nbr_pieces, meuble);
        this.etage = etage;
        this.duplex = duplex;
        this.ascenseur=ascenseur;
        this.studio=studio;
    }

    @Override
    public void afficherDetail() {
        super.afficherDetail();
        System.out.println("Etage "+etage);
        if(duplex) System.out.println("Ce bien est un duplexe");
        if(simplexe) System.out.println("Ce bien est un simplexe");
        if (studio) System.out.println("Ce bien est in studio");
        if(ascenseur) System.out.println("Ascenseur disponible");
    }

    @Override
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
                else if (getWilaya().prixMetreCarre > 70000){
                    money = getPrix() + (getPrix()*2)/100;
                }
            }
            if (etage < 3){
                money = money + 50000;
            }
        }

        else if (getTransaction() == TypeDeTransaction.location){
            if(getSurface() <= 60){
                if (getWilaya().prixMetreCarre <= 50000){
                    money = getPrix() + (getPrix()*1)/100;
                }
                else if (getWilaya().prixMetreCarre > 50000){
                    money = getPrix() + (getPrix()*15)/1000;
                }
            }
            else if((getSurface() > 60) && (getSurface() <= 150)){
                if (getWilaya().prixMetreCarre <= 50000){
                    money = getPrix() + (getPrix()*2)/100;
                }
                else if (getWilaya().prixMetreCarre > 50000) {
                    money = getPrix() + (getPrix() * 25) / 1000;
                }
            }
            else if(getSurface() > 150){
                if (getWilaya().prixMetreCarre <= 50000){
                    money = getPrix() + (getPrix()*3)/100;
                }
                else if (getWilaya().prixMetreCarre > 50000){
                    money = getPrix() + (getPrix()*35)/1000;
                }
            }
            if (etage < 3){
                money = money + 5000;
            }
            else if ((etage > 5) && !ascenseur){
                money = money - 500*getSurface();
            }
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
            else if ( (getPrix() > 5000000) && ( getPrix() <=15000000) ){
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
            if (etage < 3){
                money = money + 50000;
            }
        }
        return money;
    }
}
