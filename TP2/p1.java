import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class p1 { // Client 1
    public static void main(String[] args) {
        try {
            System.out.println("Demande de connexion...");
            Socket c = new Socket("localhost", 2004);
            System.out.println("Connected!");

            ObjectOutputStream out = new ObjectOutputStream(c.getOutputStream());
            out.writeObject("RSD");
            out.flush();
            ObjectInputStream in = new ObjectInputStream(c.getInputStream());
            String response = (String) in.readObject();
            System.out.println("Server replied: " + response);

            in.close();
            out.close();
            c.close();

        } catch (Exception e) {
            System.out.println("Exception: " + e.toString());
        }
    }
}