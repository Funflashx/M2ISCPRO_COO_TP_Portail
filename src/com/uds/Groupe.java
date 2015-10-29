package com.uds;
import java.util.ArrayList;
import java.util.List;



public abstract class Groupe {

    private Membre owner;
    private String titre;
    private String description;
    private List<Membre> listMembre;
    //private List<Objet> listObjet;
    private Repertoire repertoire;

    public Groupe(Membre owner, String title, String description) {
        this.listMembre = new ArrayList<>();
        this.repertoire = new Repertoire(title,description,owner);

        listMembre.add(owner);
        this.owner = owner;

        this.titre = title;
        this.description = description;
    }

    public Repertoire getRacine() {
        return repertoire;
    }

    //TODO:
    public abstract void method();

    public String getTitre() {
        return titre;
    }

    public Membre getOwner() {
        return owner;
    }

    public String getDescription() {
        return description;
    }

    public List<Membre> getListMembre() {
        return listMembre;
    }


    public abstract void addObject(String Type, Objet objet, Repertoire rep);
}

/*
    public void getContent() {
    }

    public void createObject() {
    }*/
