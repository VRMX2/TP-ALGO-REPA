import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class p2 { // Server
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.println("Creating service on port 2004...");
            ServerSocket s = new ServerSocket(2004);

            while (true) {
                System.out.println("Waiting for connection...");
                Socket connection = s.accept();
                System.out.println("Accepted connection from: "
                        + connection.getInetAddress());

                new Thread(() -> handleClient(connection)).start();
            }

        } catch (Exception e) {
            System.out.println("Server Exception: " + e.toString());
        }
    }

    static void handleClient(Socket connection) {
        try {
            ObjectInputStream in = new ObjectInputStream(connection.getInputStream());
            String ch = (String) in.readObject();
            System.out.println("Received from client: " + ch);

            System.out.print("Type your reply message: ");
            String myMessage = sc.nextLine();

            ObjectOutputStream out = new ObjectOutputStream(connection.getOutputStream());
            out.writeObject(myMessage);
            out.flush();

            in.close();
            out.close();
            connection.close();
            System.out.println("Connection closed.\n");

        } catch (Exception e) {
            System.out.println("Client handler exception: " + e.toString());
        }
    }
}