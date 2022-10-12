package me.hero.parallel._1_outline;

public class Sequence {
  private int value;

  /**
   * synchronized 키워드를 통해 동기화
   */
  public synchronized int getNext() {
    return value++;
  }

}
