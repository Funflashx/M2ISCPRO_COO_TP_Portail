package com.uds;

/**
 * Created by François Caillet on 29/10/2015.
 * All rights reserved.
 */
public class Etudiant extends Membre {

    /**
     * la filière de l'étudiant, le cursus qu'il suit
     */
    private Filiere filiere;

    public Etudiant(String lastname, String firstname, Filiere filiere) {
        super(lastname, firstname);
        this.filiere = filiere;
    }
}
