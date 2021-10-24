
import java.awt.MouseInfo;
import java.util.concurrent.TimeUnit;

public class Cords {

    public static void main(String[] args) throws InterruptedException {
        while(true == true)
        {
        TimeUnit.SECONDS.sleep(1/2);
        double mouseX = MouseInfo.getPointerInfo().getLocation().getX();
        double mouseY = MouseInfo.getPointerInfo().getLocation().getY();
        System.out.println(mouseX);
        System.out.println(mouseY);
        }

    }

}