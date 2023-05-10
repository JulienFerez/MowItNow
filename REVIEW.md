# Commentaires globaux

- [ X ] Il manque un fichier README.md qui explique comment installer/compiler/lancer le projet
- [ X ] Il manque des tests unitaires pour les cas qui ne se passent pas bien (mauvaises instructions, mauvais format de fichier)
- [ X ] Le fichier inputfile.txt ne devrait pas être dans src/main/resources 
- [ X ] Le code est en franglais alors qu'il devrait être entièrement en français
- [ X ] A quoi sert le fichier application.properties ?
- [ X ] Le fichier pom.xml contient des dépendances inutiles
- [ X ] Le programme ne gère pas la collision sur les murs et les tondeuses sortent de la pelouse

# TODO

## Mower.java
-[ X ] (6, 4) // TODO Ce n'est pas programmé selon la Programmation Orientée Objet
-[ X ] (7, 4) // TODO Une Tondeuse devrait être un objet qui possède des attributs membres et des méthodes de classes (pas statiques)
-[ X ] (8, 4) // TODO A revoir en mode POO

## MowItNowApplication.java
-[ X ] (8, 4) // TODO Pas besoin de SpringBoot pour cet exercice
-[ X ] (11, 4) // TODO Mauvaise utilisation de l'héritage, à changer.
-[ X ] (16, 16) // TODO Il faudrait passer le nom du fichier en paramètre du programme pour qu'il ne soit pas en dur ici
-[ X ] (19, 16) // TODO Il faut séparer en deux le parsing du fichier ET le traitement des instructions
-[ X ] (38, 24) // TODO Utiliser un enum pour les instructions au lieu d'un char
-[ X ] (40, 24) // TODO Utiliser la syntaxe switch plus évoluée, celle avec la flêche ->
-[ X ] (62, 16) // TODO que se passe-t-il si il y a une exception et que cette instruction n'est pas executée ? Peut-on mieux gérer ça ?

## MowItNowApplicationTests.java
-[ X ] (24, 6) // TODO args n'est pas du tout utilisé par le programme
-[ X ] (31, 12) // TODO le test ne devrait pas s'appuyer sur ce qui est écrit dans la console mais plutôt sur les
