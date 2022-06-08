import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*
 * This code uses one main class that works by displaying a 2D array.
 */
public class Main {

	/*
	 * The main method uses JOptionPane and a 2D boolean array to adjust the lightboard's settings based on a
	 * choice that the user makes, and then makes that change to the 2D boolean array to display it on the
	 * JOptionPane.
	 */
	public static void main(String[] args) {
		
		boolean play = true;
		while(play) {
			
			String title = "Tori's Lightboard";
			JOptionPane.showConfirmDialog(null, "Welcome to Tori's Light Board!", title, 0);

			int numRows = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Enter the number of rows you want your lightboard to have.\n(max of 6)", title, JOptionPane.QUESTION_MESSAGE, null, null, null));
			int numCols = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Enter the number of columns you want your lightboard to have.\n(max of 6)", title, JOptionPane.QUESTION_MESSAGE, null, null, null));
			if(numRows > 6) numRows = 6;
			if(numCols > 6) numCols = 6;
			
			
			boolean[][] lightBoard = new boolean[numRows][numCols];
			for(int r = 0; r < numRows; r++) {
				for(int c = 0; c < numCols; c++) {
					lightBoard[r][c] = Math.random() < 0.4;
				}
			}
			
			boolean menu = true;
			while(menu) {
				String text = printBoard(lightBoard) + "Choose how you would like to toggle your lights on/off.\n(O = on, X = off)";
				JLabel display = new JLabel("<html>" + text.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
				String[] choices = {"One Light", "All", "Row", "Column", "Section", "Randomize", "Exit"};
				int choice = JOptionPane.showOptionDialog(null, display, title, 0, JOptionPane.INFORMATION_MESSAGE, null, choices, null);
			
				//one light
				if(choice == 0) {
					int r = Integer.parseInt((String) JOptionPane.showInputDialog(null, printBoard(lightBoard) + "\nEnter the row number of the light you would like to toggle.", title, JOptionPane.QUESTION_MESSAGE, null, null, null));
					int c = Integer.parseInt((String) JOptionPane.showInputDialog(null, printBoard(lightBoard) + "\nEnter the column number of the light you would like to toggle.", title, JOptionPane.QUESTION_MESSAGE, null, null, null));
					String[] onOrOffOpt = {"On", "Off"};
					int onOrOff = JOptionPane.showOptionDialog(null, printBoard(lightBoard) + "\nWould you like to turn the light at row " + r + " and column " + c + " on or off?\n(O = on, X = off)", title, 0, JOptionPane.INFORMATION_MESSAGE, null, onOrOffOpt, null);
					boolean toggle = false;
					if(onOrOff == 0) toggle = true;
					r--;
					c--;
					lightBoard[r][c] = toggle;	
				}
			
				//all lights
				else if(choice == 1) {
					String[] onOrOffOpt = {"On", "Off"};
					int onOrOff = JOptionPane.showOptionDialog(null, printBoard(lightBoard) + "\nWould you like to turn all lights on or off?\n(O = on, X = off)", title, 0, JOptionPane.INFORMATION_MESSAGE, null, onOrOffOpt, null);
					boolean toggle = false;
					if(onOrOff == 0) toggle = true;
					for(int r = 0; r < numRows; r++) {
						for(int c = 0; c < numCols; c++) {
							lightBoard[r][c] = toggle;
						}
					}
				}
			
				//whole row
				else if(choice == 2) {
					int r = Integer.parseInt((String) JOptionPane.showInputDialog(null, printBoard(lightBoard) + "\nEnter the row number of the lights you would like to toggle.", title, JOptionPane.QUESTION_MESSAGE, null, null, null));
					String[] onOrOffOpt = {"On", "Off"};
					int onOrOff = JOptionPane.showOptionDialog(null, printBoard(lightBoard) + "\nWould you like to turn the lights in row " + r + " on or off?\n(O = on, X = off)", title, 0, JOptionPane.INFORMATION_MESSAGE, null, onOrOffOpt, null);
					boolean toggle = false;
					if(onOrOff == 0) toggle = true;
					r--;
					for(int c = 0; c < numCols; c++) {
						lightBoard[r][c] = toggle;
					}
				
				}
			
				//whole column
				else if(choice == 3) {
					int c = Integer.parseInt((String) JOptionPane.showInputDialog(null, printBoard(lightBoard) + "\nEnter the column number of the lights you would like to toggle.", title, JOptionPane.QUESTION_MESSAGE, null, null, null));
					String[] onOrOffOpt = {"On", "Off"};
					int onOrOff = JOptionPane.showOptionDialog(null, printBoard(lightBoard) + "\nWould you like to turn the lights in column " + c + " on or off?\n(O = on, X = off)", title, 0, JOptionPane.INFORMATION_MESSAGE, null, onOrOffOpt, null);
					boolean toggle = false;
					if(onOrOff == 0) toggle = true;
					c--;
					for(int r = 0; r < numRows; r++) {
						lightBoard[r][c] = toggle;
					}
				}
			
				//section
				else if(choice == 4) {
					int r1 = Integer.parseInt((String) JOptionPane.showInputDialog(null, printBoard(lightBoard) + "\nEnter the starting row number of the lights you would like to toggle.", title, JOptionPane.QUESTION_MESSAGE, null, null, null));
					int r2 = Integer.parseInt((String) JOptionPane.showInputDialog(null, printBoard(lightBoard) + "\nEnter the ending row number of the lights you would like to toggle.", title, JOptionPane.QUESTION_MESSAGE, null, null, null));
					int c1 = Integer.parseInt((String) JOptionPane.showInputDialog(null, printBoard(lightBoard) + "\nEnter the starting column number of the lights you would like to toggle.", title, JOptionPane.QUESTION_MESSAGE, null, null, null));
					int c2 = Integer.parseInt((String) JOptionPane.showInputDialog(null, printBoard(lightBoard) + "\nEnter the ending column number of the lights you would like to toggle.", title, JOptionPane.QUESTION_MESSAGE, null, null, null));
					String[] onOrOffOpt = {"On", "Off"};
					int onOrOff = JOptionPane.showOptionDialog(null, printBoard(lightBoard) + "\nWould you like to turn the lights from rows " + r1 + " to " + r2 + " and columns " + c1 + " to " + c2 + " on or off?\n(O = on, X = off)", title, 0, JOptionPane.INFORMATION_MESSAGE, null, onOrOffOpt, null);
					boolean toggle = false;
					if(onOrOff == 0) toggle = true;
					r1--;
					r2--;
					c1--;
					c2--;
					for(int r = r1; r <= r2; r++) {
						for(int c = c1; c <= c2; c++) {
							lightBoard[r][c] = toggle;
						}
					}
				
				}
			
				//randomize
				else if(choice == 5) {
					int percent = Integer.parseInt((String) JOptionPane.showInputDialog(null, printBoard(lightBoard) + "\n\nEnter the percent probability of a light being on in a random configuration (0-100).", title, JOptionPane.QUESTION_MESSAGE, null, null, null));
					for(int r = 0; r < numRows; r++) {
						for(int c = 0; c < numCols; c++) {
							lightBoard[r][c] = (Math.random() * 100) < percent;
						}
					}
				
				}
			
				//exit
				else if(choice == 6) {
					menu = false;
					play = false;
				}
			
		
			}
			
			
		}
		
		
	}

	/*
	 * This method takes in the 2D boolean array as a parameter to create a String which is displayed on the
	 * JOptionPane. True is represented as one character, and false as another. This method is ran again each
	 * time the user chooses a button to toggle the lightboard.
	 */
	private static String printBoard(boolean[][] lightBoard) {
		String ret = " - ";
		for(int i = 1; i < lightBoard[0].length+1; i++) {
			ret += i + "- ";
		}
		ret += "\n";
		String on = " O ";
		String off = " X ";
		int cols = 1;
		for(int r = 0; r < lightBoard.length; r++) {
			ret += cols + " ";
			cols++;
			for(int c = 0; c < lightBoard[0].length; c++) {
				if(lightBoard[r][c]) {
					ret += on;
				}
				else {
					ret += off;
				}
			}
			ret += "\n";
		}
		ret += "\n";
		return ret;
	}
	
	
}
