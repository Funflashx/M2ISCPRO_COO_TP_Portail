package com.uds;

/**
 * Created by François Caillet on 29/10/2015.
 * All rights reserved.
 */
public class Enseignement {
    private String title;
    private Enseignant owner;

    Enseignement (String title, Enseignant enseignant){
        this.title = title;
        this.owner = enseignant;
    }
}
