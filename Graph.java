/**
 * Created with IntelliJ IDEA.
 * User: sowmyahariharan
 * Date: 9/22/13
 * Time: 12:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class Graph {

    // Vertices : the nodes in a graph
    // count : number of nodes in the graph
    private GraphNode vertices[];
    public int count;

    public Graph() {
        vertices = new GraphNode[6];
        count = 0;
    }

    public void addNode(GraphNode x) {
        if (count < 30) {
            vertices[count] = x;
            count++;
        } else {
            System.out.print("A full graph");
        }
    }

    public GraphNode[] getNodes() {
        return vertices;
    }
}
