package com.uds;

import java.util.ArrayList;
import java.util.List;

public class Member {
    //public String _id; //TODO: Generer un id aléatoirement

    public String login;
    public String password;
    public String lastname;
    public String firstname;
    public String fullname;


    public List<Groupe> listGroups = new ArrayList<Groupe> ();

    public List<Groupe> myListGroups = new ArrayList<Groupe> ();

    public List<Groupe> getListGroups() {
        return this.listGroups;
    }

    public List<Groupe> getMyListGroups() {
        return this.myListGroups;
    }

    public Groupe createGroup(String title,String description) {
        Groupe newGroupe = new Groupe(title, description);
        listGroups.add(newGroupe);
        myListGroups.add(newGroupe);
        return newGroupe;

    }

    public Member(String lastname, String firstname/*,String login, String password*/) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.fullname = lastname + "" + firstname;
      /*  this.login = login;
        this.password = password;*/
    }

}
