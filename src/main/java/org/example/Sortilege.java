package org.example;


/*
 Les annotations en Java sont des métadonnées qui peuvent être ajoutées à des classes, des méthodes,
 des variables et d'autres éléments du code source pour fournir des informations supplémentaires
 ou pour déclencher des traitements spécifiques à l'exécution.

 Définition de l'annotation Sortilege pour annoter des méthodes spéciales.
*/
@interface Sortilege {

    // Variable utilisée pour stocker des métadonnées ou pour effectuer des traitements spécifiques à l'exécution
    String nom();
}

/* L'utilisation d'annotations est utile pour plusieurs raisons :

Métadonnées : Les annotations permettent d'ajouter des métadonnées au code source,
ce qui peut être utilisé pour générer de la documentation, pour effectuer des validations ou
pour d'autres traitements spécifiques à l'exécution.

Configuration : Les annotations peuvent être utilisées pour configurer le comportement des frameworks ou des bibliothèques,
comme Spring, Hibernate, etc.

Traitement à l'exécution : Certains frameworks ou bibliothèques peuvent traiter les annotations à l'exécution pour effectuer
des actions spécifiques, comme la gestion des transactions, la validation des entrées, etc.
*/