package basic;

import java.util.ArrayList;
import java.util.List;

public class MarkInventory {

  public static void main(String[] args) {
    String[] items = new String[]{"Purple Shirt", "Green Shirt"};
    List<String> options = markInventory(items);
    for (String option : options) {
      System.out.println(option);
    }
  }

  private static List<String> markInventory(String[] items) {
    List<String> options = new ArrayList<>();
    for (String item : items) {
      for (int size = 1; size < 6; size++) {
        String str = item + " Size : " + size;
        options.add(str);
      }
    }
    // 중첩 반복문이지만 사실 5N 의 알고리즘
    return options;
  }
}
