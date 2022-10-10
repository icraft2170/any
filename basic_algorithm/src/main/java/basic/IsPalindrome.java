package basic;

public class IsPalindrome {
  public static void main(String[] args) {
    String word = "기러기";
    if (isPalindrome(word)) {
      System.out.println("앞 뒤가 똑같은 단어에요 ~! 앞 뒤가 똑같은 단어에요~!!");
    } else {
      System.out.println("앞 뒤가 다른 단어에요 ~! 앞 뒤가 다른 단어에요~!!");
    }
  }

  private static boolean isPalindrome(String word) {
    int leftIndex = 0;
    int rightIndex = word.length() - 1;
    while (leftIndex < word.length() / 2) {
      if (word.charAt(leftIndex) != word.charAt(rightIndex)) {
        return false;
      }
      leftIndex++;
      rightIndex--;
    }
    return true;
  }

}
