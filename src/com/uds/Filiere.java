package com.uds;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by François Caillet on 29/10/2015.
 * All rights reserved.
 */
public class Filiere extends Groupe {

    private Trombinoscope trombinoscope;
    private List<Enseignant> listEnseignants;
    private List<Etudiant> listEtudiants;
    private List<Enseignement> listEnseignement;
    private Enseignant[] listEnseigant;

    public Filiere(Membre owner, String title, String description) {
        super(owner, title, description);
        this.listEnseignants = new ArrayList<>();
        this.listEtudiants = new ArrayList<>();
        this.listEnseignement = new ArrayList<>();
        this.trombinoscope = new Trombinoscope();
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


    public void setListEnseignants(List<Enseignant> listEnseignants) {
        this.listEnseignants = listEnseignants;
    }

    public void setListEtudiants(List<Etudiant> listEtudiants) {
        this.listEtudiants = listEtudiants;
    }

    public void setListEnseignement(List<Enseignement> listEnseignement) {
        this.listEnseignement = listEnseignement;
    }

    public Enseignant[] getListEnseigant() {
        return listEnseigant;
    }
}
