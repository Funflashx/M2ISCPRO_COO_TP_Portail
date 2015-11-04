package com.uds;

/**
 * Created by François Caillet on 29/10/2015.
 * All rights reserved.
 */
public class RechercheProjet extends Groupe {
    public RechercheProjet(Membre owner, String title, String description) {
        super(owner, title, description);
    }

    public  RechercheProjet(Groupe groupe, String title, String decription){
        super(groupe, title, decription);
    }

    public Groupe copy(String title, String description) {
        return new RechercheProjet(this, title, description);
    }

    public void addObject(String type, Objet objet, Repertoire repertoire) {
        //TODO: mettre le créa ici
        repertoire.add(objet);
    }

    @Override
    public void addMember(Membre membre) {
        this.getListMembre().add(membre);
    }

}
