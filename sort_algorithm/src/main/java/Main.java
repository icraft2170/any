public class Main {

  public static void main(String[] args) {
    bubbleSort();
    selectionSort();
  }

  private static void bubbleSort() {
    Sort sort = new BubbleSort();

    int[] array = new int[] {6, 3, 2, 9, 7, 3};
    int[] sortedArray = sort.sorting(array);

    for (int i : sortedArray) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  private static void selectionSort() {
    Sort sort = new SelectionSort();

    int[] array = new int[] {6, 3, 2, 9, 7, 3};
    int[] sortedArray = sort.sorting(array);

    for (int i : sortedArray) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

}
