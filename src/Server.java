import java.net.*;
import java.io.*;
import java.util.*;

public class Server implements Runnable {

    Socket socket;
    static ServerSocket s;

    public static Vector<BufferedWriter> client = new Vector<>();

    public Server(Socket socket) {
        try {
            this.socket = socket;
        } catch (Exception e) {
        }
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            client.add(writer);

            while (true) {
                String data = reader.readLine().trim();

                for (int i = 0; i < client.size(); i++) {
                    try {
                        BufferedWriter bw = (BufferedWriter) client.get(i);
                        bw.write(data);
                        bw.write("\r");
                        bw.flush();
                    } catch (Exception e) {
                    }
                }

            }
        } catch (Exception e) {
        }

    }

    public static void main(String[] args) throws Exception {
        System.out.println("Server is running...");

        s = new ServerSocket(3003);
        while (true) {
            Socket socket = s.accept();
            Server server = new Server(socket);
            Thread thread = new Thread(server);
            thread.start();
        }
    }
}
