package basic;

import java.util.*;

class AdjListNode {
    int node;
    Set<Integer> neighbour;
    AdjListNode(int data){
        this.node=data;
        neighbour=new HashSet<>();
    }
}

public class AdjList {
    public static void main(String[] args) {
        List<AdjListNode> adjLists = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int node = sc.nextInt();
        for(int i =0;i<node;i++){
            adjLists.add(new AdjListNode(i));
        }
        int edges = sc.nextInt();
        for(int i =0;i<edges;i++){
            int first = sc.nextInt();
            int second = sc.nextInt();
            adjLists.get(first).neighbour.add(second);
            adjLists.get(second).neighbour.add(first);
        }
        adjLists.stream().forEach(element->{
            element.neighbour.stream().forEach(next->{
                System.out.println("node : "+element.node+"\t has neighbour: "+next);
            });
        });

    }

}
