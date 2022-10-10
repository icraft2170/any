package basic;

import java.util.ArrayList;
import java.util.List;

public class AverageCelsius {
  public static void main(String[] args) {
    int[] array = new int[]{101, 102, 103, 104, 105, 106, 107, 108, 109, 110};
    Double average = averageCelsius(array); // 약 O(2N..) -> 즉 O(N)
    System.out.println("average = " + average);
  }

  private static Double averageCelsius(int[] array) {
    List<Double> celsiusNumbers = new ArrayList<>(); // 1

    for (int i : array) {
      celsiusNumbers.add(celsiusConversion(i)); // N번의 작업
    }

    Double sum = 0.0; //2

    for (Double celsiusNumber : celsiusNumbers) {
      sum += celsiusNumber; // N번의 작업
    }
    return sum / celsiusNumbers.size(); //3
  }

  private static double celsiusConversion(int i) {
    return (i - 32) / 1.8;
  }

}
