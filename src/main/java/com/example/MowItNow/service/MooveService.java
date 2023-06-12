package com.example.MowItNow.service;

import com.example.MowItNow.model.Lawn;
import com.example.MowItNow.model.Mower;

public class MooveService {


    public static void executeInstructions(Lawn lawn, Mower mower) {
        mower.executeInstructions(lawn, mower);
        DisplayServiceImpl.displayPositionMower(mower);
    }
}
