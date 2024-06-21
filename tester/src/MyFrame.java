import java.util.List;
import javax.swing.*;

public class MyFrame extends JFrame{
 
 MyPanel panel;
 
 MyFrame(List<Node> path){
  
  panel = new MyPanel(path);
  
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.add(panel);
  this.pack();
  this.setLocationRelativeTo(null);
  this.setVisible(true);
 }  
}