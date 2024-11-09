import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener {
	
	JFrame frame = new JFrame(); // Creates instance for Frame
	JTextField textfield; // Instance for TextField
	JButton[] numberButtons = new JButton[10]; // An array of the 10 number buttons
	JButton[] functionButtons = new JButton[9]; // An array of the 9 function buttons
	JButton addButton, subButton, mulButton, divButton; // Declaration of variables
	JButton decButton, equButton, delButton, clrButton, negButton; // Declaration of variables
	JPanel panel;
	
	Font myFont = new Font("Arial", Font.PLAIN, 30); // Declare instance for Font (Arial and 30px)
	
	double num1 = 0, num2 = 0, result = 0; // Initialize numbers and result
	char operator; // Declare data type of operator
	
	
	Main() {
		
		frame = new JFrame("Calculator"); // Setting app title
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit app on close
		frame.setSize(420, 550); // Size of the frame
		frame.setLayout(null);
		frame.setResizable(false);
		
		textfield = new JTextField(); // Declare textfield as JTextField
		textfield.setBounds(50, 25, 300, 50); // Location of the TextField
		textfield.setFont(myFont); // Setting the textfield font
		textfield.setEditable(false); // Setting the app to be uneditable
		
		addButton = new JButton("+"); // Making button for Add
		subButton = new JButton("-"); // Making button for Subdivide
		mulButton = new JButton("x"); // Making button for Multiply
		divButton = new JButton("/"); // Making button for Divide
		decButton = new JButton("."); // Making button for Decimal
		equButton = new JButton("="); // Making button for Equal
		delButton = new JButton("Delete"); // Making button for Delete
		clrButton = new JButton("Clear"); // Making button for Clear
		negButton = new JButton("(-)");
		
		functionButtons[0] = addButton; // Declaring index of addButton
		functionButtons[1] = subButton; // Declaring index of subButton
		functionButtons[2] = mulButton; // Declaring index of mulButton
		functionButtons[3] = divButton; // Declaring index of divButton
		functionButtons[4] = decButton; // Declaring index of decButton
		functionButtons[5] = equButton; // Declaring index of equButton
		functionButtons[6] = delButton; // Declaring index of delButton
		functionButtons[7] = clrButton; // Declaring index of clrButton
		functionButtons[8] = negButton;
		
		for (int i = 0; i < 9; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		
		for (int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
		
		negButton.setBounds(50, 430, 100, 50);
		delButton.setBounds(150, 430, 100, 50); // Location for the Delete button
		clrButton.setBounds(250, 430, 100, 50); // Location for the Clear button
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300); // Location for this panel
		panel.setLayout(new GridLayout(4,4, 10, 10)); // Setting the layout for the grid of buttons + spacing
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton); // Adding the Delete button to frame
		frame.add(clrButton); // Adding the Clear button to frame
		frame.add(textfield); // Adding the textfield to frame
		frame.setVisible(true); // Setting frame to be visible
		
	}

	public static void main(String[] args) {
		
		Main calculator = new Main(); // Initialize constructor to main method
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Function of: when clicking a number button, it will add to the texfield
		
		for (int i = 0; i < 10; i++) {
			if (e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		
		// If statement to add a dot when the decimal button is clicked
		
		if (e.getSource() == decButton) { 
			textfield.setText(textfield.getText().concat("."));
		}
		
		// If statement to clear the first Number and move to the second Number to calculate
		
		if (e.getSource() == addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		
		if (e.getSource() == subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		
		if (e.getSource() == mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = 'x';
			textfield.setText("");
		}
		
		if (e.getSource() == divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		
		// If & switchcase to calculate the inputs
		
		if (e.getSource() == equButton) {
			num2 = Double.parseDouble(textfield.getText());
			
			switch(operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case 'x':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			}
			
				textfield.setText(String.valueOf(result));
				num1 = result;
				
			}
		
		// If statement to clear any inputs
		
		if (e.getSource() == clrButton) {
			textfield.setText("");
		}
		
		// If & loop to delete the last number clicked
		
		if (e.getSource() == delButton) {
			String string = textfield.getText();
			textfield.setText("");
			
			for(int i = 0; i < string.length() - 1; i++) {
				textfield.setText(textfield.getText() + string.charAt(i));
			}
		}
		
		// If statement to calculate negative inputs
		
		if (e.getSource() == negButton) {
			double negValue = Double.parseDouble(textfield.getText());
			negValue *= -1;
			textfield.setText(String.valueOf(negValue));
		}
	}
}
