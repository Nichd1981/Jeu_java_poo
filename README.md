/* Petit jeu en Console JAVA pour aborder l'orienter object */

Il était une fois, dans le royaume de la programmation orientée objet...

Au commencement, nous avons décidé d'établir un contrat commun pour tous nos personnages. Pour cela, nous avons créé une classe interface nommée Pouvoir. Cette interface définissait une action essentielle : utiliserPouvoir(). Chaque personnage devrait montrer comment il utilise son pouvoir spécifique en implémentant cette méthode.

Ensuite, nous avons envisagé la création d'une classe abstraite pour décrire un personnage générique. Cette classe, appelée Personnage, serait le point de départ pour tous nos héros et héroïnes. À l'intérieur de cette classe, nous avons défini des caractéristiques communes à tous les personnages : un nom, des points de vie et un type d'attaque. De plus, nous avons imaginé deux comportements essentiels pour nos combattants : attaquer() et recevoirDegats().

Maintenant, passons à nos héros spécifiques. D'un côté, nous avons le courageux Chevalier, un combattant de force brute. De l'autre, nous avons le mystique Mage, un lanceur de sorts doué. Ces deux classes héritent de Personnage et montrent comment elles attaquent leurs adversaires respectifs. Le Chevalier utilise sa force physique pour infliger des dégâts, tandis que le Mage se sert de sa magie pour lancer des sorts.

Chaque héros possède également un pouvoir unique. Pour le Chevalier, il s'agit de l'utilisation d'un bouclier, tandis que le Mage peut lancer un sort de soin. Grâce à l'interface Pouvoir, nous avons pu garantir que chaque personnage implémente correctement son propre pouvoir.

Pour rendre notre code plus clair et éviter les erreurs de saisie, nous avons introduit une énumération TypeAttaque. Elle permet de définir clairement si une attaque est physique ou magique. C'est une manière élégante de catégoriser les attaques et de rendre le code plus lisible.

Enfin, pour ajouter une touche spéciale au Mage, nous avons introduit une annotation Sortilege. Elle nous permet de définir des compétences spéciales pour nos personnages. Par exemple, le Mage peut lancer une puissante "Boule de feu" grâce à cette annotation.

Pour conclure notre histoire, nous avons créé une petite scène de combat dans la classe JeuDeCombat. Dans cette scène, notre Chevalier Arthur affronte le Mage Merlin. Les deux combattants s'échangent des attaques et utilisent leurs pouvoirs spéciaux, nous montrant ainsi le fruit de notre travail et comment nos héros interagissent dans ce monde fantastique de programmation.

