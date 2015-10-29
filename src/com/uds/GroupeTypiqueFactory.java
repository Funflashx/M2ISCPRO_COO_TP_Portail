package com.uds;

/**
 * Created by francoiscaillet on 29/10/15.
 */
public class GroupeTypiqueFactory extends GroupeFactory {
    protected Groupe creeGroupe(Membre owner, String title, String description) {
        return new RechercheArticle(owner,title, description);
        // TODO:
        // new RechercheProjet
    }
}
