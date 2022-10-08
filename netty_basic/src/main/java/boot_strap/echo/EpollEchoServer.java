package boot_strap.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollServerSocketChannel;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.oio.OioServerSocketChannel;

public class EpollEchoServer {

  public static void main(String[] args) {
    // Thread 의 최대 개수
    EventLoopGroup bossGroup = new EpollEventLoopGroup(1);
    // 인수 없는 생성자의 스레드 수는 애플리케이션이 동작하는 "하드웨어의 코어 수 * 2" 를 기준으로 한다.
    EventLoopGroup workerGroup = new EpollEventLoopGroup();
    try {
      ServerBootstrap bootstrap = new ServerBootstrap();
      bootstrap.group(bossGroup, workerGroup) // 첫 번째 인수는 클라이언트의 연결 요청을 받는 스레드이고 두번 째 스레드는 이벤트(소켓의 I/O)를 처리하는 스레드 그룹이다.
          .channel(EpollServerSocketChannel.class)
          .childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) {
              ChannelPipeline pipeline = ch.pipeline();
              pipeline.addLast(new EchoServerHandler());
            }
          });
      ChannelFuture future = bootstrap.bind(8888).sync();
      future.channel().closeFuture().sync();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } finally {
      workerGroup.shutdownGracefully();
      bossGroup.shutdownGracefully();
    }
  }

}
