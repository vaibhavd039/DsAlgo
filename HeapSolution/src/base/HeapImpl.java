package base;

public class HeapImpl {
    public static void main(String[] args) {
        MaxHeap mx = new MaxHeap(5);
        mx.insertKey(1);
        mx.insertKey(2);
        mx.insertKey(3);
        mx.insertKey(4);
        mx.insertKey(5);
        System.out.println(mx.getMax());
        mx.removeKey(2);
        mx.removeKey(0);
        System.out.println(mx.getMax());
    }
}
