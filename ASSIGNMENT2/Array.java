package ASSIGNMENT2;
import java.util.Scanner;
public class Array
{
	public static void main(String[] args)
	{
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array : ");
		n = sc.nextInt();
		int[] arr = new int[n];
		TakeInput(arr,n);
		HighestNumbers(arr,n);
		sc.close();
	}
	public static void TakeInput(int[] a, int n)
	{
		Scanner p = new Scanner(System.in);
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter a number : ");
			a[i] = p.nextInt();
		}
		   p.close();
	}
	public static void HighestNumbers(int[] a, int n)
	{
		Scanner q = new Scanner(System.in);
		for(int j=1;j<n;j++)
		{
			int key = a[j];
			int i = j-1;
			while(i>=0&&a[i]>key)
			{
				a[i+1] = a[i];
				i = i-1;
			}
			a[i+1] = key;
		}
		  q.close();
		System.out.println("Enter the value of k : ");
		int k = q.nextInt();
		System.out.println("Numbers from highest to " + k + "th highest :");
		for(int i=n-1;i>=(n-k);i--)
		{
			System.out.println(a[i]);
		}
	}
}