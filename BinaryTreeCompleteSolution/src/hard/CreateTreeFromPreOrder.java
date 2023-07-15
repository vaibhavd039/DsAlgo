package hard;

import base.BinaryTree;
import base.BinaryTreeIterator;

import java.util.List;

class Index{
    int index=0;
}
public class CreateTreeFromPreOrder {


    public static void main(String[] args) {
        List<Integer> pre = List.of(10, 30, 20, 5, 15);
        List<Character> preNl =List.of('N', 'N', 'L', 'L', 'L');
        BinaryTree node = buildTree(pre, preNl, pre.size(), new Index());
        BinaryTreeIterator.levelOrderTraversal(node);

    }

    public static BinaryTree buildTree(List<Integer> pre, List<Character> preNL, int size, Index index) {
        if(index.index>=size){
            return null;
        }
        BinaryTree node = new BinaryTree(pre.get(index.index));

        if(preNL.get(index.index)=='N'){
            index.index++;
            node.left= buildTree(pre, preNL,size, index);
            node.right= buildTree(pre, preNL, size, index);
        } else {
            index.index++;
        }
        return node;
    }
}
