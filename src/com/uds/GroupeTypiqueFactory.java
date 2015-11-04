package com.uds;

/**
 * Created by François Caillet on 29/10/2015.
 * All rights reserved.
 */
public class GroupeTypiqueFactory extends GroupeFactory {
    protected Groupe creeGroupe(String type, Membre owner, String title, String description) {
        try {
            switch (type) {
                case "recherche-projet":
                    return new RechercheProjet(owner, title, description);
                case "recherche-article":
                    return new RechercheArticle(owner, title, description);
                default:
                    throw new Exception("Le type entré est incorrect");
            }

        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }

        return null;

    }

}
