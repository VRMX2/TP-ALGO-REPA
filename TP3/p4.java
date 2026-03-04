package TP3;

import java.net.*;
import java.io.*;

public class p4 {

    public static void main(String[] args) {

        try {

            ServerSocket server = new ServerSocket(5004);

            System.out.println("P4 running...");

            while (true) {

                Socket socket = server.accept();

                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

                int N = (Integer) in.readObject();

                System.out.println("P4 received: " + N);

                N = N * 30;

                out.writeObject(N);

                socket.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}