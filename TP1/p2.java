package TP1;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class p2 { //server
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(1234);
            System.out.println("en attente de connexion");
            Socket s = ss.accept();
            System.out.println("connexion reussie");
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            String msg = (String) ois.readObject();
            System.out.println("message recu : " + msg);
            ois.close();
            s.close();
            ss.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}