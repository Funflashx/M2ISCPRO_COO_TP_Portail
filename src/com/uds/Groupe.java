package com.uds;
import java.util.ArrayList;
import java.util.List;



public abstract class Groupe {

    public Membre owner;
    public String titre;
    public String description;
    public List<Membre> listMembre;
    public List<Objet> ListObjects;

    public Groupe(Membre owner, String title, String description) {
        this.listMembre = new ArrayList<>();
        this.ListObjects = new ArrayList<>();

        listMembre.add(owner);
        this.owner = owner;

        this.titre = title;
        this.description = description;
    }

    //TODO:
    public abstract void method();
}

/*
    public void getContent() {
    }

    public void createObject() {
    }*/
