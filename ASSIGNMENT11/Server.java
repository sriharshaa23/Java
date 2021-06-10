import java.net.*;
import java.io.*;
import java.util.*;



public class Server {
    public static int countLines(String filename) throws IOException {
        InputStream is = new BufferedInputStream(new FileInputStream(filename));
        try {
            byte[] c = new byte[1024];
            int count = 0;
            int readChars = 0;
            boolean empty = true;
            while ((readChars = is.read(c)) != -1) {
                empty = false;
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            }
            return (count == 0 && !empty) ? 1 : count;
        } finally {
            is.close();
        }
    }

    public static int countWords(File file) throws IOException {
        int count = 0;
        FileInputStream fis = new FileInputStream(file);
        byte[] bytesArray = new byte[(int)file.length()];
        fis.read(bytesArray);
        String s = new String(bytesArray);
        String [] data = s.split(" ");
        for (int i=0; i<data.length; i++) {
            count++;
        }
        return count;
    }
    
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(4999);
        System.out.println("Server Listening on 4999");
        Socket s = ss.accept();
        System.out.println("Client Connected");
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        
        PrintWriter writer = new PrintWriter(s.getOutputStream(), true);
        
        BufferedReader bf = new BufferedReader(in);
        String fileName = bf.readLine();
        System.out.println("/" + fileName + "/");
        
        File curDir = new File(".");
        File[] filesList = curDir.listFiles();
        for(File f : filesList){
            if(fileName.equals(f.getName())){
                writer.println("Found " + f.getName() + " in " + f.getPath());
                writer.println("Number of lines: " + countLines(f.getPath()));
                writer.println("Number of Words: " + countWords(f));
                return;
            }
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("File not found. Did you mean: ");
        for(File f : filesList){
            String fName = f.getName();
            if(fileName.charAt(0) == fName.charAt(0) && fileName.charAt(1) == fName.charAt(1)){
                System.out.println(fName);
                String inp = sc.nextLine();
                
            }
        }
        
    }
}
