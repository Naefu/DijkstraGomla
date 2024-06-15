import java.awt.Color;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import javax.imageio.*;
public class App {
    static Node start = new Node("Start");
    static String[] groceries = {"milk","tea","towel","ice cream","bread","black pepper","tomatoes"};
    static ArrayList<Node> grocNodes = new ArrayList<>(groceries.length);
    static ArrayList<Node> path = new ArrayList<>();
    public static void pathtobetaken() {
       //missing a way to turn the strings to the needed nodes
        Node[] nodes = new Node[groceries.length];
        for (int i = 0; i < groceries.length; i++) {
            nodes[i] = new Node(groceries[i]);
        }//to be removed when above comment is done
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.calculateShortestPath(start);
        Node shortest=start.getShortestPath().get(0);//needs to be changed to method that gets shortest distance based on the given list 
        path.add(shortest);
        for (int i = 0; i < groceries.length; i++) {
            dijkstra.calculateShortestPath(nodes[i]);
            shortest = nodes[i].getShortestPath().get(0);// same thing here
            path.add(shortest);
        }
        // path should be ordered by first you will go to then second then third and so on
    }

    public static Node helper(Node start, ArrayList<Node> grocNodes){
        int shortnigga = 999999;
        int whichnigga = 0;
        for(int i = 0;i<grocNodes.size();i++){
            if(shortnigga > grocNodes.get(i).getDistance()){
                shortnigga = grocNodes.get(i).getDistance();
                whichnigga = i;
            }
        }
        return grocNodes.get(whichnigga);
    }



    public static void main(String[] args) throws IOException {
        // String[] groceries = {"milk","tea","towel","ice cream","bread","black pepper","tomatoes"};
        // Node nodeA = new Node("Dairy");
        // Node nodeAb = new Node("Dairy");
        // Node nodeAe = new Node("Dairy");
        // Node nodeB = new Node("Bread,Pastas");
        // Node nodeBb = new Node("Bread,Pastas");
        // Node nodeBe = new Node("Bread,Pastas");
        // Node nodeC = new Node("Tea");
        // Node nodeCb = new Node("Tea");
        // Node nodeCe = new Node("Tea");
        // Node nodeD = new Node("Spices");
        // Node nodeDb = new Node("Spices");
        // Node nodeDe = new Node("Spices");
        // Node nodeE = new Node("Cereal");
        // Node nodeEb = new Node("Cereal");
        // Node nodeEe = new Node("Cereal");
        // Node nodeF = new Node("Fresh Produce");
        // Node nodeFb = new Node("Fresh Produce");
        // Node nodeFe = new Node("Fresh Produce");
        // Node nodeG = new Node("Laundry");
        // Node nodeGb = new Node("Laundry");
        // Node nodeGe = new Node("Laundry");
        // Node nodeH = new Node("Ice cream");
        // Node nodeHb = new Node("Ice cream");
        // Node nodeHe = new Node("Ice cream");
        
        // nodeA.addAdjacentNode(nodeAb, 1);
        // nodeA.addAdjacentNode(nodeAe, 1);
        // nodeB.addAdjacentNode(nodeBb, 1);
        // nodeB.addAdjacentNode(nodeBe, 1);
        // nodeC.addAdjacentNode(nodeCb, 1);
        // nodeC.addAdjacentNode(nodeCe, 1);
        // nodeD.addAdjacentNode(nodeDb, 1);
        // nodeD.addAdjacentNode(nodeDe, 1);
        // nodeE.addAdjacentNode(nodeEb, 1);
        // nodeE.addAdjacentNode(nodeEe, 1);
        // nodeF.addAdjacentNode(nodeFb, 1);
        // nodeF.addAdjacentNode(nodeFe, 1);
        // nodeG.addAdjacentNode(nodeGb, 1);
        // nodeG.addAdjacentNode(nodeGe, 1);
        // nodeH.addAdjacentNode(nodeHb, 1);
        // nodeH.addAdjacentNode(nodeHe, 1);
        // Dijkstra dijkstra = new Dijkstra();
        // dijkstra.calculateShortestPath(nodeA);
        // dijkstra.printPaths(Arrays.asList(nodeA, nodeAb));

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addAdjacentNode(nodeB, 2);
        nodeA.addAdjacentNode(nodeC, 4);

        nodeB.addAdjacentNode(nodeC, 3);
        nodeB.addAdjacentNode(nodeD, 1);
        nodeB.addAdjacentNode(nodeE, 5);

        nodeC.addAdjacentNode(nodeD, 2);

        nodeD.addAdjacentNode(nodeE, 1);
        nodeD.addAdjacentNode(nodeF, 4);

        nodeE.addAdjacentNode(nodeF, 2);

        Dijkstra dijkstra = new Dijkstra();
        dijkstra.calculateShortestPath(nodeA);
        List<Node> niggas = new LinkedList<>();
        niggas.add(nodeA);
        niggas.add(nodeB);
        niggas.add(nodeC);
        niggas.add(nodeD);
        niggas.add(nodeE);
        niggas.add(nodeF);
        ArrayList<Node> groc = new ArrayList<>(3);
        groc.add(nodeC);
        groc.add(nodeD);
        Node result = helper(nodeA, groc);
        System.out.println(result.getName());
//START OF FUNCTION ---------------------------------------------------------------------
int shortnigga = 999999;
int bignigga = 0;
int whichnigga = 0;
int whichernigga = 0;
for(int i = 0;i<niggas.size();i++){
    if(shortnigga > niggas.get(i).getDistance()){
        shortnigga = niggas.get(i).getDistance();
        whichnigga = i+1;
    }
    if(bignigga < niggas.get(i).getDistance()){
        bignigga = niggas.get(i).getDistance();
        whichernigga = i+1;
    }
}


System.out.println(whichnigga);
System.out.println(shortnigga); 
System.out.println(whichernigga);
System.out.println(bignigga);     
//END OF FUNCTION -------------------------------------------------------------------------
        dijkstra.printPaths(List.of(nodeA, nodeB, nodeC, nodeD, nodeE, nodeF));


BufferedImage img = ImageIO.read(new File("../DijkstraGomla/tester/src/imageinput.jpg"));
var a = img.createGraphics();
a.setColor(new Color(90,90,90));
a.fillRect(250, 205, 173, 4);
var b = img.createGraphics();
b.setColor(new Color(100,0,90));
b.fillRect(423, 205, 173, 4);
var c = img.createGraphics();
c.setColor(new Color(90,0,0));
c.fillRect(557, 205, 173, 4);
var d = img.createGraphics();
d.setColor(new Color(0,90,90));
d.fillRect(556, 117, 4, 90);
File f = new File("../DijkstraGomla/tester/src/image.jpg");
		try {
			ImageIO.write(img, "jpg", f);
		} catch (IOException e) {
			e.printStackTrace();
		}
        a.dispose();
        b.dispose();
        c.dispose();
        d.dispose();
    }
}
