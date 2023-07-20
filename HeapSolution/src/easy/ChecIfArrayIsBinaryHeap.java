package easy;

public class ChecIfArrayIsBinaryHeap {
    public static void main(String[] args) {
        int arr[] = { 90, 15, 10, 7, 12, 2, 7, 3 };
        int n = arr.length - 1;
        if (isBinaryHeap(arr, 0, n)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }

    public static boolean isBinaryHeap(int[] arr, int index, int size) {
        if (index > size)
            return true;
        int left = (2 * index) + 1;
        int right = (2 * index) + 2;
        if(left<size && arr[left]>arr[index]){
            return false;
        }
        if(left<size && arr[right]>arr[index]){
            return false;
        }
        return isBinaryHeap(arr, left, size) && isBinaryHeap(arr,right, size);
    }
}
