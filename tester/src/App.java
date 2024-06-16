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
        Node shortest=helper(start,grocNodes);
        grocNodes.remove(shortest);// means i reached it so no need for it in the list
        path.add(shortest);
        for (int i = 0; i < groceries.length; i++) {
            dijkstra.calculateShortestPath(nodes[i]);
            shortest = helper(shortest,grocNodes);
            grocNodes.remove(shortest);
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
        String[] groceries = {"milk","tea","towel","ice cream","bread","black pepper","tomatoes"};
        Node S = new Node("Start");
        Node Dbl = new Node("Dbl");
        Node Dairy = new Node("Dairy");
        Node Dbr = new Node("Dbr");
        Node Bb = new Node("Bb");
        Node BC = new Node("BC");
        Node Tb = new Node("Tb");
        Node TL = new Node("TL");
        Node Bread = new Node("Bread");
        Node IcecreamCereal = new Node("IcecreamCereal");
        Node Deli = new Node("Deli");
        Node TeaSpices = new Node("TeaSpices");
        Node Laundry = new Node("Laundry");
        Node Fruit = new Node("Fruit");
        Node Veggies = new Node("Veggies");
        Node De = new Node("De");
        Node Ie = new Node("Ie");
        Node Le = new Node("Le");

        S.addAdjacentNode(BC, 1);//S↔BC
        S.addAdjacentNode(Deli, 1);//S↔Deli
        BC.addAdjacentNode(Bread, 1);//BC↔Bread
        BC.addAdjacentNode(IcecreamCereal, 1);//BC↔IcecreamCereal
        BC.addAdjacentNode(TL, 1);//BC↔TL
        TL.addAdjacentNode(TeaSpices, 1);//TL↔TeaSpices
        TL.addAdjacentNode(Laundry, 1);//TL↔Laundry
        Dbl.addAdjacentNode(Deli, 1);//Dbl↔Deli
        Dbl.addAdjacentNode(Bb, 1);//Dbl↔Bb
        Bb.addAdjacentNode(Tb, 1);//Bb↔Tb
        Bb.addAdjacentNode(Bread, 1);//Bb↔Bread
        Tb.addAdjacentNode(TeaSpices, 1);//Tb↔TeaSpices
        Ie.addAdjacentNode(IcecreamCereal, 1);//Ie↔IcecreamCereal
        Ie.addAdjacentNode(Le, 1);//Ie↔Le
        Ie.addAdjacentNode(Fruit, 1);//Ie↔Fruit
        Le.addAdjacentNode(Laundry, 1);//Le↔Laundry
        Le.addAdjacentNode(Veggies, 1);//Le↔Veggies
        De.addAdjacentNode(Veggies, 1);//De↔Veggies
        De.addAdjacentNode(Dairy, 1);//De↔Dairy
        Dbr.addAdjacentNode(Fruit, 1);//Dbr↔Fruit
        Dbr.addAdjacentNode(Dairy, 1);//Dbr↔Dairy

        Dijkstra dijkstra = new Dijkstra();
        dijkstra.calculateShortestPath(Dbr);
        dijkstra.printPaths(Arrays.asList(Bread, Tb));

        // Node nodeA = new Node("A");
        // Node nodeB = new Node("B");
        // Node nodeC = new Node("C");
        // Node nodeD = new Node("D");
        // Node nodeE = new Node("E");
        // Node nodeF = new Node("F");

        // nodeA.addAdjacentNode(nodeB, 2);
        // nodeA.addAdjacentNode(nodeC, 4);

        // nodeB.addAdjacentNode(nodeC, 3);
        // nodeB.addAdjacentNode(nodeD, 1);
        // nodeB.addAdjacentNode(nodeE, 5);

        // nodeC.addAdjacentNode(nodeD, 2);

        // nodeD.addAdjacentNode(nodeE, 1);
        // nodeD.addAdjacentNode(nodeF, 4);

        // nodeE.addAdjacentNode(nodeF, 2);

        // Dijkstra dijkstra = new Dijkstra();
        // dijkstra.calculateShortestPath(nodeA);
        // List<Node> niggas = new LinkedList<>();
        // niggas.add(nodeA);
        // niggas.add(nodeB);
        // niggas.add(nodeC);
        // niggas.add(nodeD);
        // niggas.add(nodeE);
        // niggas.add(nodeF);
        // ArrayList<Node> groc = new ArrayList<>(3);
        // groc.add(nodeC);
        // groc.add(nodeD);
        // Node result = helper(nodeA, groc);
        // System.out.println(result.getName());
//START OF FUNCTION ---------------------------------------------------------------------
// int shortnigga = 999999;
// int bignigga = 0;
// int whichnigga = 0;
// int whichernigga = 0;
// for(int i = 0;i<niggas.size();i++){
//     if(shortnigga > niggas.get(i).getDistance()){
//         shortnigga = niggas.get(i).getDistance();
//         whichnigga = i+1;
//     }
//     if(bignigga < niggas.get(i).getDistance()){
//         bignigga = niggas.get(i).getDistance();
//         whichernigga = i+1;
//     }
// }


// System.out.println(whichnigga);
// System.out.println(shortnigga); 
// System.out.println(whichernigga);
// System.out.println(bignigga);     
//END OF FUNCTION -------------------------------------------------------------------------
        // dijkstra.printPaths(List.of(nodeA, nodeB, nodeC, nodeD, nodeE, nodeF));


BufferedImage img = ImageIO.read(new File("../DijkstraGomla/tester/src/imageinput.jpg"));
var a = img.createGraphics();
a.setColor(new Color(90,90,90));
a.fillRect(250, 205, 173, 4);
var b = img.createGraphics();
b.setColor(new Color(100,0,90));
b.fillRect(423, 205, 135, 4);
var c = img.createGraphics();
c.setColor(new Color(90,0,0));
c.fillRect(557, 205, 135, 4);
var d = img.createGraphics();
d.setColor(new Color(0,90,90));
d.fillRect(557, 117, 4, 92);
var e = img.createGraphics();
e.setColor(new Color(0,90,90));
e.fillRect(250, 117, 4, 92);
var f = img.createGraphics();
f.setColor(new Color(100,0,90));
f.fillRect(250, 117, 173, 4);
var g = img.createGraphics();
g.setColor(new Color(100,0,90));
g.fillRect(557, 117, 135, 4);
var h = img.createGraphics();
h.setColor(new Color(255,90,90));
h.fillRect(423, 117, 135, 4);
var i = img.createGraphics();
i.setColor(new Color(255,90,77));
i.fillRect(557, 67, 4, 50);
var j = img.createGraphics();
j.setColor(new Color(100,0,90));
j.fillRect(422, 67, 135, 4);
var k = img.createGraphics();
k.setColor(new Color(0,255,90));
k.fillRect(250, 67, 173, 4);
var l = img.createGraphics();
l.setColor(new Color(255,90,77));
l.fillRect(250, 67, 4, 50);
var m = img.createGraphics();
m.setColor(new Color(0,255,0));
m.fillRect(692, 117, 125, 4);
var n = img.createGraphics();
n.setColor(new Color(0,255,0));
n.fillRect(692, 205, 125, 4);
var o = img.createGraphics();
o.setColor(new Color(0,90,90));
o.fillRect(817, 117, 4, 92);
var p = img.createGraphics();
p.setColor(new Color(0,90,90));
p.fillRect(908, 67, 4, 85);
var q = img.createGraphics();
q.setColor(new Color(255,90,0));
q.fillRect(817, 237, 95, 4);
var r = img.createGraphics();
r.setColor(new Color(255,90,255));
r.fillRect(817, 67, 95, 4);
var s = img.createGraphics();
s.setColor(new Color(0,0,90));
s.fillRect(908, 152, 4, 85);
var t = img.createGraphics();
t.setColor(new Color(0,0,90));
t.fillRect(817, 67, 4, 50);
var u = img.createGraphics();
u.setColor(new Color(0,0,90));
u.fillRect(817, 205, 4, 34);

File fi = new File("../DijkstraGomla/tester/src/image.jpg");
		try {
			ImageIO.write(img, "jpg", fi);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
        a.dispose();
        b.dispose();
        c.dispose();
        d.dispose();
        e.dispose();
        f.dispose();
        g.dispose();
        h.dispose();
        i.dispose();
        j.dispose();
        k.dispose();
        l.dispose();
        m.dispose();
        n.dispose();
        o.dispose();
        p.dispose();
        q.dispose();
        r.dispose();
        s.dispose();
    }
}
