package TP3;

import java.net.*;
import java.io.*;

public class p2 {

    public static void main(String[] args) {

        try {

            ServerSocket server = new ServerSocket(5002);

            System.out.println("P2 running...");

            while (true) {

                Socket socketP1 = server.accept();

                ObjectInputStream inP1 = new ObjectInputStream(socketP1.getInputStream());

                ObjectOutputStream outP1 = new ObjectOutputStream(socketP1.getOutputStream());

                int N = (Integer) inP1.readObject();

                System.out.println("P2 received: " + N);

                N = N * 10;

                Socket socketP3 = new Socket("localhost", 5003);

                ObjectOutputStream outP3 = new ObjectOutputStream(socketP3.getOutputStream());

                ObjectInputStream inP3 = new ObjectInputStream(socketP3.getInputStream());

                outP3.writeObject(N);

                int result = (Integer) inP3.readObject();

                outP1.writeObject(result);

                socketP3.close();
                socketP1.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}