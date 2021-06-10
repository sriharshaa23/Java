import java.io.*;
import java.util.*; 

public class Assignment10{ 
	public static void main(String[] args) 
		throws InterruptedException 
	{ 
		final obj obj = new obj(); 

		Thread thread1 = new Thread(new Runnable() { 
			@Override
			public void run() 
			{ 
				try { 
					obj.producer(); 
				} 
				catch (InterruptedException e) { 
					e.printStackTrace(); 
				} 
			} 
		}); 

		Thread thread2 = new Thread(new Runnable() { 
			@Override
			public void run() 
			{ 
				try { 
					obj.consumer(); 
				} 
				catch (InterruptedException e) { 
					e.printStackTrace(); 
				} 
			} 
		}); 

		thread1.start(); 
		thread2.start(); 
		thread1.join(); 
		thread2.join(); 
	} 

	public static class obj { 

		LinkedList<Integer> l_list = new LinkedList<>(); 
		int buffer_size; 
		obj(){
			System.out.println("Enter buffer size");
			Scanner sc = new Scanner(System.in);
			buffer_size = sc.nextInt();
		}
		public void producer() throws InterruptedException 
		{ 
			int value = 0; 
			while (true) { 
				synchronized (this) 
				{ 
					while (l_list.size() == buffer_size) 
						wait(); 

					System.out.println("Produced- "
									+ value); 
					l_list.add(value++); 
					notify(); 
					Thread.sleep(1000); 
				} 
			} 
		} 
		public void consumer() throws InterruptedException 
		{ 
			while (true) { 
				synchronized (this) 
				{ 
					while (l_list.size() == 0) 
						wait(); 

					int val = l_list.removeFirst(); 

					System.out.println("Consumed- "
									+ val); 
					notify(); 
					Thread.sleep(1000); 
				} 
			} 
		} 
	} 
}