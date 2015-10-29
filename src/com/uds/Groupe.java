package com.uds;
import java.util.ArrayList;
import java.util.List;



public abstract class Groupe {

    public Membre owner;
    public String titre;
    public String description;
    public List<Membre> listMembre;
    public Repertoire repertoire;

    public Groupe(Membre owner, String title, String description) {
        this.listMembre = new ArrayList<>();
        this.repertoire = new Repertoire(title,description,owner);

        listMembre.add(owner);
        this.owner = owner;

        this.titre = title;
        this.description = description;
    }

    public Repertoire getRepertoire() {
        return repertoire;
    }

    //TODO:
    public abstract void method();

    public abstract void addObject(String type, String title, String description, Membre owner, Repertoire rep);
}

/*
    public void getContent() {
    }

    public void createObject() {
    }*/
