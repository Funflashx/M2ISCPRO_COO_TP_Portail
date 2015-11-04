package com.uds;

/**
 * Created by François Caillet on 29/10/2015.
 * All rights reserved.
 */
public class GroupeInstitutionnelFactory extends GroupeFactory {

    protected Groupe creeGroupe(String type, Membre owner, String title, String description) {
        try {
            switch (type) {
                case "filiere":
                    return new Filiere(owner, title, description);
                case "composante":
                    return new Composante(owner, title, description);
                case "laboratoire":
                    return new Laboratoire(owner, title, description);
                default:
                    throw new Exception("Le type entré est incorrect");
            }

        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }

        return null;
    }


}
