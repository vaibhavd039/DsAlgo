package traversal_rev;

import intro.BinaryTree;
import intro.BinaryTreeBuilder;

import java.util.List;
import java.util.Stack;

public class PreOrderIterative {
    public static void main(String [] args){
    BinaryTree root = BinaryTreeBuilder.buildBinaryTree(List.of(1,2,3,4,5,6,7,8,9));
        iterativePreOrder(root);
}
public static void iterativePreOrder(BinaryTree node){
        if(node==null)
            return;
    Stack<BinaryTree> st = new Stack<>();
    st.push(node);
    while(!st.isEmpty()){
        BinaryTree temp = st.pop();
        if(temp==null)
            continue;
        System.out.print(temp.data+"\t");
        st.push(temp.right);
        st.push(temp.left);
    }
}
}
