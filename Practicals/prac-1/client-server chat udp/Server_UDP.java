import java.net.*;
import java.util.Scanner;

public class Server_UDP {

    // static String reverseString(String str) {
    //     String output = "";

    //     int i = str.length() - 1;

    //     while (i >= 0) {
    //         char ch = str.charAt(i);

    //         if (Character.isUpperCase(ch)) {
    //             output += Character.toLowerCase(ch);
    //         } else if (Character.isLowerCase(ch)) {
    //             output += Character.toUpperCase(ch);
    //         } else {
    //             output += " ";
    //         }
    //         i--;
    //     }
    //     return output;
    // }

    public static void main(String[] args) throws Exception {

        // Using UDP

        // Creating a socket for UDP
        DatagramSocket socket = null;

        try {

            // Initializing a new Server socket
            // As if not connected, error should be prevented
            socket = new DatagramSocket(3000);

            // Making an object to receive data from client
            byte[] receiveData = new byte[1024];

            // Creating an object to store received packets
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            while(true)
                {

                    // Receiving data from client
                    socket.receive(receivePacket);
                    
                    // Storing client data into string
                    String input = new String(receivePacket.getData(), 0, receivePacket.getLength());

                    while(input!=null)
                    {
                    // Printing client message at server
                    System.out.println("Client : " + input);
                    
                    // Storing data into outputString to send to the client
                    // After revering the input string
                    System.out.print("Server(you) : ");
                    Scanner sc = new Scanner(System.in);
                    String outputString = sc.nextLine();
                    
                    // Receiving Client Address
                    InetAddress clientAddress = receivePacket.getAddress();

                    // Receiving Client Port
                    int clientPort = receivePacket.getPort();
                    
                    // Storing data in the form of bytes which is to be sent to the client
                    byte[] sendData = outputString.getBytes();
                    
                    // Converting byte data into Packets
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                    
                    // Finally sending data to the client
                    socket.send(sendPacket);

                    // Receiving data from client
                    socket.receive(receivePacket);
                    
                    // Storing client data into string
                    input = new String(receivePacket.getData(), 0, receivePacket.getLength());
                }
            }
            
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        } 
        finally 
        {
            socket.close();
        }
    }
}