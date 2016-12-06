import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import sun.print.PrinterJobWrapper;

public class Parser {
	public static void main(String [] args){
		parseIntList("data/intList.txt");
		ArrayList<Student> result = parseStudentsCSV("data/students.csv");
		System.out.println("Next Student: ");

		saveStudentsCSV("data/output.csv", result);
		
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
			System.out.println();


		} catch (FileNotFoundException e) {
			throw new RuntimeException("Fatal Error: File not found");
		}
	}

	public static ArrayList<Student> parseStudentsCSV(String filename){
		ArrayList<Student> students = new ArrayList<Student>();
		File inputFile = new File(filename);
		try {
			Scanner inputScanner = new Scanner(inputFile);
			String headerLine = inputScanner.nextLine();
			inputScanner.useDelimiter("[,\n]");

			while(inputScanner.hasNextLine()){
				String ID = inputScanner.next();
				System.out.println("ID: \t" +ID);

				String name = inputScanner.next();
				System.out.println("Name: \t" +name);

				String email = inputScanner.next();
				System.out.println("Email: \t" +email);

				String gpa = inputScanner.next();
				System.out.println("GPA: \t" +gpa);
				double gpaDouble = Double.parseDouble(gpa);

				Student nextStudent = new Student(ID, name, email, gpaDouble);
				students.add(nextStudent);

				String restOfLine = inputScanner.nextLine();
			}
			return students;

		} catch (FileNotFoundException e) {
			throw new RuntimeException("Fatal Error: File not found");
		}

	}
	public static void saveStudentsCSV(String filename, ArrayList<Student> students){
		File outputFile = new File(filename);
		try {
			PrintWriter outputWriter = new PrintWriter(outputFile);
			outputWriter.println("ID,Name,Email,GPA");
			for(Student s : students){
				 outputWriter.println(s.getID()+","+s.getName()+","+s.getEmail()+","+s.getGpa());
				 
			}
			outputWriter.close();
			
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Fatal Error: Output file not found");
		}

		
	}

}
