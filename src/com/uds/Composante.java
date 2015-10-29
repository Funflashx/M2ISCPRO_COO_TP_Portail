package com.uds;

/**
 * Created by francoiscaillet on 29/10/15.
 */
public class Composante extends Groupe {

    public Composante(Membre owner, String title, String description) {
        super(owner ,title, description);
    }

    //TODO:
    public void method(){
        System.out.println("Composante.print()");
    }

    @Override
    public void addObject(String type, String title, String description, Membre owner, Repertoire rep) {
        try {
            if (type.equals("repertoire")){
                Repertoire repository = new Repertoire(title, description,owner);
                rep.add(repository);
            }else if (type.equals("document")){
                Document doc = new Document(title, description,owner);
                rep.add(doc);
            }else if (type.equals("service")){
                Service service = new Service(title, description,owner);
                rep.add(service);
            }else throw new Exception("Le type entré est incorrect");

        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }


}
