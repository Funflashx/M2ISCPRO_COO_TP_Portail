package com.uds;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Document implements Objet {

    private List<Document> linkedDocuments;

    private String title;
    private String description;
    private Membre owner;
    private Date creationDate;
    private Date modificationDate;

    public Document(String title, String description, Membre owner) {
        this.linkedDocuments = new ArrayList<>();

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

    public void print() {
        System.out.println("Document");
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