# scorpio-recruitment-test

## Gérer l'arbre de données d'un automate

Description du context
L'arbre de données bacnet est organisé par catégories et sous-catégories.

Example :
Catégorie : 'PAC-1'

Sous-catégorie : 'analogic-value'

Measure : 'Heating setpoint 1'

Définition des entités :
Une catégorie est définie par :

- un id
- un nom
- une liste de sous-categories
- une liste de mesures

Une mesure est définie par :

- un id
- un nom
- un dataType

## structure du projet de test :

Le projet ne comporte qu'un seul module correspondant à la version java du test

## Questions :

### Gérer l'arbre de l'automate

L'arbre de l'automate bacnet est décrit dans un fichier json (bacnetPlcTree.json). Vous trouverez ce fichier dans le
répertoire resources.

Ecrivez-le code pour :

- Charger l'arbre de l'automate dans une catégorie racine
- Chercher les mesures dont le nom contient un mot donné (le chemin de chaque mesure trouvée est requis)
- Chercher les mesures dont le dataType est donné (le chemin de chaque mesure trouvée est requis)
- Chercher les mesures dont l'id est donné (le chemin de chaque mesure trouvée est requis)
- Tester unitairement le code écrit
- Gérer correctement les exceptions

#### Instructions pour le test en java

- le main est placé dans la classe Plc.java.
- un REAMDE.md est placé dans le module java-recruitment-test pour vous aider à démarrer le projet.
- il est autorisé de rajouter des librairies, de modifier les classes et l'organisation du projet.