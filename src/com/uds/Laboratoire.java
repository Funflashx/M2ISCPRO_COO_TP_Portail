package com.uds;

/**
 * Created by francoiscaillet on 29/10/15.
 */
public class Laboratoire extends Groupe {
    public Laboratoire(Membre owner, String title, String description) {
        super(owner, title, description);
    }

    public void method() {
        System.out.println("Laboratoire.print()");
    }
}
