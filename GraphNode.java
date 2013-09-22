/**
 * Created with IntelliJ IDEA.
 * User: sowmyahariharan
 * Date: 9/22/13
 * Time: 12:26 PM
 * To change this template use File | Settings | File Templates.
 */
class GraphNode {

    public enum State {
        Unvisited, Visited, Visiting;
    }

    private GraphNode adjacent[];
    public int adjacencyCount;
    private String vertex;
    public State state;

    public GraphNode(String vertex, int adjacencyListLength) {
        this.vertex = vertex;
        adjacencyCount = 0;
        adjacent = new GraphNode[adjacencyListLength];
    }

    public void addAdjacent(GraphNode x) {
        if (adjacencyCount < 30) {
            this.adjacent[adjacencyCount] = x;
            adjacencyCount++;
        } else {
            System.out.print("No more adjacent nodes can be added");
        }
    }

    public GraphNode[] getAdjacencyList() {
        return adjacent;
    }

    public String getVertex() {
        return vertex;
    }
}