package com.uds;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by francoiscaillet on 29/10/15.
 */
public class Filiere extends Groupe {

    private Trombinoscope trombinoscope = new Trombinoscope();
    private List<Enseignant> listEnseignants = new ArrayList<Enseignant>();
    private List<Etudiant> listEtudiants = new ArrayList<Etudiant>();
    private List<Enseignement> listEnseignement = new ArrayList<Enseignement>();

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
