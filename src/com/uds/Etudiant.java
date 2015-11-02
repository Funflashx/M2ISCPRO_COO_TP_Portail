package com.uds;

/**
 * Created by francoiscaillet on 29/10/2015.
 */
public class Etudiant extends Membre {

    private Filiere filiere;

    public Etudiant(String lastname, String firstname, Filiere filiere) {
        super(lastname, firstname);
        this.filiere = filiere;
    }
}
