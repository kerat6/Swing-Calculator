import javax.swing.*;
import java.awt.*;

/*
 * Program Name: GuiApplication.java
 * Purpose: A GUI Application for a Calculator.
 * @author: Tarek Al-Ahmadieh Student#: 0898279
 * Today's Date: July 28, 2025
 */

public class GuiApplication {
	/**
	*Method Name: handleButton()    <br>
	*Purpose: a public class method that will take a label, a calculator, and 3 text fields to determine how a button click should be handled.    <br>
	*Accepts: label, calculator, and 3 JTextFields    <br>
	*Returns: nothing    <br>
	*Coder: TA    <br>
	*Date: August 1, 2025    <br>
	*/
	public static void handleButton(String label, Calculator calc, JTextField accumulator, JTextField register, JTextField operator) {
	// if statement to match multiple button labels
		// digits 0-9 and A-F
		if(label.matches("[0-9A-F]")) {
			calc.inputDigit(label);
			register.setText(calc.format(calc.getRegister()));
		}
		// button to clear accumulator
		else if(label.equals("ClrA")) {
			calc.clearAccumulator();
			accumulator.setText(calc.format(calc.getAccumulator()));
		}
		// button to clear register
		else if(label.equals("ClrR")) {
			calc.clearRegister();
			register.setText(calc.format(calc.getRegister()));
		}
		// button to clear all fields
		else if(label.equals("CLR")) {
			calc.clearAll();
			accumulator.setText(calc.format(calc.getAccumulator()));
			register.setText(calc.format(calc.getRegister()));
		}
		// button to change the leading sign of register number
		else if(label.equals("+/-")) {
			calc.toggleSign();
			accumulator.setText(calc.format(calc.getAccumulator()));
			register.setText(calc.format(calc.getRegister()));
		}
		// button to delete most recent digit in register
		else if(label.equals("back")) {
			calc.backspace();
			register.setText(calc.format(calc.getRegister()));
		}
		// button to perform calculations
		else if(label.equals("=")) {
			calc.calculate();
			accumulator.setText(calc.format(calc.getAccumulator()));
			register.setText(calc.format(calc.getRegister()));
		}
		// button to close the calculator
		else if(label.equals("Exit")) {
			System.exit(0);
		}
		else if(label.equals("mod")) {
			calc.setOperator("%");
			operator.setText("%");
		}
		// button to set operator to AND
		else if(label.equals("and")) {
			calc.setOperator("AND");
			operator.setText("AND");
		}
		// button to set operator to NAND
		else if(label.equals("nand")) {
			calc.setOperator("NAND");
			operator.setText("NAND");
		}
		// button to set operator to OR
		else if(label.equals("or")) {
			calc.setOperator("OR");
			operator.setText("OR");
		}
		// button to set operator to NOR
		else if(label.equals("nor")) {
			calc.setOperator("NOR");
			operator.setText("NOR");
		}
		// button to set operator to XOR
		else if(label.equals("xor")) {
			calc.setOperator("XOR");
			operator.setText("XOR");
		}
		// button to set operator to NOT
		else if(label.equals("not")) {
			calc.setOperator("NOT");
		    operator.setText("NOT");
		}
		// button to set operator to multiplication
		else if(label.equals("*")) {
			calc.setOperator("*");
			operator.setText("*");
		}
		// button to set operator to division
		else if(label.equals("/")) {
			calc.setOperator("/");
			operator.setText("/");
		}
		// button to set operator to addition
		else if(label.equals("+")) {
			calc.setOperator("+");
			operator.setText("+");
		}
		// button to set operator to subtraction
		else if(label.equals("-")) {
			calc.setOperator("-");
			operator.setText("-");
		}
		// button to set operator to left shift
		else if(label.equals("<<")) {
			calc.setOperator("<<");
			operator.setText("<<");
		}
		// button to set operator to right shift
		else if(label.equals(">>")) {
			calc.setOperator(">>");
			operator.setText(">>");
		}
	}
	/**
	*Method Name: setBaseDigitButtons()    <br>
	*Purpose: a public class method that will take a JButton, and a NumberSystem base, and determine what buttons should be disabled.    <br>
	*Accepts: JButton, and a NumberSystem base    <br>
	*Returns: nothing    <br>
	*Coder: TA    <br>
	*Date: August 1, 2025    <br>
	*/
	public static void setBaseDigitButtons(JButton[] digitButtons, Calculator.NumberSystem base) {
	    // Enable all by default
	    for (int i = 0; i < digitButtons.length; i++) {
	        digitButtons[i].setEnabled(true);
	    }
	    // Disable invalid buttons for each base
	    switch (base) {
	        case BIN:
	            // Only 0,1 enabled
	            for (int i = 2; i < digitButtons.length; i++) digitButtons[i].setEnabled(false);
	            break;
	        case OCT:
	            // 8,9,A–F disabled
	            for (int i = 8; i < digitButtons.length; i++) digitButtons[i].setEnabled(false);
	            break;
	        case DEC:
	            // A–F disabled
	            for (int i = 10; i < digitButtons.length; i++) digitButtons[i].setEnabled(false);
	            break;
	        case HEX:
	            // All enabled
	            break;
	    }
	}
	
