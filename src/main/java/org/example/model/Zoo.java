package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private List<Secteur> secteursAnimaux = new ArrayList<>();
    private int visiteurs = 0;
    private final int nbVisiteurMaxParSecteur = 2;

    public void ajouterSecteur(TypeAnimal typeAnimal) {
        secteursAnimaux.add(new Secteur(typeAnimal));
    }

    public void nouveauVisiteur() throws LimiteVisiteurException {
        if (visiteurs >= secteursAnimaux.size() * nbVisiteurMaxParSecteur) {
            throw new LimiteVisiteurException("Nombre maximum de visiteurs atteint !");
        }
        visiteurs++;
    }

    public int getNombreVisiteurs() {
        return visiteurs;
    }

    public void nouvelAnimal(Animal animal) throws AnimalDansMauvaisSecteurException {
        for (Secteur secteur : secteursAnimaux) {
            if (secteur.obtenirType() == animal.getTypeAnimal()) {
                secteur.ajouterAnimal(animal);
                return;
            }
        }
        throw new AnimalDansMauvaisSecteurException("L'animal n'est pas dans le bon secteur !");
    }

    public int nombreAnimaux() {
        return secteursAnimaux.stream().mapToInt(Secteur::getNombreAnimaux).sum();
    }
}
