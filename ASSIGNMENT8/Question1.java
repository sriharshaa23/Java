package ASSIGNMENT8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Question1 {

	public static void main(String[] args) {
		if(args.length == 0) {
			System.out.println("File Name must be passed as argument");
			return;
		}
		
		BufferedReader br;
		try {
			File fin = new File(args[0]);
			br = new BufferedReader(new FileReader(fin));
			StringTokenizer st;
			String s;
			int l, w, c, max, curr, maxLine;
			l = w = c = curr = max = maxLine = 0;
			while((s = br.readLine()) != null) {
				l++;
				c += s.length();
				st = new StringTokenizer(s);
				while(st.hasMoreTokens()) {
					curr++;
					st.nextToken();
				}
				if(max <= curr) {
					max = curr;
					maxLine = l;
				}
				w += curr;
				curr = 0;
			}
			br.close();
			System.out.println("Following are the details of the file: " + args[0]);
			System.out.println("Total number of lines: " + l);
			System.out.println("Total number of words: " + w);
			System.out.println("Total number of characters: " + c);
			System.out.println("Total number of bytes: " + 2*c);
			System.out.println("Line " + maxLine + " contains max no. of words " + max);
		}
		catch(FileNotFoundException e) {
			System.out.println("File does not Exist");
		}
		catch(IOException e) {
			System.out.println("Error occured...");
			System.out.println(e);
		}
	}

}