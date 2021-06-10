package ASSIGNMENT1;
import java.util.Scanner;
public class Maths 
{
    public static void main(String[] args) 
    {
        int a, b, add, sub;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter first number:");
        a = s.nextInt();
        System.out.println("Enter second number:");
        b = s.nextInt();
         
        add=a+b;
        System.out.println("The sum of two numbers: "+add);

        sub=a-b;
        System.out.println("The difference of two numbers: "+sub);

        System.out.println("The addiction of "+a+" and "+b+" is "+add+" and when "+b+" subtracted from "+a+" result is "+sub+" ");
       
         s.close();   
 
              
          
        }
    }
