package com.uds;

/**
 * Created by francoiscaillet on 29/10/15.
 */
public class GroupeInstitutionnelFactory extends GroupeFactory {

    protected Groupe creeGroupe() {
        return new Filiere("","");
        //TODO: switch?
        // new Composante
        //Laboratoire
    }
}
