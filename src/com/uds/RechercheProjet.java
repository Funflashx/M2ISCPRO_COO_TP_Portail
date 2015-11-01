package com.uds;

/**
 * Created by francoiscaillet on 29/10/15.
 */
public class RechercheProjet extends Groupe {
    public RechercheProjet(Membre owner, String title, String description) {
        super(owner, title, description);
    }

    public  RechercheProjet(Groupe groupe, String title, String decription){
        super(groupe, title, decription);
    }

    public Groupe copy(Groupe toCopy, String title, String description) {
        return new RechercheProjet(toCopy, title, description);
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
