package com.uds;
import java.util.ArrayList;
import java.util.List;



public class Groupe {

    public String titre;


    public String description;

    public List<Member> ListMember  = new ArrayList<Member>();


    public List<Objet> ListObjects = new ArrayList<Objet> ();

    public void getContent() {
    }

    public void createObject() {
    }

    public Groupe(String title, String description) {
        this.titre = title;
        this.description = description;
    }

}
