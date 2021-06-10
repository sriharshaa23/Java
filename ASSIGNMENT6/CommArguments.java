package ASSIGNMENT6;
class CommArguments
{
	public static void main(String args[])
	{
		if((args.length)==0)
		{
			System.out.println("ERROR: No numbers to add");
		}
		else
		{
			if((args.length)==1)
			{
				System.out.println("ERROR: Add requires at least two numbers");
			}
			else
			{
				int s=0;
				for(int i=0;i<(args.length);i++)
				{
					int p = Integer.parseInt(args[i]);
					s = s + p;	
				}
				System.out.println(s);
			}
		}
	}
}