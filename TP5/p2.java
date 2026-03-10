package TP5;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class p2 {

    public static void main(String[] args) {

        try {

            ServerSocket server = new ServerSocket(2002);
            System.out.println("P2 running...");

            Scanner sc = new Scanner(System.in);

            while (true) {

            
                Socket socketP1 = server.accept();
                System.out.println("P1 connected.");

                ObjectInputStream inP1 = new ObjectInputStream(socketP1.getInputStream());

                ObjectOutputStream outP1 = new ObjectOutputStream(socketP1.getOutputStream());

                
                String ch = (String) inP1.readObject();

                System.out.println("P2 received from P1: " + ch);

          
                System.out.print("Enter your name: ");
                String name = sc.nextLine();

                String toSend = ch + " - " + name;

             
                DatagramSocket udpSocket = new DatagramSocket();

                byte[] sendBuffer = toSend.getBytes();

                InetAddress receiverAddress = InetAddress.getByName("192.168.203.156");

                DatagramPacket sendPacket = new DatagramPacket(sendBuffer,
                        sendBuffer.length,
                        receiverAddress,
                        2004);

                udpSocket.send(sendPacket);

                System.out.println("P2 sent to P3 via UDP: " + toSend);

                byte[] receiveBuffer = new byte[1024];

                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);

                udpSocket.receive(receivePacket);

                String result = new String(receivePacket.getData(),
                        0,
                        receivePacket.getLength());

                System.out.println("P2 received from P3: " + result);

               
                outP1.writeObject(result);
                outP1.flush();

                System.out.println("P2 sent result back to P1 via TCP.");

                
                udpSocket.close();
                inP1.close();
                outP1.close();
                socketP1.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}