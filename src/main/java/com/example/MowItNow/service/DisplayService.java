package com.example.MowItNow.service;

import com.example.MowItNow.model.Lawn;
import com.example.MowItNow.model.Mower;

public class DisplayService {

   static public void displayDimensionsLawn(Lawn lawn){
        System.out.println("Dimensions de la pelouse : " + lawn.maxX + " x " + lawn.maxY);
    }

    static public void displayPositionMower(Mower mower) {
        System.out.println("Position de départ : (" + mower.getStartX() + ", " + mower.getStartY() + ") Orientation : " + mower.getOrientation() + " Instructions : " + mower.getInstructions());
        System.out.println("Position finale : (" + mower.getFinalPositionX() + ", " + mower.getFinalPositionY() + ") Orientation : " + mower.getFinalOrientation());
    }

}
