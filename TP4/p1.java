package TP4;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class p1 { // client
    public static void main(String[] args) {
        try {
            DatagramSocket s = new DatagramSocket();

            String ch = "RSD";
            byte[] sendT = ch.getBytes();

            InetAddress ip = InetAddress.getByName("192.168.233.156");

            DatagramPacket p = new DatagramPacket(sendT, sendT.length, ip, 2004);

            s.send(p);
            System.out.println("Message sent to server");

            byte[] receiveT = new byte[100];
            DatagramPacket p1 = new DatagramPacket(receiveT, receiveT.length);

            s.receive(p1);

            String ch1 = new String(p1.getData(), 0, p1.getLength());

            System.out.println("Received: " + ch1 +
                    " From: " + p1.getAddress() +
                    " Port: " + p1.getPort());

            s.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}