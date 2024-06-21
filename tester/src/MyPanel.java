import java.awt.*;
import javax.swing.*;
import java.util.List;

public class MyPanel extends JPanel{
 List<Node> path;
 Image image;
 
 MyPanel(List<Node> paths){
  path = paths;
  image = new ImageIcon("../DijkstraGomla/tester/src/imageinput.jpg").getImage();
  this.setPreferredSize(new Dimension(1032,515));
 }
 
 public void paint(Graphics g) {
  
  Graphics2D g2D = (Graphics2D) g;
  
  g2D.drawImage(image, 0, 0, null);
  

List<Node> smollestPath = path;
for (int ic = 1; ic < smollestPath.size(); ic++) {
    if(smollestPath.get(ic).getName() == "BC"){
        switch (smollestPath.get(ic-1).getName()) {
            case "Bread":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(250, 117, 173, 4);
                break;
            case "IcecreamCereal":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(557, 117, 135, 4);
                break;
            case "TL":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(557, 117, 4, 92);
                break;
            case "Start":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(557, 67, 4, 50);
                break;
        }
    }else if(smollestPath.get(ic).getName() == "Start"){
        switch (smollestPath.get(ic-1).getName()) {
            case "BC":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(557, 67, 4, 50);
                break;
            case "Deli":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(423, 67, 135, 4);
                break;
        }
    }else if(smollestPath.get(ic).getName() == "Ie"){
        switch (smollestPath.get(ic-1).getName()) {
            case "IcecreamCereal":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(692, 117, 125, 4);
                break;
            case "Fruit":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(817, 67, 4, 50);
                break;
            case "Le":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(817, 117, 4, 92);
                break;
        }
    }else if(smollestPath.get(ic).getName() == "Le"){
        switch (smollestPath.get(ic-1).getName()) {
            case "Veggies":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(817, 205, 4, 32);
                break;
            case "Laundry":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(692, 205, 125, 4);
                break;
            case "Ie":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(817, 117, 4, 92);
                break;
        }
    }else if(smollestPath.get(ic).getName() == "S"){
        switch (smollestPath.get(ic-1).getName()) {
            case "Deli":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(423, 67, 135, 4);
                break;
            case "BC":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(557, 67, 4, 50);
                break;
        }
    }else if(smollestPath.get(ic).getName() == "Bb"){
        switch (smollestPath.get(ic-1).getName()) {
            case "Dbl":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(250, 67, 4, 50);
                break;
            case "Tb":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(250, 117, 4, 92);
                break;
            case "Bread":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(250, 117, 173, 4);
                break;
        }
    }else if(smollestPath.get(ic).getName() == "Dbl"){
        switch (smollestPath.get(ic-1).getName()) {
            case "Deli":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(250, 67, 173, 4);
                break;
            case "Bb":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(250, 67, 4, 50);
                break;
        }
    }else if(smollestPath.get(ic).getName() == "Tb"){
        switch (smollestPath.get(ic-1).getName()) {
            case "TeaSpices":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(250, 205, 173, 4);
                break;
            case "Bb":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(250, 117, 4, 92);
                break;
        }
    }else if(smollestPath.get(ic).getName() == "Dbr"){
        switch (smollestPath.get(ic-1).getName()) {
            case "Dairy":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(908, 67, 4, 85);
                break;
            case "Fruit":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(817, 67, 95, 4);
                break;
        }
    }else if(smollestPath.get(ic).getName() == "Fruit"){
        switch (smollestPath.get(ic-1).getName()) {
            case "Ie":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(817, 67, 4, 50);
                break;
            case "Dbr":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(817, 67, 95, 4);
                break;
        }
    }else if(smollestPath.get(ic).getName() == "Veggies"){
        switch (smollestPath.get(ic-1).getName()) {
            case "Le":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(817, 205, 4, 32);
                break;
            case "De":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(817, 237, 95, 4);
                break;
        }
    }else if(smollestPath.get(ic).getName() == "Deli"){
        switch (smollestPath.get(ic-1).getName()) {
            case "S":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(423, 67, 135, 4);
                break;
            case "Dbl":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(250, 67, 173, 4);
                break;
        }
    }else if(smollestPath.get(ic).getName() == "TeaSpices"){
        switch (smollestPath.get(ic-1).getName()) {
            case "Tb":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(250, 205, 173, 4);
                break;
            case "TL":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(423, 205, 135, 4);
                break;
        }
    }else if(smollestPath.get(ic).getName() == "Bread"){
        switch (smollestPath.get(ic-1).getName()) {
            case "BC":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(423, 117, 135, 4);
                break;
            case "Bb":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(250, 117, 173, 4);
                break;
        }
    }else if(smollestPath.get(ic).getName() == "TL"){
        switch (smollestPath.get(ic-1).getName()) {
            case "BC":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(557, 117, 4, 92);
                break;
            case "TeaSpices":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(423, 205, 135, 4);
                break;
            case "Laundry":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(557, 205, 135, 4);
                break;
        }
    }else if(smollestPath.get(ic).getName() == "IcecreamCereal"){
        switch (smollestPath.get(ic-1).getName()) {
            case "BC":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(557, 117, 135, 4);
                break;
            case "Ie":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(692, 117, 125, 4);
                break;
        }
    }else if(smollestPath.get(ic).getName() == "Laundry"){
        switch (smollestPath.get(ic-1).getName()) {
            case "TL":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(557, 205, 135, 4);
                break;
            case "Le":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(692, 205, 125, 4);
                break;
        }
    }else if(smollestPath.get(ic).getName() == "Dairy"){
        switch (smollestPath.get(ic-1).getName()) {
            case "Dbr":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(908, 67, 4, 85);
                break;
            case "De":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(908, 152, 4, 85);
                break;
        }
    }else if(smollestPath.get(ic).getName() == "De"){
        switch (smollestPath.get(ic-1).getName()) {
            case "Veggies":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(817, 237, 95, 4);
                break;
            case "Dairy":
            g2D.setColor(new Color(0,0,0));
            g2D.fillRect(908, 152, 4, 85);
                break;
        }
    }
}
 }
}