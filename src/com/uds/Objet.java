package com.uds;
import java.util.*;


interface Objet {

    /**
     * @return titre de l'objet
     */
    String getTitle();

    /**
     * @return description de l'objet
     */
    String getDescription();

    /**
     * @return propiétaire de l'objet
     */
    Membre getOwner();

    /**
     * @return la date de création
     */
    Date getCreationDate();

    /**
     * @return date de dernière modification
     * si non modifé cette date est celle de création
     */
    Date getModificationDate();

    /**
     * @return retourne un dictionnaire (clé, valeur) des liens que le document peut avoir avec d'autre (ex: corrigé)
     * la clé étant le document
     * la valeur étant le lien qui uni c'est deux documents
     * /!\ seule de document peut être lié à un autre document
     */
    HashMap<Document,String> getlinkedDocuments();


    /**
     * @param section indentation des dossiers
     * affiche l'objet
     */
    void print(int section);
    void clearFiles();


    /**
     * @param document document à lier avec le courant
     * @param label libéllé de cette relation
     */
    void addLink(Document document, String label);

}
