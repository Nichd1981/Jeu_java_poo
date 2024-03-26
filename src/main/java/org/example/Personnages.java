package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
// region Descriptif complet de la reflexion pour la création du code
/*
1. Analyse des besoins
Avant de commencer à coder, il est essentiel de bien comprendre les besoins et les fonctionnalités attendues pour la classe Personnages.
Lors de la création de la classe Personnages, nous avons cherché à modéliser un personnage générique doté de caractéristiques telles que le nom, les points de vie,
la force et le type d'attaque.
Le but était de créer une structure de base à partir de laquelle d'autres types de personnages pourraient être dérivés, en mettant en œuvre des fonctionnalités communes.

Utilisation d'une classe abstraite
La classe Personnages est définie comme une classe abstraite.
Une classe abstraite est une classe qui ne peut pas être instanciée directement.
Elle sert de modèle pour d'autres classes (dites "sous-classes" ou "classes dérivées") qui étendent la classe abstraite en fournissant des implémentations spécifiques
des méthodes abstraites.

Dans notre cas, la méthode attaquer est définie comme abstraite dans la classe Personnages.
Cela signifie que chaque sous-classe de Personnages doit fournir sa propre implémentation de la méthode attaquer, adaptée à son type de personnage
spécifique (par exemple, Chevalier, Mage, etc.).

Variables membres protégées
Les variables membres de la classe (nom, pointsDeVie, force, typeAttaque, nombreDeMorts) sont déclarées comme protected.
Cela signifie qu'elles sont accessibles à la fois dans la classe Personnages et dans ses sous-classes.
Cette encapsulation protégée permet aux sous-classes d'accéder et de modifier ces variables directement, tout en empêchant un accès direct depuis
l'extérieur de ces classes.

Méthodes Getter et Setter
Nous avons également implémenté des méthodes getter et setter pour chaque variable membre, afin de permettre une meilleure encapsulation des données.
Les méthodes getter permettent d'accéder aux valeurs des variables membres, tandis que les méthodes setter permettent de modifier ces valeurs tout
en contrôlant les modifications possibles (par exemple, en validant les nouvelles valeurs).

Gestion des dégâts et des points de vie
La méthode recevoirDegats est chargée de gérer les dégâts reçus par un personnage.
Elle réduit les points de vie du personnage en fonction des dégâts subis et affiche des messages appropriés.
De plus, elle vérifie si les points de vie atteignent zéro ou moins, auquel cas le personnage est déclaré "K.O." et le compteur nombreDeMorts est incrémenté.

Variation aléatoire de la force
La méthode varierForce modifie aléatoirement la force d'un personnage, en ajoutant ou en soustrayant une valeur aléatoire entre -5 et 5.
Cette fonctionnalité ajoute une dimension aléatoire et dynamique aux personnages, ce qui peut rendre le jeu plus intéressant.

Sauvegarde des scores
Enfin, la méthode sauvegarderScore est chargée de sauvegarder le score du personnage dans un fichier.
Cette méthode utilise des manipulations de fichiers et des gestionnaires d'exceptions (try-catch) pour assurer une sauvegarde sécurisée des scores.
Dans cet exemple, nous allons créer une classe abstraite pour représenter un personnage générique, capable de :

Donc on aura besoin:

-Gérer le nom, les points de vie, la force et le type d'attaque d'un personnage.
-Attaquer un autre personnage.
-Recevoir des dégâts.
-Varier la force du personnage de manière aléatoire.
-Sauvegarder les scores du personnage dans un fichier.

2. Conception de la classe
Définition des attributs
La première étape consiste à définir les attributs nécessaires pour la classe. Dans notre cas, nous avons besoin de :

-nom : pour stocker le nom du personnage.
-pointsDeVie : pour stocker les points de vie du personnage.
-force : pour stocker la force du personnage.
-typeAttaque : pour définir le type d'attaque du personnage.
-nombreDeMorts : pour suivre le nombre de fois où le personnage est mort.
-Constructeur
Ensuite, nous avons défini un constructeur pour initialiser ces attributs lors de la création d'un objet Personnages.
Le constructeur prend en paramètre toutes les valeurs nécessaires pour initialiser un personnage.

Encapsulation
Pour garantir une bonne encapsulation et protéger l'accès aux attributs de la classe, nous avons créé des méthodes getters et setters pour chaque attribut.

Méthodes abstraites
La classe contient également une méthode abstraite attaquer, qui doit être implémentée dans les sous-classes.
Cela permet de définir le comportement spécifique d'attaque pour chaque type de personnage.

3. Implémentation des méthodes
Méthodes pour recevoir des dégâts et varier la force
Nous avons ajouté des méthodes recevoirDegats et varierForce pour permettre au personnage de recevoir des dégâts et de varier sa force de manière aléatoire.

Sauvegarde des scores
Pour sauvegarder les scores du personnage, nous avons implémenté une méthode sauvegarderScore.
Cette méthode utilise des opérations d'entrée/sortie (IO) pour écrire les scores dans un fichier.

4. Gestion des exceptions
Nous avons également pris en compte la gestion des exceptions en utilisant des blocs try-catch pour gérer les éventuelles erreurs lors de l'écriture dans
le fichier ou la création de dossiers.

5. Test et débogage
Après avoir écrit le code, il est crucial de tester chaque fonctionnalité pour s'assurer qu'elle fonctionne comme prévu et de déboguer tout problème rencontré.
*/
// endregion

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