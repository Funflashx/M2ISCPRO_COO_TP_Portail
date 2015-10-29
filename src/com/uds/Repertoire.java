package com.uds;
import java.util.ArrayList;
import java.util.List;


public class Repertoire implements Objet {

    public List<Objet> ListObjects  = new ArrayList<Objet> ();

/*    public Repertoire(String titre, String description, Membre membre) {
        this.createur = membre;
        String format = "dd/MM/yy H:mm:ss";

        java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
        java.util.Date date = new java.util.Date();
        this.date_creation = date;
        this.date_modification = date;
        this.titre = titre;
        this.description = description;

    }*/

    //Collection of child graphics.
    private List<Objet> childObjet = new ArrayList<Objet>();

    public void method() {
            System.out.println("un truc doit se passer ici x)");
    }

    //Adds the objet to the composition.
    public void add(Objet objet) {
        childObjet.add(objet);
    }

    //Removes the objet from the composition.
    public void remove(Objet objet) {
        childObjet.remove(objet);
    }

}
