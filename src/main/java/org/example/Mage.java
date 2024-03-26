package org.example;

/*
    Définition de la classe Mage qui hérite de la classe Personnage et implémente l'interface Pouvoir
    extends: C'est un mot-clé utilisé pour indiquer l'héritage. La classe Mage hérite de la classe Personnage.
*/
public class Mage extends Personnages implements Pouvoir {

    // Constructeur de la classe Mage pour initialiser les variables membres spécifiques au Mage
    public Mage(String nom, int pointsDeVie, int force) {
        /* Appel du constructeur de la classe mère avec les valeurs passées en paramètres
           Le mot-clé 'super' est utilisé pour appeler le constructeur de la classe mère (Personnage).
           Ce qui est entre parenthèses sont les paramètres du constructeur de la classe mère.
        */
        // Appel du constructeur de la classe mère avec les paramètres 'nom' et 'pointsDeVie'
        super(nom, pointsDeVie, force, TypeAttaque.MAGIQUE);
    }

    // Méthode pour attaquer un autre personnage, implémentée à partir de la classe abstraite Personnage
    @Override
    public void attaquer(Personnages personnages) {
        // Utilisation de la variable membre private pour calculer les dégâts
        // Affiche le nom du Mage, la cible et le type d'attaque
        System.out.println(nom + " attaque " + personnages.getNom() + " avec une attaque " + typeAttaque + ".");

        // Appelle la méthode 'recevoirDegats' de la classe Personnage pour infliger des dégâts à la cible
        // 'force' est utilisé comme valeur de dégâts pour la cible auquel on ajoute +2 car le Mage est plus fort que le chevalier
        personnages.recevoirDegats(force +2);
    }

    // Implémentation de la méthode de l'interface Pouvoir pour utiliser le pouvoir du Mage
    @Override
    public void utiliserPouvoir() {
        // Action spécifique au Mage lors de l'utilisation de son pouvoir
        // Affiche le nom du Mage et l'action spécifique de son pouvoir
        System.out.println(getNom() + " lance un sort de soin.");
    }

    // Méthode avec une annotation Sortilege pour représenter une compétence spéciale du Mage
    @Sortilege(nom = "Boule de feu")
    public void bouleDeFeu() {
        // Action spécifique au Mage lorsqu'il utilise la boule de feu
        // Affiche le nom du Mage et l'action spécifique de la boule de feu
        System.out.println(getNom() + " lance une boule de feu !");
    }
}
