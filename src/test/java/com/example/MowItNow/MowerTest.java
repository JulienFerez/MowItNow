package com.example.MowItNow;

import com.example.MowItNow.model.Lawn;
import com.example.MowItNow.model.Mower;
import com.example.MowItNow.model.Orientation;
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
        mower.setStartX(1);
        mower.setStartY(2);
        mower.setOrientation(Orientation.N);
        mower.setInstructions("GAGAGAGAA");
        Lawn lawn = new Lawn(5,5);
        // Test avec des instructions valides
        int[] currentPosition = mower.executeInstructions(lawn, mower);
        assertArrayEquals(new int[]{1, 3}, currentPosition);

    }

    @Test
    public void testExecuteUnknownInstructions() {
        Mower mower = new Mower();
        mower.setStartX(3);
        mower.setStartY(3);
        mower.setOrientation(Orientation.E);
        mower.setInstructions("ADGZ");
        Lawn lawn = new Lawn(5,5);
        // Test avec des instructions valides
        int[] currentPosition = mower.executeInstructions(lawn, mower);
        assertArrayEquals(new int[]{4, 3}, currentPosition);

    }


    @Test
    public void testExecuteStartingPositionOffTheLawn() {
        Mower mower = new Mower();
        mower.setStartX(6);
        mower.setStartY(6);
        mower.setOrientation(Orientation.N);
        mower.setInstructions("GAGAGAGAA");
        Lawn lawn = new Lawn(5,5);
        // Test avec des instructions valides
        int[] currentPosition = mower.executeInstructions(lawn, mower);
        assertArrayEquals(new int[]{6, 6}, currentPosition);

    }

    @Test
    public void testExecuteFinalPositionOffTheLawn() {
        Mower mower = new Mower();
        mower.setStartX(1);
        mower.setStartY(2);
        mower.setOrientation(Orientation.N);
        mower.setInstructions("AAAAAAAAAAA");
        Lawn lawn = new Lawn(1,1);
        // Test avec des instructions valides
        int[] currentPosition = mower.executeInstructions(lawn, mower);
        assertArrayEquals(new int[]{1, 2}, currentPosition);

    }

}
