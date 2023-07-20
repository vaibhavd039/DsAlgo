package hard;

import base.BST;
import base.BinaryTreeToBSTBuilder;

import java.util.ArrayList;
import java.util.List;

public class SpecialTwoDigit {
   static List<Integer> mylist = new ArrayList<>();

    public static void main(String[] args) {
        BST node = BinaryTreeToBSTBuilder.buildSamplerBST();
        generateTwoDigit(node);
        mylist.stream().forEach(elemenet-> System.out.print(elemenet+"\t"));
    }

    public static void generateTwoDigit(BST node) {
        if (node == null)
            return;
        generateTwoDigit(node.left);
        if(ifSpecialNumber(node.data)){
            mylist.add(node.data);
        }
        generateTwoDigit(node.right);
    }

    static boolean ifSpecialNumber(Integer num) {
        if (num < 10 || num > 99) {
            return false;
        }
        int first = num / 10;
        int second = num % 10;
        return  ((first+second) + (first*second)) ==num;
    }
}
