package com.uds;

public class Document implements Objet {

    public void method() {
        System.out.println("Document");
    }

/*    public Document(String titre, String description, Membre membre) {
        this.createur = membre;
        String format = "dd/MM/yy H:mm:ss";

        java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
        java.util.Date date = new java.util.Date();
        this.date_creation = date;
        this.date_modification = date;
        this.titre = titre;
        this.description = description;

    }*/
}
