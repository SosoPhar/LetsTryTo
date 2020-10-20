import java.io.*;
import java.net.Socket;

public class Stream {
    public static void main(String[] args) {
        TCPServer ayServer = new TCPServer(7777);
        Socket connectingSocket = ayServer.openConnection();
        InputStream is = null;
        try {
            is = connectingSocket.getInputStream();
        } catch (Exception ex) {
            System.err.println("couldn’t open file - fatal");
            System.exit(0);
        }
        byte[] readBuffer = new byte[1];
        try {
            is.read(readBuffer);
        } catch (Exception ex) {
            System.err.println("couldn’t open file - fatal");
            System.exit(0);
        }
        String text = "Hello Sopha";
        byte[] textAsByte = text.getBytes();
        OutputStream os = null;
        try {
            os = connectingSocket.getOutputStream();
            os.write(textAsByte);
        } catch (Exception ex) {
            System.err.println("couldn’t create output- fatal");
            System.exit(0);
        }
        try {
            Thread.sleep(100000);
        } catch (Exception ex) {
            System.err.println("couldn’t fall asleep- fatal");
            System.exit(0);
        }
        try {
            os.close();
        } catch (Exception ex) {
            System.err.println("couldn’t close - fatal");
            System.exit(0);
        }
    }
}
