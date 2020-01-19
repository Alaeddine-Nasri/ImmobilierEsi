package com.company;

import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public abstract class Bien implements  Comparable<Bien>{
    protected String adresse;
    private Wilaya wilaya;
    private float surface;
    protected Proprietaire proprietaire;
    private TypeDeTransaction transaction;
    private float prix;
    private float immoprix;
    private boolean negociable;
    private String descriptif;
    private Date date;
    private String photos; //Lien URL vers l'album des photos

    public Bien(String adresse, Wilaya wilaya, float surface, Proprietaire proprietaire, TypeDeTransaction transaction, float prix, boolean negociable, String descriptif, Date date, String photos)  {
        this.adresse = adresse;
        this.wilaya = wilaya;
        this.surface = surface;
        this.proprietaire = proprietaire;
        this.transaction = transaction;
        this.prix = prix;
        this.negociable = negociable;
        this.descriptif = descriptif;
        this.date = date;
        this.photos = photos;
    }

    public Bien(String adresse, Wilaya wilaya) {
        this.adresse = adresse;
        this.wilaya = wilaya;
    }

    public Bien(String adresse) {
        this.adresse=adresse;
    }

    public void afficher(){
        System.out.print("Adresse : "+adresse); System.out.println("   Wilaya "+wilaya);
        System.out.println("Ce bien est en "+transaction);
        System.out.println("Propreitaire :"+proprietaire.nom);
        System.out.println("Surface "+surface);
        System.out.println("Prix" +prix);
        System.out.println("Date d'ajout "+ date);
    }
    public void afficher_prix(){
        System.out.println("Prix du bien "+prix);
    }
    public abstract float calculerprix();

    public int compareTo(Bien o){
        if(this.adresse.equalsIgnoreCase(o.adresse) && this.wilaya==o.wilaya)
            return 0;
        else if(this.date.compareTo(o.date)>0)
            return -1;
        else return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bien bien = (Bien) o;
        return adresse.equals(bien.adresse) &&
                wilaya == bien.wilaya;
    }
    public void modifierattributs(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Voulez vous modifier le type de transaction "); String modif=sc.nextLine();
        if(modif.equalsIgnoreCase("oui")){
            System.out.println("Nouveau type de transaction");
            TypeDeTransaction transaction =Enum.valueOf(TypeDeTransaction.class, sc.next().toLowerCase());
            this.transaction=transaction;
        }
        System.out.println("Voulez vous modifier le prix "); modif=sc.nextLine();
        if(modif.equalsIgnoreCase("oui")){
            System.out.println("Nouveau prix "); float prix=sc.nextFloat();
            this.prix=prix;
        }
        sc.nextLine();
        System.out.println("Voulez vous modifier la négociabilité de ce bien ");  modif=sc.nextLine();
        if(modif.equalsIgnoreCase("oui")){
            System.out.println("Voulez vous rendre de bien negociable"); String negociable=sc.nextLine();
            if(negociable.equalsIgnoreCase("oui")) this.negociable=true;
            else this.negociable=false;
        }
        System.out.println("Voulez vous modifier le descriptif de ce bien ");  modif=sc.nextLine();
        if(modif.equalsIgnoreCase("oui")){
            System.out.println("Nouveau descriptif"); String descriptif=sc.nextLine();
            this.descriptif=descriptif;
        }
        System.out.println("Voulez vous modifier les photos de ce bien ");  modif=sc.nextLine();
        if(modif.equalsIgnoreCase("oui")){
            System.out.println("Nouvelles photos du bien"); String photos=sc.nextLine();
            this.photos=photos;
        }
    }
    public void afficherDetail(){
        afficher();
        System.out.println("Plus de détails sur ce bien ");
        System.out.println("Descriptif du bien "+descriptif);
    }

    public Wilaya getWilaya() {
        return wilaya;
    }

    public float getSurface() {
        return surface;
    }

    public float getPrix() {
        return prix;
    }

    public Date getDate() {
        return date;
    }

    public TypeDeTransaction getTransaction() {
        return transaction;
    }

}
