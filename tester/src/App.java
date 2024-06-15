
import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");

        nodeA.addAdjacentNode(nodeB, 3);
        nodeA.addAdjacentNode(nodeC, 9);

        nodeB.addAdjacentNode(nodeC, 5);

        Dijkstra dijkstra = new Dijkstra();
        dijkstra.calculateShortestPath(nodeA);
        dijkstra.printPaths(Arrays.asList(nodeA, nodeB, nodeC));

    }
}
