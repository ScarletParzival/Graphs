import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: sowmyahariharan
 * Date: 9/22/13
 * Time: 12:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class FindPathBetweenNodesInADirectedGraph {

    public static Graph createNewGraph()
    {
        Graph g = new Graph();
        GraphNode[] temp = new GraphNode[6];

        temp[0] = new GraphNode("a", 3);
        temp[1] = new GraphNode("b", 0);
        temp[2] = new GraphNode("c", 0);
        temp[3] = new GraphNode("d", 1);
        temp[4] = new GraphNode("e", 1);
        temp[5] = new GraphNode("f", 0);

        temp[0].addAdjacent(temp[1]);
        temp[0].addAdjacent(temp[2]);
        temp[0].addAdjacent(temp[3]);
        temp[3].addAdjacent(temp[4]);
        temp[4].addAdjacent(temp[5]);

        /*
        "a" ---> "b"
        | \
        |  \-------
        |         |
        V         V
        "c" ---> "d" ---> "e" --> "f"
         */
        for (int i = 0; i < 6; i++) {
            g.addNode(temp[i]);
        }
        return g;
    }

    public static boolean search(Graph g,GraphNode start,GraphNode end) {
        System.out.println("\nIs there a path between "+ start.getVertex() + " and "+ end.getVertex() +"?\n");
        LinkedList<GraphNode> q = new LinkedList<GraphNode>();
        // This is redundant since the state is set in the GraphNode's constructor
        for (GraphNode u : g.getNodes()) {
            u.state = GraphNode.State.Unvisited;
        }
        start.state = GraphNode.State.Visiting;
        q.add(start);
        GraphNode u;
        while(!q.isEmpty()) {
            u = q.removeFirst();
            System.out.println("Main loop of: "+u);
//            if (u != null) {      This is redundant since no node of null is ever added!
                for (GraphNode v : u.getAdjacencyList()) {
                    System.out.println("\t\tChecking: "+v);
                    // The state is 'Visiting' when you are going through a loop.
                    // Don't add the node to the queue in that case (it's already in there waiting to be visited!)
                    if (v.state == GraphNode.State.Unvisited) {
                        if (v == end) {
                            g.printGraph();
//                            g.printGraphWithState();
                            return true;
                        } else {
                            v.state = GraphNode.State.Visiting;
                            q.add(v);
                            printQueue(q);
//                            printQueue(q, true);
                        }
                    }
                }
                u.state = GraphNode.State.Visited;
//            }
//            else {
//                System.out.println("U was null now!!!");
//            }
        }
        return false;
    }

    public static void printQueue(Queue<GraphNode> q){
        System.out.print("\t\t\tPrinting the queue: [");
        for(GraphNode node:q){
            System.out.print(node.getVertex());
        }
        System.out.println("]");
    }

    public static void printQueue(Queue<GraphNode> q, boolean alsoPrintState){
        System.out.print("\t\t\tPrinting the queue: [ ");
        for(GraphNode node:q){
            System.out.print(node.getVertex()+":"+node.state+" ");
        }
        System.out.println("]");
    }

    public static boolean searchGraph(Graph g, GraphNode start, GraphNode end){
        Queue<GraphNode> queue = new LinkedList<GraphNode>();
        start.state = GraphNode.State.Visiting;
        queue.add(start);
        while (!queue.isEmpty()){
            GraphNode current = queue.remove();
            for(GraphNode adjacent : current.getAdjacencyList()){
                if(adjacent.state == GraphNode.State.Unvisited){
                    if(adjacent == end){
                        return true;
                    }
                    else{
                        adjacent.state = GraphNode.State.Visiting;
                        queue.add(adjacent);
                    }
                }
            }
            current.state = GraphNode.State.Visited;
        }
        return false;
    }

    public static void main(String a[])
    {
        Graph g = createNewGraph();

        g.printGraph();

        GraphNode[] n = g.getNodes();
        GraphNode start = n[3];
        GraphNode end = n[5];
        System.out.println("\n"+search(g, start, end));

        start = n[0];
        end = n[4];
        System.out.println("\n"+search(g,start,end));

        start = n[1];
        end = n[3];
        System.out.println("\n"+search(g,start,end));
    }
}
