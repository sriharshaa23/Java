package ASSIGNMENT8;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

 class Student implements java.io.Serializable{
		/**
		 *
		 */
		private static final long serialVersionUID = 8193570761238877355L;
		String firstName;
	String lastName;
	int rollNumber;
	double cpi;
	
	Student() {
		firstName = lastName = "";
		rollNumber = 0;
		cpi = 0;
	}
	
	Student(String f, String l, int r, double c) {
		firstName = f;
		lastName = l;
		rollNumber = r;
		cpi = c;
	}
	
	void display() {
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Roll Number: " + rollNumber);
		System.out.println("CPI: " + cpi);
		System.out.println();
	}
}

public class Assignment8 {
	
	static void serialize(ArrayList<Student> arr) {
		
		try {
			FileOutputStream fout = new FileOutputStream("Student.ser");
			ObjectOutputStream objout = new ObjectOutputStream(fout);
			
			for(int i=0; i<arr.size(); i++) {
				objout.writeObject(arr.get(i));
			}
			objout.close();
			fout.close();
			System.out.println("Serialization completed...");
		} 
		catch (IOException e) {
			System.out.println("Error occured while serialization...");
			System.out.println(e);
			System.out.println();
		}
	}
	
	static ArrayList<Student> deserialize() {
		
		ArrayList<Student> arr = new ArrayList<Student>();
		FileInputStream fin;
		ObjectInputStream objin;
		try {
			fin = new FileInputStream("Student.ser");
			objin = new ObjectInputStream(fin);
			
			while(true) {
				arr.add((Student)objin.readObject());
			}
			
		} 
		catch(EOFException e) {
			System.out.println("Deserialization completed...");
		}
		catch(IOException e) {
			System.out.println("Error occured while deserialization...");
			System.out.println(e);
			System.out.println();
		}
		catch(ClassNotFoundException e) {
			System.out.println("Error occured while deserialization...");
			System.out.println(e);
			System.out.println();
		}
		
		return arr;
	}
	
	
	static void lowestCPI(ArrayList<Student> arr) {
		
		Student min = arr.get(0);
		for(int i=1; i<arr.size(); i++) {
			if(min.cpi > arr.get(i).cpi)
				min = arr.get(i);
		}
		System.out.println();
		System.out.println("Student with lowest CPI");
		min.display();
	}
	
	static void averageCPI(ArrayList<Student> arr) {
		double total = 0;
		for(int i=0; i<arr.size(); i++)
			total += arr.get(i).cpi;
		System.out.println("Average CPI: " + total/arr.size());
	}
	
	static void getInput(ArrayList<Student> arr) {
		Scanner sc = new Scanner(System.in);
		String f, l;
		int r;
		double cpi;
		
		System.out.println("Enter details of 10 Students");
		for(int i=0; i<10; i++) {
			System.out.print("Enter First Name: ");
			f = sc.next();
			System.out.print("Enter Last Name: ");
			l = sc.next();
			System.out.print("Enter Roll Number: ");
			r = sc.nextInt();
			System.out.print("Enter CPI: ");
			cpi = sc.nextDouble();
			System.out.println();
			arr.add(new Student(f, l, r, cpi));
		}
		sc.close();
	}
	
	public static void main(String args[]) {
		ArrayList<Student> arr = new ArrayList<Student>();
		getInput(arr);
		serialize(arr);
		arr = deserialize();
		lowestCPI(arr);
		averageCPI(arr);
	}
}