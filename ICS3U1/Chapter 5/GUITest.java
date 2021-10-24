import javax.swing.*;
import java.awt.event.*;
public class GUITest implements ActionListener {
  final static String LABEL_TEXT = "Ya boi";
  JFrame frame;
  JPanel contentPane;
  JLabel label;
  JButton button;
  
  public GUITest() {
    frame = new JFrame("GUITest");
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
   String eventName = event.getActionCommand();
   
   if (eventName.equals("Hide")) {
    label.setText(" ");
    button.setText("Show");
    button.setActionCommand("Show");
   } else {
     label.setText(LABEL_TEXT);
    button.setText("Hide");
    button.setActionCommand("Hide");
   }
  }
  
  private static void runGUI() {
    JFrame.setDefaultLookAndFeelDecorated(true);
    
    GUITest greeting = new GUITest();
  }
  
  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        runGUI(); 
      }
    });
  }
}