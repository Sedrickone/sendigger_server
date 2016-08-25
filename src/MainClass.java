import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by ОБИ on 25.08.2016.
 */
public class MainClass {
    static final int SOCKET_PORT=8849;
    public static void main(String[] args) {
        try {

            //Создадим сервер
            ServerSocket s=new ServerSocket(SOCKET_PORT);
            Socket socket=s.accept();

            //исходящий поток
            PrintWriter pw=new PrintWriter(socket.getOutputStream());

            //входящий поток
            Scanner sc=new Scanner(socket.getInputStream());

            while (sc.hasNext()){
                String w=sc.nextLine();
                pw.println("echo:  "+w);
                pw.flush();

                if (w.equals("END"))break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
