package com.example.MowItNow;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;


class MowItNowApplicationTests {

    @Test
    public void testDisplayOfResults() {
        // Capture la sortie standard dans un tableau de bytes
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Exécute le programme avec les entrées spécifiées
        String[] args = new String[]{"inputfile.txt"};
        MowItNowApplication.main(args);

        // Récupère la sortie du programme
        String output = outputStream.toString().trim();

        // Vérifie que la sortie correspond aux résultats attendus
        List<String> expectedOutput = Arrays.asList(
                "Dimensions de la pelouse : 5 x 5",
                "Position de départ : (1, 2) Orientation : N Instructions : GAGAGAGAA",
                "Position finale : (1, 3) Orientation : N",
                "Position de départ : (3, 3) Orientation : E Instructions : AADAADADDA",
                "Position finale : (5, 1) Orientation : E"
        );
        assertLinesMatch(expectedOutput, Arrays.asList(output.split("\\r?\\n")));
        assertEquals(5, 5);
    }

    @Test
    public void testFinalPositionOfTheMowers() {

        Mower mower = new Mower(1, 2, Orientation.N);
        Mower secondMower = new Mower(1, 2, Orientation.E);

        int[] finalPosition1 = mower.executeInstructions(1, 2, Orientation.N, "GAGAGAGAA", 5, 5, mower);
        assertEquals(1, finalPosition1[0]);
        assertEquals(3, finalPosition1[1]);
        assertEquals(Orientation.N, mower.getOrientation());

        int[] finalPosition2 = secondMower.executeInstructions(3, 3, Orientation.E, "AADAADADDA", 5, 5, secondMower);
        assertEquals(5, finalPosition2[0]);
        assertEquals(1, finalPosition2[1]);
        assertEquals(Orientation.E, secondMower.getOrientation());
    }

    @Test
    public void testMainNoFile() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expected = "Veuillez passer le nom du fichier en paramètre";
        String[] args = {};
        MowItNowApplication.main(args);
        assertEquals(expected + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void testMainFileNotFound() {
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));
        String expected = "Le fichier file-does-not-exist.txt n'a pas été trouvé !";
        String[] args = {"file-does-not-exist.txt"};
        MowItNowApplication.main(args);
        assertEquals(expected + System.lineSeparator(), errContent.toString());
    }

    @Test
    public void testExecuteInstructionsMissingInstructions() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Mower mower = new Mower();
        mower.executeInstructions(0, 0, Orientation.N, "", 5, 5, mower);
        assertEquals("", outContent.toString());
    }

    @Test
    public void testExecuteInstructionsUnknownInstruction() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Mower mower = new Mower();
        String expected = "Instruction inconnue : X";
        mower.executeInstructions(0, 0, Orientation.N, "DGAX", 5, 5, mower);
        assertEquals(expected + System.lineSeparator(), outContent.toString());
    }

}







