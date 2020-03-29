import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        try (var socket = new Socket(InetAddress.getLocalHost(), 49000)) {
            System.out.println("Enter lines of text then Ctrl+D or Ctrl+C to quit");
            var scanner = new Scanner(System.in);
            var in = new Scanner(socket.getInputStream());
            var out = new PrintWriter(socket.getOutputStream(), true);
            while (scanner.hasNextLine()) {
                out.println(scanner.nextLine());
                System.out.println(in.nextLine());
                byte[] b= new byte[11111];
                InputStream is = socket.getInputStream();
                FileOutputStream fr = new FileOutputStream("C:\\test\\testOut.txt");
                is.read(b, 0, b.length);
                fr.write(b, 0, b.length);
            }

        }
    }
}