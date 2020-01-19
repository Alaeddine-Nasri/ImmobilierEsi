package com.company;


import java.util.*;
public class Main {

    public static void main(String[] args) throws SuperficieHabitableException,BienExistantException{
        ImmoESI agence= new ImmoESI();
        TreeSet<Proprietaire> proprietaires =new TreeSet<Proprietaire>();

        /*CREATION D'ADMINISTRATEUR*/
        Administrateur admin=new Administrateur("admin1","motdepasse1");
        Administrateur admin2=new Administrateur("admine2","motdepasse2");
        agence.administrateurs.add(admin); agence.administrateurs.add(admin2);
        /*CREATION D'ADMINISTRATEUR*/


        /*CREATION DES PROPRIETAIRES*/
        Proprietaire prop1= new Proprietaire("AMMALI","+213*********","Mouna","im_ammali@esi.dz","Lido Mohammadia");
        Proprietaire prop2= new Proprietaire("NASRI","+213*********","Ala Edine","ia_nasri@esi.dz","Batna");
        Proprietaire prop3= new Proprietaire("DJEFFAL","+213*********","Belkis","ib_djeffal@esi.dz","El Bordj");
        Proprietaire prop4= new Proprietaire("BELGUENBOUR","+213*********","Walid","iw_belguenbour@esi.dz","Dely Brahim");
        proprietaires.add(prop1);
        proprietaires.add(prop2);
        proprietaires.add(prop3);
        proprietaires.add(prop4);
        agence.setProprietaires(proprietaires);
        /*CREATION DES PROPRIETAIRES*/

        /*CREATION DES BIENS*/
        Date date=new Date();
        Date date1 = new Date("2019/2/2");
        Date date2 = new Date("2018/5/2");
        Date date3 = new Date("2007/9/1");
        Date date4 = new Date("2006/1/11");
        Date date5 = new Date("2005/3/13");
        Date date6 = new Date("2004/2/12");
        Date date7 = new Date("1990/2/2");
        Wilaya wilaya2 =Enum.valueOf(Wilaya.class, "wilaya2");
        Wilaya wilaya3 =Enum.valueOf(Wilaya.class, "wilaya3");
        Wilaya wilaya1 =Enum.valueOf(Wilaya.class, "wilaya1");

        TypeDeTransaction vente=Enum.valueOf(TypeDeTransaction.class,"vente");
        TypeDeTransaction location=Enum.valueOf(TypeDeTransaction.class,"location");
        TypeDeTransaction echange=Enum.valueOf(TypeDeTransaction.class,"echange");

        Bien bien1=new Appartement("Lido Mohammadia",wilaya2,120,prop2,vente,4000000,false,"",date,"",4,false,1,false);
        Bien bien2=new Maison("Birkhadem ",wilaya3,200,prop1,vente,10000000,false,"",date1,"",0,false,true,true,200);
        Bien bien3=new Terrain("Cheraga",wilaya1,500,prop1,vente,20000000,false,"",date2,"",3,"");
        Bien bien4=new Appartement("Bab ezzouar",wilaya3,100,prop2,location,40000,false,"",date7,"",3,false,1,false);
        Bien bien5=new Maison("Belfort",wilaya2,160,prop3,location,150000,false,"",date3,"",0,false,false,true,160);
        Bien bien6=new Appartement("Dely Brahim",wilaya3,50,prop2,location,600000,false,"",date4,"",1,false,6,false,false,true);
        Bien bien7=new Terrain("Kharoubier",wilaya1,650,prop1,echange,18000000,false,"",date5,"",1,"");
        Bien bien8=new Maison("Belf",wilaya2,200,prop2,echange,14000000,false,"",date6,"",0,false,0,true,false,false,200);
        agence.ajouterBien(admin,bien1);
        agence.ajouterBien(admin,bien2);
        agence.ajouterBien(admin,bien3);
        agence.ajouterBien(admin,bien4);
        agence.ajouterBien(admin,bien5);
        agence.ajouterBien(admin,bien6);
        agence.ajouterBien(admin,bien7);
        agence.ajouterBien(admin,bien8);
        /*CREATION DES BIENS*/

        /*GESTION DES MESSAGES*/
        agence.envoyerMessage(bien1, "Je suis interessé par ce bien");
        agence.envoyerMessage(bien2, "Pouvons nous visiter ce bien");
        agence.envoyerMessage(bien3, "Ce bien est il encore disponible ? ");
        agence.envoyerMessage(bien4,"Ce bien est il negociable ? ");
        agence.envoyerMessage(bien7,"Pouvons nous passer en agence pour ce bien ! ");
        /*GESTION DES MESSAGES*/
        System.out.println("--------------------------------------------------------------------------------------------\n");
        System.out.println("                        Ecole Nationale Supérieure d'Informatique               ");
        System.out.println("                                    AMMALI  -   NASRI");
        System.out.println("                                   Mouna    -   Ala Edine");
        System.out.println("                                    S B     -   G 06");
        System.out.println("--------------------------------------------------------------------------------------------\n");

        int choix;
        do {
            System.out.println("    1 - Continuer en tant qu'utilisateur");
            System.out.println("    2 - se connecter en tant qu'administrateur");
            System.out.println("    3 - Quitter\n\n");
            Scanner sc = new Scanner(System.in);
            System.out.print("Veuillez introduire votre choix : ");

            choix = sc.nextInt();
            switch (choix) {
                case 1:
                    do{
                        System.out.println("    1 - affichage des biens d'un proprietaire");
                        System.out.println("    2 - affichage detaille d'un bien");
                        System.out.println("    3 - calcul des prix");
                        System.out.println("    4 - recherche filtrée");
                        System.out.println("    5 - Envoie de messages");
                        System.out.println("    6 - afficher tous les biens existants");
                        System.out.println("    7 - Quitter\n");
                        choix = sc.nextInt();
                        switch (choix) {
                            case 1:
                                System.out.println("************************    /Affichage des biens d'un proprietaire/    ************************************************\n\n\n\n");

                                /*GESTION BIENS DES PROPRIETAIRES*/
                                System.out.println("Biens du proprietaire /Prop1/");
                                prop1.afficher_biens_proprietaires();
                                System.out.println("\nBien du proprietaire /Prop2/");
                                prop2.afficher_biens_proprietaires();

                                break;
                            case 2 :
                                System.out.println("************************    /Affichage detaillé d'un bien/    ************************************************\n\n\n\n");
                                System.out.println("Detail du  Bien : /bien1/ ");
                                bien1.afficherDetail();
                                break;
                            case 3 :
                                System.out.println("************************    /Calcul du prix/    ************************************************\n\n");
                                float dd;
                                dd = bien1.calculerprix();
                                System.out.println("Prix du bien1 est = "+dd );
                                dd = bien2.calculerprix();
                                System.out.println("Prix du bien2 est = "+dd );
                                dd = bien3.calculerprix();
                                System.out.println("Prix du bien3 est = "+dd );
                                dd = bien4.calculerprix();
                                System.out.println("Prix du bien4 est = "+dd );
                                dd = bien5.calculerprix();
                                System.out.println("Prix du bien5 est = "+dd );
                                dd = bien6.calculerprix();
                                System.out.println("Prix du bien6 est = "+dd );
                                dd = bien7.calculerprix();
                                System.out.println("Prix du bien7 est = "+dd );
                                dd = bien8.calculerprix();
                                System.out.println("Prix du bien8 est = "+dd );
                                break;
                            case 4:
                                System.out.println("************************    /Recherche filtrée/    ************************************************\n\n");
                                Filtter f = new Filtter();
                                int a=0,b=0;
                                ArrayList<Bien> list1 = new ArrayList<Bien>();
                                ArrayList<Bien> list2 = new ArrayList<Bien>();
                                ArrayList<Bien> list3 = new ArrayList<Bien>();
                                agence.rech_filltre(list1,list2,f.affichage_fillter());
                                System.out.println("On a deja filtre les bien ! voulez vous filtter une autre foit ?");
                                System.out.println("1/ Oui je veux filtrer une autre fois");
                                System.out.println("2/ Non je veux just le affichier !");
                                System.out.println("ENTRE 1 ou 2 !");
                                a = sc.nextInt();
                                if (a == 2){
                                    b = 1;
                                    for (Bien  ele : list2){
                                        int cpt = 1;
                                        System.out.println("NUMERO DU BIEN : "+cpt);
                                        ele.afficher();
                                        System.out.println("---------------------------------------");
                                        cpt++;
                                    }
                                }
                                while ( a == 1 ){
                                    agence.rech_filltre(list2,list3,f.affichage_fillter());
                                    System.out.println("On a deja filtre les bien ! voulez vous filtter une autre foit ?");
                                    System.out.println("1/ Oui je veux filtrer une autre fois");
                                    System.out.println("2/ Non je veux just le affichier !");
                                    System.out.println("ENTRE 1 ou 2 !");
                                    a = sc.nextInt();
                                }
                                if (a == 2 && b !=1){
                                    for (Bien  ele : list3){
                                        int cpt = 1;
                                        System.out.println("NUMERO DU BIEN : "+cpt);
                                        ele.afficher();
                                        System.out.println("---------------------------------------");
                                        cpt++;
                                    }
                                }
                              //  prop1.afficher_biens_proprietaires();

                                System.out.println("***bien recherche : Appartement , à batna de prix superieur à 16000 DA et inferieur à 1000000***\n ");
                                break;
                            case 5 :

                                break;
                            case 6:
                                System.out.println("******************    /Biens existants/    ****************************");
                                agence.afficher_liste_des_bien();
                                break;
                            case 7:
                                break;
                        }
                    }while (choix != 7);
                case 2:


                    sc = new Scanner(System.in);
                    System.out.print("IDENTIFIANT : ");
                    String identifiant = sc.nextLine();
                    System.out.println("");
                    System.out.println("MOT DE PASSE : ");
                    String motdepasse = sc.nextLine();
                    System.out.println("");
                    Administrateur seconnecter = new Administrateur(identifiant, motdepasse);
                    if (agence.seconnecter(seconnecter)) {
                        do {
                            System.out.println("    1 - Ajouter un bien" );
                            System.out.println("    2 - Supprimer un bien");
                            System.out.println("    3 - Archiver un bien");
                            System.out.println("    4 - Modification d'un bien ");
                            System.out.println("    5 - Consulter les messages reçues");
                            System.out.println("    6 - Quitter\n");
                            choix = sc.nextInt();
                            switch (choix) {

                                case 1:
                                    System.out.println("************************    /Ajout d'un bien/    ************************************************\n\n\n\n");
                                    /* ajout d'un bien */
                                    try {
                                        agence.ajouterBien(admin);
                                    } catch (SurfaceNulleException e) {
                                        System.out.println("La surface est invalide ");
                                        e.printStackTrace();
                                    }catch (BienExistantException e){
                                        System.out.println("Ce bien existe deja");
                                        e.printStackTrace();
                                    }
                                    System.out.println("Liste des biens après ajout");
                                    agence.afficher_liste_des_bien();
                                    break;
                                case 2 :
                                    System.out.println("************************    /Suppression d'un bien/    ************************************************\n\n\n\n");
                                    System.out.println("bien supprimé : bien1\n*** ");
                                    bien1.afficher();
                                    System.out.println("\n------------------------------------\n");
                                    agence.supprimer_bien(admin, bien1);
                                    /* affichage de la liste des biens apres suppression */
                                    System.out.println("Liste des biens après suppression\n\n");
                                    agence.afficher_liste_des_bien();
                                    System.out.println("Liste des biens des proprietaires après suppression \n\n");
                                    bien1.proprietaire.afficher_biens_proprietaires();
                                    break;
                                case 3 :
                                    System.out.println("************************    /Archiver un bien/    ************************************************\n\n\n\n");
                                    System.out.println("bien archivé: bien2 ");
                                    agence.archiver_bien(admin, bien2);
                                    System.out.println("Liste des biens après archivage");
                                    agence.afficher_liste_des_bien();
                                    System.out.println("Liste des biens archivés : \n\n");
                                    agence.afficher_liste_des_bien_archives();

                                    break;
                                case 4:
                                    System.out.println("************************    /Modification d'un bien/    ************************************************\n\n");
                                    /*GESTION DES MODFICATIONS*/
                                    System.out.println("bien modifié : bien5 ");
                                    Bien bien = agence.choisirBien(5);
                                    agence.modifierBien(admin, bien);
                                    agence.afficher_liste_des_bien();
                                    /*GESTION DES MODFICATIONS*/
                                    System.out.println("************************    /Calcul du prix apres modification/    ************************************************\n\n");
                                    System.out.println("$$$$$$$$$$$$$$$$\t    prix final :      " + bien.calculerprix());

                                    break;
                                case 5:
                                    System.out.println("********************    /Affichage des messages recues/    ******************************************\n\n");
                                    /*Afficher la liste des messages*/
                                    agence.afficherMessages(admin);
                                    break;
                                case 6:
                                    break;
                            }
                        }while(choix != 6);

                    } else{
                        System.out.println("Identifiants errones,veuillez réeassayer ! ");
                    }


                    break;

            }
        } while ((choix != 3));


    }
}
