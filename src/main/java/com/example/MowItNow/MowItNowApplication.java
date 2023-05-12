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

            // Parsing du fichier pour obtenir les dimensions de la pelouse
            String[] dimensions = reader.readLine().split(" ");
            int maxX = Integer.parseInt(dimensions[0]);
            int maxY = Integer.parseInt(dimensions[1]);
            System.out.println("Dimensions de la pelouse : " + maxX + " x " + maxY);

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

                // Traitement des instructions pour déplacer la tondeuse
                Mower mower = new Mower();
                int[] finalPosition = executeInstructions(startX, startY, orientation, instructions, maxX, maxY, mower);
                System.out.println("Position finale : (" + finalPosition[0] + ", " + finalPosition[1] + ") Orientation : " + orientation);

            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("Le fichier " + fileName + " n'a pas été trouvé !");
        } catch (IOException | IllegalArgumentException e) {
            System.err.println("Une erreur s'est produite lors de la lecture du fichier " + fileName + " : " + e.getMessage());
        }
    }

    static int[] executeInstructions(int startX, int startY, Orientation startOrientation, String instructions, int maxX, int maxY, Mower mower) {
        int[] currentPosition = new int[]{startX, startY};
        Orientation currentOrientation = startOrientation;

        for (int i = 0; i < instructions.length(); i++) {
            Instruction instruction;
            try {
                instruction = Instruction.valueOf(String.valueOf(instructions.charAt(i)));
            } catch (IllegalArgumentException e) {
                System.out.println("Instruction inconnue : " + instructions.charAt(i));
                continue;
            }
            switch (instruction) {
                case D:
                    currentOrientation = mower.rotateRight(currentOrientation);
                    break;
                case G:
                    currentOrientation = mower.rotateLeft(currentOrientation);
                    break;
                case A:
                    int[] newPosition = mower.advance(currentPosition[0], currentPosition[1], currentOrientation);
                    if (newPosition[0] >= 0 && newPosition[0] <= maxX && newPosition[1] >= 0 && newPosition[1] <= maxY) {
                        currentPosition = newPosition;
                    } else {
                        System.out.println("La tondeuse a rencontré une limite de la pelouse, elle ne bougera pas.");
                    }
                    break;
                default:
                    System.out.println("Instruction inconnue : " + instruction);
                    break;
            }
        }

        return currentPosition;
    }
}
