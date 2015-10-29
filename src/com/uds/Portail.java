package com.uds;

import java.io.IOException;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;

public class Portail { //PORTAIL_UDS

    public static List<Groupe> listGroups = new ArrayList<Groupe> ();
    public static List<Membre> listMembres = new ArrayList<Membre> ();
    public static List<Filiere> listGroupFiliere = new ArrayList<Filiere>();

    public static void main(String[] args) throws IOException, InterruptedException {

        GroupeFactory groupInstitutionnel = new GroupeInstitutionnelFactory();
        GroupeFactory groupTypique = new GroupeTypiqueFactory();

        //Creation d'une liste d'utilisateur
        Membre antoine = new Membre("Antoine","Daniel");
        Membre lalie = new Membre("Lalie","Clérel");
        Membre françois = new Membre("François", "Caillet");
        Membre anthony = new Membre("Antony", "Di Lisio");
        Membre christine = new Membre("Christine", "Ferraris");
        Membre jack = new Membre("Jack", "Sparrow");

        //Portail (1)--gere--(*)> Membre
        listMembres.add(antoine);
        listMembres.add(lalie);
        listMembres.add(françois);
        listMembres.add(anthony);
        listMembres.add(christine);
        listMembres.add(jack);

        //Antoine crée un group institutionnel
        Groupe groupeT = groupInstitutionnel.creeGroupe("filiere", antoine,"M2ISCPRO", "Groupe associée au master 2 ISC PRO STIC de l'université de savoie");
        //le portail l'ajoute à la liste de ses(antoine) groupe
        antoine.addGroup(groupeT);
        //Portail (1)--gere--(*)> Group
        listGroups.add(groupeT);

        // Antoine ajoute un répertoire à M2ISCPRO
        //Member (1)--est gestionnaire--(*)>Group(1)----(*)>Object
        Repertoire sousRepertoire1 = new Repertoire("rep1","", antoine);
        antoine.getGroups().get(0).addObject("repertoire", sousRepertoire1, groupeT.getRacine());

        Repertoire sousSousRepertoire1 = new Repertoire("rep2","", antoine);
        groupeT.addObject("repertoire", sousSousRepertoire1,sousRepertoire1);

        Document document = new Document("document", "", antoine);
        groupeT.addObject("document",document,sousSousRepertoire1);

        Service service = new Service("efef","fs",antoine);
        groupeT.addObject("service",service,sousRepertoire1);


        displayGroups(antoine.getGroups());
        //displayMembers(listMembres);
        Thread.sleep(1000);
        displayGroup(groupeT);

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
            System.out.println((char)27 + "[31;1m" +"LISTE VIDE");
            clear();
            //displayMenu();
        }else {
            for (Groupe g : groupes) {
                System.out.println("#" + groupes.indexOf(g) + "." + (char) 27 + "[30;4m" + g.getTitre());
                clear();
                System.out.print("=============================\n#created by: "+ (char)27 + "[36;1m" + g.getOwner().getFullname() + (char)27 + "[0;0m"+"\n##brief:"
                        + (char)27 + "[30;0m"+ g.getDescription() + (char)27 + "[0;0m" + "\n_____________________membres: " + (char)27 + "[0;1m" + g.getListMembre().size() + (char)27 + "[0;0m\n\n\n");
            }
        }

    }

    public static void displayGroup(Groupe g){
        System.out.print("#" + (char) 27 + "[30;4m" + g.getTitre());
        clear();
        System.out.print("\n=============================\n#created by: "+ (char)27 + "[36;1m" + g.getOwner().getFullname() + (char)27 + "[0;0m"+"\n##brief:"
                + (char)27 + "[30;0m"+ g.getDescription() + (char)27 + "[0;0m" + "\n_____________________membres:\n");

        displayMembers(g.getListMembre());
        g.getRacine().print(0);
    }

    public static void displayMembers(List<Membre> membres){
        int index = 1;
        for (Membre m: membres){
            System.out.print((char)27 + "[34;0m" + m.getSumFullname());
            if (index < membres.size()){
                System.out.print("|");
            }
            if (index%4 == 0){
                System.out.print("\n");
            }
            if (index == membres.size()){
                System.out.println((char)27 + "[235;1m\n_____________________________");
                System.out.print((char)27 + "[0;0m");
            }
            index++;
        }
    }


    public static void clear(){
        System.out.print((char)27 + "[0;0m");
    }

}


