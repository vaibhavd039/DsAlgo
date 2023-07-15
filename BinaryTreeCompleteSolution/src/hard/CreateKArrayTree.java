package hard;

//Construct the full k-ary tree from its preorder traversal

import java.util.ArrayList;
import java.util.List;

class KArrayTree {
    public  int data;
  public   List<KArrayTree> child = new ArrayList<>();

    KArrayTree(int data) {
        this.data = data;
    }
}

public class CreateKArrayTree {
    static Integer index = 0;

    public static void main(String[] args) {
        List<Integer> pre = List.of(1, 2, 5, 6, 7, 3, 8, 9, 10, 4);
        int k =3;
        int height = (int)Math.ceil(Math.log((double)pre.size() * (k - 1) + 1) /
                Math.log((double)k));
        KArrayTree root=   createTree(pre, k, height, pre.size()-1);
        System.out.print(root);
    }

    public static KArrayTree createTree(List<Integer> pre, int k, int height, int size) {
        if(size<=0)
            return null;
        KArrayTree node = new KArrayTree(pre.get(index));
        for(int i =0;i<k;i++){
            if(index< size-1 && height> 1 ){
                index++;
                node.child.add(createTree(pre, k, height-1, size));
            }
        }
        return node;
    }
}
