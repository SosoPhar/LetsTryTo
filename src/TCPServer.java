import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public int port;
    public ServerSocket sSocket;

    public TCPServer(int port) {
        this.port = port;
        try {
            this.sSocket = new ServerSocket(port);
        } catch (IOException ex) {
            System.err.println("no Socket was created");
            System.exit(0);
        }
    }

    public Socket openConnection() {
        Socket socket = null;
        try {
            socket = sSocket.accept();
        } catch (Exception ex) {
            System.exit(0);
        }
        return socket;
    }
}