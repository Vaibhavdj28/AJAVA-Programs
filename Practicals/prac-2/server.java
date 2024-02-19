import java.net.*;
import java.io.*;

public class server {
    public static void main(String[] args) throws IOException
    {

        //creating serversocket 
        ServerSocket server = new ServerSocket(255);

        //accepting client
        Socket client = server.accept();
        System.out.println("Connection Established");

        //creating array object to read and write data in form of byte
        byte b[] = new byte[1024];
        
        //creating object to fetch file from its location
        FileInputStream fr = new FileInputStream("C:\\Github Repo\\AJAVA-Programs\\Practicals\\prac-2\\hello.py");
        //reading a file
        fr.read(b, 0, b.length);
        
        //creating object to send file to client
        OutputStream os = client.getOutputStream();
        //sending a file to client
        os.write(b, 0, b.length);

    }
    
}
