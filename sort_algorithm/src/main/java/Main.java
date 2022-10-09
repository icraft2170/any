public class Main {

  public static void main(String[] args) {
    Sort sort = new BubbleSort();

    int[] array = new int[] {6, 3, 2, 9, 7};
    int[] sortedArray = sort.sorting(array);

    for (int i : sortedArray) {
      System.out.print(i + " ");
    }
  }

}
