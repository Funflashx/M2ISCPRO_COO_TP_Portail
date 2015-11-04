package com.uds;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by François Caillet on 29/10/2015.
 * All rights reserved.
 */
public class Membre {

    private String lastname;
    private String firstname;
    private String fullname;
    private String sumFullname;


    public List<Groupe> listGroups = new ArrayList<> ();

    public Membre(String firstname, String lastname) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.fullname = firstname + " " + lastname;
        this.sumFullname = String.valueOf(firstname.charAt(0)) + lastname;
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

    public String getFullname() {
        return fullname;
    }

    public String getSumFullname() {
        return sumFullname;
    }
}
