/*le client recoit en argument (1) le nom de la machine sur lequelle se trouve le serveur et (2) le port
d'ecoute UPD du serveur*/

import java.net.*;
import java.io.*;

public class ClientUDP{

    public static void main(String[] args) {
        String mod;
//modification de code avec ce commentaire
        BufferedReader stdin; //input du clavier
        String sendString; //string à envoyer
        byte[] sendBytes; //octets à envoyer

        try{

            InetAddress receiver = InetAddress.getByName("");//adresse ip
            int port = Integer.parseInt("10");
            DatagramSocket theSocket= new DatagramSocket();

            stdin= new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Begin typing (return to send,"+"ctrl-C to quit):");

            while((sendString=stdin.readLine()) != null){

                //convertir input clavier en octects
                sendBytes = sendString.getBytes();

                DatagramPacket theOutput = new DatagramPacket(sendBytes, sendBytes.length ,
                receiver,port);
                theSocket.send(theOutput); 
            }

             theSocket.close();
        }

        catch(Exception e){
            System.err.println(e);
        }
        
    }
}p