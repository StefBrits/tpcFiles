import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerCalled implements Runnable{
    private Socket socket;
    public ServerCalled(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        System.out.println("Connected: " + socket);
        try {
            var in = new Scanner(socket.getInputStream());
            var out = new PrintWriter(socket.getOutputStream(), true);
            while (in.hasNextLine()) {
                if (in.nextLine().equals("Geef me de file")) {
                    out.println("file in C://test gedropt.");
                    FileInputStream fr = new FileInputStream("C:\\test\\test1.txt");
                    byte b[] = new byte[11111];
                    fr.read(b, 0, b.length);
                    OutputStream os = socket.getOutputStream();
                    os.write(b, 0, b.length);
                }
            }
        } catch (Exception e) {
            System.out.println("Error:" + socket);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
            }
            System.out.println("Closed: " + socket);
        }
    }
}

