import javax.swing.*;
import java.awt.event.*;
public class DiscountCC implements ActionListener {
  final static String LABEL_TEXT = "Ya boi";
  int n = 0;
  JFrame frame;
  JPanel contentPane;
  JLabel label;
  JButton button;
  
  public DiscountCC() {
    frame = new JFrame("DiscountCC");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    contentPane = new JPanel();
    
    label = new JLabel(LABEL_TEXT);
    contentPane.add(label);
    
    button = new JButton("You have clicked the button 0 times");
    button.addActionListener(this);
    contentPane.add(button);
    
    frame.setContentPane(contentPane);
    
    frame.pack();
    frame.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent event) {
    n ++;
    String eventName = event.getActionCommand();
    button.setText("You have clicked the button " + n + " times");
  }
  
  private static void runGUI() {
    JFrame.setDefaultLookAndFeelDecorated(true);
    
    DiscountCC greeting = new DiscountCC();
  }
  
  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        runGUI(); 
      }
    });
  }
}