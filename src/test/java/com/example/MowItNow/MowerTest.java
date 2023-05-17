package com.example.MowItNow;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MowerTest {

    Orientation north = Orientation.N;
    Orientation east = Orientation.E;
    Orientation south = Orientation.S;
    Orientation west = Orientation.W;

    Mower mower = new Mower();
    @Test
    public void testRotateRight() {

        assertEquals(Orientation.E, mower.rotateRight(north));
        assertEquals(Orientation.S, mower.rotateRight(east));
        assertEquals(Orientation.W, mower.rotateRight(south));
        assertEquals(Orientation.N, mower.rotateRight(west));
        assertEquals(Orientation.S, mower.rotateRight(mower.rotateRight(north)));

    }

    @Test
    public void testRotateLeft() {

        assertEquals(Orientation.W, mower.rotateLeft(north));
        assertEquals(Orientation.N, mower.rotateLeft(east));
        assertEquals(Orientation.E, mower.rotateLeft(south));
        assertEquals(Orientation.S, mower.rotateLeft(west));

    }

    @Test
    public void testAdvance() {
        Mower mower = new Mower();
        assertArrayEquals(new int[]{0, 1}, mower.advance(0, 0, Orientation.N));

        mower.setOrientation(Orientation.E);
        assertArrayEquals(new int[]{1, 0}, mower.advance(1, 1, Orientation.S));

        mower.setOrientation(Orientation.S);
        assertArrayEquals(new int[]{3, 2}, mower.advance(2, 2, Orientation.E));

        mower.setOrientation(Orientation.W);
        assertArrayEquals(new int[]{2, 3}, mower.advance(3,3, Orientation.W));

    }


    @Test
    public void testExecuteInstructions() {
        Mower mower = new Mower();
        // Test avec des instructions valides
        int[] currentPosition = mower.executeInstructions(1, 2, Orientation.N, "GAGAGAGAA", 5, 5, new Mower());
        assertArrayEquals(new int[]{1, 3}, currentPosition);

        // Test avec une instruction inconnue
        currentPosition = mower.executeInstructions(3, 3, Orientation.E, "ADGZ", 5, 5, new Mower());
        assertArrayEquals(new int[]{4, 3}, currentPosition);

        // Test avec une position de départ en dehors de la pelouse
        currentPosition = mower.executeInstructions(6, 6, Orientation.N, "GAGAGAGAA", 5, 5, new Mower());
        assertArrayEquals(new int[]{6, 6}, currentPosition);

        // Test avec une position finale en dehors de la pelouse
        currentPosition = mower.executeInstructions(1, 2, Orientation.N, "AAAAAAAAAAA", 1, 1, new Mower());
        assertArrayEquals(new int[]{1, 2}, currentPosition);


    }



}
