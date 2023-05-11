package medium;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;

import java.util.List;
import java.util.Stack;

class Pair<K, V> {

    private final K firs;
    private final V second;

    public static <K, V> Pair<K, V> createPair(K element0, V element1) {
        return new Pair<K, V>(element0, element1);
    }

    public Pair(K element0, V element1) {
        this.firs = element0;
        this.second = element1;
    }

    public K getFirs() {
        return firs;
    }

    public V getSecond() {
        return second;
    }

}
public class PrintRootToLeaf {
    public static void main(String [] args) {
        BinaryTree node = BinaryTreeBuilder.buildBinaryTree(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        printThePath(node);
    }

    public static void printThePath(BinaryTree node) {
        if(node==null)
            return;
        String path = "";
        Stack<Pair<BinaryTree, String>> stack = new Stack<>();
        stack.push(new Pair<>(node, path));
        while(!stack.isEmpty()){
            Pair<BinaryTree, String> temp = stack.pop();
            BinaryTree tempNode = temp.getFirs();
            if(tempNode==null)
                continue;
            String currPath = temp.getSecond();
            String curr = tempNode.data +"\t";
            currPath = currPath+curr;
            if(tempNode.left==null && tempNode.right==null){
                System.out.println(currPath);
                continue;
            }
            if(tempNode.right!=null){
                stack.push(new Pair<>(tempNode.right, currPath));
            }
            if(tempNode.left!=null){
                stack.push(new Pair<>(tempNode.left, currPath));
            }

        }
    }

}
