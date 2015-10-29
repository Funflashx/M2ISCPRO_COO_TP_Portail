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
}
