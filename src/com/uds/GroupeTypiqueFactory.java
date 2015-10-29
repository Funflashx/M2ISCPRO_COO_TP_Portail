package com.uds;

/**
 * Created by francoiscaillet on 29/10/15.
 */
public class GroupeTypiqueFactory extends GroupeFactory {
    protected Groupe creeGroupe(String type, Membre owner, String title, String description) {
        try {
            if (type.equals("recherche-projet")){
                return new RechercheProjet(owner,title, description);
            }else if (type.equals("recherche-article")){
                return new RechercheArticle(owner,title, description);
            }else throw new Exception("Le type entré est incorrect");

        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }

        return null;

    }
}
