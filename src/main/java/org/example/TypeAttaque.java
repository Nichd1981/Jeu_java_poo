package org.example;


/* Une énumération en Java est un type de données qui permet de définir un ensemble fixe de constantes.
Chaque constante représente une valeur unique de l'énumération.

   Définition de l'énumération TypeAttaque pour les types d'attaques possibles
*/
enum TypeAttaque {
    PHYSIQUE, // Attaque physique
    MAGIQUE   // Attaque magique
}


/* L'utilisation d'énumérations est bénéfique pour plusieurs raisons :

Lisibilité : Les énumérations rendent le code plus lisible et compréhensible en remplaçant des valeurs littérales par des noms symboliques.

Sécurité : Les énumérations offrent une sécurité accrue, car elles garantissent que seules les valeurs définies dans l'énumération peuvent être utilisées, ce qui réduit les erreurs potentielles.

Maintenance : En regroupant des constantes liées au même concept dans une énumération, vous facilitez la maintenance et les modifications ultérieures du code.

*/