import java.awt.Color;
import java.awt.image.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.imageio.*;
public class App {
    static Node start = new Node("Start");
    static String[] groceries = {"milk","tea","towel","ice cream","bread","black pepper","tomatoes"};
    static ArrayList<Node> grocNodes = new ArrayList<>(groceries.length);
    static List<Node> path = new LinkedList<>();
    private static Node S;
    private static Node Dbl;
    private static Node Dairy;
    private static Node Dbr;
    private static Node Bb;
    private static Node BC;
    private static Node Tb;
    private static Node TL;
    private static Node Bread;
    private static Node IcecreamCereal;
    private static Node Deli;
    private static Node TeaSpices;
    private static Node Laundry;
    private static Node Fruit;
    private static Node Veggies;
    private static Node De;
    private static Node Ie;
    private static Node Le;
    private static HashMap<String, Node> niggas = new HashMap<>();
    private static List<Node> allnodes = new ArrayList<>();
    // everything that needs to be loaded before app starts
    public static void init(){
        S = new Node("Start");
        Dbl = new Node("Dbl");
        Dairy = new Node("Dairy");
        Dbr = new Node("Dbr");
        Bb = new Node("Bb");
        BC = new Node("BC");
        Tb = new Node("Tb");
        TL = new Node("TL");
        Bread = new Node("Bread");
        IcecreamCereal = new Node("IcecreamCereal");
        Deli = new Node("Deli");
        TeaSpices = new Node("TeaSpices");
        Laundry = new Node("Laundry");
        Fruit = new Node("Fruit");
        Veggies = new Node("Veggies");
        De = new Node("De");
        Ie = new Node("Ie");
        Le = new Node("Le");

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

        //getallshortestpath();
        allnodes.add(S);
        allnodes.add(BC);
        allnodes.add(TL);
        allnodes.add(Dbl);
        allnodes.add(Dbr);
        allnodes.add(Bb);
        allnodes.add(Tb);
        allnodes.add(Ie);
        allnodes.add(Le);
        allnodes.add(IcecreamCereal);
        allnodes.add(Fruit);
        allnodes.add(Veggies);
        allnodes.add(Deli);
        allnodes.add(Bread);
        allnodes.add(Dairy);
        allnodes.add(De);
        allnodes.add(Laundry);
        allnodes.add(TeaSpices);
        str_to_node();
    }
    // private static void getallshortestpath(){
    //     // might be removed depending on the time it takes
    //     Dijkstra dijkstra = new Dijkstra();
    //     dijkstra.calculateShortestPath(S);
    //     // dijkstra.calculateShortestPath(BC);
    //     // dijkstra.calculateShortestPath(Bread);
    //     // dijkstra.calculateShortestPath(IcecreamCereal);
    //     // dijkstra.calculateShortestPath(TL);
    //     // dijkstra.calculateShortestPath(TeaSpices);
    //     // dijkstra.calculateShortestPath(Laundry);
    //     // dijkstra.calculateShortestPath(Deli);
    //     // dijkstra.calculateShortestPath(Dbl);
    //     // dijkstra.calculateShortestPath(Bb);
    //     // dijkstra.calculateShortestPath(Tb);
    //     // dijkstra.calculateShortestPath(Ie);
    //     // dijkstra.calculateShortestPath(Le);
    //     // dijkstra.calculateShortestPath(De);
    //     // dijkstra.calculateShortestPath(Dbr);
    //     // dijkstra.calculateShortestPath(Dairy);
    //     // dijkstra.calculateShortestPath(Fruit);
    //     // dijkstra.calculateShortestPath(Veggies);
    // }
    private static void reset(){
        S.setDistance(Integer.MAX_VALUE);
        Dbl.setDistance(Integer.MAX_VALUE);
        Dairy.setDistance(Integer.MAX_VALUE);
        Dbr.setDistance(Integer.MAX_VALUE);
        Bb.setDistance(Integer.MAX_VALUE);
        BC.setDistance(Integer.MAX_VALUE);
        Tb.setDistance(Integer.MAX_VALUE);
        TL.setDistance(Integer.MAX_VALUE);
        Bread.setDistance(Integer.MAX_VALUE);
        IcecreamCereal.setDistance(Integer.MAX_VALUE);
        Deli.setDistance(Integer.MAX_VALUE);
        TeaSpices.setDistance(Integer.MAX_VALUE);
        Laundry.setDistance(Integer.MAX_VALUE);
        Fruit.setDistance(Integer.MAX_VALUE);
        Veggies.setDistance(Integer.MAX_VALUE);
        De.setDistance(Integer.MAX_VALUE);
        Ie.setDistance(Integer.MAX_VALUE);
        Le.setDistance(Integer.MAX_VALUE);  
        for(Node n : allnodes){
            n.remove();
        } 
    }
    private static void str_to_node(){

        //mapping the nodes to the strings

        niggas.put("bread",Bread);
        niggas.put("ice cream",IcecreamCereal);
        niggas.put("cereal",IcecreamCereal);
        niggas.put("tea",TeaSpices);
        niggas.put("spices",TeaSpices);
        niggas.put("vegetables",Veggies);
        niggas.put("fruits",Fruit);
        niggas.put("laundry",Laundry);
        niggas.put("deli",Deli);// not sure what is this
        niggas.put("dairy",Dairy);
        niggas.put("milk",Dairy);
        niggas.put("towel",Laundry);
        niggas.put("icecream",IcecreamCereal);
        niggas.put("black pepper",TeaSpices);
        niggas.put("tomatoes",Fruit);
        
    }
    public static void pathtobetaken(String[] groce) {
       
        grocNodes = getnodes(groce);
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.calculateShortestPath(S);
        Node shortest=helper(S,grocNodes);
        grocNodes.remove(shortest);// means i reached it so no need for it in the list
        for(int j = 0; j < shortest.getShortestPath().size();j++){
            path.add(shortest.getShortestPath().get(j));
        }
        for (int i = 0; i < groceries.length-1; i++) {
            reset();
            dijkstra.calculateShortestPath(shortest);
            shortest = helper(shortest,grocNodes);
            grocNodes.remove(shortest);
            for(int j = 0; j < shortest.getShortestPath().size();j++){
                path.add(shortest.getShortestPath().get(j));
            }
        }

        // path should be ordered by first you will go to then second then third and so on
    }

