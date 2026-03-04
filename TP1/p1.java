package TP1;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class p1 { //client
    public static void main(String[] args) {
       try{
           System.out.println("demande de connexion ..");
           Socket s  = new Socket("localhost",1234);
           System.out.println("connexion reussie");
           ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
           oos.writeObject("HELLO RSD");
           oos.close();
           s.close();
       }
       catch(Exception e){
          e.printStackTrace();
       }
        
    }
}