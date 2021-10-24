import becker.robots.*;
public class RobotAgain {
  public static void main(String[] args) {
    int wallCount = -1;
    City city = new City("trial.txt");
    Robot yaBoi = new Robot(city, 1,2,Direction.EAST);
    while (wallCount <= 20) {
      Wall berlin = new Wall(city,wallCount,1, Direction.EAST);
      wallCount ++;
    }
    
  }
}