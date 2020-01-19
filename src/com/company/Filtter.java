package com.company;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Scanner;


public class Filtter {
    Scanner sc = new Scanner(System.in);
    protected String tab[] = new String[10];
    // Bien tab_bien[] = new Bien[200];
    protected int wilaya;
    protected Float prix;
    protected float superficie;
    protected int choix,choix2;
    protected TypeDeTransaction transaction;
    protected int  i;
    protected int j ;
    protected int k ;
    protected int indice;




    public Filtter() {
        tab[0] = "Wilaya";
        tab[1] = "Prix_max";
        tab[2] = "Prix_min";
        tab[3] = "Type de transaction ( vente,location,echange )";
        tab[4] = "Type de bien ( Maison,Apart,Terrain )";
        tab[5] = "La superficie_min";
        //   tab[6] = "Le nombre de peices minimal";
    }

    public int affichage_fillter(){
        Scanner sc = new Scanner(System.in);
        int i = 0,k=0;
        System.out.println("Voici les filtre :");
        for (i=0;i<6;i++){
            System.out.println(i+"/"+tab[i]);
        }
        i = 0;
        System.out.println("entre un chiffre de 0 a 5");
        k = sc.nextInt();
        return k;
    }
    public int getChoix2() {
        return choix2;
    }

    public int getWilaya() {
        return wilaya;
    }

    public Float getPrix() {
        return prix;
    }

    public float getSuperficie() {
        return superficie;
    }

    public int getChoix() {
        return choix;
    }

    public TypeDeTransaction getTransaction() {
        return transaction;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public int getK() {
        return k;
    }

    public int getIndice() {
        return indice;
    }


}
