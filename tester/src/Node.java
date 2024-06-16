
import java.util.*;

public class Node implements Comparable<Node> {


  private final String name;
  private Integer distance = Integer.MAX_VALUE;
  private List<Node> shortestPath = new LinkedList<>();
  private Map<Node, Integer> adjacentNodes = new HashMap<>();

    public Node(String name) {
        this.name = name;
    }

public void addAdjacentNode(Node node, int weight){
  adjacentNodes.put(node, weight);
  node.flipaddAdjacentNode(this, weight);
}
public void flipaddAdjacentNode(Node node, int weight){
    adjacentNodes.put(node, weight);
  }

public int compareTo(Node node){
  return Integer.compare(this.distance, node.getDistance());
}

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    public String getName() {
        return name;
    }

    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }




}