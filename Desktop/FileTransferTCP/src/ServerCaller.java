import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.Executors;

public class ServerCaller {
    public static void main(String[] args) throws IOException {
        var listener = new ServerSocket(49000);
        System.out.println("Server is running baby..");
        var threadPool = Executors.newFixedThreadPool(10);
        while(true) {
            threadPool.execute(new ServerCalled(listener.accept()));
        }
    }
}

