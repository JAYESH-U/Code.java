package TCP;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TcpEchoClient {
    private final static String HOSTNAME = "localhost";
    private final static int PORT = 8080;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        try (
            Socket clientSocket = new Socket(HOSTNAME, PORT);
            InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
            BufferedReader in = new BufferedReader(isr);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        ) {
            System.out.println("Connected to " + HOSTNAME + " on port " + PORT);

            // String data = "Hello\nJayesh\nBye";

            
            String data = new String();
            while (!data.equals("Bye")) {
                System.out.print("Enter: ");
                data = sc.nextLine();
                
                System.out.println("Sending to server: " + data);
                out.println(data);
            }
            
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Client received: " + line);
            }
        }
        sc.close();
    }
}
