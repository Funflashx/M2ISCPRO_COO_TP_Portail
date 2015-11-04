package com.uds;

/**
 * Created by François Caillet on 29/10/2015.
 * All rights reserved.
 */
public abstract class GroupeFactory {

    /**
     * Crée un groupe
     * @param type intitusionnel ou typique
     * @param owner propriataire du groupe
     * @param title titre du groupe
     * @param description description du groupe
     * @return le groupe voulu
     */
    protected abstract Groupe creeGroupe(String type, Membre owner, String title, String description);


}
