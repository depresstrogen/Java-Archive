
public class ClassDayOne {
	
	public static void main(String[] args) {
		int x = 100;
		int y = 100;
		if (x <= 100)
		{
		    if (y > 100)
		    {
		        x = 200;
		    }
		    else
		    {
		        x = 99;
		    }
		}
		else
		{
		    x++;
		}
		y = x + y;
		System.out.println(x + " y:" + y);
	}
	
}
