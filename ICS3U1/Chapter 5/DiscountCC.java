import javax.swing.*;
import java.awt.event.*;
public class DiscountCC implements ActionListener {
  final static String LABEL_TEXT = "Ya boi";
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
    
    button = new JButton("Hide");
    button.setActionCommand("Hide");
    button.addActionListener(this);
    contentPane.add(button);
    
    frame.setContentPane(contentPane);
    
    frame.pack();
    frame.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent event) {
    int n = 0;
    String eventName = event.getActionCommand();
    n ++;
    button.setText("You have clicked" + n);
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