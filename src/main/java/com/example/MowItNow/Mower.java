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
            default -> orientation;
        };
    }

    public Orientation rotateLeft(Orientation orientation) {
        return switch (orientation) {
            case N -> W;
            case E -> N;
            case S -> E;
            case W -> S;
            default -> orientation;
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

}
