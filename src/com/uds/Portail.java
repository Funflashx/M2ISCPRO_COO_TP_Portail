package com.uds;

import java.io.IOException;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * LE PORTAIL DE L'UNIVERSITÉ DE SAVOIE
 * IL S'AGIT DU CLIENT DE L'APPLICATION
 */
public class Portail {

    /**
     * Le portail connait tout les groupe
     */
    public static List<Groupe> listGroups = new ArrayList<Groupe> ();
    /**
     * Le portail connait tout ses membres
     */
    public static List<Membre> listMembres = new ArrayList<Membre> ();
    public static List<Filiere> listGroupFiliere = new ArrayList<Filiere>();
    public static Membre currentMember = null;

    public static void main(String[] args) throws IOException, InterruptedException {


        //Lancement des Usine !!! Tchou tchou
        GroupeFactory groupInstitutionnel = new GroupeInstitutionnelFactory();
        GroupeFactory groupTypique = new GroupeTypiqueFactory();




        //Filière
        DSI jack = new DSI("Jack", "Sparrow");
        Filiere filiere = new Filiere(jack,"M2ISCSTICINFO", "Groupe des étudiant de master 2 STIC INFO");
        listGroupFiliere.add(filiere);

        //Creation d'une liste d'utilisateur
        Etudiant antoine = new Etudiant("Antoine", "Daniel",filiere);
        Etudiant françois = new Etudiant("François", "Caillet",filiere);
        Etudiant anthony = new Etudiant("Antony", "Di Lisio",filiere);
        Enseignant christine = new Enseignant("Christine", "Ferraris");




        //Portail (1)--gere--(*)> Membre
        //Chaque membre est ajouté à la liste des mebre du portail
        listMembres.add(antoine);
        listMembres.add(françois);
        listMembres.add(anthony);
        listMembres.add(christine);
        listMembres.add(jack);


        //Antoine crée un group institutionnel
        Groupe groupeTest = groupInstitutionnel.creeGroupe("filiere", antoine, "M2ISCPRO", "Groupe associée au master 2 ISC PRO STIC de l'université de savoie");
        //le portail l'ajoute à la liste de ses groupe
        antoine.addGroup(groupeTest);
        //Portail (1)--gere--(*)> Group
        listGroups.add(groupeTest);

        // Antoine ajoute un répertoire "rep1" au groupe "M2ISCPRO"
        //Member (1)--est gestionnaire--(*)>Group(1)----(*)>Object
        Repertoire sousRepertoire1 = new Repertoire("rep1", "", antoine);
        antoine.getGroups().get(0).addObject("repertoire", sousRepertoire1, groupeTest.getRacine());

        Repertoire sousSousRepertoire1 = new Repertoire("rep2", "", antoine);
        antoine.getGroups().get(0).addObject("repertoire", sousSousRepertoire1, sousRepertoire1);

        Document document = new Document("document", "", antoine);
        antoine.getGroups().get(0).addObject("document", document, sousSousRepertoire1);

        Document documentCorrection = new Document("document correction", "", antoine);
        antoine.getGroups().get(0).addObject("document", documentCorrection, sousSousRepertoire1);

        Service service = new Service("doodle", "sondage sur la faim du monde", antoine);
        antoine.getGroups().get(0).addObject("service", service, sousRepertoire1);



/*


        //Lier des documents
        //selectObject()
        //selected.selectObject()
        document.addLink(documentCorrection, "correction");
        //displayLinkedDocument()

        //Copier la structure d'un groupe
        //TODO:copy()
        //Groupe copyGroupT =  groupInstitutionnel.copy(groupeTest,"copyM2ISCPRO","une copie de la stucture");

        Groupe copie = groupeTest.copy("copie", "copie");

        //Affichage
        displayGroups(antoine.getGroups());
        //displayMembers(listMembres);
        //Ajouter un membre à un group
        selectGroup(listGroups);
        Groupe selected = antoine.getGroups().get(0);
        //TODO: searchMember("françois")
        Membre finded = listMembres.get(2);
        selected.addMember(finded);
        Thread.sleep(1000);
        displayGroup(groupeTest);

*/

        Menu menu = new Menu();
        menu.display();


    }


    /**
     * affiche les document lié à un document
     * Ex: document<--correction--document correction
     * @param document
     */
    public static void displayDocumentlinked(Objet document) {
        if (document.getlinkedDocuments().entrySet().size() == 0){
            System.err.println("Rien n'a afficher");
        }else{
            for (Map.Entry<Document, String> entry : document.getlinkedDocuments().entrySet()) {
                Document linkedDocument = entry.getKey();
                String lien = entry.getValue();
                System.out.println(document.getTitle() + "<--" + lien + "--" + linkedDocument.getTitle());
            }
        }
    }


