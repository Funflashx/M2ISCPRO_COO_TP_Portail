package com.uds;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class Repertoire implements Objet {


    //Collection of child objects.
    private List<Objet> childObjets;
    private String title;
    private String description;
    private Membre owner;
    private Date creationDate;
    private Date modificationDate;

    public Repertoire(String title, String description, Membre owner) {
        this.childObjets = new ArrayList<>();

        this.title = title;
        this.description = description;
        this.owner = owner;

        Date today = new java.util.Date();
        this.modificationDate = today;
        this.creationDate = today;
    }


    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public Membre getOwner() {
        return owner;
    }
    public Date getCreationDate() {
        return creationDate;
    }
    public Date getModificationDate() {
        return modificationDate;
    }
    public HashMap<Document, String> getlinkedDocuments() {
        return null;
    }
    public List<Objet> getChildObjets (){
        return this.childObjets;
    }

    public void clearFiles(){
        for (Objet objet : childObjets) {
            if (objet.getClass().getSimpleName().equals("Document")){
                remove(objet);
            } else if (objet.getClass().getSimpleName().equals("Repertoire")) {
                objet.clearFiles();
            }
        }
    }

    /**
     * @param section indentation des dossiers
     * le répertoire affiche ses enfants
     */
    public void print(int section) {
        int index = section;
        while (index >= 0){
            System.out.print("|===|");
            index --;
        }
        System.out.println(this.title);
        for (Objet objet : childObjets) {
            objet.print(section + 1);
        }
    }


    /**
     * @param document document à lier avec le courant
     * @param label    libéllé de cette relation
     * ne fait rien ici,
     * affiche une erreur
     */
    public void addLink(Document document, String label) {
        System.err.println("le répertoire ne peut pas être lié à un document");
    }


    /**
     * @param objet ajoute l'objet à la composition
     */
    public void add(Objet objet) {
        childObjets.add(objet);
    }


    /**
     * @param objet retire l'objet de la composition
     */
    public void remove(Objet objet) {
        childObjets.remove(objet);
    }



}
