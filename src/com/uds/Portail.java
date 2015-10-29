package com.uds;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;

public class Portail { //PORTAIL_UDS

    public List<Groupe> ListGroups = new ArrayList<Groupe> ();
    public List<Membre> listMembres = new ArrayList<Membre> ();
    public List<Filiere> listGroupFiliere = new ArrayList<Filiere>();

    public static void main(String[] args) {
        //EXEMPLE FACTORY
        //src: http://www.jmdoudoux.fr/java/dej/chap-design-patterns.htm
        ////////////////////////////
        GroupeFactory groupInstitutionnel = new GroupeInstitutionnelFactory();
        GroupeFactory groupTypique = new GroupeTypiqueFactory();

        Groupe groupe = null;

        System.out.println("Utilisation de la premiere fabrique à groupe institutionnel");
//        groupe = groupInstitutionnel.getGroupe();
//        groupe.method();

        System.out.println("Utilisation de la seconde fabrique à groupe typique");
//        groupe = groupTypique.getGroupe();
//        groupe.method();

        //EXEMPLE Composite
        //src: https://en.wikipedia.org/wiki/Composite_pattern
        ////////////////////////////
        //Initialize 4 feuilles (doc,service)
        Document doc1 = new Document();
        Service service1 = new Service();
        Document doc2 = new Document();
        Document doc3 = new Document();

        //Initialize 3 répertoire
        Repertoire repertoire = new Repertoire();
        Repertoire sousRepertoire1 = new Repertoire();
        Repertoire sousRepertoire2 = new Repertoire();

        //Composes les répertoires
        sousRepertoire1.add(doc1);
        sousRepertoire1.add(service1);
        sousRepertoire1.add(doc2);

        sousRepertoire2.add(doc3);

        repertoire.add(sousRepertoire1);
        repertoire.add(sousRepertoire2);

        //affiche le répertoire !
        repertoire.print();

    }

}
