package lesson180124;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketExample {

    public static final int PORT = 10000;

    public static void main(String[] args) throws Exception {

        ServerSocket ss = new ServerSocket(PORT);
        System.out.println("waiting");
        Socket s = ss.accept();
        System.out.println("Connected: "+s);

        try (ObjectInputStream ois = new ObjectInputStream(s.getInputStream())){
            Cat c = (Cat) ois.readObject();
            System.out.println("Received " + c);
            Object o = ois.readObject();
            System.out.println("and " + o);
        }
        s.close();

    }
}
