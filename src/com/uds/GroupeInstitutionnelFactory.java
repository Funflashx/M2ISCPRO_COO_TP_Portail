package com.uds;

/**
 * Created by francoiscaillet on 29/10/15.
 */
public class GroupeInstitutionnelFactory extends GroupeFactory {

    protected Groupe creeGroupe(String type, Membre owner, String title, String description) {
        try {
            if (type.equals("filiere")){
                return new Filiere(owner,title, description);
            }else if (type.equals("composante")){
                return new Composante(owner,title, description);
            }else if (type.equals("laboratoire")){
                return new Laboratoire(owner,title, description);
            }else throw new Exception("Le type entré est incorrect");

        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }

        return null;
    }


}
