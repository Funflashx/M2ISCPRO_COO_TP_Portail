package com.uds;

/**
 * Created by François Caillet on 29/10/2015.
 * All rights reserved.
 */
public class Laboratoire extends Groupe {
    public Laboratoire(Membre owner, String title, String description) {
        super(owner, title, description);
    }

    public  Laboratoire(Groupe groupe, String title, String decription){
        super(groupe, title, decription);
    }

    public Groupe copy(String title, String description) {
        return new Laboratoire(this, title, description);
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
