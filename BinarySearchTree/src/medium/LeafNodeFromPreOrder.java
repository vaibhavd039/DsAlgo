package medium;

import java.util.List;

public class LeafNodeFromPreOrder {
    static int i = 0;

    public static void main(String[] args) {
        List<Integer> mylist = List.of(890, 325, 290, 530, 965);
        printLeafs(mylist, mylist.size()-1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean printLeafs(List<Integer> preOrder, int size, int min, int max) {
        if (i > size)
            return false;
        if (preOrder.get(i) > min && preOrder.get(i) < max) {
            int current = preOrder.get(i);
            i++;
            boolean isLeftLeaf = printLeafs(preOrder, size, min, current - 1);
            boolean isRightLeaf = printLeafs(preOrder, size, current + 1, max);
            if (!isLeftLeaf && !isRightLeaf) {
                System.out.print(current +"\t");
            }
            return true;
        }
        return false;
    }
}
