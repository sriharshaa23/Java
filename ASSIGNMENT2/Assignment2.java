package ASSIGNMENT2;
import java.util.Scanner;
public class Assignment2 {

  public static void main(String[] args)
    {
        String str;
        str = Read();
        System.out.print("Number of words in the string: " + count_Words(str)+"\n");
        System.out.println("Palindrome words in the sentence: ");      
        Palindromewords(str);
     }
     public static String Read()
      {
       
        String sen;
        System.out.print("Input the string: ");
        Scanner sc = new Scanner(System.in);
        sen = sc.nextLine();
        sc.close();
        return sen;
      }
    
    
  
       
    

 public static int count_Words(String c)
    {
       c = c + ' ';
       int count = 0;
            for (int i = 0; i < c.length(); i++)
            {
               char Z = c.charAt(i);
               if(Z ==' ')
                {
                    count++;
                }
        
        }
        return count;
    }
public static void Palindromewords(String a)
{
    a = a + ' ';
    String actual ="";
    String reverse ="";
    for(int i=0;i<(a.length());i++)
		{
			char b = a.charAt(i);
			if(b!=' ')
			{
				actual = actual + b;
				reverse = b + reverse;
			}
			else
			{
				if(actual.equalsIgnoreCase(reverse))
				{
					System.out.println(actual);
				}
				actual = "";
				reverse = "";
			}
		}
	}
}




