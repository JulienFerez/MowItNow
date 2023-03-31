import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@SpringBootApplication
public class MowItNowApplication {

	public static void main(String[] args) {
		SpringApplication.run(MowItNowApplication.class, args);
	}
	public static void maintwo(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

			// Lire les dimensions de la pelouse
			String[] dimensions = reader.readLine().split(" ");
			int maxX = Integer.parseInt(dimensions[0]);
			int maxY = Integer.parseInt(dimensions[1]);

			// Traiter les informations de la pelouse
			int[][] lawn = new int[maxX][maxY];
			System.out.println(lawn);

			// Lire les informations de chaque tondeuse
			String line;
			while ((line = reader.readLine()) != null) {
				String[] tokens = line.split(" ");
				int startX = Integer.parseInt(tokens[0]);
				int startY = Integer.parseInt(tokens[1]);
				char orientation = tokens[2].charAt(0);
				String instructions = reader.readLine();

				// Traiter les informations de la tondeuse
				System.out.println(tokens);
				// ...
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