    private static ArrayList<Node> getnodes(String[] groc){
        ArrayList<Node> grocnodes = new ArrayList<>();
        for(int i = 0;i<groc.length;i++){
         grocnodes.add(niggas.get(groc[i]));  
        }
        return grocnodes;
    }

    private static Node helper(Node start, ArrayList<Node> grocNodes){
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
        init();
        String[] groce = {"milk","tea","towel","ice cream","bread","black pepper","tomatoes"};
        pathtobetaken(groce);
        Dijkstra dijkstra = new Dijkstra();
        // dijkstra.calculateShortestPath(S);
        Node destination = Dairy;
        for (Node node : path) {
            System.out.println(node.getName());
        }
        // ArrayList<Node> groc = new ArrayList<>(3);
        // groc.add(nodeC);
        // groc.add(nodeD);
        // Node result = helper(nodeA, groc);
        // System.out.println(result.getName());
//START OF FUNCTION ---------------------------------------------------------------------
// int smolnigga = 999999;
// String whichnigga = "";
// for(int i = 0;i<niggas.size();i++){
//     if(smolnigga > niggas.get(i).getDistance()){
//         smolnigga = niggas.get(i).getDistance();
//         whichnigga = niggas.get(i).getName();
//     }
// }
// System.out.println(whichnigga);
// System.out.println(smolnigga);  
//END OF FUNCTION -------------------------------------------------------------------------


BufferedImage img = ImageIO.read(new File("../DijkstraGomla/tester/src/imageinput.jpg"));
var a = img.createGraphics();//Tb↔TeaSpices
// a.setColor(new Color(90,90,90));
a.fillRect(250, 205, 173, 4);
var b = img.createGraphics();//TL↔TeaSpices
// b.setColor(new Color(100,0,90));
b.fillRect(423, 205, 135, 4);
var c = img.createGraphics();//TL↔Laundry
// c.setColor(new Color(90,0,0));
c.fillRect(557, 205, 135, 4);
var d = img.createGraphics();//BC↔TL
// d.setColor(new Color(0,90,90));
d.fillRect(557, 117, 4, 92);
var e = img.createGraphics();//Bb↔Tb
// e.setColor(new Color(0,90,90));
e.fillRect(250, 117, 4, 92);
var f = img.createGraphics();//Bb↔Bread
// f.setColor(new Color(100,0,90));
f.fillRect(250, 117, 173, 4);
var g = img.createGraphics();//BC↔IcecreamCereal
// g.setColor(new Color(100,0,90));
g.fillRect(557, 117, 135, 4);
var h = img.createGraphics();//BC↔Bread
// h.setColor(new Color(255,90,90));
h.fillRect(423, 117, 135, 4);
var i = img.createGraphics();//S↔BC
// i.setColor(new Color(255,90,77));
i.fillRect(557, 67, 4, 50);
var j = img.createGraphics();//S↔Deli
// j.setColor(new Color(100,0,90));
j.fillRect(423, 67, 135, 4);
var k = img.createGraphics();//Dbl↔Deli
// k.setColor(new Color(0,255,90));
k.fillRect(250, 67, 173, 4);
var l = img.createGraphics();//Dbl↔Bb
// l.setColor(new Color(255,90,77));
l.fillRect(250, 67, 4, 50);
var m = img.createGraphics();//Ie↔IcecreamCereal
// m.setColor(new Color(0,255,0));
m.fillRect(692, 117, 125, 4);
var n = img.createGraphics();//Le↔Laundry
// n.setColor(new Color(0,255,0));
n.fillRect(692, 205, 125, 4);
var o = img.createGraphics();//Ie↔Le
// o.setColor(new Color(0,90,90));
o.fillRect(817, 117, 4, 92);
var p = img.createGraphics();//Dbr↔Dairy
// p.setColor(new Color(0,90,90));
p.fillRect(908, 67, 4, 85);
var q = img.createGraphics();//De↔Veggies
// q.setColor(new Color(255,90,0));
q.fillRect(817, 237, 95, 4);
var r = img.createGraphics();//Dbr↔Fruit
// r.setColor(new Color(255,90,255));
r.fillRect(817, 67, 95, 4);
var s = img.createGraphics();//De↔Dairy
// s.setColor(new Color(0,0,90));
s.fillRect(908, 152, 4, 85);
var t = img.createGraphics();//Ie↔Fruit
// t.setColor(new Color(0,0,90));
t.fillRect(817, 67, 4, 50);
var u = img.createGraphics();//Le↔Veggies
// u.setColor(new Color(0,0,90));
u.fillRect(817, 205, 4, 32);


List<Node> smollestPath = destination.getShortestPath();
smollestPath = Stream.concat(smollestPath.stream(), Stream.of(destination)).toList();
for (int ic = 1; ic < smollestPath.size(); ic++) {
    if(smollestPath.get(ic).getName() == "BC"){
        switch (smollestPath.get(ic-1).getName()) {
            case "Bread":
                f.setColor(new Color(0,0,0));
                break;
            case "IcecreamCereal":
                g.setColor(new Color(0,0,0));
                break;
            case "TL":
                d.setColor(new Color(0,0,0));
                break;
            case "Start":
                i.setColor(new Color(0,0,0));
                break;
        }
    }else if(smollestPath.get(ic).getName() == "Start"){
        switch (smollestPath.get(ic-1).getName()) {
            case "BC":
                i.setColor(new Color(0,0,0));
                break;
            case "Deli":
                j.setColor(new Color(0,0,0));
                break;
        }
    }else if(smollestPath.get(ic).getName() == "Ie"){
        switch (smollestPath.get(ic-1).getName()) {
            case "IcecreamCereal":
                m.setColor(new Color(0,0,0));
                break;
            case "Fruit":
                t.setColor(new Color(0,0,0));
                break;
            case "Le":
                o.setColor(new Color(0,0,0));
                break;
        }
    }else if(smollestPath.get(ic).getName() == "Le"){
        switch (smollestPath.get(ic-1).getName()) {
            case "Veggies":
                u.setColor(new Color(0,0,0));
                break;
            case "Laundry":
                n.setColor(new Color(0,0,0));
                break;
            case "Ie":
                o.setColor(new Color(0,0,0));
                break;
        }
    }else if(smollestPath.get(ic).getName() == "S"){
        switch (smollestPath.get(ic-1).getName()) {
            case "Deli":
                j.setColor(new Color(0,0,0));
                break;
            case "BC":
                i.setColor(new Color(0,0,0));
                break;
        }
    }else if(smollestPath.get(ic).getName() == "Bb"){
        switch (smollestPath.get(ic-1).getName()) {
            case "Dbl":
                l.setColor(new Color(0,0,0));
                break;
            case "Tb":
                e.setColor(new Color(0,0,0));
                break;
            case "Bread":
                f.setColor(new Color(0,0,0));
                break;
        }
    }else if(smollestPath.get(ic).getName() == "Dbl"){
        switch (smollestPath.get(ic-1).getName()) {
            case "Deli":
                k.setColor(new Color(0,0,0));
                break;
            case "Bb":
                l.setColor(new Color(0,0,0));
                break;
        }
    }else if(smollestPath.get(ic).getName() == "Tb"){
        switch (smollestPath.get(ic-1).getName()) {
            case "TeaSpices":
                a.setColor(new Color(0,0,0));
                break;
            case "Bb":
                e.setColor(new Color(0,0,0));
                break;
        }
    }else if(smollestPath.get(ic).getName() == "Dbr"){
        switch (smollestPath.get(ic-1).getName()) {
            case "Dairy":
                p.setColor(new Color(0,0,0));
                break;
            case "Fruit":
                r.setColor(new Color(0,0,0));
                break;
        }
    }else if(smollestPath.get(ic).getName() == "Fruit"){
        switch (smollestPath.get(ic-1).getName()) {
            case "Ie":
                t.setColor(new Color(0,0,0));
                break;
            case "Dbr":
                r.setColor(new Color(0,0,0));
                break;
        }
    }else if(smollestPath.get(ic).getName() == "Veggies"){
        switch (smollestPath.get(ic-1).getName()) {
            case "Le":
                u.setColor(new Color(0,0,0));
                break;
            case "De":
                q.setColor(new Color(0,0,0));
                break;
        }
    }else if(smollestPath.get(ic).getName() == "Deli"){
        switch (smollestPath.get(ic-1).getName()) {
            case "S":
                j.setColor(new Color(0,0,0));
                break;
            case "Dbl":
                k.setColor(new Color(0,0,0));
                break;
        }
    }else if(smollestPath.get(ic).getName() == "TeaSpices"){
        switch (smollestPath.get(ic-1).getName()) {
            case "Tb":
                a.setColor(new Color(0,0,0));
                break;
            case "TL":
                b.setColor(new Color(0,0,0));
                break;
        }
    }else if(smollestPath.get(ic).getName() == "Bread"){
        switch (smollestPath.get(ic-1).getName()) {
            case "BC":
                h.setColor(new Color(0,0,0));
                break;
            case "Bb":
                f.setColor(new Color(0,0,0));
                break;
        }
    }else if(smollestPath.get(ic).getName() == "TL"){
        switch (smollestPath.get(ic-1).getName()) {
            case "BC":
                d.setColor(new Color(0,0,0));
                break;
            case "TeaSpices":
                b.setColor(new Color(0,0,0));
                break;
            case "Laundry":
                c.setColor(new Color(0,0,0));
                break;
        }
    }else if(smollestPath.get(ic).getName() == "IcecreamCereal"){
        switch (smollestPath.get(ic-1).getName()) {
            case "BC":
                g.setColor(new Color(0,0,0));
                break;
            case "Ie":
                m.setColor(new Color(0,0,0));
                break;
        }
    }else if(smollestPath.get(ic).getName() == "Laundry"){
        switch (smollestPath.get(ic-1).getName()) {
            case "TL":
                c.setColor(new Color(0,0,0));
                break;
            case "Le":
                n.setColor(new Color(0,0,0));
                break;
        }
    }else if(smollestPath.get(ic).getName() == "Dairy"){
        switch (smollestPath.get(ic-1).getName()) {
            case "Dbr":
                p.setColor(new Color(0,0,0));
                break;
            case "De":
                s.setColor(new Color(0,0,0));
                break;
        }
    }else if(smollestPath.get(ic).getName() == "De"){
        switch (smollestPath.get(ic-1).getName()) {
            case "Veggies":
                q.setColor(new Color(0,0,0));
                break;
            case "Dairy":
                s.setColor(new Color(0,0,0));
                break;
        }
    }
}
a.fillRect(250, 205, 173, 4);
b.fillRect(423, 205, 135, 4);
c.fillRect(557, 205, 135, 4);
d.fillRect(557, 117, 4, 92);
e.fillRect(250, 117, 4, 92);
f.fillRect(250, 117, 173, 4);
g.fillRect(557, 117, 135, 4);
h.fillRect(423, 117, 135, 4);
i.fillRect(557, 67, 4, 50);
j.fillRect(423, 67, 135, 4);
k.fillRect(250, 67, 173, 4);
l.fillRect(250, 67, 4, 54);
m.fillRect(692, 117, 125, 4);
n.fillRect(692, 205, 125, 4);
o.fillRect(817, 117, 4, 92);
p.fillRect(908, 67, 4, 85);
q.fillRect(817, 237, 95, 4);
r.fillRect(817, 67, 95, 4);
s.fillRect(908, 152, 4, 85);
t.fillRect(817, 67, 4, 50);
u.fillRect(817, 205, 4, 32);
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
        t.dispose();
        u.dispose();
    }
}
