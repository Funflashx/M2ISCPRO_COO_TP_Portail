package com.uds;

/**
 * Created by francoiscaillet on 29/10/15.
 */
public class GroupeTypiqueFactory extends GroupeFactory {
    protected Groupe creeGroupe() {
        return new RechercheArticle("","");
        // TODO:
        // new RechercheProjet
    }
}
