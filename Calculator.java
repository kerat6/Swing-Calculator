/*
 * Program Name: Calculator.java
 * Purpose: A class that implements the computations and methods for a calculator.
 * @author: Tarek Al-Ahmadieh Student#: 0898279
 * Today's Date: August 1, 2025
 */

import javax.swing.JOptionPane;

public class Calculator {
	private int accumulator = 0;
	private int register = 0;
	private String operator = "+";
	private NumberSystem base = NumberSystem.DEC;
	
	public enum NumberSystem { DEC, HEX, OCT, BIN }
	
	// Getters and Setters
		public int getAccumulator() {
		return accumulator;
	}



	public void setAccumulator(int accumulator) {
		this.accumulator = accumulator;
	}



	public int getRegister() {
		return register;
	}



	public void setRegister(int register) {
		this.register = register;
	}



	public String getOperator() {
		return operator;
	}



	public void setOperator(String operator) {
		this.operator = operator;
	}



	public NumberSystem getBase() {
		return base;
	}



	public void setBase(NumberSystem base) {
		this.base = base;
	}

	/**
	*Method Name: calculate()    <br>
	*Purpose: a public class method that perform an operation based on what operator has been selected.   <br>
	*Accepts: nothing   <br>
	*Returns: nothing    <br>
	*Coder: TA    <br>
	*Date: August 1, 2025    <br>
	*/
	public void calculate() {
	    switch(operator) {
        case "+": accumulator += register; break;
        case "-": accumulator -= register; break;
        case "*": accumulator *= register; break;
        case "/": 
            if (register != 0) accumulator /= register; 
            else JOptionPane.showMessageDialog(null, "Cannot divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
            break;
        case "%":
            if (register != 0) accumulator %= register;
            else JOptionPane.showMessageDialog(null, "Cannot modulus by zero", "Error", JOptionPane.ERROR_MESSAGE);
            break;
        case "and": accumulator &= register; break;
        case "or":  accumulator |= register; break;
        case "xor": accumulator ^= register; break;
        case "nand": accumulator = ~(accumulator & register); break;
        case "nor":  accumulator = ~(accumulator | register); break;
        case "<<": accumulator <<= 1; break;
        case ">>": accumulator >>= 1; break;
        default: break;
        }
		register = 0; // Reset register after operation
	}
	
	/**
	*Method Name: inputDigit()    <br>
	*Purpose: a public class method that will add a number to the register text field  <br>
	*Accepts: a String    <br>
	*Returns: nothing    <br>
	*Coder: TA    <br>
	*Date: August 1, 2025    <br>
	*/
	public void inputDigit(String digit) {
		String current = format(register);
		// set the current value of register to blank to avoid extra 0's
		if(current.equals("0")) current = "";
	    switch (base) {
        case HEX:
            register = Integer.parseInt(current + digit, 16);
            break;
        case OCT:
            register = Integer.parseInt(current + digit, 8);
            break;
        case BIN:
            register = Integer.parseInt(current + digit, 2);
            break;
        default:
            register = Integer.parseInt(current + digit, 10);
            }
	    }

	/**
	*Method Name: toggleSign()    <br>
	*Purpose: a public class method convert the current value in register to negative or positive.  <br>
	*Accepts: nothing    <br>
	*Returns: nothing    <br>
	*Coder: TA    <br>
	*Date: August 1, 2025    <br>
	*/
	public void toggleSign() {
	register *= -1;
	}
	
	/**
	*Method Name: backspace()    <br>
	*Purpose: a public class method that will erase the last digit entered in the register.  <br>
	*Accepts: nothing    <br>
	*Returns: nothing    <br>
	*Coder: TA    <br>
	*Date: August 1, 2025    <br>
	*/
	public void backspace() {
		String current = format(register);
		if(current.length() > 1) {
			register = Integer.parseInt(current.substring(0, current.length()-1), getRadix());
		}
	}
	
	/**
	*Method Name: getRadix()    <br>
	*Purpose: a private class method that returns the radix based on the current base selected.  <br>
	* Accepts: nothing    <br>
	* Returns: an int representing the radix    <br>
	* Coder: TA    <br>
	* Date: August 1, 2025    <br>
	*/
	private int getRadix() {
		switch(base) {
		case HEX: return 16;
		case OCT: return 8;
		case BIN: return 2;
		default: return 10;
		}
	}
	
	/**
	 * Method Name: clearAccumulator()    <br>
	 * Purpose: a public class method that clears the accumulator value.  <br>
	 * Accepts: nothing    <br>
	 * Returns: nothing    <br>
	 * Coder: TA    <br>
	 * Date: August 1, 2025    <br>
	 */
	public void clearAccumulator() {
		accumulator = 0;
	}
	
	/**
	 * Method Name: clearRegister()    <br>
	 * Purpose: a public class method that clears the register value.  <br>
	 * Accepts: nothing    <br>
	 * Returns: nothing    <br>
	 * Coder: TA    <br>
	 * Date: August 1, 2025    <br>
	 */
	public void clearRegister() {
		register = 0;
	}
	
	/**
	 * Method Name: clearAll()    <br>
	 * Purpose: a public class method that clears all display field values.  <br>
	 * Accepts: nothing    <br>
	 * Returns: nothing    <br>
	 * Coder: TA    <br>
	 * Date: August 1, 2025    <br>
	 */
	public void clearAll() {
		accumulator = 0;
		register = 0;
		operator = "+";
	}

	/*
	 * Method Name: format()    <br>
	 * Purpose: a public class method that formats the integer value based on the current base selected.  <br>
	 * Accepts: an int value    <br>
	 * Returns: a String representing the formatted value    <br>
	 * Coder: TA    <br>
	 * Date: August 1, 2025    <br>
	 */
	public String format(int value) {
		switch(base) {
		case HEX:
			return Integer.toHexString(value).toUpperCase();
        case OCT: 
        	return Integer.toOctalString(value);
        case BIN: 
        	return Integer.toBinaryString(value);
        default:
			return Integer.toString(value);
		}
	}

} //end of class