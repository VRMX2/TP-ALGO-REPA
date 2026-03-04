package TP1;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class p3 {//client
    public static void main(String[] args) {   
        try{
            Socket s = new Socket("localhost",1234);
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject("HELLO RSD");
            oos.flush();
            oos.close();
            s.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
