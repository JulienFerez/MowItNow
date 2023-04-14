# Commentaires globaux

- [ ] Il manque un fichier README.md qui explique comment installer/compiler/lancer le projet
- [ ] Il manque des tests unitaires pour les cas qui ne se passent pas bien (mauvaises instructions, mauvais format de fichier)
- [ ] Le fichier inputfile.txt ne devrait pas être dans src/main/resources 
- [ ] Le code est en franglais alors qu'il devrait être entièrement en français
- [ ] A quoi sert le fichier application.properties ?
- [ ] Le fichier pom.xml contient des dépendances inutiles
- [ ] Le programme ne gère pas la collision sur les murs et les tondeuses sortent de la pelouse

# TODO

## Mower.java
- (6, 4) // TODO Ce n'est pas programmé selon la Programmation Orientée Objet
- (7, 4) // TODO Une Tondeuse devrait être un objet qui possède des attributs membres et des méthodes de classes (pas statiques)
- (8, 4) // TODO A revoir en mode POO

## MowItNowApplication.java
- (8, 4) // TODO Pas besoin de SpringBoot pour cet exercice
- (11, 4) // TODO Mauvaise utilisation de l'héritage, à changer.
- (16, 16) // TODO Il faudrait passer le nom du fichier en paramètre du programme pour qu'il ne soit pas en dur ici
- (19, 16) // TODO Il faut séparer en deux le parsing du fichier ET le traitement des instructions
- (38, 24) // TODO Utiliser un enum pour les instructions au lieu d'un char
- (40, 24) // TODO Utiliser la syntaxe switch plus évoluée, celle avec la flêche ->
- (62, 16) // TODO que se passe-t-il si il y a une exception et que cette instruction n'est pas executée ? Peut-on mieux gérer ça ?

## MowItNowApplicationTests.java
- (24, 6) // TODO args n'est pas du tout utilisé par le programme
- (31, 12) // TODO le test ne devrait pas s'appuyer sur ce qui est écrit dans la console mais plutôt sur les
