import java.awt.*;
import java.applet.*;

public class dipper extends Applet {
 String dip;
 public void init() {
   dip="Big Dipper";
 }
 public void paint(Graphics g) {
   setBackground (Color.black);
   g.setColor(Color.red);
   g.drawLine(55, 55, 105, 55);
   g.drawLine(105, 55, 155, 95);
   g.drawLine(155, 95, 205, 135);
   g.drawLine(205, 135, 205, 185);
   g.drawLine(205, 185, 285, 195);
   g.drawLine(285, 195, 305, 145);
   g.drawLine(305, 145, 205, 135);
    
   g.fillOval(50, 50, 10, 10);
   g.fillOval(100, 50, 10, 10);
   g.fillOval(150, 90, 10, 10);
   g.fillOval(200, 130, 10, 10);
   g.fillOval(200, 180, 10, 10);
   g.fillOval(300, 140, 10, 10);
   g.fillOval(280, 190, 10, 10);
   
   g.setColor(Color.white);
   g.drawString(dip, 150, 250);
  }
}