    /**
     * selectionné un objet parmis une liste d'objet
     * @param listObject
     * @return l'objet selectioné
     */
    public static Objet selectObject(List<Objet> listObject){
        Scanner in = new Scanner(System.in);
        String selectedDocument = "";
        System.out.print("\nQuelle Documents souhaitez vous selectionner? (réponse accepté compris de 0 à " + (listObject.size() - 1) + ")\n");
        selectedDocument = in.nextLine();
        try {
            if (Integer.parseInt(selectedDocument) <= listObject.size()) {
                return listObject.get(Integer.parseInt(selectedDocument));
            } else throw new Exception("Saisie incorrecte");
        } catch (Exception e) {
            System.err.println(e.getMessage() + " est une saisie incorrect-");
            selectObject(listObject);
        }
        return null;
    }

    /**
     * Selection d'un groupe parmis une liste de groupes
     * @param listGroups (liste de groupes)
     * @return le groupe selectionné
     */
    public static Groupe selectGroup(List<Groupe> listGroups){
        displayGroups(listGroups);
        if (listGroups.size()>0) {
            Scanner in = new Scanner(System.in);
            String selectedGroup = "";
            System.out.print("\nQuelle groupe souhaitez vous selectionner? (réponse accepté compris de 0 à " + (listGroups.size() - 1) + ")\n");
            selectedGroup = in.nextLine();
            try {
                if (Integer.parseInt(selectedGroup) <= listGroups.size()) {
                    return listGroups.get(Integer.parseInt(selectedGroup));
                } else throw new Exception("Saisie incorrecte");
            } catch (Exception e) {
                System.err.println(e.getMessage() + " est une saisie incorrect-");
                selectGroup(listGroups);
            }
            return null;
        }else {
            return null;
        }
    }

    /**
     * Affiche une liste de groupe numéroté de 0 à listGroups.size() - 1
     * @param listGroups
     */
    public static void displayGroups(List<Groupe> listGroups) {
        if(listGroups.size() == 0){
            System.out.println((char)27 + "[31;1m" +"LISTE VIDE");
            defaultDisplay();
            //displayMenu();
        }else {
            for (Groupe g : listGroups) {
                System.out.println("#" + listGroups.indexOf(g) + "." + (char) 27 + "[30;4m" + g.getTitre());
                defaultDisplay();
                System.out.print("=============================\n#created by: "+ (char)27 + "[36;1m" + g.getOwner().getFullname() + (char)27 + "[0;0m"+"\n##brief:"
                        + (char)27 + "[30;0m"+ g.getDescription() + (char)27 + "[0;0m" + "\n_____________________membres: " + (char)27 + "[0;1m" + g.getListMembre().size() + (char)27 + "[0;0m\n\n\n");
            }
        }

    }

    /**
     * Affiche un groupe de façon détaillé
     * @param groupe
     */
    public static void displayGroup(Groupe groupe){
        System.out.print("#" + (char) 27 + "[30;4m" + groupe.getTitre());
        defaultDisplay();
        System.out.print("\n=============================\n#created by: "+ (char)27 + "[36;1m" + groupe.getOwner().getFullname() + (char)27 + "[0;0m"+"\n##brief:"
                + (char)27 + "[30;0m"+ groupe.getDescription() + (char)27 + "[0;0m" + "\n_____________________membres:\n");

        displayMembers(groupe.getListMembre());
        groupe.getRacine().print(0);
    }

    /**
     * Affiche une liste de membre
     * Ex: Antoine D. | François C. | Anthony D.
     * @param listMembers
     */
    public static void displayMembers(List<Membre> listMembers){
        int index = 1;
        for (Membre m: listMembers){
            System.out.print((char)27 + "[34;0m" + m.getSumFullname());
            if (index < listMembers.size()){
                System.out.print(" | ");
            }
            if (index%4 == 0){
                System.out.print("\n");
            }
            if (index == listMembers.size()){
                System.out.println((char)27 + "[235;1m\n_____________________________");
                System.out.print((char)27 + "[0;0m");
            }
            index++;
        }
    }


    /**
     * Remet à zero l'affichage sur le terminal (couleur par defaut et style par defaut)
     */
    public static void defaultDisplay(){
        System.out.print((char)27 + "[0;0m");
    }


    public static Membre searchMember(String fullname) {
        for (Membre membres: listMembres){
            if (membres.getFullname().equals(fullname)){
                return membres;
            }
        }

        return null;
    }
}



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


