package traversal;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
//he idea is, root is always the first item in preorder traversal and it must be the last item in postorder traversal.
//        We first recursively print left subtree, then recursively print right subtree. Finally, print root.

public class PrintPostOrderFromInandPreOrder {
    static int preIndex = 0;
    public static void main(String[] args) {
        List<Integer> preOrder = List.of(1, 2, 4, 8, 9, 5, 3, 6, 7, 10, 11);
        List<Integer> inOrder = List.of(8, 4, 9, 2, 5, 1, 6, 3, 10, 7, 11);
        Map<Integer, Integer> indexMap = buildValuetoIndexMap(inOrder);
        printPostOrder(preOrder, inOrder, 0, inOrder.size() - 1, indexMap);
    }

    private static Map<Integer, Integer> buildValuetoIndexMap(List<Integer> inOrder) {
        return IntStream.range(0, inOrder.size())
                .boxed()
                .collect(Collectors.toMap(inOrder::get, i -> i));
    }

    private static void printPostOrder(List<Integer> preOrder, List<Integer> inOrder, int left, int right,
                                       Map<Integer, Integer> indexMap) {
        if (left > right) {
            return;
        }

        int rootIndex = indexMap.get(preOrder.get(preIndex++));
        printPostOrder(preOrder, inOrder, left, rootIndex - 1, indexMap);
        printPostOrder(preOrder, inOrder, rootIndex + 1, right, indexMap);
        System.out.print(inOrder.get(rootIndex)+"\t");
    }
}
