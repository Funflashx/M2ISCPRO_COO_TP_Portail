package com.uds;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by François Caillet on 29/10/2015.
 * All rights reserved.
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
            System.out.println("STUDENT_HOME########################\n" +
                    "--- Veillez selectionner une action:\n" +
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
                    Groupe group = Portail.selectGroup(Portail.currentMember.getGroups());
                    this.addMemberToGroup(group);
                    Portail.displayGroup(group);
                    break;
                case 4:
                    this.copyGroup(Portail.selectGroup(Portail.currentMember.getGroups()));
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

    private void copyGroup(Groupe toCopy) {
        System.out.println(" --- Veillez indiquer le titre du groupe copié:");
        String title = input.nextLine();
        System.out.println(" --- Veillez indiquer la description du groupe copié:");
        String description = input.nextLine();
        assert toCopy != null;
        Groupe copiedGroup = toCopy.copy(title, description);
        Portail.displayGroup(copiedGroup);
        Portail.currentMember.addGroup(copiedGroup);
        Portail.listGroups.add(copiedGroup);
    }

    private void addMemberToGroup(Groupe group) {
        System.out.println("Veuillez indiquer le nom et prenom du membre à ajouter:");
        String fullname = input.nextLine();
        Membre addedMember = Portail.searchMember(fullname);
        //le portail l'ajoute à la liste de ses groupe
        if (addedMember != null && group != null) {
            group.addMember(addedMember);
            addedMember.addGroup(group);
        }else {
            addMemberToGroup(group);
        }


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
            switch (selection) {
                case 1:
                    selectDocumentsToLink(selected);
                    break;
                case 2:
                    addObject(selected);
                    break;
                case 3:
                    addMemberToGroup(selected);
                    Portail.displayGroup(selected);
                    break;
                case 4:
                    copyGroup(selected);
                    break;
                case 5:
                    accessToGroup();
                    break;
                case 6:
                    break;
                default:
                    System.err.println("Invalid selection.");
                    accessToGroup();
                    break;
            }
        }
    }

    private void createGroup() {
        System.out.println("--- Veillez selectionner le type de groupe que vous souhaitez creer:\n" +
                "   --- 1) Groupe Institutionnel\n" +
                "   --- 2) Groupe Typique\n" +
                "   --- 3) Retour");
        int selection = input.nextInt();
        input.nextLine();

        switch (selection) {
            case 1:
                createGroupInstitutionnel();
                break;
            case 2:
                createGroupTypique();
                break;
            case 3:
                break;
            default:
                System.err.println("Invalid selection.");
                createGroup();
                break;
        }
    }

    private void createGroupInstitutionnel() {
        System.out.println("--- Veillez selectionner le type de groupe que vous souhaitez creer:\n" +
                "   --- 1) Filière\n" +
                "   --- 2) Composante\n" +
                "   --- 3) Laboratoire\n" +
                "   --- 4) Retour");
        int type = input.nextInt();
        input.nextLine();
        System.out.println("Indiquer le titre du groupe:");
        String title = input.nextLine();
        System.out.println("Indiquer la description du groupe:");
        String description = input.nextLine();
        Groupe groupeInstitutionnel;

        switch (type){
            case 1:
                groupeInstitutionnel = Portail.groupInstitutionnel.creeGroupe("filiere", Portail.currentMember, title , description );
                //le portail l'ajoute à la liste de ses groupe
                Portail.currentMember.addGroup(groupeInstitutionnel);
                //Portail (1)--gere--(*)> Group
                Portail.listGroups.add(groupeInstitutionnel);
                System.out.println("Voici le groupe que vous venez de creer:");
                Portail.displayGroup(groupeInstitutionnel);
                break;
            case 2:
                groupeInstitutionnel = Portail.groupInstitutionnel.creeGroupe("composante", Portail.currentMember, title , description );
                //le portail l'ajoute à la liste de ses groupe
                Portail.currentMember.addGroup(groupeInstitutionnel);
                //Portail (1)--gere--(*)> Group
                Portail.listGroups.add(groupeInstitutionnel);
                System.out.println("Voici le groupe que vous venez de creer:");
                Portail.displayGroup(groupeInstitutionnel);
                break;
            case 3:
                groupeInstitutionnel = Portail.groupInstitutionnel.creeGroupe("laboratoire", Portail.currentMember, title , description );
                //le portail l'ajoute à la liste de ses groupe
                Portail.currentMember.addGroup(groupeInstitutionnel);
                //Portail (1)--gere--(*)> Group
                Portail.listGroups.add(groupeInstitutionnel);
                System.out.println("Voici le groupe que vous venez de creer:");
                Portail.displayGroup(groupeInstitutionnel);
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid selection.");
                createGroupInstitutionnel();
                break;


        }

    }

    private void createGroupTypique() {
        System.out.println("--- Veillez selectionner le type de groupe que vous souhaitez creer:\n" +
                "   --- 1) Recherche Article\n" +
                "   --- 2) Recherche Projet\n" +
                "   --- 4) Retour");

        int type = input.nextInt();
        input.nextLine();
        System.out.println("Indiquer le titre du groupe:");
        String title = input.nextLine();
        System.out.println("Indiquer la description du groupe:");
        String description = input.nextLine();
        Groupe groupeTypique;

        switch (type) {
            case 1:
                groupeTypique = Portail.groupTypique.creeGroupe("recherche-article", Portail.currentMember, title, description);
                //le portail l'ajoute à la liste de ses groupe
                Portail.currentMember.addGroup(groupeTypique);
                //Portail (1)--gere--(*)> Group
                Portail.listGroups.add(groupeTypique);
                System.out.println("Voici le groupe que vous venez de creer:");
                Portail.displayGroup(groupeTypique);
                break;
            case 2:
                groupeTypique = Portail.groupTypique.creeGroupe("recherche-projet", Portail.currentMember, title, description);
                //le portail l'ajoute à la liste de ses groupe
                Portail.currentMember.addGroup(groupeTypique);
                //Portail (1)--gere--(*)> Group
                Portail.listGroups.add(groupeTypique);
                System.out.println("Voici le groupe que vous venez de creer:\n");
                Portail.displayGroup(groupeTypique);
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid selection.");
                createGroupInstitutionnel();
                break;
        }


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

    private Filiere chooseFiliere() {
        return Portail.selectGroupsFiliere(Portail.listGroupFiliere);
    }

    private void deployGroupArea() {
        int index = 0;
        for (Filiere f : Portail.listGroupFiliere){
            System.out.println(index + "- " + f.getTitre());
            index++;
        }
        System.out.println("Lequels selectionnez vous?");
        int selection = input.nextInt();
        System.out.println("            ...loading...");
        Filiere selectedFiliere = Portail.listGroupFiliere.get(selection);

        //La DSI crée un group institutionnel
        Groupe groupe = Portail.groupInstitutionnel.creeGroupe("filiere", Portail.currentMember, selectedFiliere.getTitre(), selectedFiliere.getDescription());

        //le portail l'ajoute à la liste de des groupe des enseignants
        for (Enseignant e : selectedFiliere.getListEnseigant()){
            selectedFiliere.addMember(e);
            e.addGroup(selectedFiliere);
        }

        Repertoire sousRepertoire1 = new Repertoire("cours", "", Portail.currentMember);
        selectedFiliere.addObject("repertoire", sousRepertoire1, groupe.getRacine());
        selectedFiliere.addRepository(sousRepertoire1);

        Repertoire sousRepertoire2 = new Repertoire("td", "", Portail.currentMember);
        selectedFiliere.addObject("repertoire", sousRepertoire2, groupe.getRacine());
        selectedFiliere.addRepository(sousRepertoire2);

        Repertoire sousRepertoire3 = new Repertoire("tp", "", Portail.currentMember);
        selectedFiliere.addObject("repertoire", sousRepertoire3, groupe.getRacine());
        selectedFiliere.addRepository(sousRepertoire3);

        Portail.displayGroup(selectedFiliere);

    }

    private void addObject(Groupe groupe) {
        ArrayList<String> titleDescription = new ArrayList<>();

        System.out.println("--- Quelle type de document souhaitez vous ajouter:\n"+
                "   --- 1) nouveau Document\n" +
                "   --- 2) nouveau Service\n" +
                "   --- 3) nouveau Repertoire\n" +
                "   --- 4) Retour\n");
        int selection = input.nextInt();
        input.nextLine();
        Repertoire selelectedRepertoire = selectRepositories(groupe.getRepositories());
        titleDescription = selectTitleDescription();
        switch (selection){
            case 1:
                assert selelectedRepertoire != null;
                Document document = new Document(titleDescription.get(0), titleDescription.get(1), Portail.currentMember);
                groupe.addDocument(document);
                selelectedRepertoire.add(document);
                groupe.getRacine().print(0);
                break;
            case 2:
                assert selelectedRepertoire != null;
                selelectedRepertoire.add(new Service(titleDescription.get(0), titleDescription.get(1), Portail.currentMember));
                groupe.getRacine().print(0);
                break;
            case 3:
                assert selelectedRepertoire != null;
                Repertoire repertoire = new Repertoire(titleDescription.get(0), titleDescription.get(1), Portail.currentMember);
                groupe.addRepository(repertoire);
                selelectedRepertoire.add(repertoire);
                groupe.getRacine().print(0);
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid selection.");
                addObject(groupe);
                break;
        }


    }

    private ArrayList<String> selectTitleDescription() {
        System.out.println("Veuillez indiquer le titre:");
        ArrayList<String> titleDescription = new ArrayList<>();
        titleDescription.add(input.nextLine());
        System.out.println("Veuillez indiquer le description:");
        titleDescription.add(input.nextLine());
        return titleDescription;
    }




    private Repertoire selectRepositories(List<Repertoire> repositories) {
        int index = 0;
        for (Repertoire r : repositories){
            System.out.println(index + "- " + r.getTitle());
            index++;
        }
        System.out.println("Ou souhaitez vous l'ajouter: ");
        int selection = input.nextInt();
        input.nextLine();
        assert selection >= repositories.size() - 1;
        return repositories.get(selection);

    }

    private void selectDocumentsToLink(Groupe groupe) {
        int index = 0;
        for (Document d : groupe.getDocuments()){
            System.out.println(index + "- " + d.getTitle());
            index++;
        }
        System.out.println("Lesquels souhaitez vous lier? ");
        int selection = input.nextInt();
        System.out.println("avec ?");
        int selection2 = input.nextInt();
        input.nextInt();
        System.out.println("Décrire le type du lien (ex: corriger):");
        String description = input.nextLine();
        groupe.getDocuments().get(selection).addLink(groupe.getDocuments().get(selection2), description);
        Portail.displayDocumentlinked(groupe.getDocuments().get(selection));
    }

    private void exit() {
        System.out.println("Au revoir, petite Monica,\n" +
                "Nous partons au combat,\n" +
                "Au revoir, petite Monica,\n" +
                "Que tes yeux ne pleurent pas....");
        System.exit(1);
    }
}
