
public class SortingValues {

    public static void main(String[] args) {
        int[] arr = {45, 87, 39, 32, 93, 86, 12, 44, 75, 50};
        int temp = 0;

        // Display the original (unsorted values)
        System.out.print("before: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Swap the values around to put them ascending order.
        for (int x = 0; x < arr.length; x++) {
            for (int y = x + 1; y < arr.length; y++) {
                if (arr[x] > arr[y]) {
                    // swap the values in two slots
                    temp = arr[x];
                    arr[x] = arr[y];
                    arr[y] = temp;
                }
            }
        }

        // Display the values again, now (hopefully) sorted.
        System.out.print("after : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
