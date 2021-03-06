import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 
 */

/**
 * @author Marcus Perez, Tristian Mortimer, Matthew Davis
 *
 */
public class CountriesTextFile {

	public CountriesTextFile(String countryName) {
		super();
		this.countryName = countryName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String countryName;

	public static void readFromFile() {
		Path writeFile = Paths.get("countries.txt");
		File file = writeFile.toFile();

		try {
			FileReader fr = new FileReader(file);
			// this is a buffer and the benefit of using this is to is to store a block of
			// memory that
			// we can read data from later -- more efficient than Scanner

			BufferedReader reader = new BufferedReader(fr);
			// this is attempting to read the first line from the text document

			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("There were no countries!");
		}

	}
	
	public static String fileAsString () {
		Path writeFile = Paths.get("countries.txt");
		File file = writeFile.toFile();

		try {
			FileReader fr = new FileReader(file);
			// this is a buffer and the benefit of using this is to is to store a block of memory that
			//we can read data from later -- more efficient than Scanner
		
			BufferedReader reader = new BufferedReader(fr);
			// this is attempting to read the first line from the text document
			
			String line = reader.readLine();
			while(line!=null) {
				System.out.println(line);
				line += reader.readLine() + ",";
				
			}
			reader.close();
			return line;
		} catch (IOException e) {
			e.printStackTrace();
			return "ERROR";
		}
		
	}
	
	public static void writeToFile(String name) {
		Path writeFile = Paths.get("countries.txt");
		File file = writeFile.toFile();

		try {
			PrintWriter out = new PrintWriter(new FileOutputStream(file, true));
			out.println( name);
			out.close();
		} catch (FileNotFoundException e) {
			//System.out.println(" the file was not found here ...");Path filePath = Paths.get(fileString);
			// this will only happen if the file is not there
			createFile("countries.txt");
			try {
				PrintWriter out = new PrintWriter(new FileOutputStream(file, true));
				out.println( name);
				out.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public static void createFile(String fileString) {
		// get method is overloaded, and I can just pass in the name for the file if i
		// want --
		// if i dont want it to live in a folder
		Path filePath = Paths.get(fileString);
		// this will only happen if the file is not there
		if (Files.notExists(filePath)) {
			try {
				Files.createFile(filePath);
				System.out.println("Your file was cerated successfully");
			} catch (IOException e) {
				System.out.println("Something went wrong with file creation ");
				e.printStackTrace();
			}
		}
	}
}
