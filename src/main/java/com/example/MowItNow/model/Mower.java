package com.example.MowItNow.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mower {
    private int startX;
    private int startY;
    private int positionX;
    private int positionY;
    private Orientation orientation;
    private String instructions;

    private int finalPositionX;
    private int finalPositionY;
    private Orientation finalOrientation;


    public Orientation getOrientation() {
        return orientation;
    }

    public Orientation rotateRight(Orientation orientation) {
        Orientation newOrientation;
        switch (orientation) {
            case N:
                newOrientation = Orientation.E;
                break;
            case E:
                newOrientation = Orientation.S;
                break;
            case S:
                newOrientation = Orientation.W;
                break;
            case W:
                newOrientation = Orientation.N;
                break;
            default:
                throw new IllegalArgumentException("Invalid orientation: " + orientation);
        }

        this.setFinalOrientation(newOrientation);
        return newOrientation;
    }


    public Orientation rotateLeft(Orientation orientation) {
        Orientation newOrientation = null;
        switch (orientation) {
            case N :
                newOrientation = Orientation.W;
                        break;
            case E :
                newOrientation = Orientation.N;
                break;
            case S :
                newOrientation = Orientation.E;
                break;
            case W :
                newOrientation = Orientation.S;
                break;
            default:
                throw new IllegalArgumentException("Invalid orientation: " + orientation);

        };
        this.setFinalOrientation(newOrientation);
        return newOrientation;
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
        this.setFinalPositionX(newPosition[0]) ;
        this.setFinalPositionY(newPosition[1]);
        return newPosition;
    }

    public int[] executeInstructions(Lawn lawn, Mower mower) {
        int[] currentPosition = new int[]{mower.getStartX(), mower.getStartY()};
        Orientation currentOrientation = mower.getOrientation();

        for (int i = 0; i < this.instructions.length(); i++) {
            Instruction instruction;
            try {
                instruction = Instruction.valueOf(String.valueOf(instructions.charAt(i)));
            } catch (IllegalArgumentException e) {
                System.out.println("Instruction inconnue : " + this.instructions.charAt(i));
                continue;
            }
            switch (instruction) {
                case D:
                    currentOrientation = this.rotateRight(currentOrientation);
                    break;
                case G:
                    currentOrientation = this.rotateLeft(currentOrientation);
                    break;
                case A:
                    int[] newPosition = this.advance(currentPosition[0], currentPosition[1], currentOrientation);
                    if (newPosition[0] >= 0 && newPosition[0] <= lawn.getMaxX() && newPosition[1] >= 0 && newPosition[1] <= lawn.getMaxY()) {
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
