package introduce.blocking_nonblocking;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BlockingServer {

  public static void main(String[] args) throws IOException {
    BlockingServer server = new BlockingServer();
    server.run();
  }

  private void run() throws IOException {
    ServerSocket server = new ServerSocket(8888);
    System.out.println("접속 대기중");

    while (true) {
      //Bocking 지점 - 클라이언트의 요청이 있을 때 까지 멈춰있는다.
      Socket socket = server.accept();
      System.out.println("클라이언트 연결됨");

      InputStream in = socket.getInputStream();
      OutputStream out = socket.getOutputStream();

      while (true) {
        try {
          int reuqest = in.read();
          out.write(reuqest);
        } catch (IOException ex) {
          break;
        }
      }
    }
  }

}
