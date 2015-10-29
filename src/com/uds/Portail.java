package com.uds;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Portail { //PORTAIL_UDS

    public static List<Groupe> listGroups = new ArrayList<Groupe> ();
    public static List<Membre> listMembres = new ArrayList<Membre> ();
    public static List<Filiere> listGroupFiliere = new ArrayList<Filiere>();

    public static void main(String[] args) {

        GroupeFactory groupInstitutionnel = new GroupeInstitutionnelFactory();
        GroupeFactory groupTypique = new GroupeTypiqueFactory();

        Membre antoine = new Membre("Antoine","Daniel");
        listMembres.add(antoine);

        Groupe groupeT = groupInstitutionnel.creeGroupe("filiere", antoine,"M2ISCPRO", "Groupe associée au master 2 ISC PRO STIC de l'université de savoie");
        antoine.addGroup(groupeT);
        listGroups.add(groupeT);
        antoine.addObject("repertoire", "TP", "", groupeT);

        displayGroups(antoine.getGroups());
       /* //varible de l'environement
        Scanner in = new Scanner(System.in);
        String nom;
        String prenom;
        boolean actif = true;
        String selectedItem;

        //- Authentification
        System.out.println("Bienvenue sur le portail UDS.\n=============================");
        System.out.println("Entrez votre nom:");
        nom = in.nextLine();
        System.out.println("Entrez votre prenom:");
        prenom = in.nextLine();

        //création du membre
        Membre newUser = new Membre(nom, prenom);

        //- Système
        while (actif) {
            selectedItem = displayMenu(); //affiche le menu

            switch (selectedItem) {
                case "1":
                    String selectedGroup;
                    List<Groupe> listeGroupe = newUser.getListGroups();
                    displayGroups(listeGroupe);
                    System.out.println("Selectionner un groupe:");
                    selectedGroup = in.nextLine();

                    if (Integer.parseInt(selectedGroup) <= listeGroupe.size()) {
                        Groupe selectGroup = listeGroupe.get(Integer.parseInt(selectedGroup) - 1);
                        System.out.println("=============================\n" +
                                "Configuration du groupe \"" + selectGroup.titre  + "\"" +
                                "\n=============================\n" +
                                "1- Ajouter un objet au groupe (document, répertoire, service)\n");
                        String actionSelected = in.nextLine();
                        switch (actionSelected){
                            case "1":
                                System.out.println("Selectionner le type de l'objet:\n" +
                                        "1-Document\n" +
                                        "2-Répertoire\n" +
                                        "3-Service\n");
                                String typeObject = in.nextLine();
                                System.out.println("Titre:\n");
                                String titre = in.nextLine();
                                System.out.println("Description:\n");
                                String description = in.nextLine();
                                createObjet(typeObject);
                            default:
                                System.err.println("error");
                        }
                    }
                    break;
                case "2":
                    String desc;
                    String title;
                    System.out.println("Entrez un titre:");
                    title = in.nextLine();
                    System.out.println("Entrez une description:");
                    desc = in.nextLine();
                    //Groupe newGroup = newUser.createGroup(title, desc);
                    //displayGroups(new ArrayList<Groupe>() {{ add(newGroup);}});
                    break;
                default:
                    System.err.println("Saisie incorrecte");
                    break;
            }

            System.err.println("Pressez entrer pour revenir au menu, exit pour la quitter");
            String tmp = in.nextLine();
            switch (tmp){
                case "exit":
                    actif = false;
                    break;
                default:
                    actif = true;

            }

        }
        System.err.println("À bientôt sur le portail UDS");
*/
    }

  /*  public static void createObjet(String type){
        switch (type){
            case "1":

            case "2":

            case "3":

            default:

        }
    }*/

/*    public static String displayMenu(){
        Scanner in = new Scanner(System.in);
        System.out.println("Choisissez une action:" +
                "\n1- Afficher tous les groupes" +
                "\n2- Créer un groupe");
        return in.nextLine();
    }*/

    public static void displayGroups(List<Groupe> groupes) {
        if(groupes.size() == 0){
            System.out.println("Liste Vide");
            //displayMenu();
        }else {
            for (Groupe g : groupes) {
                System.out.println("#"+groupes.indexOf(g) + "." + g.titre
                        + "\n=============================\ncreated by: "+ g.owner.fullname + "\nbrief:"
                        + g.description + "___________________membres: "+g.listMembre.size());
            }
        }

    }


}


