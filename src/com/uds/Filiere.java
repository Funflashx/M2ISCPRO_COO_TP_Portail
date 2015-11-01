package com.uds;

/**
 * Created by francoiscaillet on 29/10/15.
 */
public class Filiere extends Groupe {
    public Filiere(Membre owner, String title, String description) {
        super(owner, title, description);
    }

    //TODO:
    public void method() {
        System.out.println("Filiere.print()");
    }

    public Groupe copy(Groupe toCopy, String title, String description) {
        return null;
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
