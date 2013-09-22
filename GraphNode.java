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

    private GraphNode adjacencyList[];
    public int adjacencyCount;
    private String vertex;
    public State state;

    public GraphNode(String vertex, int adjacencyListLength) {
        this.vertex = vertex;
        adjacencyCount = 0;
        adjacencyList = new GraphNode[adjacencyListLength];
        state = State.Unvisited;
    }

    public void addAdjacent(GraphNode x) {
        if (adjacencyCount < 30) {
            this.adjacencyList[adjacencyCount] = x;
            adjacencyCount++;
        } else {
            System.out.print("No more adjacencyList nodes can be added");
        }
    }

    public GraphNode[] getAdjacencyList() {
        return adjacencyList;
    }

    public String getVertex() {
        return vertex;
    }

    @Override
    public String toString(){
        StringBuffer adjacencyListBuffer = new StringBuffer();
        for(GraphNode a: adjacencyList){
            adjacencyListBuffer.append(a.vertex);
        }
        return ""+vertex+" --> ["+ new String(adjacencyListBuffer) + "]";
    }

    public String toStringWithState(){
        StringBuffer adjacencyListBuffer = new StringBuffer();
        boolean commaAdded = false;
        for(GraphNode a: adjacencyList){
            if(commaAdded == true){
                adjacencyListBuffer.append(", ");
            }
            else {
                commaAdded = true;
            }
            adjacencyListBuffer.append(a.vertex);
            adjacencyListBuffer.append(":");
            adjacencyListBuffer.append(a.state);
        }
        return ""+vertex+" --> ["+ new String(adjacencyListBuffer) + "]";
    }

}