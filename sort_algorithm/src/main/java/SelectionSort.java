public class SelectionSort implements Sort{

  @Override
  public int[] sorting(int[] array) {
    int length = array.length;
    if (length < 2) return array;

    // 왼쪽 맨 끝부터 각 인덱스에 알 맞은 값을 넣기 위해 순회한다.
    for (int i = 0; i < length; i++) {
      int min = i;
      for (int j = i; j < length; j++) {
        if (array[min] == array[j]) continue;
        if (array[min] > array[j]) min = j;
      }
      int temp = array[i];
      array[i] = array[min];
      array[min] = temp;
    }
    return array;
  }
}
