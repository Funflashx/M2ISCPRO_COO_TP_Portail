package com.uds;

/**
 * Created by francoiscaillet on 29/10/15.
 */
public class RechercheArticle extends Groupe {
    public RechercheArticle(Membre owner, String title, String description) {
        super(owner, title, description);
    }

    public void method() {
        System.out.println("RechercheArticle.print()");
    }

    @Override
    public void addObject(String type, Objet objet, Repertoire rep) {
        //TODO: mettre le créa ici
        rep.add(objet);
    }


}
