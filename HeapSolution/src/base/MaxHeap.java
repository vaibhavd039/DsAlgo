package base;

public class MaxHeap {
    int size;
    int[] heapArray;

    int lastNodeIndex;

    MaxHeap(int size) {
        lastNodeIndex = 0;
        this.size = size;
        heapArray = new int[size];
    }

    public int getParent(int index) {
        return (index - 1) / 2;
    }

    public int getLeft(int index) {
        return 2 * index + 1;
    }

    public int getRight(int index) {
        return 2 * index + 2;
    }

    public void insertKey(int data) {
        int i = lastNodeIndex;
        heapArray[lastNodeIndex] = data;
        lastNodeIndex++;
        while (i != 0 && heapArray[getParent(i)] < heapArray[i]) {
            int temp = heapArray[i];
            heapArray[i] = heapArray[getParent(i)];
            heapArray[getParent(i)] = temp;
            i = getParent(i);
        }
    }

    public void updateKey(int index, int data) {
        heapArray[index] = data;
        while (index != 0 && heapArray[getParent(index)] < heapArray[index]) {
            int temp = heapArray[getParent(index)];
            heapArray[getParent(index)] = heapArray[index];
            heapArray[index] = temp;
            index++;
        }
    }

    public int removeMax() {
        if (lastNodeIndex < 0)
            return Integer.MIN_VALUE;
        if (size == 1) {
            lastNodeIndex--;
            return heapArray[0];
        }
        int node = heapArray[0];
        heapArray[0] = heapArray[lastNodeIndex - 1];
        lastNodeIndex--;
        maxHeapify(0);
        return node;
    }

    public void maxHeapify(int index) {
        int left = getLeft(index);
        int right = getRight(index);
        int largest = index;
        if (left < size && heapArray[left] > heapArray[index]) {
            largest = left;
        }
        if (right < size && heapArray[right] > heapArray[largest]) {
            largest = right;
        }
        if (largest != index) {
            int temp = heapArray[index];
            heapArray[index] = heapArray[largest];
            heapArray[largest] = temp;
            maxHeapify(largest);
        }
    }

    public void removeKey(int keyIndex) {
        updateKey(keyIndex, Integer.MAX_VALUE);
        removeMax();
    }

    public int getMax(){
        return heapArray[0];
    }

}
