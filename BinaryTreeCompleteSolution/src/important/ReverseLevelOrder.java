package important;

import base.BinaryTree;
import base.BinaryTreeBuilder;

import java.util.*;

public class ReverseLevelOrder {
    public static void main(String[] args) {
        BinaryTree node = BinaryTreeBuilder.buildBasicBinaryTree();
        printReverseOptimised(node);

    }

    public static void reverseLevelOrder(BinaryTree node) {
        if (node == null) {
            return;
        }
        Stack<BinaryTree> stack = new Stack<>();
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            BinaryTree temp = queue.poll();
            if (temp == null)
                continue;
            stack.push(temp);
            queue.add(temp.right);
            queue.add(temp.left);
        }

        while (!stack.isEmpty()) {
            BinaryTree temp = stack.pop();
            System.out.print(temp.data + "\t");
        }
    }

    public static void printReverseOptimised(BinaryTree node) {
        int level = 0;
        Map<Integer, List<BinaryTree>> treeMap = new HashMap<>();
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int counter = 0;
            int size = queue.size();
            while (counter < size) {
                BinaryTree temp = queue.poll();
                List<BinaryTree> list = treeMap.computeIfAbsent(level, k -> new ArrayList<>());
                list.add(temp);
                counter++;
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
            level++;
        }

        Map<Integer, List<BinaryTree>> sortedMap = new TreeMap<>(Comparator.reverseOrder());
        sortedMap.putAll(treeMap);
        for (Map.Entry<Integer, List<BinaryTree>> entry : sortedMap.entrySet()) {
            entry.getValue().forEach(value-> System.out.print(value.data+"\t"));
            System.out.print("\n");
        }

    }
}
