package com.uds;

/**
 * Created by francoiscaillet on 29/10/15.
 */
public abstract class GroupeFactory {

    //TODO:
    //public Groupe getGroupe() {
    //    return creeGroupe();
    //}

    protected abstract Groupe creeGroupe(Membre owner, String title, String description);
}
