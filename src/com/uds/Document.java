package com.uds;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by François Caillet on 29/10/2015.
 * All rights reserved.
 */
public class Document implements Objet {

    private HashMap<Document,String> linkedDocuments;

    private String title;
    private String description;
    private Membre owner;
    private Date creationDate;
    private Date modificationDate;
    private String extention;

    public Document(String title, String description, Membre owner) {
        this.linkedDocuments = new HashMap<>();
        this.extention = ".doc";
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

    public HashMap<Document,String> getlinkedDocuments() {
        return this.linkedDocuments;
    }

    public void print(int section) {
        int index = section;
        while (index >= 0){
            System.out.print("|===|");
            index --;
        }
        System.out.println(this.title  + this.extention);
    }


    public void addLink(Document document, String label) {
        this.getlinkedDocuments().put(document,label);
    }

}


/*    public Document(String titre, String description, Membre membre) {
        this.createur = membre;
        String format = "dd/MM/yy H:mm:ss";

        java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
        java.util.Date date = new java.util.Date();
        this.date_creation = date;
        this.date_modification = date;
        this.titre = titre;
        this.description = description;

    }*/