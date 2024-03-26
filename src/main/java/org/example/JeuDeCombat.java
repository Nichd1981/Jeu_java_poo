package org.example;

import java.util.Arrays;
import java.util.List;


// Classe principale JeuDeCombat pour tester le jeu de combat entre un Chevalier et un Mage
public class JeuDeCombat {

    public static void main(String[] args) {
        // On construit Chevalier et Mage en précisant dans les () des valeurs que le constructeur de Personnages impose.
        Chevalier chevalier = new Chevalier("Arthur", 100, 20);
        Mage mage = new Mage("Merlin", 80, 25);


        // Combat entre le Chevalier et le Mage
        // Initialisation du compteur de tour à 1.
        int tour = 1;

        // Boucle tant que les deux personnages ont des points de vie
        while (chevalier.pointsDeVie > 0 && mage.pointsDeVie > 0) {
            // Affichage du numéro du tour
            System.out.println("Tour " + tour + " :");

            // Le Chevalier attaque le Mage
            // On appelle de la méthode "attaquer" du Chevalier sur le (Mage).
            chevalier.attaquer(mage);
            chevalier.utiliserPouvoir();
            // On vérifie les points de vie du Mage après l'attaque
            // Si Mage a des pointsDeVie inférieur ou égale à 0 alors
            if (mage.pointsDeVie <= 0) {
                // Si le Mage a 0 points de vie ou moins, affichage d'un message
                System.out.println("Le Mage " + mage.getNom() + " est K.O.");
                // Sortie de la boucle si le Mage est K.O.
                break;
            }

            // Le Mage attaque le Chevalier
            mage.attaquer(chevalier);

            /* Vérification des points de vie du Chevalier après l'attaque
             Si le Chevalier, dont on reprend la caractéristique pointsDeVie venant de la class Personnage et qui est déterminé dans
             l'initialisation ci-dessus, est plus grandou égale à 0 alors...
            */
            if (chevalier.pointsDeVie <= 0) {
                // Si le Chevalier a 0 points de vie ou moins, affichage d'un message
                System.out.println("Le Chevalier " + chevalier.getNom() + " est K.O.");
                // Sortie de la boucle si le Chevalier est K.O.
                break;
            }
            // Incrémentation du compteur de tour à la fin de la boucle while.
            tour++;
        }

        System.out.println("-------------------------------------------------------");
        /* Utilisation d'une expression lambda pour afficher un message
        une lambda est une manière concise de définir des fonctions anonymes ou des implémentations d'interfaces fonctionnelles sans
        avoir besoin de créer une classe anonyme ou une classe interne.
        */
        Pouvoir pouvoir = () -> System.out.println("Message depuis une expression lambda pour utiliser les pouvoir du Mage");
        pouvoir.utiliserPouvoir();
        // Utilisation d'un if pour vérifier les points de vie restants
        // Si le Mage, dont on reprend la caractéristique pointsDeVie venant de la class Personnage, est plus grand ou égale à 0 alors...
        if (mage.pointsDeVie > 0) {
            // Appel de la méthode bouleDeFeu avec l'annotation Sortilege sur l'instance de Mage pour lancer la méthode.
            mage.bouleDeFeu();
            // Appel de la méthode utiliserPouvoir de l'interface Pouvoir sur l'instance de Mage
            mage.utiliserPouvoir();
        }

        /* Utilisation d'un stream pour afficher les dégâts reçus par le Mage
         Pour notre exemple, on crée liste degats et on l'initialise avec trois valeurs d'entiers : 10, 15 et 20.
        Cette liste contient les dégâts reçus par un Mage.
        */
        List<Integer> degats = Arrays.asList(10, 15, 20);
        // Utilisation d'un stream pour calculer la somme des dégâts
        System.out.println(STR."Dégâts reçus par le Mage : \{degats.stream().mapToInt(Integer::intValue).sum()}");
        /* degats.stream() : Convertit la liste dégats en un flux (stream) de données.
            .mapToInt(Integer::intValue) : Transforme chaque élément du flux en type int.
            .sum() : Calcule la somme de tous les éléments du flux.
         La valeur résultante de la somme est ensuite affichée avec System.out.println().
         */
        // Appel de la méthode bouleDeFeu avec l'annotation Sortilege sur l'instance de Mage
        mage.bouleDeFeu();
        // Appel de la méthode utiliserPouvoir de l'interface Pouvoir sur l'instance de Mage
        mage.utiliserPouvoir();

        System.out.println("-------------------------------------------------------");
        System.out.println("Une autre méthode pour aborder le jeu");

        // Création d'un tableau pour stocker les statistiques des personnages
        // 2 lignes pour 2 personnages, 2 colonnes pour les points de vie et le nombre de morts
        int[][] statistiques = new int[2][2];

        // Cette boucle s'exécute trois fois
        // (i commence à 1;(si) i est plus petit ou égale à 3;(alors) i +1).
        for (int i = 1; i <= 3; i++) {
            System.out.println("-------------------------------------------------------");
            // Affichage du numéro du tour en cours
            System.out.println("Tour " + i + " :");
            // Appel à la méthode varierForce() pour ajuster la force du chevalier
            chevalier.varierForce();
            // Appel à la méthode varierForce() pour ajuster la force du mage
            mage.varierForce();
            // Le chevalier attaque le mage en utilisant la méthode attaquer()
            chevalier.attaquer(mage);
            // Le mage riposte en attaquant le chevalier à son tour en utilisant la méthode attaquer()
            mage.attaquer(chevalier);
            // Mise à jour des statistiques dans le tableau en donnant la position [] dans le tableau des valeurs.
            statistiques[0][0] = chevalier.getPointsDeVie();
            statistiques[0][1] = chevalier.getNombreDeMorts();
            statistiques[1][0] = mage.getPointsDeVie();
            statistiques[1][1] = mage.getNombreDeMorts();
        }

        System.out.println("----------------------------------------------------------------------------------");
        // Affichage des statistiques finales
        System.out.println("Information reçue par le tableau");
        System.out.println("Statistiques finales :");
        // On affiche les valeurs du tableau en précisant la position de la valeur souhaitée.
        System.out.println("Chevalier: Points de vie : " + statistiques[0][0] + ", Nombre de morts : " + statistiques[0][1]);
        System.out.println("Mage: Points de vie : " + statistiques[1][0] + ", Nombre de morts : " + statistiques[1][1]);


        System.out.println("----------------------------------------------------------------------------------");
        // Affichage via les données reprise dans le constructeur personnage
        System.out.println("Information reçue par le constructeur");
        // Affichage du nombre de fois que le Chevalier et le Mage sont morts
        System.out.println("Nombre de fois que le Chevalier est mort : " + chevalier.getNombreDeMorts());
        System.out.println("Nombre de fois que le Mage est mort : " + mage.getNombreDeMorts());


        System.out.println("----------------------------------------------------------------------------------");
        // Sauvegarde des scores après chaque tour
        System.out.println("Sauvegarde des scores dans un fichier txt");
        chevalier.sauvegarderScore();
        mage.sauvegarderScore();
    }
}
