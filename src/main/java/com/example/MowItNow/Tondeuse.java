package com.example.MowItNow;

import lombok.Getter;

@Getter
public class Tondeuse {



    public static char pivoterDroite(char orientation) {
        return switch (orientation) {
            case 'N' -> 'E';
            case 'E' -> 'S';
            case 'S' -> 'W';
            case 'W' -> 'N';
            default -> orientation;
        };
    }

    public static char pivoterGauche(char orientation) {
        return switch (orientation) {
            case 'N' -> 'W';
            case 'E' -> 'N';
            case 'S' -> 'E';
            case 'W' -> 'S';
            default -> orientation;
        };
    }

    public static int[] avancer(int x, int y, char orientation) {
        int[] newPosition = new int[2];
        switch (orientation) {
            case 'N' -> {
                newPosition[0] = x;
                newPosition[1] = y + 1;
            }
            case 'E' -> {
                newPosition[0] = x + 1;
                newPosition[1] = y;
            }
            case 'S' -> {
                newPosition[0] = x;
                newPosition[1] = y - 1;
            }
            case 'W' -> {
                newPosition[0] = x - 1;
                newPosition[1] = y;
            }
            default -> {
                newPosition[0] = x;
                newPosition[1] = y;
            }
        }
        return newPosition;
    }


}
