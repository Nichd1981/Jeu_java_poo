package org.example;


/* L'interface Pouvoir définit une méthode abstraite appelée utiliserPouvoir().
 Cela signifie que toute classe qui implémente cette interface doit fournir une implémentation concrète de la méthode utiliserPouvoir().

  Définition de l'interface Pouvoir
*/
interface Pouvoir {
     /* Méthode à implémenter pour utiliser un pouvoir
        Dans la signature de la méthode utiliserPouvoir(), le mot-clé void est utilisé pour indiquer que la méthode ne retourne aucune valeur.
        En d'autres termes, la méthode effectue une action (ou un effet de bord) mais ne renvoie pas de résultat.
     */
    void utiliserPouvoir();

    // Méthode par défaut pour afficher un message générique
    default void message() {
        System.out.println("Utilisation du pouvoir !");
    }
}

/* L'utilisation d'interfaces est très utile pour plusieurs raisons :

 Abstraction : Les interfaces permettent d'abstraire la logique métier ou les comportements spécifiques d'une classe,
 rendant le code plus modulaire et facile à gérer.

 Contrat : Une interface définit un contrat que les classes implémentant cette interface doivent respecter. Cela assure une certaine cohérence et uniformité dans le code.

 Polymorphisme : Grâce aux interfaces, il est possible d'utiliser le polymorphisme en Java. Vous pouvez traiter des objets d'une classe qui implémente une interface comme des instances de cette interface, ce qui facilite la gestion des types et permet une plus grande flexibilité dans la conception du code.

 En résumé, l'interface Pouvoir dans votre code définit un contrat pour toutes les classes qui souhaitent avoir un pouvoir et doit implémenter une méthode utiliserPouvoir() sans retourner de valeur (void).
 */