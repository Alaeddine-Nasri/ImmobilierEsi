package com.company;

public class Messages {
    protected Bien bienconcerne;
    protected String message;

    public Messages(Bien bienconcerne, String message) {
        this.bienconcerne = bienconcerne;
        this.message = message;
    }
    public void afficher(){
        System.out.println("/ Adresse du bien concerné : "+bienconcerne.adresse);
        System.out.println("/ Message : "+message);

    }
}
