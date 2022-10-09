public class SelectionSort implements Sort{

  @Override
  public int[] sorting(int[] array) {
    int length = array.length;
    if (length < 2) return array;

    // 왼쪽 맨 끝부터 각 인덱스에 알 맞은 값을 넣기 위해 순회한다.
    for (int i = 0; i < length; i++) {
      // 가장 작은 값을 가진 인덱스를 기록해둔다.
      int min = i;
      // 시작 인덱스부터 배열의 끝까지 순회를 돌면서 가장 작은 값의 인덱스를 찾고 시작 값과 교체한다.
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
