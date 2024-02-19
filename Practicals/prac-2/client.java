import java.net.*;
import java.io.*;

public class client{
      public static void main(String[] args) throws IOException
      {
        //creating socket 
        Socket client = new Socket("localhost",255);
        
        //creating array object to read and write data in form of byte
        byte b[] = new byte[1024];

        //creating object to receive file from server
        InputStream is = client.getInputStream();
        //reading received file from server
        is.read(b,0,b.length);
        
        //creating object to save file to particular location
        FileOutputStream fr = new FileOutputStream("C:\\Users\\vaibh\\OneDrive\\Pictures\\Desktop\\hello.py");
        //saving the file
        fr.write(b, 0, b.length);
        

      }
    }
