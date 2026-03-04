package TP3;

import java.net.*;
import java.io.*;

public class p1 {

    public static void main(String[] args) {

        try {

            BufferedReader keyboard = new BufferedReader(
                    new InputStreamReader(System.in));

            while (true) {

                System.out.print("\nEnter N: ");

                int N = Integer.parseInt(keyboard.readLine());

                Socket socket = new Socket("localhost", 5002);

                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

                out.writeObject(N);

                int result = (Integer) in.readObject();

                System.out.println("Result = " + result);

                socket.close();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}