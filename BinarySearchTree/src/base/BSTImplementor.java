package base;

public class BSTImplementor {
    public static void main(String[] args) {
        BST node = BSTBuilder.buildSampleBST();
        BSTIterator.inOrder(node);
        System.out.print("\n");
        BSTIterator.preOrder(node);
        System.out.print("\n");
        BSTIterator.postOrder(node);
        System.out.print("\n");
        BSTIterator.levelOrder(node);

        BST temp = BSTSearch.searchNodeData(node, 13);
       System.out.print("\n"+temp.data+"\t");
    }
}
