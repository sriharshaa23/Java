package ASSIGNMENT7;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

 class User {
	
	String firstName;
	String lastName;
	String PAN;
	String emailID; 
	String addressPin;
	
	User()
	{
		firstName = lastName =  PAN = emailID = addressPin = "";
	}
	
	User(String fn, String ln, String pan, String eid, String pin)
	{
		firstName = fn;
		lastName = ln;
		PAN = pan;
		emailID = eid;
		addressPin = pin;
	}
	
	void display()
	{
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("PAN: " + PAN);
		System.out.println("Email ID: " + emailID);
		System.out.println("Address PIN: " + addressPin);
	}
}
 class Student extends User{
	
	int rollNo;
	
	Student()
	{
		super();
		rollNo = 0;
	}
	
	Student(String fn, String ln, String pan, String eid, String pin, int rn)
	{
		super(fn, ln, pan, eid, pin);
		rollNo = rn;
	}
	
	void display()
	{
		super.display();
		System.out.println("Roll No.: " + rollNo);
		System.out.println("");
	}
	
}
 class Faculty extends User{
	
	int employeeID;
	
	Faculty()
	{
		super();
		employeeID = 0;
	}
	
	Faculty(String fn, String ln, String pan, String eid, String pin, int empid)
	{
		super(fn, ln, pan, eid, pin);
		employeeID = empid;
	}
	
	void display()
	{
		super.display();
		System.out.println("Employee ID: " + employeeID);
		System.out.println("");
	}
	
}
public class Main {
	
	static Scanner sc = new Scanner(System.in);
	static String fn, ln, pan, eid, pin;
	
	static void validateName(String s) throws InvalidNameException
	{
		int i;
		char ch;
		
		for(i=0; i<s.length(); i++)
		{
			ch = s.charAt(i);
			if((ch < 'A' || ch > 'Z') && (ch < 'a' || ch > 'z'))
				throw new InvalidNameException("Error! Name should contain only alphabets");
		}
	}
	
	static void validatePan(String s) throws InvalidPanException
	{
		int i;
		char ch;
		
		if(s.charAt(0) < 'A' || s.charAt(0) > 'Z')
			throw new InvalidPanException("Error! First character of PAN should be capital");
		
		for(i=1; i<s.length(); i++)
		{
			ch = s.charAt(i);
			if((ch < 'A' || ch > 'Z') && (ch < 'a' || ch > 'z') && (ch < '0' || ch > '9'))
				throw new InvalidPanException("Error! PAN only contains alphanumeric");
		}
	}
	
	static void validateEmail(String s) throws InvalidEmailException
	{
		int x = s.indexOf('@');
		
		if(x == -1 || x != s.lastIndexOf('@') || x == 0 || x == s.length()-1)
			throw new InvalidEmailException("Error! Invalid Email ID");
	}
	
	static void validatePin(String s) throws InvalidPinException
	{
		if(s.length() != 6)
			throw new InvalidPinException("Error! Pin should exactly be 6 digits long");
		
		int i;
		char ch;
		for(i=0; i<s.length(); i++)
		{
			ch = s.charAt(i);
			if(ch < '0' || ch > '9')
				throw new InvalidPinException("Error! PIN should only contains numbers");
		}
	}
	
	static void getUserDetails()
	{
		boolean flag;
		
		do
		{
			flag = false;
			try {
				System.out.print("Enter First Name: ");
				fn = sc.next();
				validateName(fn);
			}
			catch(InvalidNameException e)
			{
				System.out.println(e);
				flag = true;
			}
		}while(flag);
		
		do
		{
			flag = false;
			try {
				System.out.print("Enter Last Name: ");
				ln = sc.next();
				validateName(ln);
			}
			catch(InvalidNameException e)
			{
				System.out.println(e);
				flag = true;
			}
		}while(flag);
		
		do
		{
			flag = false;
			try {
				System.out.print("Enter PAN: ");
				pan = sc.next();
				validatePan(pan);
			}
			catch(InvalidPanException e)
			{
				System.out.println(e);
				flag = true;
			}
		}while(flag);
		
		do
		{
			flag = false;
			try {
				System.out.print("Enter Address PIN: ");
				pin = sc.next();
				validatePin(pin);
			}
			catch(InvalidPinException e)
			{
				System.out.println(e);
				flag = true;
			}
		}while(flag);
		
		do
		{
			flag = false;
			try {
				System.out.print("Enter Email ID: ");
				eid = sc.next();
				validateEmail(eid);
			}
			catch(InvalidEmailException e)
			{
				System.out.println(e);
				flag = true;
			}
		}while(flag);
	}

	public static void main(String[] args) {
		
		ArrayList<User> arr = new ArrayList<User>();
		boolean flag = true, f;
		int i, ch;
		int x;
		
		fn = ln = pan = eid = pin = "";
		x = 0;
		
		while(flag)
		{
			System.out.println("Enter 1 to create Student object");
			System.out.println("Enter 2 to create Faculty object");
			System.out.println("Enter 3 to print details of all objects");
			System.out.println("Enter 4 to exit");
			System.out.println("");
			System.out.print("Enter Choice: ");
			
			ch = sc.nextInt();
			switch(ch)
			{
				case 1:
					getUserDetails();
					do
					{
						f = false;
						try {
							System.out.print("Enter Roll No.: ");
							x = sc.nextInt();
						}
						catch(InputMismatchException e)
						{
							System.out.println(e + ": Error! Invalid Roll No.");
							sc.nextLine();
							f = true;
						}
					}while(f);
					
					arr.add(new Student(fn, ln, pan, eid, pin, x));
					break;
					
				case 2:
					getUserDetails();
					do
					{
						f = false;
						try {
							System.out.print("Enter Employee ID: ");
							x = sc.nextInt();
						}
						catch(InputMismatchException e)
						{
							System.out.println(e + ": Error! Invalid Employee ID");
							sc.nextLine();
							f = true;
						}
					}while(f);
					
					arr.add(new Faculty(fn, ln, pan, eid, pin, x));
					break;
					
				case 3:
					for(i=0; i<arr.size(); i++)
						arr.get(i).display();
					break;
				
				case 4:
					flag = false;
					break;
					
				default:
					System.out.println("Invalid Command");
			}
			System.out.println("");
		}
		sc.close();
		System.out.println("Program Terminated Successfully");
	}
}
 class InvalidNameException extends Exception{
	
		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		InvalidNameException(String s)
	{
		super(s);
	}
}
 class InvalidEmailException extends Exception{
	
		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		InvalidEmailException(String s)
	{
		super(s);
	}
}
 class InvalidPanException extends Exception{
	
		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		InvalidPanException(String s)
	{
		super(s);
	}
}
 class InvalidPinException extends Exception{
	
		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		InvalidPinException(String s)
	{
		super(s);
	}
}