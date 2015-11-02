package com.uds;

import java.util.ArrayList;
import java.util.List;

public class Membre {
    //public String _id; //TODO: Generer un id aléatoirement



    private String login;
    private String password;
    private String lastname;
    private String firstname;
    private String fullname;
    private String sumFullname;


    public List<Groupe> listGroups = new ArrayList<Groupe> ();


/*    public Groupe createGroup(String title,String description) {
        //TODO: refactoring pour le nouveau modéle (les groupe se crée par l'intermédiaire de la FactoryGroup)
        Groupe newGroupe = new Groupe(title, description);
        listGroups.add(newGroupe);
        myListGroups.add(newGroupe);
        return newGroupe;

    }*/

    public Membre(String firstname, String lastname/*,String login, String password*/) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.fullname = firstname + " " + lastname;
        this.sumFullname = firstname + " " + lastname.charAt(0);
      /*  this.login = login;
        this.password = password;*/
    }

    public void addObject(String type, Objet objet, Repertoire repertoire, Groupe groupe){
        groupe.addObject(type,objet,repertoire);
    }

    public List<Groupe> getGroups(){
        return listGroups;
    }

    public void addGroup(Groupe groupe) {
        this.listGroups.add(groupe);
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getFullname() {
        return fullname;
    }

    public String getSumFullname() {
        return sumFullname;
    }

    public void addGroupe(Membre membre) {

    }
}
