# Projet de développement Java du jeu Mastermind

Dans ce premier projet Java OpenClassrooms, il s'agit de créer une application proposant des jeux de logique. Plusieurs variantes autour de la recherche de combinaisons secrètes :
- La recherche d'une combinaison à l'aide d'indications +/-
- Le célèbre Mastermind.

## Code source
Le téléchargement est disponible  au repositary Github suivant:
https://github.com/josephherradi/mastermind.git

### Prérequis

à partir de Java JDK 1.6, Maven

testé avec:
Java 1.6/1.7/1.8
maven-compiler-plugin 3.8.0
maven-jar-plugin 3.1.1

### Paramètrage
Le fichier config.properties dans src/main/resources permet de paramètrer:

n: le nombre de chiffres de la combinaison

nMaxTry:  le nombre de coups à jouer

m= le chiffre max pour le tirage ordinateur

dev: true/false permet d'activer ou non l'affichage de la combinaison secrète de l'ordinateur

### Compilation

```
mvn clean install
```
```
java -jar target/Mastermind.jar
```
### logging
un fichier test.log est généré à la racine du projet pour une compilation avec l'IDE et dans le dossier du jar.

## Versions
1.0 - Initial release  29/01/2018
1.1 - Initial release  31/01/2018 mode dev via launcher
## Auteur

* **Joseph Herradi ** - [Github repos](https://github.com/josephherradi/)
