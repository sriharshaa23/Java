package ASSIGNMENT1;
import java.util.*;
public class MyClass 
{
  public static void main(String[] args) 
    {
    Scanner sc = new Scanner(System.in);
     sc.close();
    System.out.println("Please enter a Firstname: ");
    String firstname = sc.nextLine();
    System.out.println("Please enter a Lastname: ");
    String lastname = sc.nextLine();
    System.out.println(firstname+""+lastname);
    System.out.println("\""+firstname+""+lastname+"\"");
    
    System.out.println("Lastname= "+lastname);
   
 }
  } 
