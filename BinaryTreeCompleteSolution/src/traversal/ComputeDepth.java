package traversal;
//Calculate depth of a full Binary tree from Preorder

public class ComputeDepth {
    public static void main(String[] args) {
        String preOrder = "nlnll";
        System.out.print(getDepth(preOrder, preOrder.length(), 0));
    }

    public static int getDepth(String tree, int n, int index) {
        if (index >= n || tree.charAt(index) == 'l') {
            return 0;
        }
        index++;
        int left = getDepth(tree, n, index);
        index++;
        int right = getDepth(tree, n, index);
        return Math.max(left, right) + 1;
    }

}
