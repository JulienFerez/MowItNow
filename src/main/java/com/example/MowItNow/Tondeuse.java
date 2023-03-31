package com.example.MowItNow;

public class Tondeuse {



    public static char pivoterDroite(char orientation) {
        switch (orientation) {
            case 'N':
                return 'E';
            case 'E':
                return 'S';
            case 'S':
                return 'W';
            case 'W':
                return 'N';
            default:
                return orientation;
        }
    }

    public static char pivoterGauche(char orientation) {
        switch (orientation) {
            case 'N':
                return 'W';
            case 'E':
                return 'N';
            case 'S':
                return 'E';
            case 'W':
                return 'S';
            default:
                return orientation;
        }
    }

    public static int[] avancer(int x, int y, char orientation) {
        int[] newPosition = new int[2];
        switch (orientation) {
            case 'N':
                newPosition[0] = x;
                newPosition[1] = y + 1;
                break;
            case 'E':
                newPosition[0] = x + 1;
                newPosition[1] = y;
                break;
            case 'S':
                newPosition[0] = x;
                newPosition[1] = y - 1;
                break;
            case 'W':
                newPosition[0] = x - 1;
                newPosition[1] = y;
                break;
            default:
                newPosition[0] = x;
                newPosition[1] = y;
                break;
        }
        return newPosition;
    }

}
