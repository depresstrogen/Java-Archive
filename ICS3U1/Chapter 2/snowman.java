import java.awt.*;
import java.applet.*;
import java.util.concurrent.TimeUnit;
import java.awt.MouseInfo;

public class snowman extends Applet {
public void init() {
 }
 public void paint(Graphics g) {
   setBackground (Color.white);
   // Chain
   g.setColor(Color.orange);
   g.drawOval(145, 90, 55, 55);
   g.setColor(Color.white); 
   g.fillRect(0, 0, 400, 120);
   g.setColor(Color.black); 
   // Hat
   g.fillRect(150, 20, 50, 50);
   g.drawLine(130, 70, 220, 70);  
   // Arms
   g.drawLine(100, 100, 132, 150);
   g.drawLine(250, 100, 210, 150);  
   // Body
   g.drawOval(150, 70, 40, 40);
   g.drawOval(132, 110, 80, 80);
   g.drawOval(116, 190, 120, 120);
   // Eyes
   g.fillOval(160, 80, 10, 10);
   g.fillOval(180, 80, 10, 10);
   // Flex
   g.drawString("Gucci Top Hat $2000 ->", 10, 50 );
   g.drawString("Gucci Belt $400 ->", 10, 200 );
   g.drawString("<- Gucci Gloves $600", 260, 105 );
   g.drawString("<- Gucci Chain $500", 230, 135 );
 }
}