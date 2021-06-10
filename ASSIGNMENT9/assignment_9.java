package ASSIGNMENT9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;   

class Assignment9 extends Thread
{   String s1,s2;

    Assignment9(String s1,String s2)
	{
	  this.s1=  s1;
      this.s2 = s2;
	}	  
	public void run()
 	{
       Scanner myFile1= null;
		try {
			Scanner file1= new Scanner (new File (s1)) ;
			myFile1= file1;
		} catch(FileNotFoundException e) {
			System.out.println("Please check First file not found !!!");
		}
		
		Scanner myFile2= null;
		try {
			Scanner file2= new Scanner (new File (s2)) ;
			myFile2= file2;
		} catch(FileNotFoundException e) {
			System.out.println("Please check Second file not found !!!");
		}
		String FILE1[]=new String[1000];
		String FILE2[]=new String[1000];
		
		String[] words1= new String[1000];
		String[] words2= new String[1000];
		int i=0;int i1=0;
		while(myFile1.hasNext()) {
			FILE1[i]= myFile1.nextLine();
			
					
	     
		
			String r1=FILE1[i];
			Scanner sb=new Scanner(r1);
			sb.useDelimiter(" ");
			sb.close();
			while(sb.hasNext())
			{
			words1[i1]=sb.next();
			i1++;
			
		}
		i++;
		}
		int j=0;int j1=0;
		while(myFile2.hasNext()) {
			FILE2[j]= myFile2.nextLine();
			
		
			String r2=FILE2[j];
			    Scanner sj=new Scanner(r2);
				sj.useDelimiter(" ");
				sj.close();
				while(sj.hasNext())
				{
            words2[j1]=sj.next();
            j1++;
            			
		}
		 j++;   
	
		}
		
		
		        
		
		System.out.println("\nFollowing words are common in both the files with the following details: \n");
		for(int p=0 ;p<i ;p++) 
		{
			for(int q=0 ;q<j ;q++) {
				if(words1[p].equals(words2[q])){
					System.out.println(words1[p]+" : length "+ words1[p].length() +" appeared in line no. "+ p +" of file1.txt and line no. "+ q+" of file2.txt");
				    System.out.println("\n");
				}
			}
        }
 
	}
}

class new1
{
	public static void main(String[] args)
	{
	 /* String s1,s2;
	  s1 = args[0];
	  s2 = args[1];*/
	  Assignment9 obj1 = new Assignment9("file1.txt","file2.txt");
	  obj1.start();
	}
}