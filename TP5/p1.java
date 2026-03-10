package TP5;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p1 {

    public static void main(String[] args) {

        try {

            BufferedReader keyboard = new BufferedReader(
                    new InputStreamReader(System.in));

            while (true) {

                System.out.println("Entrer votre Nom:");

                String name = keyboard.readLine();

                String message = "RSD-" + name;

                Socket socket = new Socket("192.168.203.21", 2002);

                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

                out.writeObject(message);

                String result = (String) in.readObject();

                System.out.println("Resultat = " + result);

                socket.close();
            }

        } catch (Exception e) { e.printStackTrace();}
    }
}