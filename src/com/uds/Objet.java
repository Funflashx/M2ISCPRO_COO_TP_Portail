package com.uds;
import java.util.Date;


interface Objet {

    public String getTitle();
    public String getDescription();
    public Membre getOwner();
    public Date getCreationDate();
    public Date getModificationDate();



    public void print();
    //TODO: methode à implementer ici

}
