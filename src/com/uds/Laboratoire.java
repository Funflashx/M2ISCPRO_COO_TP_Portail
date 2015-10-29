package com.uds;

/**
 * Created by francoiscaillet on 29/10/15.
 */
public class Laboratoire extends Groupe {
    public Laboratoire(Membre owner, String title, String description) {
        super(owner, title, description);
    }

    public void method() {
        System.out.println("Laboratoire.print()");
    }

    @Override
    public Objet addObject(String type, String title, String description, Membre owner, Repertoire rep) {
        Objet addedObject = null;
        try {
            if (type.equals("repertoire")){
                Repertoire repository = new Repertoire(title, description,owner);
                rep.add(repository);
                addedObject = repository;
            }else if (type.equals("document")){
                Document doc = new Document(title, description,owner);
                rep.add(doc);
                addedObject = doc;
            }else if (type.equals("service")){
                Service service = new Service(title, description,owner);
                rep.add(service);
                addedObject = service;
            }else throw new Exception("Le type entr� est incorrect");

        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }

        return null;
    }
}
