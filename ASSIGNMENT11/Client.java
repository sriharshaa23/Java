import java.net.*;
import java.io.*;
import java.util.*;

public class Client{
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 4999);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the file: ");
        String inp = sc.nextLine();
        //Send inp to Server
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println(inp);
        pr.flush();
        System.out.println("Searching for " + inp + "...");
        //Search function
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);
        Scanner sccc = new Scanner(in);

        String str;
        while(!s.isClosed()){
            while(sccc.hasNextLine()){
                str = sccc.nextLine();
                System.out.println("Server: " + str);
            }
            
        }
    }
    
}
