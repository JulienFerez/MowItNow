# Tondeuse Automatique

Ce projet permet de simuler le déplacement d'une ou plusieurs tondeuses automatiques sur une pelouse rectangulaire.
Chaque tondeuse se déplace selon les instructions données dans un fichier d'entrée et renvoie sa position finale.

# Instructions d'installation
Cloner le projet sur votre machine locale.
Assurez-vous que vous avez installé Java 17 ou une version ultérieure.
Ouvrez le projet dans votre IDE préféré (par exemple, Eclipse, IntelliJ IDEA).
Exécutez la classe MowItNowApplication.

# Utilisation
Le programme lit un fichier d'entrée appelé inputFile.txt qui doit être placé à la racine du projet.
Ce fichier doit contenir les informations suivantes :

Les dimensions de la pelouse (maxX et maxY) séparées par un espace.
Les informations de chaque tondeuse : la position initiale (startX et startY), 
l'orientation (N, E, W ou S) et la liste des instructions (D, G ou A) séparées par un espace.
Voici un exemple de fichier d'entrée :

5 5
1 2 N
GAGAGAGAA
3 3 E
AADAADADDA

Dans cet exemple, il y a deux tondeuses. 
La première commence à la position (1,2) en orientation Nord (N) et effectue les instructions suivantes : pivoter à gauche (G),
avancer d'une case (A), pivoter à gauche (G), avancer d'une case (A), etc. La deuxième tondeuse commence à la position (3,3)
en orientation Est (E) et effectue les instructions suivantes : avancer d'une case (A), pivoter à droite (D),
avancer d'une case (A), pivoter à droite (D), etc.

Après l'exécution du programme, la position finale de chaque tondeuse est affichée dans la console.

# Exemple de sortie

Voici la sortie correspondant à l'exemple de fichier d'entrée précédent :

Dimensions de la pelouse : 5 x 5
Position de départ : (1, 2) Orientation : N Instructions : GAGAGAGAA
Position finale : (1, 3) Orientation : N
Position de départ : (3, 3) Orientation : E Instructions : AADAADADDA
Position finale : (5, 1) Orientation : E

