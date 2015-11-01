package com.uds;

/**
 * Created by francoiscaillet on 29/10/15.
 */
public class Filiere extends Groupe {
    public Filiere(Membre owner, String title, String description) {
        super(owner, title, description);
    }

    public  Filiere(Groupe groupe, String title, String decription){
        super(groupe,title,decription);
    }

    public Groupe copy(String title, String description) {
        return new Filiere(this, title, description);
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

/*    //TODO:
    public void method() {
        System.out.println("Filiere.print()");
    }*/

}
