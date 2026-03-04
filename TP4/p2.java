package TP4;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class p2 { // server
    public static void main(String[] args) {
        try {
            DatagramSocket s = new DatagramSocket(2004);

            byte[] receiveT = new byte[100];
            DatagramPacket q = new DatagramPacket(receiveT, receiveT.length);

            System.out.println("Server waiting...");

            s.receive(q);

            String ch = new String(q.getData(), 0, q.getLength());

            System.out.println("Received: " + ch +
                    " From: " + q.getAddress() +
                    " Port: " + q.getPort());

            String upper = ch.toUpperCase();
            byte[] sendData = upper.getBytes();

            DatagramPacket q1 = new DatagramPacket(sendData, sendData.length, q.getAddress(), q.getPort());

            s.send(q1);

            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}