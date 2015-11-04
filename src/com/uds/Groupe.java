package com.uds;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by François Caillet on 29/10/2015.
 * All rights reserved.
 */
public abstract class Groupe {

    private Membre owner;
    private String titre;
    private String description;
    private List<Membre> listMembre;
    private Repertoire repertoire;

    /**
     * @return le répertoire associé au groupe
     */
    public Repertoire getRacine() {
        return repertoire;
    }

    /**
     * @return titre du groupe
     */
    public String getTitre() {
        return titre;
    }

    /**
     * @return le propriétaire du groupe
     */
    public Membre getOwner() {
        return owner;
    }

    /**
     * @return la description du groupe
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return la liste des memebre associé au groupe
     */
    public List<Membre> getListMembre() {
        return listMembre;
    }

    /**
     * copie la structure du groupe
     * @param title titre du nouveau groupe
     * @param description description du nouveau groupe
     * @return la copie
     */
    public abstract Groupe copy(String title, String description);
    /**
     * @param Type de l'oject à ajouter
     * @param objet l'objet en question
     * @param repertoire le répertoire ou ajouter l'objet
     */
    public abstract void addObject(String Type, Objet objet, Repertoire repertoire);

    /**
     * ajouter un membre à un groupe
     * @param membre à ajouter
     */
    public abstract void addMember(Membre membre);


    /**
     * super constructeur de groupe
     * @param owner créateur du groupe
     * @param title titre du groupe
     * @param description du groupe
     */
    public Groupe(Membre owner, String title, String description) {
        this.listMembre = new ArrayList<>();
        this.repertoire = new Repertoire(title,description,owner);

        listMembre.add(owner);
        this.owner = owner;

        this.titre = title;
        this.description = description;
    }

    public Groupe(Groupe groupe, String title, String description){
        this.listMembre = groupe.getListMembre();
        this.repertoire = groupe.repertoire; //TODO: supprimer document et service, juste l'architecture see :
        this.owner = groupe.owner;
        this.titre = title;
        this.description = description;
    }
}