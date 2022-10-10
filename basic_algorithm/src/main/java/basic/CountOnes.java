package basic;

public class CountOnes {
  public static void main(String[] args) {
    int[][] numbers = {
        {0, 1, 1, 1, 0},
        {0, 1, 0, 1, 0, 1},
        {1, 0}
    };
    int count = countOnes(numbers);
    System.out.println("count = " + count);
  }

  private static int countOnes(int[][] numbers) {
    int count = 0; // 1
    for (int i = 0; i < numbers.length; i++) {
      for (int j = 0; j < numbers[i].length; j++) {
        if (numbers[i][j] == 1) count++;
      }
    } // 총 13개의 요소를 가지고 있는 이차원 배열을 전부 순회하는 중첩 포문은 O(N^2)이 아닌 O(N)이다.
    return count;
  }
}
