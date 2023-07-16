package hard;

//Given an integer ‘K’ and a binary tree in string format. Every node of a tree has a value in the range of 0 to 9.
// We need to find the sum of elements at the K-th level from the root. The root is at level 0.
//        Tree is given in the form: (node value(left subtree)(right subtree))
public class SumOfKthLevel {
    public static void main(String[] args) {
        String tree = "(0(5(6()())(4()(9()())))(7(1()())(3()())))";
        int k = 2;
        System.out.print(getSum(tree, k));
    }

    public static int getSum(String tree, int k) {
        if (tree == null)
            return 0;
        int level = -1;
        int sum = 0;
        for (int i = 0; i < tree.length(); i++) {
            if (tree.charAt(i) == '(') {
                level++;
            } else if (tree.charAt(i) == ')') {
                level--;
            } else {
                if (level == k) {
                    sum += Character.getNumericValue(tree.charAt(i));
                }
            }
        }
        return sum;
    }


}
