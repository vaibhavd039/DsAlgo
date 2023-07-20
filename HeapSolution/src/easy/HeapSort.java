package easy;

import java.util.Arrays;

public class HeapSort {
    static int[] arr;

    public static int getLeft(int index) {
        return 2 * index + 1;
    }

    public static int getRight(int index) {
        return 2 * index + 1;
    }

    public static void main(String[] args) {

        arr = new int[10];
        int N = arr.length;

        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--)
            maxHeapify(i, N);

        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            maxHeapify(0,i);
        }

        Arrays.stream(arr).forEach(element->System.out.println(element));
    }

    public static void maxHeapify(int index, int N) {
        int largest = index;
        int left = getLeft(index);
        int right = getRight(index);
        if (left < N && arr[left] > arr[index]) {
            largest = left;
        }
        if (right < N && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != index) {
            int temp = arr[largest];
            arr[largest] = arr[index];
            arr[largest] = temp;
            maxHeapify(largest, N);
        }
    }
}
