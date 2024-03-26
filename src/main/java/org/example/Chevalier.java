package org.example;

/*
 Définition de la classe Chevalier qui hérite de la classe Personnage et implémente l'interface Pouvoir
 extends: C'est un mot-clé utilisé pour indiquer l'héritage. La classe Chevalier hérite de la classe Personnage.
 */
public class Chevalier extends Personnages implements Pouvoir {

    // Constructeur de la classe Chevalier pour initialiser les variables membres spécifiques au Chevalier
    public Chevalier(String nom, int pointsDeVie, int force) {
        /* Appel du constructeur de la classe mère avec les valeurs passées en paramètres
           Le mot-clé 'super' est utilisé pour appeler le constructeur de la classe mère (Personnage).
           Ce qui est entre parenthèses sont les paramètres du constructeur de la classe mère.
        */
        // Appel du constructeur de la classe mère avec les paramètres 'nom', 'pointsDeVie', 'force' et typeAttaque de l'enum
        super(nom, pointsDeVie, force, TypeAttaque.PHYSIQUE);
    }

    // Méthode pour attaquer un autre personnage, implémentée à partir de la classe abstraite Personnage
    @Override
    public void attaquer(Personnages personnages) {
        // Utilisation de la variable membre private pour calculer les dégâts
        // Affiche le nom du Chevalier, la cible et le type d'attaque
        System.out.println(getNom() + " attaque " + personnages.getNom() + " avec une attaque " + typeAttaque + ".");

        // Appelle la méthode 'recevoirDegats' de la classe Personnage pour infliger des dégâts à la cible
        // 'force' est utilisé comme valeur de dégâts pour la cible
        personnages.recevoirDegats(force);
    }

    // Implémentation de la méthode de l'interface Pouvoir pour utiliser le pouvoir du Chevalier
    @Override
    public void utiliserPouvoir() {
        // Action spécifique au Chevalier lors de l'utilisation de son pouvoir
        // Affiche le nom du Chevalier et l'action spécifique de son pouvoir
        System.out.println(getNom() + " utilise son bouclier.");
    }
}
