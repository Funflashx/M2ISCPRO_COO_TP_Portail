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

    @Override
    public HashMap<Document, String> getlinkedDocuments() {
        return null;
    }


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

    @Override
    public void addLink(Document document, String label) {

    }

    //Adds the objet to the composition.
    public void add(Objet objet) {
        childObjets.add(objet);
    }

    //Removes the objet from the composition.
    public void remove(Objet objet) {
        childObjets.remove(objet);
    }



}

/*    public Repertoire(String titre, String description, Membre membre) {
        this.createur = membre;
        String format = "dd/MM/yy H:mm:ss";

        java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
        java.util.Date date = new java.util.Date();
        this.date_creation = date;
        this.date_modification = date;
        this.titre = titre;
        this.description = description;

    }*/