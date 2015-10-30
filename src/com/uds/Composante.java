package com.uds;

/**
 * Created by francoiscaillet on 29/10/15.
 */
public class Composante extends Groupe {

    public Composante(Membre owner, String title, String description) {
        super(owner ,title, description);
    }

    //TODO:
    public void method(){
        System.out.println("Composante.print()");
    }

    @Override
    public void addObject(String type, Objet objet, Repertoire rep) {
        //TODO: mettre le créa ici
        rep.add(objet);
    }

    @Override
    public void addMember(Membre membre) {
        this.getListMembre().add(membre);
    }


}
