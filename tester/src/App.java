import java.awt.Color;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
public class App {
    public static void main(String[] args) throws IOException {
        String[] groceries = {"milk","tea","towel","ice cream","bread","black pepper","tomatoes"};
        Node nodeA = new Node("Dairy");
        Node nodeAb = new Node("Dairy");
        Node nodeAe = new Node("Dairy");
        Node nodeB = new Node("Bread,Pastas");
        Node nodeBb = new Node("Bread,Pastas");
        Node nodeBe = new Node("Bread,Pastas");
        Node nodeC = new Node("Tea");
        Node nodeCb = new Node("Tea");
        Node nodeCe = new Node("Tea");
        Node nodeD = new Node("Spices");
        Node nodeDb = new Node("Spices");
        Node nodeDe = new Node("Spices");
        Node nodeE = new Node("Cereal");
        Node nodeEb = new Node("Cereal");
        Node nodeEe = new Node("Cereal");
        Node nodeF = new Node("Fresh Produce");
        Node nodeFb = new Node("Fresh Produce");
        Node nodeFe = new Node("Fresh Produce");
        Node nodeG = new Node("Laundry");
        Node nodeGb = new Node("Laundry");
        Node nodeGe = new Node("Laundry");
        Node nodeH = new Node("Ice cream");
        Node nodeHb = new Node("Ice cream");
        Node nodeHe = new Node("Ice cream");
        
        nodeA.addAdjacentNode(nodeAb, 1);
        nodeA.addAdjacentNode(nodeAe, 1);
        nodeB.addAdjacentNode(nodeBb, 1);
        nodeB.addAdjacentNode(nodeBe, 1);
        nodeC.addAdjacentNode(nodeCb, 1);
        nodeC.addAdjacentNode(nodeCe, 1);
        nodeD.addAdjacentNode(nodeDb, 1);
        nodeD.addAdjacentNode(nodeDe, 1);
        nodeE.addAdjacentNode(nodeEb, 1);
        nodeE.addAdjacentNode(nodeEe, 1);
        nodeF.addAdjacentNode(nodeFb, 1);
        nodeF.addAdjacentNode(nodeFe, 1);
        nodeG.addAdjacentNode(nodeGb, 1);
        nodeG.addAdjacentNode(nodeGe, 1);
        nodeH.addAdjacentNode(nodeHb, 1);
        nodeH.addAdjacentNode(nodeHe, 1);
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.calculateShortestPath(nodeA);
        dijkstra.printPaths(Arrays.asList(nodeA, nodeB, nodeC));


BufferedImage img = ImageIO.read(new File("../DijkstraGomla/tester/src/imageinput.jpg"));
var g = img.createGraphics();
g.setColor(new Color(90,90,90));
// Draw on the BufferedImage via the graphics context.
int x = 0;
int y = 0;
int width = 100;
int height = 1000;
g.drawLine(10, 10, 500, 500);
File f = new File("../DijkstraGomla/tester/src/image.jpg");
		try {
			ImageIO.write(img, "jpg", f);
		} catch (IOException e) {
			e.printStackTrace();
		}
g.dispose();
    }
}
