package hard;
//Inorder predecessor and successor for a given key in BST

import base.BST;
import base.BinaryTreeToBSTBuilder;

public class InOrderSuccAndPreForGivenKey {
    static int pre = -1;
    static int suc = -1;

    public static void main(String[] args) {
        BST node = BinaryTreeToBSTBuilder.buildSamplerBST();
        preAndSuc(node, 5);
        System.out.print(pre+"\t"+suc);
    }

    public static void preAndSuc(BST node, int key) {
        if (node == null)
            return;
        if (node.data == key) {
            BST temp = null;
            if (node.left != null) {
                temp = node.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                pre = temp.data;
            }
            if (node.right != null) {
                temp = node.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                suc = temp.data;
            }


        } else if (node.data < key) {
            pre=node.data;
            preAndSuc(node.right, key);
        } else {
            suc=node.data;
            preAndSuc(node.left, key);
        }

    }

}
