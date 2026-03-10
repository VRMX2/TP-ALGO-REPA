package TP5;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

public class p3 {

    public static void main(String[] args) {

        try {

            DatagramSocket s = new DatagramSocket(2004);
            byte[] ReceiveT = new byte[50];
            DatagramPacket q = new DatagramPacket(ReceiveT, ReceiveT.length);
            s.receive(q);
            String ch = new String(q.getData());
            ch = ch.trim();
            System.out.println("Receive:" + ch + " From:" + q.getAddress() + "Port:" + q.getPort());

            System.out.println("Creation de service sur le port 2005");
            ServerSocket s1 = new ServerSocket(2005);
            System.out.println("Waiting .....");
            Socket connection = s1.accept();
            System.out.println("Accpeted ....");

            ObjectOutputStream out = new ObjectOutputStream(connection.getOutputStream());
            out.writeObject(" Message :" + ch + "-YOUR NAME-");

            ObjectInputStream in = new ObjectInputStream(connection.getInputStream());

            String chi = (String) in.readObject();
            System.out.println("Ch = " + chi);

            byte[] dataToSend = chi.getBytes();

            DatagramPacket q1 = new DatagramPacket(dataToSend, dataToSend.length, q.getAddress(), q.getPort());

            s.send(q1);
            System.out.println("Message Sent");

            in.close();
            out.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}