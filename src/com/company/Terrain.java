package com.company;

import java.util.Date;

public class Terrain extends NonHabitable {

    public Terrain(String adresse, Wilaya wilaya, float surface, Proprietaire proprietaire, TypeDeTransaction transaction, float prix, boolean negociable, String descriptif, Date date, String photos, int nbr_facades, String etat_juridique)  {
        super(adresse, wilaya, surface, proprietaire, transaction, prix, negociable, descriptif, date, photos, nbr_facades, etat_juridique);
    }
    public Terrain(String adresse, Wilaya wilaya) {
        super(adresse, wilaya);
    }
    @Override
    public float calculerprix(){
        float money=0;
        if (getTransaction() == TypeDeTransaction.vente){
            if ( getPrix() < 5000000 ){
                if (getWilaya().prixMetreCarre < 50000){
                    money = getPrix() + (getPrix()*3)/100;
                }
                else if (getWilaya().prixMetreCarre > 50000){
                    money = getPrix() + (getPrix()*35)/1000;
                }
            }
            else if ( (getPrix() > 5000000) && ( getPrix() <15000000) ){
                if (getWilaya().prixMetreCarre < 50000){
                    money = getPrix() + (getPrix()*2)/100;
                }
                else if (getWilaya().prixMetreCarre > 50000){
                    money = getPrix() + (getPrix()*25)/1000;
                }
            }
            else if ( getPrix() > 15000000 ){
                if (getWilaya().prixMetreCarre <70000){
                    money = getPrix() + (getPrix()*1)/100;
                }
                else if (getWilaya().prixMetreCarre > 70000){
                    money = getPrix() + (getPrix()*2)/100;
                }
            }
            if (getNbr_facades() > 1){
                money = money + money*(getNbr_facades()-1)*5/1000;
            }
        }

        else if (getTransaction() == TypeDeTransaction.location){
            if(getSurface() < 60){
                if (getWilaya().prixMetreCarre <= 50000){
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
            else if(getSurface() > 150){
                if (getWilaya().prixMetreCarre <= 50000){
                    money = getPrix() + (getPrix()*3)/100;
                }
                else if (getWilaya().prixMetreCarre > 50000){
                    money = getPrix() + (getPrix()*35)/1000;
                }
            }
        }

        else if (getTransaction() == TypeDeTransaction.echange){
            if ( getPrix() < 5000000 ){
                if (getWilaya().prixMetreCarre <= 50000){
                    money = getPrix() + (getPrix()*3)/100;
                }
                else if (getWilaya().prixMetreCarre > 50000){
                    money = getPrix() + (getPrix()*35)/1000;
                }
            }
            else if ( (getPrix() > 5000000) && ( getPrix() <15000000) ){
                if (getWilaya().prixMetreCarre <= 50000){
                    money = getPrix() + (getPrix()*2)/100;
                }
                else if (getWilaya().prixMetreCarre > 50000){
                    money = getPrix() + (getPrix()*25)/1000;
                }
            }
            else if ( getPrix() > 15000000 ){
                if (getWilaya().prixMetreCarre < 70000){
                    money = getPrix() + (getPrix()*1)/100;
                }
                else if (getWilaya().prixMetreCarre >= 70000){
                    money = getPrix() + (getPrix()*2)/100;
                }
            }
            if (getNbr_facades() > 1){
                money = money + money*(getNbr_facades()-1)*5/1000;
            }
            if ( getWilaya().matricule != 12 ){
                money = money + ((money*25)/10000);
            }
        }
        return money;
    }
}
