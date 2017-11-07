//Marcus Perez, Tristian Mortimer, Matthew Davis
 

import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 2;
		while (choice != 3) {
			choice = Validator.getInt(sc, " 1 - See list of countries\n 2 - Add a country\n 3 - Exit \n", 1, 3);
			if (choice == 1) {
				CountriesTextFile.readFromFile();
			} else if (choice == 2) {
				String country = Validator.getString(sc, "Enter your damn country: ");

				CountriesTextFile.writeToFile(country);
			}

		}
	}
}
