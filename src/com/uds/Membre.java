package com.uds;

import java.util.ArrayList;
import java.util.List;

public class Membre {
    //public String _id;

    public String login;
    public String nom;
    public String prenom;
    public String password;

    public List<Groupe> listGroupes = new ArrayList<Groupe> ();

    public List<Groupe> mesGroupes = new ArrayList<Groupe> ();

    public List<Groupe> getGroups() {
        return this.listGroupes;
    }

    public Groupe createGroup(String title,String description) {
        Groupe newGroupe = new Groupe(title, description);
        listGroupes.add(newGroupe);
        mesGroupes.add(newGroupe);
        return newGroupe;

    }

    public Membre(String nom, String prenom, String login, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
    }

}
