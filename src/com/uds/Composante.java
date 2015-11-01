package com.uds;

import javax.swing.*;

/**
 * Created by francoiscaillet on 29/10/15.
 */
public class Composante extends Groupe {

    public Composante(Membre owner, String title, String description) {
        super(owner ,title, description);
    }

    public Composante(Groupe groupe, String title, String description){
        super(groupe,title,description);
    }

    //TODO:
    public void method(){
        System.out.println("Composante.print()");
    }

    public Groupe copy(String title, String description) {
        return new Composante(this,title,description);
    }

    @Override
    public void addObject(String type, Objet objet, Repertoire repertoire) {
        //TODO: mettre le créa ici
        repertoire.add(objet);
    }

    @Override
    public void addMember(Membre membre) {
        this.getListMembre().add(membre);
    }


}
