import java.awt.*;
import java.applet.*;

public class Shapes_color extends Applet {
  public void paint(Graphics g) {
    setBackground (Color.darkGray);
    g.setColor(Color.red);
    g.drawRect(50, 50, 40, 40);
    g.setColor(Color.red);
    g.fillRect(100, 100, 150, 150);
    g.setColor(Color.red);
    g.fillOval(250, 250, 50, 50);
    g.setColor(Color.red);
    g.drawLine(20, 20, 30, 20);
  }
}