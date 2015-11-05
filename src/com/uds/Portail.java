package com.uds;

import java.io.IOException;
import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by François Caillet on 29/10/2015.
 * All rights reserved.
 */
public class Portail {

    /**
     * Le portail connait tout les groupe
     */
    public static List<Groupe> listGroups = new ArrayList<> ();
    /**
     * Le portail connait tout ses membres
     */
    public static List<Membre> listMembres = new ArrayList<> ();
    public static List<Filiere> listGroupFiliere = new ArrayList<>();
    public static Membre currentMember = null;
    public static GroupeFactory groupInstitutionnel;
    public static GroupeFactory groupTypique;

    public static void main(String[] args) throws IOException, InterruptedException {


        //Lancement des Usine !!! Tchou tchou
        groupInstitutionnel = new GroupeInstitutionnelFactory();
        groupTypique = new GroupeTypiqueFactory();

        //Creation des prof
        Enseignant christine = new Enseignant("Christine", "Ferraris");


        //Enseignements
        Enseignement enseignement1 = new Enseignement("INFO921", christine);
        Enseignement enseignement2 = new Enseignement("INFO912", christine);
        Enseignement enseignement3 = new Enseignement("INFO932", christine);
        Enseignement enseignement4 = new Enseignement("INFO978", christine);
        Enseignement enseignement5 = new Enseignement("INFO999", christine);
        Enseignement enseignement6 = new Enseignement("INFO966", christine);
        Enseignement enseignement11 = new Enseignement("INFO821", christine);
        Enseignement enseignement12 = new Enseignement("INFO831", christine);
        Enseignement enseignement13 = new Enseignement("INFO821", christine);
        Enseignement enseignement14 = new Enseignement("INFO701", christine);
        Enseignement enseignement15 = new Enseignement("INFO871", christine);



        //Filières
        DSI jack = new DSI("Jack", "Sparrow");
        Filiere filiere = new Filiere(jack,"M2ISCSTICINFO", "Groupe des étudiant de master 2 STIC INFO");
        Filiere filiere1 = new Filiere(jack,"M1ISCSTICINFO", "Groupe des étudiant de master 1 STIC INFO");
        Filiere filiere2 = new Filiere(jack,"L3ISCSTICINFO", "Groupe des étudiant de licence 3 STIC INFO");
        Filiere filiere3 = new Filiere(jack,"L2ISCSTICINFO", "Groupe des étudiant de licence 2 STIC INFO");
        Filiere filiere4 = new Filiere(jack,"L1ISCSTICINFO", "Groupe des étudiant de licence 1 STIC INFO");
        listGroupFiliere.add(filiere);
        listGroupFiliere.add(filiere1);
        listGroupFiliere.add(filiere2);
        listGroupFiliere.add(filiere3);
        listGroupFiliere.add(filiere4);

        //Ajout des enseignement:
        ArrayList<Enseignement> enseignements1 = new ArrayList<>();
        enseignements1.add(enseignement1);
        enseignements1.add(enseignement2);
        enseignements1.add(enseignement3);
        enseignements1.add(enseignement4);
        enseignements1.add(enseignement5);
        enseignements1.add(enseignement6);

        ArrayList<Enseignement> enseignements2 = new ArrayList<>();
        enseignements2.add(enseignement11);
        enseignements2.add(enseignement12);
        enseignements2.add(enseignement13);
        enseignements2.add(enseignement14);
        enseignements2.add(enseignement15);

        //ajoute à la filière:
        filiere.setListEnseignement(enseignements1);
        filiere1.setListEnseignement(enseignements2);

        //Creation d'une liste d'utilisateur
        Etudiant antoine = new Etudiant("Antoine", "Daniel",filiere);
        Etudiant françois = new Etudiant("François", "Caillet",filiere);
        Etudiant anthony = new Etudiant("Anthony", "Di Lisio",filiere);

        Etudiant etudiant1 = new Etudiant("foo", "bar",filiere1);
        Etudiant etudiant2 = new Etudiant("foo", "bar1",filiere1);
        Etudiant etudiant4 = new Etudiant("foo", "bar2",filiere1);


        //liste enseignant:
        ArrayList<Enseignant> enseignants = new ArrayList<>();
        enseignants.add(christine);
        filiere.setListEnseignants(enseignants);
        filiere1.setListEnseignants(enseignants);





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
        groupeTest.addRepository(sousRepertoire1);

        Repertoire sousSousRepertoire1 = new Repertoire("rep2", "", antoine);
        antoine.getGroups().get(0).addObject("repertoire", sousSousRepertoire1, sousRepertoire1);
        groupeTest.addRepository(sousSousRepertoire1);

        Document document = new Document("document", "", antoine);
        antoine.getGroups().get(0).addObject("document", document, sousSousRepertoire1);
        groupeTest.addDocument(document);

        Document documentCorrection = new Document("document correction", "", antoine);
        antoine.getGroups().get(0).addObject("document", documentCorrection, sousSousRepertoire1);
        groupeTest.addDocument(documentCorrection);

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
     * Ex: document<--correction--document correction
     * @param document dont il faut afficher les liens
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
     * selectionne un objet
     * @param listObject parmis une liste d'objet
     * @return l'objet selectioné
     */
    public static Objet selectObject(List<Objet> listObject){
        Scanner in = new Scanner(System.in);
        String selectedDocument;
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
            String selectedGroup;
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
     * @param listGroups liste de groupe numéroté de 0 à listGroups.size() - 1
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
     * @param groupe le groupe
     */
    public static void displayGroup(Groupe groupe){
        System.out.print("\n#" + (char) 27 + "[30;4m" + groupe.getTitre());
        defaultDisplay();
        System.out.print("\n=============================\n#created by: "+ (char)27 + "[36;1m" + groupe.getOwner().getFullname() + (char)27 + "[0;0m"+"\n##brief:"
                + (char)27 + "[30;0m"+ groupe.getDescription() + (char)27 + "[0;0m" + "\n_____________________membres:\n");

        displayMembers(groupe.getListMembre());
        groupe.getRacine().print(0);
        System.out.println();
    }

    /**
     * Affiche une liste de membre
     * Ex: Antoine D. | François C. | Anthony D.
     * @param listMembers une liste de membre
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
                defaultDisplay();
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

    public static Filiere selectGroupsFiliere(List<Filiere> listGroupFiliere) {
        //TODO
        return null;
    }
}
