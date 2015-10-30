package com.uds;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Service implements Objet {

    private String title;
    private String description;
    private Membre owner;
    private Date creationDate;
    private Date modificationDate;

    public Service(String title, String description, Membre owner) {
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
    public HashMap<Document,String> getlinkedDocuments() {
        return null;
    }

    public void print(int section) {
        int index = section;
        while (index >= 0){
            System.out.print("|===|");
            index --;
        }
        System.out.println((char)27 + "[35;1m" + title + (char)27 + "[0;0m");
    }

    @Override
    public void addLink(Document document, String label) {

    }

}
