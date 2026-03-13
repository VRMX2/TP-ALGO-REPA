package test;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class client {
    public static void main(String[] args) {
        try{
            Socket s = new Socket("localhost",1234);

            PrintWriter out = new PrintWriter(client.getOutputStream());
            Scanner in = new Scanner(client.getInputStream());

            System.out.println("Connected!");

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
