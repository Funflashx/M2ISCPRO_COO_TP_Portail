package com.uds;
import java.util.*;


interface Objet {

    public String getTitle();
    public String getDescription();
    public Membre getOwner();
    public Date getCreationDate();
    public Date getModificationDate();
    public HashMap<Document,String> getlinkedDocuments();



    public void print(int section);
    //TODO: methode à implementer ici
    public void addLink(Document document, String label);

}
