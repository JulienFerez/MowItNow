package com.example.MowItNow;

import lombok.*;

import static com.example.MowItNow.Orientation.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mower {
    private int positionX;
    private int positionY;
    private Orientation orientation;


    public Orientation getOrientation() {
        return orientation;
    }

    public Orientation rotateRight(Orientation orientation) {
        return switch (orientation) {
            case N -> E;
            case E -> S;
            case S -> W;
            case W -> N;
        };
    }

    public Orientation rotateLeft(Orientation orientation) {
        return switch (orientation) {
            case N -> W;
            case E -> N;
            case S -> E;
            case W -> S;
        };
    }

    public int[] advance(int x, int y, Orientation orientation) {
        int[] newPosition = new int[2];
        switch (orientation) {
            case N -> {
                newPosition[0] = x;
                newPosition[1] = y + 1;
            }
            case E -> {
                newPosition[0] = x + 1;
                newPosition[1] = y;
            }
            case S -> {
                newPosition[0] = x;
                newPosition[1] = y - 1;
            }
            case W -> {
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

    public int[] executeInstructions(int startX, int startY, Orientation startOrientation, String instructions, int maxX, int maxY, Mower mower) {
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
