import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser {
	public static void main(String [] args){
		parseIntList("data/intList.txt");
	}
	public static void parseIntList(String filename){

		File inputFile = new File(filename);
		try {
			Scanner inputScanner = new Scanner(inputFile);
			int count = 0;
			int sum = 0; 
			while(inputScanner.hasNextInt()){
				int nextNumber = inputScanner.nextInt();
				count++;
				sum += nextNumber;
				System.out.println("Next number ("+count+"): " +nextNumber);
			}
			System.out.println("Sum = " + sum);

		} catch (FileNotFoundException e) {
			throw new RuntimeException("Fatal Error: File not found");
		}
	}
}
