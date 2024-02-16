import java.net.*;
import java.util.Scanner;

public class Client_UDP {

    public static void main(String[] args) throws Exception {

        
        // Creating Socket
        DatagramSocket socket = null;
        
        try {
            // Initializing socket
            socket = new DatagramSocket();
            
            // Getting Server's IP Address
            InetAddress serverAddress = InetAddress.getByName("localhost");
            
            // Server PORT number
            int serverPort = 3000;

            System.out.println("Input String : ");
            Scanner sc = new Scanner(System.in);
            String input;
            
            while((input = sc.nextLine())!="exit"){
        
                // Printing the same message
                
                // Converting input string data into bytes
                byte[] sendData = input.getBytes();
                
                // Converting byte data into Packets
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
                
                // Sending packets to the server
                socket.send(sendPacket);
                
                // Converting received data into bytes
                byte[] receiveData = new byte[1024];
                
                // Storing received packet
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                
                // Receiving data from server in form of packets
                socket.receive(receivePacket);
                
                // Data that is being converted and stored which is received from the server
                String Output = new String(receivePacket.getData(), 0, receivePacket.getLength());
                
                // Printing the output sent by server
                System.out.println("Server : " + Output);

                System.out.print("Client(you): ");
                // Scanner sd = new Scanner(System.in);
                // input = sc.nextLine();
                
            }
            } catch (Exception e) {

            System.out.println(e);

        } finally {

            socket.close();
        }
    }
}