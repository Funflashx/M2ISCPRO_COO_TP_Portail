package com.uds;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main { //PORTAIL_UDS

    public List<Groupe> ListGroups = new ArrayList<Groupe> ();
    public List<Member> ListMembers = new ArrayList<Member> ();

    public static void main(String[] args) {

        //Simulation TODO: instancier une liste de membre et groupe


        //varible de l'environement
        Scanner in = new Scanner(System.in);
        String nom;
        String prenom;
        boolean actif = true;
        String selectedItem;

        //- Authentification
        System.out.println("Bienvenue sur le portail UDS. \n=============================");

        System.out.println("Entrez votre lastname:");
        nom = in.nextLine();
        System.out.println("Entrez votre firstname:");
        prenom = in.nextLine();

        //création du membre
        Member newUser = new Member(nom, prenom);

        //- Système
        while (actif) {
            selectedItem = displayMenu(); //affiche le menu

            switch (selectedItem) {
                case "1":
                    List<Groupe> listeGroupe = newUser.getListGroups();
                    displayGroups(listeGroupe);
                    break;
                case "2":
                    String desc;
                    String title;
                    System.out.println("Entrez un titre:");
                    title = in.nextLine();
                    System.out.println("Entrez une description:");
                    desc = in.nextLine();
                    Groupe newGroup = newUser.createGroup(title, desc);
                    displayGroups(new ArrayList<Groupe>() {{ add(newGroup);}});
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
                default:
                    actif = true;

            }

        }
        System.err.println("À bientôt sur le portail UDS");

    }

    public static String displayMenu(){
        Scanner in = new Scanner(System.in);
        System.out.println("Choisissez une action:" +
                "\n1- Afficher tous les groupes" +
                "\n2- Créer un groupe");
        return in.nextLine();
    }

    public static void displayGroups(List<Groupe> groupes) {
        int i = 1;
        if(groupes.size() == 0){
            System.out.println("Liste Vide");
            //displayMenu();
        }else {
            for (Groupe g : groupes) {
                System.out.println(i + "-" + g.titre);
                System.out.println(g.description + "\n---------------------------------");

                i++;
            }
        }

    }


/*    public Member logIn(String login, String password){
        Scanner in = new Scanner(System.in);
        System.out.println("CONNEXION:\n=============================Entrez votre login:");
        login = in.nextLine();
        System.out.println("Entrez votre mot de passe:");
        password = in.nextLine();
        for (Member member: ListMembers){
            if (login == member.login && password == member.password){
                return member;
            }
        }
        return null;
    }

    public Member signIn(){
        String login; String password; String lastname; String firstname;
        Scanner in = new Scanner(System.in);

        System.out.println("CREATION D'UN COMPTE:\n=============================Entrez votre login:");
        login = in.nextLine();
        System.out.println("Entrez votre mot de passe:");
        password = in.nextLine();
        Member newMember = new Member(lastname, firstname,login, password);
        return newMember;
    }

    public static void logOut(){

    }*/
}
