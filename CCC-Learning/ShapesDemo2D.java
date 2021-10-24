import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;
 
/* 
 * This is like the FontDemo applet in volume 1, except that it 
 * uses the Java 2D APIs to define and render the graphics and text.
 */
 
public class ShapesDemo2D extends JApplet {
    static int p = 0;
    static int[][] board = new int[10][20];
    
    public void init() {       
    setBackground(Color.WHITE);
    setForeground(Color.BLACK);
    }

    
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        final int SQUARE_SIZE = 30;
        Color current = new Color(0,0,0);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(Color.RED);
        for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 20; i++) {
				if (board[j][i] != 0) {
					g2.fillRect(board[j][i] * SQUARE_SIZE, board[j][i]*SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
				}
			}
		}
    }
 
    public static void main(String s[]) {
    	Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int j = sc.nextInt();
        board[j][i] = 1;
        EventQueue.invokeLater( new Runnable() {
            public void run() {
            	JFrame f = new JFrame("Tetronimo");
                f.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {System.exit(0);}
                });
                JApplet applet = new ShapesDemo2D();
                f.pack();
                f.setSize(new Dimension(30 * 10, 30 * 20));
                f.setVisible(true);
                ShapesDemo2D p = new ShapesDemo2D();
                p.repaint();
            }
        } );
        
    }
 
}