	public static void main(String[] args) {
		//Creating the Frame
		JFrame frame = new JFrame ("Tarek's Calculator");
		
		// Creating Border layout for frame
		frame.setLayout(new BorderLayout(10, 10));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 400);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		// Creating accumulator, register, and operator text fields, and assigning properties
		JTextField accumulator = new JTextField(20);
		accumulator.setEditable(false);
		accumulator.setForeground(java.awt.Color.BLACK);
		accumulator.setHorizontalAlignment(JTextField.CENTER);
		accumulator.setText("0");
		accumulator.setFont(new Font("Arial", Font.BOLD, 20));
		
		JTextField register = new JTextField(20);
		register.setEditable(false);
		register.setForeground(java.awt.Color.RED);
		register.setHorizontalAlignment(JTextField.CENTER);
		register.setText("0");
		register.setFont(new Font("Arial", Font.BOLD, 20));
		
		JTextField operator = new JTextField(20);
		operator.setEditable(false);
		operator.setForeground(java.awt.Color.DARK_GRAY);
		operator.setHorizontalAlignment(JTextField.CENTER);
		operator.setText("+");
		operator.setFont(new Font("Arial", Font.BOLD, 15));
		
		// Customizing the text fields to remove borders
		accumulator.setBorder(null);
		register.setBorder(null);
		operator.setBorder(null);
		
		// GridLayout parameters
		int rows = 6;
		int columns = 6;
		int rowGap = 5;
		int colGap = 5;
		
		// Creating button panel
		JPanel buttonPanel = new JPanel(new GridLayout(rows, columns, rowGap, colGap));
		// Create a string array for the button labels
		String[][] buttonLabels = {
				{"and", "nand", "or", "nor", "xor", "not"},
				{"*", "/", "+", "-", "<<", ">>"},
				{"7", "8", "9", "A", "D", "ClrA"},
				{"4", "5", "6", "B", "E", "ClrR"},
				{"1", "2", "3", "C", "F", "CLR"},
				{"+/-", "0", "back", "=", "mod", "Exit"}
		};
		
		// Create an instance of calculator
		Calculator calc = new Calculator();
		
		// Create an array to hold the buttons
		JButton[] digitButtons = new JButton[16];
		
		// Loop to create buttons and add to frame
		for (int i = 0; i < buttonLabels.length; i++) {
			for(int j = 0; j < buttonLabels[i].length; j++) {
				String label = buttonLabels[i][j];
				JButton button = new JButton(label);
				button.setFont(new Font("sans-serif", Font.BOLD, 10));
				buttonPanel.add(button);
				
				// Store digit buttons in the array
				if(label.matches("[0-9]")) {
				digitButtons[Integer.parseInt(label)] = button;
				}
				else if(label.matches("[A-F]")) {
					digitButtons[10 + (label.charAt(0) - 'A')] = button;
				}
				
				// Adding action listeners to buttons
				button.addActionListener(e -> {
				    handleButton(label, calc, accumulator, register, operator);
				});
				
			}
		}
		
		// Set the base to DEC by default
		setBaseDigitButtons(digitButtons, Calculator.NumberSystem.DEC);
		
