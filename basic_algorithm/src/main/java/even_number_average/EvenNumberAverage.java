package even_number_average;

public class EvenNumberAverage {

  public static void main(String[] args) {
    int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    double average =  averageOfEvenNumbers(array);
    System.out.println("average = " + average);
  }

  private static double averageOfEvenNumbers(int[] array) {
    double sum = 0.0; // 1
    int count = 0; // 2
    // N은 array 의 요소 개수
    for (int i : array) {
      if (isEven(i)) { // N번 비교
        sum += i; // N 번 더하기
        count++; // N 번 더하기
      }
    } // 3N
    return sum/count; // 3
  }
  // 즉 O(3N + 3) => O(N) 의 시간복잡도를 갖는다.

  private static boolean isEven(int number) {
    return number % 2 == 0;
  }


}
