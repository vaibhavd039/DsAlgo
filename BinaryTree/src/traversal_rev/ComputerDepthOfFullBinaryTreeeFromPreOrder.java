package traversal_rev;

public class ComputerDepthOfFullBinaryTreeeFromPreOrder {
    public static void main(String [] args) {
        String tree ="nlnnlll";
        System.out.print(getHeight(tree, 0, tree.length()));
    }

    public static int getHeight(String tree, int index, int len){
        if(index>len || tree.charAt(index)=='l')
            return 0;
        index++;
       int left =  getHeight(tree, index, len);
       index++;
        int right =  getHeight(tree, index, len);
        return Math.max(left, right)+1;
    }
}
