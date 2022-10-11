import static org.junit.jupiter.api.Assertions.*;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateByteBufferTest {

  @Test
  void createTest() {
    CharBuffer heapBuffer = CharBuffer.allocate(11);
    assertEquals(11, heapBuffer.capacity());
    assertEquals(false, heapBuffer.isDirect());


    ByteBuffer directBuffer = ByteBuffer.allocateDirect(11);
    assertEquals(11, directBuffer.capacity());
    assertEquals(true, directBuffer.isDirect());


    int[] array = {1, 2, 3,4,5,6,7,8,9,0,0};
    IntBuffer intHeapBuffer = IntBuffer.wrap(array);
    assertEquals(11, intHeapBuffer.capacity());
    assertEquals(false, intHeapBuffer.isDirect());
  }
}
