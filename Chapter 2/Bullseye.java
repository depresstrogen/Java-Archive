// The "Bullseye" class.
import java.awt.*;
import java.applet.Applet;

public class Bullseye extends Applet{
  final int MAX_WIDTH = 300;
  final int NUM_RINGS = 5;
  final int RING_WIDTH = 25;
  
  public void paint (Graphics g){
                                 
   setBackground(Color.cyan);
   int x = 0, y = 0;
   int diameter = MAX_WIDTH;
   
   for (int counter = 0 ; counter < NUM_RINGS ; counter++)
   {
    if (counter % 2 == 0)
      g.setColor (Color.black);
    else
      g.setColor (Color.white);
    g.fillOval (x, y, diameter, diameter);
    
    diameter -= (2 * RING_WIDTH);
    x += RING_WIDTH;
    y += RING_WIDTH;
   }
   g.setColor (Color.red);
   g.fillOval (x, y, diameter, diameter);
   }
}