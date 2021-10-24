import java.awt.*;
import java.applet.*;

public class olympic extends Applet {
 public void paint(Graphics g) {
   setBackground (Color.gray);
   g.setColor(Color.blue);
   g.drawOval(30, 50, 100, 100);
   g.setColor(Color.black);
   g.drawOval(140, 50, 100, 100);
   g.setColor(Color.red);
   g.drawOval(250, 50, 100, 100);
   g.setColor(Color.green);
   g.drawOval(195, 110, 100, 100);
   g.setColor(Color.yellow);
   g.drawOval(85, 110, 100, 100);
  }
}