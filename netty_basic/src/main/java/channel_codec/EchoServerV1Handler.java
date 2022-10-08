package channel_codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.EventExecutorGroup;
import java.nio.charset.Charset;

public class EchoServerV1Handler extends ChannelInboundHandlerAdapter {

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    ByteBuf readMessage = (ByteBuf) msg;
    System.out.println("channelRead : " + readMessage.toString(Charset.defaultCharset()));
    ctx.writeAndFlush(msg);
  }
}
