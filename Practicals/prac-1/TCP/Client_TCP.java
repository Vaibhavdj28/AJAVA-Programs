import java.net.*;
import java.io.*;

public class Client{
    public static void main(String[] args) throws IOException{

        //////////////////////////////////////////////////////////////
        //creating client socket
        Socket client = new Socket("localhost",255);
        //////////////////////////////////////////////////////////////



        /////////////////////////////////////////////////////////////
        //making an object to read data coming from the server
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        
        //making an object to read data from the key board
        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));

        //making an object to send data to server
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        /////////////////////////////////////////////////////////////



        String str,str1;
        System.out.print("Client(You) : ");



        /////////////////////////////////////////////////////////////
        //repeat as long as exit is not typed by client
        while(!(str = kb.readLine()).equals("exit"))
        {
            dos.writeBytes(str+"\n");//sending data to Server

            str1 = br.readLine();//reding data from server

            System.out.println("Server : " + str1);

            System.out.print("Client(You) : ");

        }
        //////////////////////////////////////////////////////////////


        //closing connection
        br.close();
        kb.close();
        dos.close();
        client.close();
    }
}