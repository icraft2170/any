
public class BubbleSort implements Sort {
  @Override
  public int[] sorting(int[] array) {
    int length = array.length;
    if (length < 2) return array;

    for (int i = length - 1; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        if (array[j] >= array[j + 1]) {
          int temp = array[j + 1];
          array[j + 1] = array[j];
          array[j] = temp;
        }
      }
    }

    return array;
  }
}
