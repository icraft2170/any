import static org.junit.jupiter.api.Assertions.*;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.Unpooled;
import java.util.Collections;
import java.util.EnumSet;
import org.junit.jupiter.api.Test;

public class CreateByteBufferNettyTest {

  @Test
  void createUnpooledHeapBufferTest() {
    ByteBuf buf = Unpooled.buffer(11);
    testBuffer(buf,false);
  }

  @Test
  void createUnpooledDirectBufferTest() {
    ByteBuf buf = Unpooled.directBuffer(11);
    testBuffer(buf,true);
  }

  @Test
  void createPooledHeapBufferTest() {
    ByteBuf buf = PooledByteBufAllocator.DEFAULT.heapBuffer(11);
    testBuffer(buf,false);
  }

  @Test
  void createPooledDirectBufferTest() {
    ByteBuf buf = PooledByteBufAllocator.DEFAULT.directBuffer(11);
    testBuffer(buf,true);
    StackWalker
  }

  private void testBuffer(ByteBuf buf, boolean isDirect) {
    assertEquals(11, buf.capacity());
    assertEquals(isDirect, buf.isDirect());

    assertEquals(0, buf.readableBytes());
    assertEquals(11, buf.writableBytes());
  }
}
