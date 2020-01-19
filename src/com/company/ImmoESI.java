package com.company;

import java.util.*;
import java.util.Scanner;

public class ImmoESI {
    private TreeSet<Bien> liste_des_biens =new TreeSet<Bien>(); //liste des biens de l'agence
    private TreeSet<Bien> biens_archives =new TreeSet<Bien>(); //liste des biens archivés
    private LinkedList<Messages>  liste_messages=new LinkedList<Messages>();
    protected LinkedList<Administrateur> administrateurs=new LinkedList<Administrateur>();
    public void setProprietaires(TreeSet<Proprietaire> proprietaires) {
        this.proprietaires = proprietaires;
    }

    private TreeSet<Proprietaire> proprietaires =new TreeSet<Proprietaire>(); //liste de proprietaires

    public ImmoESI(TreeSet<Bien> liste_des_biens, TreeSet<Bien> biens_archives, TreeSet<Proprietaire> proprietaires) {
        this.liste_des_biens = liste_des_biens;
        this.biens_archives = biens_archives;
        this.proprietaires = proprietaires;
    }

    public ImmoESI() {

    }
    private Bien AjouterMaison(Proprietaire proprietaire, TypeDeTransaction transaction) throws SuperficieHabitableException,SurfaceNulleException{
        Scanner sc=new Scanner(System.in);
        System.out.println("Informations relatives au bien : ");
        System.out.println("Adresse : "); String adresse =sc.nextLine(); //sc.nextLine();
        System.out.println("Wilaya ");
        Wilaya wilaya =Enum.valueOf(Wilaya.class, sc.next().toLowerCase()); sc.nextLine();
        System.out.println("Superficie du bien : "); float surface=sc.nextFloat(); sc.nextLine();
        if(surface< 0) throw  new SurfaceNulleException();
        System.out.println("Prix : "); float prix=sc.nextFloat(); sc.nextLine();
        System.out.println("Ce bien est-il negociable ? ");
        String nego=sc.nextLine(); //sc.nextLine();
        boolean negociable;
        negociable= nego.equalsIgnoreCase("oui");
        System.out.println("Descriptif du bien "); String descriptif=sc.nextLine(); //sc.nextLine();
        System.out.println("Photos :(Entrez le lien URL vers l'album photos"); String photo=sc.nextLine(); //sc.nextLine();
        Date date = new Date();
        System.out.println("Nombre d'etages : "); int nbr_etages=sc.nextInt(); sc.nextLine();
        System.out.println("Nombre de pieces : "); int nbr_pieces=sc.nextInt(); sc.nextLine();
        System.out.println("Cette maison contient-elle meublee ? "); String jar=sc.nextLine(); //sc.nextLine();
        boolean meuble;
        meuble= jar.equalsIgnoreCase("oui"); //sc.nextLine();
        System.out.println("Cette maison contient-elle un jardin ? ");  jar=sc.nextLine(); //sc.nextLine();
        boolean jardin;
        jardin= jar.equalsIgnoreCase("oui"); //sc.nextLine();
        System.out.println("Cette maison contient-elle une piscine ? "); String pis=sc.nextLine();
        // sc.nextLine();
        boolean piscine;
        piscine= jar.equalsIgnoreCase("oui");
        System.out.println("Cette maison contient-elle un garage ? "); String gar=sc.nextLine(); //sc.nextLine();
        boolean garage;
        garage= jar.equalsIgnoreCase("oui");
        System.out.println("Surface habitable "); float surface_habitable=sc.nextFloat(); sc.nextLine();
        //Creation de l'objet
        if(surface < surface_habitable) throw new SuperficieHabitableException();
        Bien nouveau= null;
        nouveau = new Maison(adresse,wilaya,surface,proprietaire,transaction,prix,negociable,descriptif,date,photo,nbr_pieces,meuble,nbr_etages,garage,jardin,piscine,surface_habitable);

        return  nouveau;
    }
    private Bien AjouterAppart(Proprietaire proprietaire, TypeDeTransaction transaction) throws SurfaceNulleException{
        Scanner sc=new Scanner(System.in); Bien nouveau=null;
        System.out.println("Informations relatives au bien : ");
        System.out.println("Adresse : "); String adresse =sc.nextLine();
        System.out.println("Wilaya ");
        Wilaya wilaya =Enum.valueOf(Wilaya.class, sc.next().toLowerCase());
        System.out.println("Superficie du bien : "); float surface=sc.nextFloat();
        if(surface<= 0) {
            throw  new SurfaceNulleException();
        }
        System.out.println("Prix : "); float prix=sc.nextFloat(); sc.nextLine();
        System.out.println("Ce bien est-il negociable ? "); String nego=sc.nextLine();
        boolean negociable;
        negociable= nego.equalsIgnoreCase("oui");
        System.out.println("Descriptif du bien "); String descriptif=sc.nextLine();
        System.out.println("Nombre de pieces : "); int nbr_pieces=sc.nextInt(); sc.nextLine();
        System.out.println("Cette maison contient-elle meublee ? "); String jar=sc.nextLine(); //sc.nextLine();
        boolean meuble;
        meuble= jar.equalsIgnoreCase("oui"); //sc.nextLine();
        System.out.println("Photos :(Entrez le lien URL vers l'album photos"); String photo=sc.nextLine();
        Date date = new Date(); //Date d'ajout
        System.out.println("A quelle étage se situe le bien? "); int etage=sc.nextInt();
        sc.nextLine();
        System.out.println("Ce bien est-il un duplexe ? "); String dup=sc.nextLine();
        boolean duplexe;
        duplexe= dup.equalsIgnoreCase("oui");
        nouveau=  new Appartement(adresse,wilaya,surface,proprietaire,transaction,prix,negociable,descriptif,date,photo,nbr_pieces,meuble,etage,duplexe);
        return nouveau;
    }
    private Bien AjouterTerrain(Proprietaire proprietaire, TypeDeTransaction transaction) throws SurfaceNulleException{
        Scanner sc=new Scanner(System.in); Bien nouveau=null;
        System.out.println("Informations relatives au bien : ");
        System.out.println("Adresse : "); String adresse =sc.nextLine();
        System.out.println("Wilaya ");
        Wilaya wilaya =Enum.valueOf(Wilaya.class, sc.next().toLowerCase());
        System.out.println("Superficie du bien : "); float surface=sc.nextFloat();
        if(surface<= 0) throw  new SurfaceNulleException();
        System.out.println("Prix : "); float prix=sc.nextFloat(); sc.nextLine();
        System.out.println("Ce bien est-il negociable ? "); String nego=sc.nextLine();
        boolean negociable;
        negociable= nego.equalsIgnoreCase("oui");
        System.out.println("Descriptif du bien "); String descriptif=sc.nextLine();
        System.out.println("Photos :(Entrez le lien URL vers l'album photos"); String photo=sc.nextLine();
        Date date = new Date(); //Date d'ajout
        System.out.println("Nombre de façades du bien : "); int nbr_facades=sc.nextInt(); sc.nextLine();
        System.out.println("Etat juridique : "); String etat_juridique=sc.nextLine();

        nouveau= new Terrain(adresse,wilaya,surface,proprietaire,transaction,prix,negociable,descriptif,date,photo,nbr_facades,etat_juridique);

        return nouveau;
    }
    public void ajouterBien(Administrateur admin) throws SuperficieHabitableException,SurfaceNulleException,BienExistantException{
        Scanner sc = new Scanner(System.in);
        Bien nouveau = null;

        System.out.println("Le type du bien a ajouter : Maison, Appartement, Terrain ");
        String type_bien = sc.nextLine();
        System.out.println("Le type de transaction ");
        TypeDeTransaction transaction =Enum.valueOf(TypeDeTransaction.class, sc.next().toLowerCase());
        System.out.println("Proprietaire du bien");
        sc.nextLine();
        System.out.println("Adresse du proprietaire "); String adresse_prop=sc.nextLine();
        System.out.println("Nom du proprietaire "); String nom=sc.nextLine();
        System.out.println("Prenom du proprietaire: "); String prenom=sc.nextLine();
        System.out.println("Numero de telephone "); String num_tel=sc.nextLine();
        System.out.println("Adresse mail :"); String mail=sc.nextLine();
        Proprietaire proprietaire=new Proprietaire(nom,num_tel,prenom,mail,adresse_prop);
        if (type_bien.equalsIgnoreCase("maison")) {
            try {
                nouveau = AjouterMaison(proprietaire, transaction);
            }catch (SuperficieHabitableException e){
                e.printStackTrace();
                System.out.println("Superficie habitable invalide");
            }
            catch (SurfaceNulleException e) {
                e.printStackTrace();
                System.out.println("Surface invalide");
            }
            if(liste_des_biens.contains(nouveau)) throw new BienExistantException();
            else{
                liste_des_biens.add(nouveau); //Utiliser un TreeSet supprime la possibilité de doublons
                proprietaires.add(proprietaire);
                //Ajouter le bien à la liste des biens du proprietaires
                proprietaire.liste_proprietees.add(nouveau);}
        } else {
            if (type_bien.equalsIgnoreCase("appartement")) {
                try {
                    nouveau = AjouterAppart(proprietaire, transaction);
                } catch (SurfaceNulleException e) {
                    e.printStackTrace();
                    System.out.println("Surface exception");
                }
                if(liste_des_biens.contains(nouveau)) System.out.println("Ce bien existe deja");
                else{
                    liste_des_biens.add(nouveau);
                    proprietaires.add(proprietaire);
                    //Ajouter le bien à la liste des biens du proprietaires
                    proprietaire.liste_proprietees.add(nouveau);}
            } else {
                if (type_bien.equalsIgnoreCase("terrain")) {
                    try {
                        nouveau = AjouterTerrain(proprietaire, transaction);
                    } catch (SurfaceNulleException e) {
                        e.printStackTrace();
                    }
                    if(liste_des_biens.contains(nouveau)) System.out.println("Ce bien existe deja");
                    else{
                        liste_des_biens.add(nouveau);
                        proprietaires.add(proprietaire);
                        proprietaire.liste_proprietees.add(nouveau);}
                } else {
                    System.out.println("Type de bien invalide! ");
                }
            }
        }
    }
    public void afficher_liste_des_bien(){
        int cpt=1;
        for(Bien ele:liste_des_biens){
            System.out.println("NUMERO DU BIEN : "+cpt);
            ele.afficher();
            System.out.println("---------------------------------------");
            cpt++;
        }
    }
    public void afficher_liste_des_bien_archives(){
        int cpt=1;
        for(Bien ele:biens_archives){
            System.out.println("NUMERO DU BIEN : "+cpt);
            ele.afficher();
            System.out.println("---------------------------------------");
            cpt++;
        }
    }
    public void archiver_bien(Administrateur admin,Bien archive){

        biens_archives.add(archive);
        /*Supprimer de la liste des biens*/
        boolean removed=liste_des_biens.remove(archive);
    }
    public void supprimer_bien(Administrateur admin,Bien supp){

        this.liste_des_biens.remove(supp);
        supp.proprietaire.liste_proprietees.remove(supp);
    }
    public void ajouterBien(Administrateur admin, Bien o){
        liste_des_biens.add(o);
        o.proprietaire.liste_proprietees.add(o);
    }
    public void envoyerMessage(Bien o,String message){
        Messages nouveau=new Messages(o,message);
        liste_messages.add(nouveau);
    }
    public void afficherMessages(Administrateur administrateur){
        Iterator<Messages> iterator= liste_messages.iterator();
        while (iterator.hasNext()){
            System.out.println("----------------------------------------------------\n");
            Messages it=iterator.next();
            it.afficher();
        }
        System.out.println("----------------------------------------------------\n\n");

    }
    public void modifierBien(Administrateur administrateur, Bien bien){

        bien.modifierattributs();
    }
    public Bien choisirBien(int numerodubien){
        int cpt=0; Bien bien=null;
        Iterator<Bien> it=liste_des_biens.iterator();
        while (it.hasNext()&&cpt!=numerodubien){
            cpt++;
            bien=it.next();
        }

        return bien;
    }
    public boolean seconnecter(Administrateur administrateur){
        if(this.administrateurs.contains(administrateur)) return true;
        else return false;
    }
    Filtter f = new Filtter();
    private int choix;
    protected int wilaya;
    protected Float prix;
    protected float superficie;

