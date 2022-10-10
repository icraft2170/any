package basic;

import java.util.ArrayList;
import java.util.List;

public class TwoArraysProduct {
  public static void main(String[] args) {
    int[] array1 = {1, 2, 3};
    int[] array2 = {10, 100, 1000};
    List<Integer> products = twoNumberProducts(array1, array2);
    System.out.println("products = " + products);
  }

  private static List<Integer> twoNumberProducts(int[] array1, int[] array2) {
    List<Integer> products = new ArrayList<>();
    for (int i = 0; i < array1.length; i++) {
      for (int j = 0; j < array2.length; j++) {
        products.add(array1[i] * array2[j]);
      }
    }
    return products;
  }

}
