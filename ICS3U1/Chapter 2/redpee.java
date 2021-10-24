/*
 * Example_Applet.java 
 */

import java.awt.*;
import java.applet.*;

public class Example_Applet extends Applet {
  
  String message;
  
  public void init() {
    message="Help, why is my pee red?";
  }
  
  public void paint(Graphics g) {
    g.setColor(Color.red);
    g.drawString(message, 100, 100 );
  }
}