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

    public Member(String lastname, String firstname/*,String login, String password*/) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.fullname = lastname + "" + firstname;
      /*  this.login = login;
        this.password = password;*/
    }

}
