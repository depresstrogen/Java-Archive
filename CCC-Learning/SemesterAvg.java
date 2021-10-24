import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Scanner;
public class SemesterAvg implements ActionListener {
	static JFrame frame;
	static JPanel contentPane;
	static JLabel prompt1, prompt2, prompt3, prompt4, average;
	static JTextField grade1, grade2, grade3, grade4;
	static JButton button;

	public SemesterAvg() {
		frame = new JFrame("SemesterAvg");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(0, 2, 10, 5));
		contentPane.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

		prompt1 = new JLabel("Enter the first grade: ");
		contentPane.add(prompt1);
		
		grade1 = new JTextField(10);
		contentPane.add(grade1);
		
		prompt2 = new JLabel("Enter the second grade: ");
		contentPane.add(prompt2);
		
		grade2 = new JTextField(10);
		contentPane.add(grade2);
		
		prompt3 = new JLabel("Enter the third grade: ");
		contentPane.add(prompt3);
		
		grade3 = new JTextField(10);
		contentPane.add(grade3);
		
		prompt4 = new JLabel("Enter the fourth grade: ");
		contentPane.add(prompt4);
		
		grade4 = new JTextField(10);
		contentPane.add(grade4);

		button = new JButton("Calculate");
		button.setAlignmentX(JButton.CENTER_ALIGNMENT);
		button.setActionCommand("Avg");
		button.addActionListener(this);
		contentPane.add(button);
		
		average = new JLabel(" ");
		contentPane.add(average);

		frame.setContentPane(contentPane);

		frame.pack();
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand();
		if (eventName.contentEquals("Avg")) {
			double avgGrade;
			String g1 = grade1.getText();
			String g2 = grade2.getText();
			String g3 = grade3.getText();
			String g4 = grade4.getText();
			avgGrade = (Double.parseDouble(g1) + Double.parseDouble(g2) + Double.parseDouble(g3) + Double.parseDouble(g4)) / 4;
			average.setText(Double.toString(avgGrade));
		}
	}

	private static void runGUI() {
		SemesterAvg grades = new SemesterAvg();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				runGUI();
			}
			
		});
		int run = sc.nextInt();
		if (run == 1) {
			contentPane.setBackground(Color.BLUE);
			frame.repaint();
		}
	}
}