package ASSIGNMENT4;
import java.util.*;
class User
{
	String name;
	int dateOfBirth;
	int userId;

	User()
	{
		name = null;
		dateOfBirth = 00000000;
		userId = 0;
	}

	void showDetails(int birthyear)
	{
		System.out.print("\nName  : "+name);
		

		System.out.print("\ndateOfBirth(DDMMYYYY) : "+dateOfBirth);
	

		System.out.print("\nUserId : "+userId);
	
	}

	void setDetails()
	{
		Scanner in = new Scanner(System.in);
        in.close();
		System.out.print("\nEnter Name : ");
		name = in.nextLine();

		System.out.print("\nEnter dateOfBirth(DDMMYYYY format) : ");
		dateOfBirth = in.nextInt();


		System.out.print("\nEnter userId : ");
		userId = in.nextInt();
	}
	

}
class Student extends User
{


	int rollNumber;
	int semester;
	float cpi;
	Student()
	{
		rollNumber = 0;
		semester = 0;
		cpi = 0;
	}
	void showDetails(int birthyear)
	{
		super.showDetails(birthyear);

		System.out.print("\nRoll Number : "+rollNumber);
	

		System.out.print("\nsemester : "+semester);
		

		System.out.print("\ncpi : "+cpi);
		
	}
	void setDetails()
	{

        super.setDetails();

		Scanner in = new Scanner(System.in);

		in.close();

		System.out.print("\nEnter Roll Number : ");
		rollNumber = in.nextInt();

		System.out.print("\nEnter semester : ");
		semester = in.nextInt();

		System.out.print("\nEnter cpi : ");
		cpi = in.nextFloat();

	}

}
class Faculty extends User
{
	int employeeId;
	String departmentName;
	int noOfPublications;

	Faculty()
	{
		employeeId = 0;
		departmentName="XXX";
		noOfPublications = 0;
	}
	void showDetails(int birthyear)
	{
		super.showDetails(birthyear);

		System.out.print("\nemployeeId : "+employeeId);
		

		System.out.print("\ndepartmentName : "+departmentName);
	

	
		System.out.print("\nnoOfPublications : "+noOfPublications);
		
	}
	void setDetails()
	{

        super.setDetails();

		Scanner in = new Scanner(System.in);

		in.close();

		System.out.print("\nEnter employeeId : ");

		employeeId = in.nextInt();

         in.nextLine();

		System.out.print("\nEnter departmentName : ");
		departmentName = in.nextLine();

		in.nextLine();

		System.out.print("\nEnter noOfPublications : ");
		noOfPublications = in.nextInt();

	}
}
class Staff extends User
{
	int employeeId;
	String sectionName;
	String designation;

	Staff()
	{
		employeeId = 0;
		sectionName = "XX";
		designation = "XXXX";

	}
	void showDetails(int birthyear)
	{
		super.showDetails(birthyear);

		System.out.print("\nemployeeId  : "+employeeId);
	

		System.out.print("\nsectionName : "+sectionName);
		

		System.out.print("\ndesignation : "+designation);
		

	}
	void setDetails()
	{

        super.setDetails();

		Scanner in = new Scanner(System.in);

		in.close();

		System.out.print("\nEnter employeeId  : ");
		employeeId = in.nextInt();

		 in.nextLine();

		System.out.print("\nEnter sectionName : ");
		sectionName = in.nextLine();

		System.out.print("\nEnter designation : ");
		designation = in.nextLine();

	}
	

}
class Assignment 
{
	int check(int dateOfBirth,int inputYear)
	{
		int i = 0;
		while(i<4)
		{
			if(dateOfBirth%10 != inputYear%10)
			{
				return 0;


			}
			dateOfBirth = dateOfBirth/10;
			inputYear = inputYear/10;
			i++;
		}
		return 1;
	}
	public static void main(String[] args)
	{


		Assignment assign = new Assignment();

		Scanner in = new Scanner(System.in);
         in.close();
		System.out.println("\nStaff : ");


		Staff staff1 = new Staff();
		staff1.setDetails();

		System.out.println("\nStudent : ");
		
		Student student1 = new Student();
		student1.setDetails();

		

		System.out.println("\nFaculty : ");

		Faculty faculty1 = new Faculty();
		faculty1.setDetails();


		while(true)
		{
			

			System.out.println("1.Print Info using BirthYear\n2.Print Info using EmployeeId\n3.print Info using UserId\n4.Exit");


			System.out.print("\nEnter Choice : ");
			int choice = in.nextInt();

			int birthyear,id;

			
			switch(choice)
			{
				case 1 : 

					System.out.print("\nEnter BirthYear : ");
					birthyear = in.nextInt();
					if(assign.check(student1.dateOfBirth,birthyear)==1)
					{
						student1.showDetails(birthyear);
					}
					if(assign.check(staff1.dateOfBirth,birthyear)==1)
					{
						staff1.showDetails(birthyear);
					}
					if(assign.check(faculty1.dateOfBirth,birthyear)==1)
					{
						faculty1.showDetails(birthyear);
					}

					break;


				case 2 :

					System.out.print("\nEnter employeeId : ");
					id = in.nextInt();

				    if(staff1.employeeId==id)
				    {
				    	staff1.showDetails(staff1.dateOfBirth);
				    }
				    if(faculty1.employeeId==id)
				    {
				    	faculty1.showDetails(faculty1.dateOfBirth);
				    }
				    break;

				 case 3 :

				     System.out.print("\nEnter userId : ");
					id = in.nextInt();

				    if(staff1.userId==id)
				    {
				    	staff1.showDetails(staff1.dateOfBirth);
				    }
				    if(student1.userId==id)
				    {
				    	student1.showDetails(student1.dateOfBirth);
				    }
				    if(faculty1.userId==id)
				    {
				    	faculty1.showDetails(faculty1.dateOfBirth);
				    }
				    break;

				   case 4 : 
				   	return;
				   

				  

			}
			System.out.println("\n");


		}







		

		

}
}


