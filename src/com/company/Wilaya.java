package com.company;

public enum Wilaya {
    wilaya1(49,100000),
    wilaya2(50,30000 ),
    wilaya3(51,60000);
    public final int matricule;
    public final double prixMetreCarre;
    Wilaya(int matricule, double prixMetreCarre){
        this.matricule=matricule;
        this.prixMetreCarre=prixMetreCarre;
    }
    public int getMatricule(){
        return matricule;
    }
    public double getPrixMetreCarre(){
        return prixMetreCarre;
    }

}
