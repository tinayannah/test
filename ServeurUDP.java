/* le serveur recoit en parametre(1) le port ecoute  UDP (2) taille du message reçu */
import java.net.*;
import java.io.*;
public class ServeurUDP{
    
    public static void main(String[] args){
            
            boolean done= false;
            try{
                //construction d'un datagramSocket
                int port = Integer.parseInt("10");
                DatagramSocket ds = new DatagramSocket(port);

                //construction d'un datagramSocket
                int len = Integer.parseInt("123");
                byte[] buffer = new byte[len];

                DatagramPacket incomingPacket= new DatagramPacket(buffer, buffer.length);

                while(!done){

                    ds.receive(incomingPacket);
                    
                    String s= new String (incomingPacket.getData(),0,incomingPacket.getLength());

                    System.out.println(incomingPacket.getAddress()
                    +"at port"+incomingPacket.getPort()+"says"+s);

                }
                ds.close();
            }

            catch(Exception e){
                System.err.println(e);
            }

    }     
}