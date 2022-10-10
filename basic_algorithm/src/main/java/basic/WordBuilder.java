package basic;

import java.util.ArrayList;
import java.util.List;

/**
 * 배열의 모든 문자를 조합해서 만들 수 있는 모든 단어의 조합 생성기
 */
public class WordBuilder {
  public static void main(String[] args) {
    char[] array = new char[]{'a', 'b', 'c', 'd'};
    List<String> words = wordBuilder(array);
    words.forEach(word -> System.out.print(word + " "));
  }

  private static List<String> wordBuilder(char[] array) {
    List<String> wordArray = new ArrayList<>(); // 1
    for (char ch1 : array) {
      for (char ch2 : array) {
        if (ch1 != ch2) { // 이중포문 즉, N^2 비교
          wordArray.add(String.valueOf(ch1) + ch2); // 최악의 경우 N^2 - N 번 추가
        }
      }
    }
    return wordArray; // 2
  }
  // O(2N^2 -N + 2) 즉, O(N^2)
}
