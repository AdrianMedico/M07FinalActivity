package sudoku.main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GroupNameA17SudokuRulesDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GroupNameA17SudokuRulesDialog dialog = new GroupNameA17SudokuRulesDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GroupNameA17SudokuRulesDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JEditorPane editorPane = new JEditorPane();
				
		editorPane.setEditable(false);
		
		java.net.URL creditsURL = GroupNameA17Sudoku.class.getResource("/activities/sudoku/RamJuaA17Rules.html");
		
		try {
			editorPane.setPage(creditsURL);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		this.add(editorPane);
		this.setSize(500,800);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

}
