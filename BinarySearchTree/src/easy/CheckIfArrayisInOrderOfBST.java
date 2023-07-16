package easy;

public class CheckIfArrayisInOrderOfBST {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.print(checkIfArrayIsInorderOfBST(arr));

    }

    public static boolean checkIfArrayIsInorderOfBST(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
                if(arr[i]>arr[i+1]){
                    return false;
                }
        }
        return true;
    }

}
