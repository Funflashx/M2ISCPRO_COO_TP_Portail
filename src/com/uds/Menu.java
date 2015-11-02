package com.uds;

import java.util.Scanner;

/**
 * Created by francoiscaillet on 01/11/2015.
 */
public class Menu {

    private Scanner input = new Scanner(System.in);

    public Menu(){

    }

    public void display(){

        do {
            System.out.println((char) 27 + "[31;1m" + "-- Bienvenue sur le portail " + (char) 27 + "[30;1m" + "de l'université de Savoie --" + (char) 27 + "[0;0m");
            System.out.println("-- Veillez selectionner une action: \n" +
                            "  -- 1) Connexion\n" +
                            "  -- 2) Première fois ?\n" +
                            "  -- 3) Quitter\n "
            );

            int selection = input.nextInt();
            input.nextLine();

            switch (selection) {
                case 1:
                    this.connexion();
                    break;
                case 2:
                    this.signIn();
                    break;
                case 3:
                    this.exit();
                    break;
                default:
                    System.out.println("Invalid selection.");
                    break;
            }
        } while (true);
    }

    private void signIn() {
        System.out.println("Veillez nous indiquer votre nom suivis de votre prénom (Ex: Fred Caillou):");
        String fullname = input.nextLine();
        System.out.println("--- Vous êtes:\n" +
                "   --- 1) Étudiant\n" +
                "   --- 2) Enseignant\n" +
                "   --- 3) Membre de la DSI\n" +
                "   --- 4) Retour");

        String[] fullnameSplited = fullname.split(" ");
        int selection = input.nextInt();
        input.nextLine();
        switch (selection){
            case 1:
                Portail.currentMember = new Etudiant(fullnameSplited[0], fullnameSplited[1], this.chooseFiliere());
                this.displayStudentHome();
                break;
            case 2:
                Portail.currentMember = new Enseignant(fullnameSplited[0], fullnameSplited[1]);
                this.displayTeacherHome();
                break;
            case 3:
                Portail.currentMember = new DSI(fullnameSplited[0], fullnameSplited[1]);
                this.displayDSIHome();
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid selection.");
                signIn();
                break;
        }


    }


    private void displayDSIHome() {
        boolean disconnected = false;
        do {
            System.out.println("DSI_HOME###########################\n" +
                    "--- Veillez selectionner une action:\n" +
                    "   --- 1) Deployement d'un espace de group\n" +
                    "   --- 2) Deconnexion\n");
            int selection = input.nextInt();
            input.nextLine();
            switch (selection) {
                case 1:
                    this.deployGroupArea();
                    break;
                case 2:
                    disconnected = true;
                    Portail.currentMember = null;
                    break;
                default:
                    System.out.println("Invalid selection.");
                    break;
            }
        } while (!disconnected);
    }

    private void displayTeacherHome() {
        boolean disconnected = false;
        do {
            System.out.println("TEACHER_HOME########################\n" +
                    "--- Veillez selectionner une action:\n" +
                    "   --- 1) Deconnexion\n");
            int selection = input.nextInt();
            input.nextLine();
            switch (selection) {
                case 1:
                    disconnected = true;
                    Portail.currentMember = null;
                    break;
                default:
                    System.out.println("Invalid selection.");
                    break;
            }
        }while (!disconnected);


    }

    private void displayStudentHome() {

        boolean disconnected = false;
        do {
            System.out.println("STUDENT_HOME########################\n" + Portail.currentMember.getFullname() +
                    "\n--- Veillez selectionner une action:\n" +
                    "   --- 1) Creer un groupe\n" +
                    "   --- 2) Accéder à un groupe\n" +
                    "   --- 3) Ajouter un membre à un groupe\n" +
                    "   --- 4) Copier la stucture d'un groupe\n" +
                    "   --- 5) Deconnexion");
            int selection = input.nextInt();
            input.nextLine();
            switch (selection) {
                case 1:
                    this.createGroup();
                    break;
                case 2:
                    this.accessToGroup();
                    break;
                case 3:
                    this.addMemberToGroup();
                    break;
                case 4:
                    this.copyGroup();
                    break;
                case 5:
                    disconnected = true;
                    Portail.currentMember = null;
                    break;
                default:
                    System.out.println("Invalid selection.");
                    break;
            }
        } while (!disconnected);

    }

    private void copyGroup() {
        //TODO: copyGroup
    }

    private void addMemberToGroup() {
        //TODO: addMemberToGroup()
    }

    private void accessToGroup() {
        Groupe selected = Portail.selectGroup(Portail.currentMember.getGroups());
        if (selected != null){
            Portail.displayGroup(selected);
            System.out.println("\n--- Selectionnez une action:\n" +
                    "   --- 1) Lier des documents\n" +
                    "   --- 2) Ajouter un objet\n" +
                    "   --- 3) Ajouter un membre\n" +
                    "   --- 4) Copier le groupe\n" +
                    "   --- 5) Retour aux groupes\n" +
                    "   --- 6) Retour au menu principale\n");
            int selection = input.nextInt();
            input.nextLine();
            //TODO: group menue
            switch (selection) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid selection.");
                    break;
            }
        }
    }

    private void createGroup() {
        //TODO: createGroup
    }

    private Filiere chooseFiliere() {
        //TODO:chooseFilère
        return null;
    }

    private void deployGroupArea() {
        //TODO:deploygroupArea
    }

    private void connexion() {

        System.out.println("Entrez votre nom suivi de votre prénom:");
        String fullname = input.nextLine();
        if (Portail.searchMember(fullname) == null){
            connexion();
        }else{
            Portail.currentMember = Portail.searchMember(fullname);

            System.out.println("--- Vous êtes:\n" +
                    "   --- 1) Étudiant\n" +
                    "   --- 2) Enseignant\n" +
                    "   --- 3) Membre de la DSI\n" +
                    "   --- 4) Retour");

            String[] fullnameSplited = fullname.split(" ");
            int selection = input.nextInt();
            input.nextLine();
            switch (selection){
                case 1:
                    this.displayStudentHome();
                    break;
                case 2:
                    this.displayTeacherHome();
                    break;
                case 3:
                    this.displayDSIHome();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid selection.");
                    connexion();
                    break;
            }
        }

    }

    private void exit() {
        System.out.println("Au revoir, petite Monica,\n" +
                "Nous partons au combat,\n" +
                "Au revoir, petite Monica,\n" +
                "Que tes yeux ne pleurent pas....");
        System.exit(1);
    }
}
