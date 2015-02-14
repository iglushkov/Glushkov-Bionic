
public class BinarySearch {

    public static void binary() {

        int[] arr = { 5, 22, 23, 43, 56, 62, 63, 70, 72, 125 };

        System.out.println("Binary. Элемент под индексом " + indx(56, arr));// вводим искомое число из массива
    }

    public static int indx(int value, int[] arr) {
        return indx(value, arr, 0, arr.length-1);
    }

    private static int indx(int value, int[] arr, int low, int high) {

        if (low > high) return -1;

        int mid = (low + (high - low) / 2);

        if (value < arr[mid]) {
            return indx(value, arr, low, mid - 1);
        } else if (value > arr[mid]) {
            return indx(value, arr, mid + 1, high);
        } else {
            return mid;
        }
    }
}