    public ArrayList<Bien> rech_filltre(ArrayList<Bien> list1, ArrayList<Bien> list2,int k){
        list1.addAll(liste_des_biens);
        Scanner sc = new Scanner(System.in);

        //System.out.println("this is k = "+k+"get k = "+f.getK());
        if (k == 0){
            System.out.println("entre le matricule de la wiliya");
            wilaya = sc.nextInt();
            for (Bien ele1:list1){ // wilaya
                if (ele1.getWilaya().matricule == wilaya) {list2.add(ele1);}
            }
        }
        else if (k == 1){  // prix max
            System.out.println("entre le prix max");
            prix = sc.nextFloat();
            for (Bien ele1:list1){ //prix max
                if (ele1.getPrix() < prix) {list2.add(ele1);}
            }
        }
        else if (k == 2){  // prix min
            System.out.println("entre le prix min ");
            prix = sc.nextFloat();
            for (Bien ele1:list1){ //prix min
                if (ele1.getPrix() > prix) {list2.add(ele1);}
            }
        }
        else if (k == 3){  // type de transaction
            System.out.println("Entre un numero de 1 a 3");
            System.out.println("1/ Vente");
            System.out.println("2/ Location");
            System.out.println("3/ Echange");
            choix = sc.nextInt();
            if (choix == 1) {
                for (Bien ele1 : list1) {
                    if (ele1.getTransaction() == TypeDeTransaction.vente) { list2.add(ele1);}
                }
            }
            else if (choix == 2) {
                for (Bien ele1 : list1) {
                    if (ele1.getTransaction() == TypeDeTransaction.location) { list2.add(ele1); }
                }
            } else if (choix== 3) {
                for (Bien ele1 : list1) {
                    if (ele1.getTransaction() == TypeDeTransaction.echange) { list2.add(ele1); }
                }
            }
        }
        else if (k == 4){  // type de Bien
            System.out.println("Entre un numero de 1 a 3");
            System.out.println("1/ Maison");
            System.out.println("2/ Appartement");
            System.out.println("3/ Terrain");
            choix = sc.nextInt();
            if (choix == 1) {
                for (Bien ele1 : list1) {
                    if (ele1 instanceof Maison ) {list2.add(ele1);}
                }
            }
            if (choix == 2) {
                for (Bien ele1 : list1) {
                    if (ele1 instanceof Appartement ) {list2.add(ele1);}
                }
            }
            if (choix == 3) {
                for (Bien ele1 : list1) {
                    if (ele1 instanceof Terrain ) {list2.add(ele1);}
                }
            }
        }
        else if (k == 5){  // prix min
            System.out.println("entre le surface min ");
            superficie = sc.nextFloat();
            for (Bien ele1:list1){ //surface min
                if (ele1.getSurface() > superficie) {list2.add(ele1);}
            }
        }

        return list2;
    }
}
