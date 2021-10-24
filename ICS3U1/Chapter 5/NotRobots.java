import java.awt.Color;
import becker.robots.*;

public class NotRobots {
  public static void main(String[] args) {
    
    City city = new City("city.txt");
    Robot wasteYute = new Robot(city, 2,1, Direction.EAST);
    
    while (true) {
      wasteYute.move();
      if (wasteYute.canPickThing()) {
        wasteYute.pickThing(); 
      }
    }
  }
}