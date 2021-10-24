import java.awt.Color;
import becker.robots.*;

public class NotRobot {
  public static void main(String[] args) {
    City myBum = new City();
    Robot laquisha = new Robot(myBum, 8,1, Direction.NORTH,100);
    laquisha.setColor(Color.BLACK);
    laquisha.putThing();
    laquisha.move();
    laquisha.putThing();
    laquisha.move();
    laquisha.putThing();
    laquisha.move();
    laquisha.putThing();
    laquisha.move();
    laquisha.putThing();
    laquisha.move();
    laquisha.putThing();
    laquisha.move();
    laquisha.putThing();
    laquisha.move();
    
    laquisha.turnLeft();
    laquisha.turnLeft();
    laquisha.turnLeft();
    laquisha.putThing();
    laquisha.move();
    laquisha.putThing();
    laquisha.move();
    laquisha.putThing();
    laquisha.move();
    laquisha.putThing();
    laquisha.move();
    
    laquisha.turnLeft();
    laquisha.turnLeft();
    laquisha.turnLeft();
    laquisha.putThing();
    laquisha.move();
    laquisha.putThing();
    laquisha.move();
    laquisha.putThing();
    laquisha.move();
    
    laquisha.turnLeft();
    laquisha.turnLeft();
    laquisha.turnLeft();
    laquisha.putThing();
    laquisha.move();
    laquisha.putThing();
    laquisha.move();
    laquisha.putThing();
    laquisha.move();
    laquisha.putThing();
    laquisha.move();
    
    laquisha.turnLeft();
    laquisha.putThing();
    laquisha.move();
    laquisha.move();
    laquisha.putThing();
    laquisha.turnLeft();
    laquisha.turnLeft();
    laquisha.turnLeft();
    laquisha.move();
    laquisha.putThing();
    laquisha.turnLeft();
    laquisha.move();
    laquisha.putThing();
    laquisha.turnLeft();
    laquisha.turnLeft();
    laquisha.turnLeft();
    laquisha.move();
    laquisha.putThing();
    
    while (true) {
      laquisha.turnLeft();
      laquisha.move();
      laquisha.setColor(Color.RED);
      laquisha.turnLeft();
      laquisha.move();
      laquisha.setColor(Color.YELLOW);
      laquisha.turnLeft();
      laquisha.move();
      laquisha.setColor(Color.CYAN);
      laquisha.turnLeft();
      laquisha.move();
      laquisha.setColor(Color.PINK);
    }
  }
}