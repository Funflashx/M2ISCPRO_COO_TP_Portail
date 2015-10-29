package com.uds;

/**
 * Created by francoiscaillet on 29/10/15.
 */
public class GroupeInstitutionnelFactory extends GroupeFactory {

    protected Groupe creeGroupe(Membre owner, String title, String description) {
        return new Filiere(owner,title, description);
        //TODO: switch?
        // new Composante
        //Laboratoire
    }
}
