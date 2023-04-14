package com.example.MowItNow;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@SpringBootApplication

public class MowItNowApplication extends Mower {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("inputFile.txt"));

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
                char orientation = tokens[2].charAt(0);
                String instructions = reader.readLine();
                System.out.println("Position de départ : (" + startX + ", " + startY + ") Orientation : " + orientation + " Instructions : " + instructions);

                for (int i = 0; i < instructions.length(); i++) {
                    char instruction = instructions.charAt(i);
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

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
