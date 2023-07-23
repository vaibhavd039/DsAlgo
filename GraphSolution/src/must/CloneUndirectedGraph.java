package must;

import java.util.*;

class GraphNode {
    int val;
    Vector<GraphNode> neighbours;

    public GraphNode(int val) {
        this.val = val;
        neighbours = new Vector<GraphNode>();
    }
}


public class CloneUndirectedGraph {
    public static GraphNode buildGraph() {
        /*
            Note : All the edges are Undirected
            Given Graph:
            1--2
            |  |
            4--3
        */
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        Vector<GraphNode> v = new Vector<GraphNode>();
        v.add(node2);
        v.add(node4);
        node1.neighbours = v;
        v = new Vector<GraphNode>();
        v.add(node1);
        v.add(node3);
        node2.neighbours = v;
        v = new Vector<GraphNode>();
        v.add(node2);
        v.add(node4);
        node3.neighbours = v;
        v = new Vector<GraphNode>();
        v.add(node3);
        v.add(node1);
        node4.neighbours = v;
        return node1;
    }

    public static void main(String[] args) {

        GraphNode head = buildGraph();
        bfs(head);
        System.out.println("after");
        GraphNode newHead = cloneGraph(head);
        bfs(newHead);
    }


    public static GraphNode cloneGraph(GraphNode original) {
        if (original == null)
            return null;
        Set<GraphNode> visited = new HashSet<>();
        Map<GraphNode, GraphNode> clonedNodes = new HashMap<>();
        Queue<GraphNode> queue = new LinkedList<>();


        GraphNode newNode = new GraphNode(original.val);
        clonedNodes.put(original, newNode);
        queue.add(original);
        while (!queue.isEmpty()) {
            GraphNode temp = queue.poll();
            if (temp == null)
                continue;
            GraphNode tempNew = clonedNodes.get(temp);

            if (temp.neighbours != null && !temp.neighbours.isEmpty()) {
                for (GraphNode next : temp.neighbours) {
                    GraphNode cloneNodeG = clonedNodes.get(next);
                    if (cloneNodeG == null) {
                        cloneNodeG = new GraphNode(next.val);
                        clonedNodes.put(next, cloneNodeG);
                        queue.add(next);
                    }
                    tempNew.neighbours.add(cloneNodeG);
                }
            }
            clonedNodes.put(temp, tempNew);
        }
        return clonedNodes.get(original);
    }

    public static void bfs(GraphNode source) {
        Queue<GraphNode> q = new LinkedList<GraphNode>();
        q.add(source);
        HashMap<GraphNode, Boolean> visit =
                new HashMap<GraphNode, Boolean>();
        visit.put(source, true);
        while (!q.isEmpty()) {
            GraphNode u = q.poll();
            System.out.println("Value of Node " + u.val);
            System.out.println("Address of Node " + u);
            if (u.neighbours != null) {
                Vector<GraphNode> v = u.neighbours;
                for (GraphNode g : v) {
                    if (visit.get(g) == null) {
                        q.add(g);
                        visit.put(g, true);
                    }
                }
            }
        }
        System.out.println();
    }
}


