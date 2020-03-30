import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main_Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6969);
        while(true){
                Socket socket = serverSocket.accept();
                Socket_Handler socket_handler = new Socket_Handler(socket);
                socket_handler.start();
        }

    }
}
