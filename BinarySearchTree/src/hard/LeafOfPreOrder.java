package hard;

import java.util.List;
import java.util.Stack;

public class LeafOfPreOrder {
    public static void main(String[] argss) {
        List<Integer> mylist = List.of(1,2,3,4,5,7,6,8);
        printLeaf(mylist);
    }

    public static void printLeaf(List<Integer> mylist) {
        Stack<Integer> stack = new Stack<>();
        int i,j = 0;
        for ( i = 0, j = 1; j < mylist.size(); i++, j++) {
            boolean found = false;
            if (mylist.get(i) > mylist.get(j)) {
                stack.push(mylist.get(i));
            } else {
                while (!stack.isEmpty()) {
                    if (mylist.get(j) > stack.peek()) {
                        stack.pop();
                        found = true;
                    } else {
                        break;
                    }
                }
            }
            if (found) {
                System.out.print(mylist.get(i) + " ");
            }
        }
        System.out.print(mylist.get(mylist.size()-1));
    }
}
