package me.hero.parallel._1_outline;

import me.hero.parallel.common.NotThreadSafe;

/**
 * 동시에 다수의 스레드가 getNext() 를 요청하면
 * value 값에 같이 접근하여 정확한 값을 뱉어내지 못할 수 도 있다.
 */
@NotThreadSafe
public class UnsafeSequence {
  private int value;

  public int getNext() {
    /**
     * 해당 지점에서 Race Condition (경쟁 조건) 발생.
     */
    // Critical Section -----
    return value++;
    //-----------------------
  }
}
