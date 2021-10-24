import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class imageConvert {
	public static void main(String[] args) {
		BufferedImage image;
		try {
		image = ImageIO.read(new File("miniMap.png"));
		} catch (Exception e) {
			image = new BufferedImage(0, 0, 0);
		}
		  FileReader in;
		  FileWriter out;
		  Scanner sc = new Scanner(System.in);
		  BufferedReader readFile;
		  BufferedWriter writeFile;
		  char[] nextLine = new char[image.getWidth()];
		try {
			// ObjectOutputStream basically puts all of the raw data in one file
			
			// Writes the ArrayList to the directory specified
			out = new FileWriter("map.txt",true);
			writeFile = new BufferedWriter(out);
			for(int y = 0; y < image.getHeight(); y++) {
				for(int x = 0; x < image.getWidth(); x++) {
					if (image.getRGB(x, y) == -65281) {
						System.out.print("d");
						
					} else {
						
					}
					System.out.print(image.getRGB(x, y));
				}
				System.out.println();
			}
			// Memory leaks are not cool
			
		} catch (Exception e) {
			System.err.println("IOExeption: " + e.getMessage());
		}
		
	}
}
