package com.example.MowItNow.service;

import com.example.MowItNow.model.Lawn;
import com.example.MowItNow.model.Mower;
import com.example.MowItNow.model.Orientation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderService {

    public static void readFile(String[] args) {

        if (args.length < 1) {
            System.out.println("Veuillez passer le nom du fichier en paramètre");
            return;
        }
        String fileName = args[0];

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            Lawn lawn = new Lawn();

            String[] dimensions = reader.readLine().split(" ");
            lawn.setMaxX(Integer.parseInt(dimensions[0]));
            lawn.setMaxY(Integer.parseInt(dimensions[1]));
            String line;
            DisplayServiceImpl.displayDimensionsLawn(lawn);
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");
                Mower mower = new Mower();
                mower.setStartX(Integer.parseInt(tokens[0]));
                mower.setStartY(Integer.parseInt(tokens[1]));
                mower.setOrientation(Orientation.valueOf(tokens[2]));
                mower.setInstructions(reader.readLine());
                MooveService.executeInstructions(lawn, mower);
            }
            reader.close();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
