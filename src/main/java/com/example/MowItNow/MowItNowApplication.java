package com.example.MowItNow;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// TODO Pas besoin de SpringBoot pour cet exercice
@SpringBootApplication

// TODO Mauvaise utilisation de l'héritage, à changer.
public class MowItNowApplication extends Mower {

    public static void main(String[] args) {
        try {
            // TODO Il faudrait passer le nom du fichier en paramètre du programme pour qu'il ne soit pas en dur ici
            BufferedReader reader = new BufferedReader(new FileReader("inputFile.txt"));

            // TODO Il faut séparer en deux le parsing du fichier ET le traitement des instructions
            // Lire les dimensions de la pelouse
            String[] dimensions = reader.readLine().split(" ");
            int maxX = Integer.parseInt(dimensions[0]);
            int maxY = Integer.parseInt(dimensions[1]);
            System.out.println("Dimensions de la pelouse : " + maxX + " x " + maxY);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");
                int startX = Integer.parseInt(tokens[0]);
                int startY = Integer.parseInt(tokens[1]);

                // Utiliser un enum pour les orientations au lieu d'un char
                char orientation = tokens[2].charAt(0);
                String instructions = reader.readLine();
                System.out.println("Position de départ : (" + startX + ", " + startY + ") Orientation : " + orientation + " Instructions : " + instructions);

                for (int i = 0; i < instructions.length(); i++) {
                    // TODO Utiliser un enum pour les instructions au lieu d'un char
                    char instruction = instructions.charAt(i);
                    // TODO Utiliser la syntaxe switch plus évoluée, celle avec la flêche ->
                    switch (instruction) {
                        case 'D':
                            orientation = pivoterDroite(orientation);
                            break;
                        case 'G':
                            orientation = pivoterGauche(orientation);
                            break;
                        case 'A':
                            int[] newPosition = avancer(startX, startY, orientation);
                            startX = newPosition[0];
                            startY = newPosition[1];
                            break;
                        default:
                            System.out.println("Instruction inconnue : " + instruction);
                            break;
                    }
                }

                System.out.println("Position finale : (" + startX + ", " + startY + ") Orientation : " + orientation);
            }

            // TODO que se passe-t-il si il y a une exception et que cette instruction n'est pas executée ? Peut-on mieux gérer ça ?
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
