package sudoku.main;

import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JPanel;

public class GroupNameA17SudokuDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel GroupNameA17SudokuContent = new GroupNameA17SudokuContent();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GroupNameA17SudokuDialog dialog = new GroupNameA17SudokuDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @throws IOException 
	 */
	public GroupNameA17SudokuDialog() throws IOException {
		setBounds(100, 100, 450, 300);
		GroupNameA17SudokuContent dialogContent = new GroupNameA17SudokuContent();
		setContentPane(dialogContent);
		
	}

}
