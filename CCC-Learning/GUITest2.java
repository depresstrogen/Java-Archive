import javax.swing.*;
import java.awt.event.*;
import java.awt.GridLayout;

public class GUITest2 implements ActionListener {
	final static String LABEL_TEXT = "Ya boi";
	JFrame frame;
	JPanel contentPane;
	JLabel label;
	JButton button;

	public GUITest2() {
		frame = new JFrame("GUITest2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(1, 2, 10, 5));
		contentPane.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

		label = new JLabel(LABEL_TEXT);
		label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		contentPane.add(label);

		button = new JButton("Hide");
		button.setAlignmentX(JButton.CENTER_ALIGNMENT);
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

		GUITest2 greeting = new GUITest2();
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				runGUI();
			}
		});
	}
}