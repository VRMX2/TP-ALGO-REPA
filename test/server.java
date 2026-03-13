package test;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {
    public static void main(String[] args) {
        try{
            ServerSocket s = new ServerSocket(1234);
            System.out.println("Server is running");
            while(true){
                Socket client = s.accept();
                PrintWriter out = new PrintWriter(client.getOutputStream());
                Scanner in = new Scanner(client.getInputStream());

                String ch = in.nextLine();
                ch = ch.toUpperCase();
                out.println(ch);
                out.flush();
                out.close();

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
