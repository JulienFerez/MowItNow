package com.example.MowItNow;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;

@SpringBootTest
class MowItNowApplicationTests {

	@Test
	public void testAffichageResultats() {
		// Capture la sortie standard dans un tableau de bytes
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));

		// Exécute le programme avec les entrées spécifiées
		String[] args = {"5 5", "1 2 N", "GAGAGAGAA", "3 3 E", "AADAADADDA"};
		// TODO args n'est pas du tout utilisé par le programme
        MowItNowApplication.main(args);

		// Récupère la sortie du programme
		String output = outputStream.toString().trim();

		// Vérifie que la sortie correspond aux résultats attendus
        // TODO le test ne devrait pas s'appuyer sur ce qui est écrit dans la console mais plutôt sur les
        // données calculées (positions et orientation finales des tondeuses)
		List<String> expectedOutput = Arrays.asList(
				"Dimensions de la pelouse : 5 x 5",
				"Position de départ : (1, 2) Orientation : N Instructions : GAGAGAGAA",
				"Position finale : (1, 3) Orientation : N",
				"Position de départ : (3, 3) Orientation : E Instructions : AADAADADDA",
				"Position finale : (5, 1) Orientation : E"
		);
		assertLinesMatch(expectedOutput, Arrays.asList(output.split("\\r?\\n")));
	}

}







