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

Pour le moment le projet ne comporte qu'un seul module correspondant à la version java du test

## Questions :

### Gérer l'arbre de l'automate
L'arbre de l'automate bacnet est décrit dans un fichier json (bacnetPlcTree.json). Vous trouverez ce fichier dans le projet github (répertoire resources).

Ecrivez-le code pour :

- Charger l'arbre de l'automate dans une catégorie racine
- Chercher les mesures dont le nom contient un mot donné (le chemin de chaque mesure trouvée est requis)
- Chercher les mesures dont le type est donné (le chemin de chaque mesure trouvée est requis)
- tester unitairement le code écrit

#### Instructions pour le test en java
 - le main est placé dans la classe Plc.java, il contient déjà la structure finale du programme.
 - les fonctions loadPlcTree (Plc.java), searchMeasureByName et searchMeasureByType sont à implémenter.
 - un REAMDE.md est placé dans le module java-recruitment-test pour vous aider à démarrer le projet.
 - il est autoriser de rajouter des librairies au projet.