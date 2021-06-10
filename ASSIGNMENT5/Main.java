package ASSIGNMENT5;
import java.util.*;

abstract  class Employee {
	String userId;
	String name;
	String designation;
	int salary;
	final int yearofJoining;

	Employee(){
		userId = "";
		name = "";
		yearofJoining = -1;
		salary = 0;
		
	}
	
	Employee(String id, String n, int y, int s){
		userId = id;
		name= n;
		salary = s;
		yearofJoining = y;
		
	}
	
	final void salaryUpdate(int s) {
		salary = s;
	}
	
	abstract void setDesignation(String s);
	void display() {
		System.out.println("The user id is: "+userId);
		System.out.println("The name of the Employee is: "+name);
		System.out.println("The Year of joining is: "+yearofJoining);
		System.out.println("Salary is: "+salary);
	}
	
	void display(int y) {
		if(yearofJoining == y) {
			System.out.println("The user id is: "+userId);
			System.out.println("The name of the Employee is: "+name);
			System.out.println("The Year of joining is: "+yearofJoining);
			System.out.println("Salary is: "+salary);
		}
	}
}

 class Faculty extends Employee {
	
	final String specialization;
	int noOfPublications;
	
	Faculty()
	{
		super();
		specialization = "";
		noOfPublications = 0;
	}
	
	Faculty(String id, String n,  int y, int s, int nop, String sp){
		super(id, n, y, s);
		noOfPublications = nop;
		specialization = sp;
	}
	
	final void setDesignation(String s) {
		designation = s;
	} 
	
	void display() {
		super.display();
		System.out.println("The Specialization is: "+specialization);
		System.out.println("Number of Publications is: "+noOfPublications);
	}
	
	void display(int y) {
		if(yearofJoining == y) {
			super.display();
			System.out.println("The Specialization is: "+specialization);
			System.out.println("Number of Publications is: "+noOfPublications);
		}
	}
}
 class Staff extends Employee {

	
		
		final String workAssigned;
		
		 Staff()
		 {
			 super();
			 workAssigned = "";
			 
		 }
		 
		 Staff(String id, String n, int y, int s,String w)
		 {
			 super(id,n,y,s);
			 workAssigned = w;
			 
		 }
		 
		 final void setDesignation(String s)
		 {
			 designation = s;
			 
		 }
		 
		 void display()
		 {
			 super.display();
		    System.out.println("Work Assigned: "+  workAssigned);
		    
		 }
		 
		 void display(int year)
		 {
			 if(yearofJoining == year)
			 {
				 super.display();
				    System.out.println("Work Assigned: "+ workAssigned); 
			 }
		 }
}
 class TemporaryEmployee extends Employee {
	
	final String department;
	
	 TemporaryEmployee()
	 {
		 super();
		 department = "";
		 
	 }
	 
	 TemporaryEmployee(String id, String n, int y, int s,String d)
	 {
		 super(id,n,y,s);
		 department = d;
		 
	 }
	 
	 final void setDesignation(String s)
	 {
		 designation = s;
		 
	 }
	 
	 void display()
	 {
		 super.display();
	    System.out.println("Department: "+ department);
	    
	 }
	 
	 void display(int year)
	 {
		 if(yearofJoining == year)
		 {
			 super.display();
			    System.out.println("Department: "+ department); 
		 }
	 }
}

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Employee[] e = new Employee[30];
		boolean flag = true;
		int ch, j;
		char c;
		String temp;
		String id, n;
		int s, y;
		
		j = 0;
		while(flag)
		{
			System.out.println("Press 1 to display Admin options");
			System.out.println("Press 2 to display Non-Admin options");
			System.out.println("Press 3 to Exit");
			ch = sc.nextInt();
			
			switch(ch)
			{
				case 1:
					System.out.println("Press a to create new Object");
					System.out.println("Press b to delete Existing Object");
					c = sc.next().charAt(0);
					
					switch(c)
					{
						case 'a':
							System.out.println("Press 1 to create Faculty Object");
							System.out.println("Press 2 to create Staff Object");
							System.out.println("Press 3 to create Temporary Employee Object");
							ch = sc.nextInt();
							temp = sc.nextLine();
							
							switch(ch)
							{
								case 1:
									int nop;
									String sp;
									System.out.print("Enter User Id: ");
									id = sc.nextLine();
									System.out.print("Enter Name: ");
									n = sc.nextLine();
									System.out.print("Enter Salary: ");
									s = sc.nextInt();
									System.out.print("Enter Year of Joining: ");
									y = sc.nextInt();
									System.out.print("Enter No of Publication: ");
									nop = sc.nextInt();
									temp = sc.nextLine();
									System.out.print("Enter Specialization: ");
									sp = sc.nextLine();
									e[j++] = new Faculty(id, n, y, s, nop, sp);
									break;
									
								case 2:
									String w;
									System.out.print("Enter User Id: ");
									id = sc.nextLine();
									System.out.print("Enter Name: ");
									n = sc.nextLine();
									System.out.print("Enter Salary: ");
									s = sc.nextInt();
									System.out.print("Enter Year of Joining: ");
									y = sc.nextInt();
									temp = sc.nextLine();
									System.out.print("Enter Work Assigned: ");
									w = sc.nextLine();
									e[j++] = new Staff(id, n, y, s, w);
									break;
									
								case 3:
									String d;
									System.out.print("Enter User Id: ");
									id = sc.nextLine();
									System.out.print("Enter Name: ");
									n = sc.nextLine();
									System.out.print("Enter Salary: ");
									s = sc.nextInt();
									System.out.print("Enter Year of Joining: ");
									y = sc.nextInt();
									temp = sc.nextLine();
									System.out.print("Enter Department: ");
									d = sc.nextLine();
									e[j++] = new TemporaryEmployee(id, n, y, s, d);
									break;
							}
							break;
							
						case 'b':
							System.out.println("Press 1 to delete object using Name");
							System.out.println("Press 2 to delete object using User Id");
							ch = sc.nextInt();
							temp = sc.nextLine();
							
							switch(ch)
							{
								case 1:
									System.out.print("Enter Name: ");
									n = sc.nextLine();
									for(int i=0; i<j; i++)
									{
										if(n.equals(e[i].name))
										{
											Employee t = e[i];
											e[i] = e[j-1];
											e[j-1] = t;
											j--;
											break;
										}
									}
									break;
									
								case 2:
									System.out.print("Enter User Id: ");
									id = sc.nextLine();
									for(int i=0; i<j; i++)
									{
										if(id.equals(e[i].userId))
										{
											Employee t = e[i];
											e[i] = e[j-1];
											e[j-1] = t;
											j--;
											break;
										}
									}
									break;
							}
							break;
					}
					break;
				
				case 2:
					System.out.println("Press a to display info using Name");
					System.out.println("Press b to display info using User Id");
					System.out.println("Press c to display info using Year Of Joining");
					c = sc.next().charAt(0);
					temp = sc.nextLine();
					
					switch(c)
					{
						case 'a':
							System.out.print("Enter Name: ");
							n = sc.nextLine();
							for(int i=0; i<j; i++)
							{
								if(n.equals(e[i].name))
								{
									e[i].display();
								}
							}
							break;
							
						case 'b':
							System.out.print("Enter User Id: ");
							id = sc.nextLine();
							for(int i=0; i<j; i++)
							{
								if(id.equals(e[i].userId))
								{
									e[i].display();
								}
							}
							break;
						
						case 'c':
							System.out.print("Enter Year of Joining: ");
							y = sc.nextInt();
							temp = sc.nextLine();
							
							for(int i=0; i<j; i++)
							{
								e[i].display(y);
							}
							break;
					}
					break;
				
				case 3:
					System.out.println("Program has been Terminated");
					flag = false;
					break;
					
				default:
					System.out.println("Invalid Command");
			}
			System.out.println();
		}
		sc.close();
	}

}