import java.net.*;
import java.io.*;

public class Server{
    public static void main(String[] args) throws IOException{

        /////////////////////////////////////////////////////////////
        //open or create server socket
        ServerSocket server = new ServerSocket(255);

        //waiting for client or connecting to client socket
        Socket client = server.accept();
        System.out.println("connection established");
        /////////////////////////////////////////////////////////////



        /////////////////////////////////////////////////////////////
        //making an object to read data coming from the client
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        
        //making an object to read data from the key board
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));

        //making an object to send data to client
        PrintStream ps = new PrintStream(client.getOutputStream());
        /////////////////////////////////////////////////////////////



        /////////////////////////////////////////////////////////////
        //to excute server continuosly
        while(true)
        {
            String str,str1;

            //repeat as long as client does not send null string
            while((str = br.readLine()) != null)
            {
                System.out.println("Client : " + str);

                System.out.print("Server(You) : ");

                str1 = kb.readLine();//reding data from keyboard
                ps.println(str1);//sending data to client
            }

            //closing connection
            br.close();
            kb.close();
            ps.close();
            server.close();
            client.close();

            //termination of application
            System.exit(0);
        ///////////////////////////////////////////////////////////
        }
    }
}