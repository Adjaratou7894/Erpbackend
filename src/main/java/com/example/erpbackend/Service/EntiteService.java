package com.example.erpbackend.Service;

import com.example.erpbackend.Model.Entite;

import java.util.List;

public interface EntiteService {
    //**********On ajoute un entité avec un type de retour entite********
    public Entite  ajouter(Entite entite);
    //**********On affiche un entité avec un type de retour liste********
    public List<Entite> afficher();
    //**********On modifie une entité avec son id et un type de retour String********
    public Entite modifier(Entite entite);
    //**********On supprime une entité avec son id et un type de retour String********
    public String supprimer(Long id);
}
