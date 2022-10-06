package introduce.blocking_nonblocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class NonBlockingServer {
  private Map<SocketChannel, List<byte[]>> keepDataTrack = new HashMap<>();
  private ByteBuffer buffer = ByteBuffer.allocate(2 * 1024);

  private void startEchoServer() {
    try (
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()
    ) {

      if ((serverSocketChannel.isOpen()) && selector.isOpen()) {
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(8888));

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("접속 대기중");
        while (true) {
          selector.select();
          Iterator<SelectionKey> keys = selector.selectedKeys().iterator();

          while (keys.hasNext()) {
            SelectionKey key = keys.next();
            keys.remove();

            if (!key.isValid()) {
              continue;
            }

            if (key.isAcceptable()) {
              this.acceptOp(key, selector);
            } else if (key.isReadable()) {
              this.readOp(key);
            } else if (key.isWritable()) {
              this.writeOp(key);
            }
          }
        }
      } else {
        System.out.println("서버 소켓을 생성하지 못했습니다.");
      }

    } catch (IOException exception) {
      System.err.println(exception);
    }
  }

  private void writeOp(SelectionKey key) throws IOException {
    SocketChannel socketChannel = (SocketChannel) key.channel();

    List<byte[]> channelData = keepDataTrack.get(socketChannel);
    Iterator<byte[]> its = channelData.iterator();
    while (its.hasNext()) {
      byte[] it = its.next();
      its.remove();
      socketChannel.write(ByteBuffer.wrap(it));
    }
    key.interestOps(SelectionKey.OP_READ);
  }

  private void readOp(SelectionKey key) {
    try {
      SocketChannel socketChannel = (SocketChannel) key.channel();
      buffer.clear();
      int numRead = -1;
      try {
        numRead = socketChannel.read(buffer);
      } catch (IOException exception) {
        System.out.println("데이터 읽기 에러");
      }

      if (numRead == -1) {
        this.keepDataTrack.remove(socketChannel);
        System.out.println("클라이언트 연결 종료 : " + socketChannel.getRemoteAddress());
        socketChannel.close();
        key.cancel();
        return;
      }
      byte[] data = new byte[numRead];
      System.arraycopy(buffer.array(), 0 , data, 0, numRead);
      System.out.println(new String(data, "UTF-8") + " from " + socketChannel.getRemoteAddress());
      doEchoJob(key, data);
    } catch (IOException exception) {
      System.err.println(exception);
    }
  }

  private void doEchoJob(SelectionKey key, byte[] data) {
    SocketChannel socketChannel = (SocketChannel) key.channel();
    List<byte[]> channelData = keepDataTrack.get(socketChannel);
    channelData.add(data);

    key.interestOps(SelectionKey.OP_WRITE);
  }

  private void acceptOp(SelectionKey key, Selector selector) throws IOException{
    ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
    SocketChannel socketChannel = serverChannel.accept();
    socketChannel.configureBlocking(false);

    System.out.println("클라이언트 연결됨 : " + socketChannel.getRemoteAddress());

    keepDataTrack.put(socketChannel, new ArrayList<byte[]>());
    socketChannel.register(selector, SelectionKey.OP_READ);
  }

  public static void main(String[] args) {
    NonBlockingServer main = new NonBlockingServer();
    main.startEchoServer();
  }

}
