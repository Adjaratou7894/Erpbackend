package com.example.erpbackend.Service;

import com.example.erpbackend.Message.ReponseMessage;
import com.example.erpbackend.Model.Entite;

import java.io.IOException;
import java.util.List;

public interface EntiteService {
    //**********On ajoute un entité avec un type de retour entite********
    public ReponseMessage  ajouter(Entite entite);
    //**********On affiche un entité avec un type de retour liste********
    public List<Entite> afficher();
    //**********On modifie une entité avec son id et un type de retour String********
    public  ReponseMessage modifier(Entite entite);
    //**********On supprime une entité avec son id et un type de retour String********
    public ReponseMessage supprimer(Long id);


    Entite recupererEntiteParNom(String nom);

    public ReponseMessage getBytes(long idEntite) throws IOException;
}