		// Creating 4 radio buttons for the dec, hex, oct, and bin number systems
		JRadioButton dec, hex, oct, bin;
		dec = new JRadioButton("dec");
		hex = new JRadioButton("hex");
		oct = new JRadioButton("oct");
		bin = new JRadioButton("bin");
		
		// Grouping the radio buttons for mutual exclusivity
		ButtonGroup numberSystem = new ButtonGroup();
		numberSystem.add(dec);
		numberSystem.add(hex);
		numberSystem.add(oct);
		numberSystem.add(bin);
		
		// Add action listeners to radio buttons for base conversion
		dec.addActionListener(e -> {
		    calc.setBase(Calculator.NumberSystem.DEC);
		    accumulator.setText(calc.format(calc.getAccumulator()));
		    register.setText(calc.format(calc.getRegister()));
		    setBaseDigitButtons(digitButtons, Calculator.NumberSystem.DEC);
		});
		hex.addActionListener(e -> {
		    calc.setBase(Calculator.NumberSystem.HEX);
		    accumulator.setText(calc.format(calc.getAccumulator()));
		    register.setText(calc.format(calc.getRegister()));
		    setBaseDigitButtons(digitButtons, Calculator.NumberSystem.HEX);
		});
		oct.addActionListener(e -> {
		    calc.setBase(Calculator.NumberSystem.OCT);
		    accumulator.setText(calc.format(calc.getAccumulator()));
		    register.setText(calc.format(calc.getRegister()));
		    setBaseDigitButtons(digitButtons, Calculator.NumberSystem.OCT);
		});
		bin.addActionListener(e -> {
		    calc.setBase(Calculator.NumberSystem.BIN);
		    accumulator.setText(calc.format(calc.getAccumulator()));
		    register.setText(calc.format(calc.getRegister()));
		    setBaseDigitButtons(digitButtons, Calculator.NumberSystem.BIN);
		});
		
		// add the displays to a panel
		JPanel displayPanel = new JPanel();
		displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
		displayPanel.add(accumulator);
		displayPanel.add(register);
		displayPanel.add(operator);
		
		//add the radio buttons to a panel and set dec as default selected numberSystem
		JPanel numberSystemPanel = new JPanel();
		numberSystemPanel.setLayout(new BoxLayout (numberSystemPanel, BoxLayout.Y_AXIS));
		numberSystemPanel.add(dec);
		numberSystemPanel.add(hex);
		numberSystemPanel.add(oct);
		numberSystemPanel.add(bin);
		
		// Creating a panel for radio buttons and calculator buttons together
		JPanel lowerPanel = new JPanel(new BorderLayout());
		lowerPanel.add(numberSystemPanel, BorderLayout.WEST);
		lowerPanel.add(buttonPanel, BorderLayout.CENTER);
		
		// add menu bar for help menu and about menu
		JMenuBar menuBar = new JMenuBar();
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
		JMenu aboutMenu = new JMenu("About");
		menuBar.add(aboutMenu);
		
		// add menu items to the help and about menus
		JMenuItem helpItem = new JMenuItem("Help");
		JMenuItem aboutItem = new JMenuItem("About");

		// add listeners for help and about menus to have pop-ups
		helpItem.addActionListener(e -> {
			JOptionPane.showMessageDialog(frame,  "How to use Tarek's Calculator app:\n\n"
		+ "1. Select the number system you want to use\n"
		+ "2. Select the numbers you want to input\n"
		+ "3. Click the '=' button to add the initial number to the register\n"
		+ "4. Add your next number, select an operator, and click '=' again\n"
		+ "5. Repeat step 4 until you've finished");
		});
		
		aboutItem.addActionListener(e -> {
			JOptionPane.showMessageDialog(frame,  "This is Tarek's Calculator app.\n"
					+ "Student#: 0898279\n"
					+ "Submitted for Project 2's Calculator Project");
		});
		
		helpMenu.add(helpItem);
		aboutMenu.add(aboutItem);
		frame.setJMenuBar(menuBar);
		
		// add the panels to the frame
		frame.add(displayPanel, BorderLayout.NORTH);
		frame.add(lowerPanel, BorderLayout.CENTER);
		
		// Set the default radio button to dec
		dec.setSelected(true);
		
	} //End of main
	
} //End of class
