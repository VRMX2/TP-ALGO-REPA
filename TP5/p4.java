package TP5;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class p4 {

    public static void main(String[] args) {

        try {

            ServerSocket server = new ServerSocket(2005);
            BufferedReader keyboard = new BufferedReader(
                    new InputStreamReader(System.in));

            System.out.println("P4 en attente de connexion de P3...");

            while (true) {

                Socket socket = server.accept();

                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

                
                String message = (String) in.readObject();

                System.out.println("Chaine reçue de P3 : " + message);

       
                System.out.print("Entrer le nom de P4 : ");
                String nom = keyboard.readLine();

                
                message = message + "-" + nom;

                out.writeObject(message);

                socket.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}