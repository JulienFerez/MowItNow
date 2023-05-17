package com.example.MowItNow;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MowItNowApplication {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Veuillez passer le nom du fichier en paramètre");
            return;
        }

        String fileName = args[0];

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            displayLawnDimensions(reader);
            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("Le fichier " + fileName + " n'a pas été trouvé !");
        } catch (IOException | IllegalArgumentException e) {
            System.err.println("Une erreur s'est produite lors de la lecture du fichier " + fileName + " : " + e.getMessage());
        }
    }

    private static void displayLawnDimensions(BufferedReader reader) throws IOException {
        String[] dimensions = reader.readLine().split(" ");
        int maxX = Integer.parseInt(dimensions[0]);
        int maxY = Integer.parseInt(dimensions[1]);
        System.out.println("Dimensions de la pelouse : " + maxX + " x " + maxY);
        displayStartingPositions(reader, maxX, maxY);
    }

    private static void displayStartingPositions(BufferedReader reader, int maxX, int maxY) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            // Parsing du fichier pour obtenir la position de départ, l'orientation et les instructions
            String[] tokens = line.split(" ");
            int startX = Integer.parseInt(tokens[0]);
            int startY = Integer.parseInt(tokens[1]);
            Orientation orientation = Orientation.valueOf(tokens[2]);
            String instructions = reader.readLine();
            if (instructions == null) {
                throw new IOException("Instructions manquantes pour la tondeuse");
            }
            System.out.println("Position de départ : (" + startX + ", " + startY + ") Orientation : " + orientation + " Instructions : " + instructions);
            displayFinalPosition(startX, startY, orientation, instructions, maxX, maxY);
        }
    }

    private static void displayFinalPosition(int startX, int startY, Orientation orientation, String instructions, int maxX, int maxY) {
        // Traitement des instructions pour déplacer la tondeuse
        Mower mower = new Mower();
        int[] finalPosition = mower.executeInstructions(startX, startY, orientation, instructions, maxX, maxY, mower);
        System.out.println("Position finale : (" + finalPosition[0] + ", " + finalPosition[1] + ") Orientation : " + orientation);
    }


}
