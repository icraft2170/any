package channel_codec;

import introduce.echo.EchoServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class EchoServer {

  public static void main(String[] args) {
    NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
    NioEventLoopGroup workerGroup = new NioEventLoopGroup();
    try {
      ServerBootstrap bootstrap = new ServerBootstrap();
      bootstrap.group(bossGroup, workerGroup)
          .channel(NioServerSocketChannel.class)
          .childHandler(new ChannelInitializer<SocketChannel>() { // ChileHandler 메서드를 통해 연결된 클라이언트 소켓 채널이 사용할 채널 파이프라인을 설정
            @Override
            protected void initChannel(SocketChannel ch) { // 채널 파이프라인의 설정을 수행한다.
              ChannelPipeline pipeline = ch.pipeline(); // 소켓 채널에 연결된 채널 파이프라인을 가져온다.
              pipeline.addLast(new EchoServerHandler()); // 채널 파이프라인에 이벤트핸들러를 등록한다.
            }
          });
    } catch (Exception exception) {}
    finally {
      workerGroup.shutdownGracefully();
      bossGroup.shutdownGracefully();
    }


  }

}
