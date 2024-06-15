import java.awt.Graphics2D;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class App {
    public static void main(String[] args) throws IOException {

        // Node nodeA = new Node("A");
        // Node nodeB = new Node("B");
        // Node nodeC = new Node("C");

        // nodeA.addAdjacentNode(nodeB, 3);
        // nodeA.addAdjacentNode(nodeC, 9);

        // nodeB.addAdjacentNode(nodeC, 5);

        // Dijkstra dijkstra = new Dijkstra();
        // dijkstra.calculateShortestPath(nodeA);
        // dijkstra.printPaths(Arrays.asList(nodeA, nodeB, nodeC));

BufferedImage img = ImageIO.read(new File("../DijkstraGomla/tester/src/image.jpg"));
Graphics2D g = img.createGraphics();

// Draw on the BufferedImage via the graphics context.
int x = 0;
int y = 0;
int width = 100;
int height = 1000;
g.drawRect(x, y, width, height);

g.drawLine(10, 10, 500, 500);
File f = new File("../DijkstraGomla/tester/src/image.jpg");
		try {
			ImageIO.write(img, "jpg", f);
		} catch (IOException e) {
			e.printStackTrace();
		}
// Clean up -- dispose the graphics context that was created.
g.dispose();
    }
}
