package TP3;

import java.net.*;
import java.io.*;

public class p3 {

    public static void main(String[] args) {

        try {

            ServerSocket server = new ServerSocket(5003);

            System.out.println("P3 running...");

            while (true) {

                Socket socketP2 = server.accept();

                ObjectInputStream inP2 = new ObjectInputStream(socketP2.getInputStream());

                ObjectOutputStream outP2 = new ObjectOutputStream(socketP2.getOutputStream());

                int N = (Integer) inP2.readObject();

                System.out.println("P3 received: " + N);

                N = N * 20;

                Socket socketP4 = new Socket("localhost", 5004);

                ObjectOutputStream outP4 = new ObjectOutputStream(socketP4.getOutputStream());

                ObjectInputStream inP4 = new ObjectInputStream(socketP4.getInputStream());

                outP4.writeObject(N);

                int result = (Integer) inP4.readObject();

                outP2.writeObject(result);

                socketP4.close();
                socketP2.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}