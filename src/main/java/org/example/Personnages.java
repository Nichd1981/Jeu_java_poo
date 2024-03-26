package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

// Définition de la classe abstraite Personnage pour représenter un personnage générique
public abstract class Personnages {

    // Variables membres protégées pour être accessibles dans les sous-classes
    // Le mot-clé 'protected' permet d'accéder à ces variables depuis les sous-classes.

    // Nom du personnage
    protected String nom;
    // Points de vie du personnage
    protected int pointsDeVie;
    // Implementation de l'enum TypeAttaque
    protected TypeAttaque typeAttaque;
    // Force du personnage
    protected int force;

    public int getNombreDeMorts() {
        return nombreDeMorts;
    }

    public void setNombreDeMorts(int nombreDeMorts) {
        this.nombreDeMorts = nombreDeMorts;
    }

    // Nombre de fois que le personnage est mort
    private int nombreDeMorts;


    // Constructeur de la classe Personnage pour initialiser les variables membres
    public Personnages(String nom, int pointsDeVie, int force, TypeAttaque typeAttaque) {
         /* Initialisation des variables membres avec les valeurs passées en paramètres
         Le mot-clé 'this' fait référence à l'objet actuel de la classe.
         Il est utilisé ici pour distinguer la variable membre 'nom' de l'argument 'nom'.
         Ce qui est entre parenthèses sont les paramètres du constructeur.
         */
        this.nom = nom;                      // 'this.nom' fait référence à la variable membre 'nom' de la classe.
                                             // 'nom' fait référence à l'argument 'nom' du constructeur.
        this.pointsDeVie = pointsDeVie;      // 'this.pointsDeVie' fait référence à la variable membre 'pointsDeVie' de la classe.
                                             // 'pointsDeVie' fait référence à l'argument 'pointsDeVie' du constructeur.
        this.force = force;                  // Force du personnage
        this.typeAttaque = typeAttaque;
        this.nombreDeMorts = 0;
    }

    // Création des Getter et Setter qui permettra une meilleure encapsulation
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }
    /* Méthode abstraite à implémenter dans les sous-classes pour attaquer un autre personnage
     Le mot-clé 'abstract' indique que cette méthode n'a pas d'implémentation dans cette classe,
     et qu'elle doit être définie dans les sous-classes.
     */
    public abstract void attaquer(Personnages personnages);

    // Méthode pour recevoir des dégâts, en créant une variable dégats en int
    public void recevoirDegats(int degats) {
        // Réduction des points de vie du personnage
        // PointsDeVie moins ou égale à degats
        pointsDeVie -= degats;  // Réduit les points de vie du personnage par la valeur 'degats'.

        // Affiche le nom et les dégats venant du constructeur
        System.out.println(nom + " a reçu " + degats + " dégâts.");

        // Si pointsDeVie est plus petit ou égale à 0 alors
        if (pointsDeVie <= 0) {
            // Assure que les points de vie ne deviennent pas négatifs
            pointsDeVie = 0;
            // Ajoute +1 à nombreDeMorts
            nombreDeMorts++;
            // Affiche le nom
            System.out.println(nom + " est K.O.");
        }
    }

    // Méthode pour faire varier la force du personnage aléatoirement
    public void varierForce() {
        // Appel la méthode Java pour génerer un nombre aléatoire.
        Random random = new Random();
        // Variation aléatoire entre -5 et 5
        int variation = random.nextInt(11) - 5;
        force += variation;
        System.out.println(nom + " a maintenant une force de " + force + ".");
    }
    // Méthode pour sauvegarder les scores du Chevalier et du Mage
    public void sauvegarderScore() {
        /* try-catch : Le bloc try permet d'essayer d'exécuter le code à l'intérieur.
        Si une exception est levée (comme IOException ou URISyntaxException), le bloc catch sera exécuté pour gérer l'exception.
        Dans ce cas, une trace de l'exception est affichée avec e.printStackTrace().
        */
        try {
            // Définir le chemin du dossier "Scores"
            String cheminScores = "Scores";
            Path score = Paths.get(cheminScores);
            // Remplacez par le chemin correct
            File dossierScores = score.toFile();
            // Si le dossier n'existe pas alors
            if (!dossierScores.exists()) {
                throw new IOException("Le dossier Score n'a pas été trouvé.");
            } // Sinon
            // Obtenir le fichier à partir de l'URL
            File fichier = getFile(dossierScores);
            // On écrit dans le fichier en sécurisant se que l'on fait dans un try
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichier, true))) {
                writer.write("Force après le tour : " + force);
                writer.newLine();
            }
            // Affiche un message si la sauvegarde a réussi
            System.out.println("Score sauvegardé avec succès.");
        // Attraper les exceptions IOException et URISyntaxException
        } catch (IOException | URISyntaxException e) {
            // Afficher la trace de l'exception
            e.printStackTrace();
        }
    }
    // Méthode privée pour obtenir ou créer un fichier
    private File getFile(File dossierScores) throws IOException, URISyntaxException {

        // Vérifier si le dossier "nom" existe dans le dossier "Score"
        File dossierNom = new File(dossierScores, nom);
        // Créer le dossier "nom" s'il n'existe pas
        if (!dossierNom.exists()) {
            // Cette méthode crée les répertoires parents s'ils n'existent pas
            boolean created = dossierNom.mkdirs();
            // Si le dossier est créé alors
            if (created) {
                // On affiche le nom du dossier créé
                System.out.println("Dossier " + nom + " créé avec succès.");
            // Sinon
            } else {
                // On affiche l'echec de la création du dossier
                System.out.println("Échec de la création du dossier " + nom + ".");
            }
        }

        // Créer le fichier "nom_score.txt" dans le dossier "nom"
        File fichier = new File(dossierNom, nom + "_score.txt");

        // Identique à la création du dossier
        if (!fichier.exists()) {
            boolean created = fichier.createNewFile();
            if (created) {
                System.out.println("Fichier " + fichier.getName() + " créé avec succès.");
            } else {
                System.out.println("Échec de la création du fichier " + fichier.getName() + ".");
            }
        }
        // Retourner le fichier
        return fichier;
    }

}

/*
    protected: C'est un modificateur d'accès qui permet d'accéder aux variables ou méthodes depuis les classes dérivées (sous-classes),
    mais pas depuis l'extérieur de la classe ou du package.

    private: C'est un modificateur d'accès qui permet de restreindre l'accès aux variables ou méthodes uniquement à l'intérieur de
     la classe où elles sont déclarées.

    abstract: Lorsqu'une classe est déclarée comme abstract, cela signifie qu'elle ne peut pas être instanciée directement.
    Elle sert de modèle pour d'autres classes qui étendent (héritent) de cette classe abstraite.
    Une méthode abstraite dans une classe abstraite doit être implémentée (définie) dans les sous-classes.

    this: C'est une référence à l'objet actuel de la classe.
    Il est utilisé pour distinguer entre les variables membres de la classe et les variables locales ou les paramètres
    d'une méthode ou d'un constructeur ayant le même nom.

    Paramètres du constructeur : Ce sont les valeurs fournies lors de la création d'une nouvelle instance de la classe.
    Ils permettent d'initialiser les variables membres de l'objet.
*/