package sudoku.main;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import java.awt.CardLayout;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Window;
import javax.swing.Icon;
import java.awt.FlowLayout;

public class GroupNameA17SudokuContent extends JPanel implements ActionListener,ItemListener {

	private JPanel centralPanel = new JPanel();
	private JPanel descriptionCard = new JPanel();
	private	JToggleButton tglbtnCredits = new JToggleButton("Crèdits");
	private JToggleButton tglbtnLlicencia = new JToggleButton("Llicència");
	private JLabel lblNewLabel;
	private JLabel lblversion;
	private JLabel lbltext;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1;
	

	public GroupNameA17SudokuContent() {

		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(100, 100, 450, 300);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		add(panel);
		
		lblNewLabel = new JLabel();
		panel.add(lblNewLabel);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(new ImageIcon(GroupNameA17Sudoku.class.getResource("/activities/sudoku/sudoku.png")).getImage().getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH)));

		JPanel topPanel = new JPanel();
		add(topPanel);
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblversion = new JLabel("SudokuFilaW2");
		lblversion.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		topPanel.add(lblversion);
		
		lblNewLabel_2 = new JLabel("v1.0");
		topPanel.add(lblNewLabel_2);
		
		add(centralPanel);
		centralPanel.setLayout(new CardLayout(0, 0));
		
		centralPanel.add(descriptionCard, "name_16890827109362");
		descriptionCard.setLayout(new BoxLayout(descriptionCard, BoxLayout.Y_AXIS));
		
		lbltext = new JLabel("Sudoku made with love from junior developers </>");
		descriptionCard.add(lbltext);
		lbltext.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbltext.setBounds(0, 0, 298, 15);
		
		Component verticalGlue_1 = Box.createVerticalGlue();
		descriptionCard.add(verticalGlue_1);
		lblNewLabel.setIcon(new ImageIcon(new ImageIcon(GroupNameA17Sudoku.class.getResource("/activities/sudoku/sudoku.png")).getImage().getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH)));
		
		JLabel Image = new JLabel("");
		Image.setAlignmentX(Component.CENTER_ALIGNMENT);
		descriptionCard.add(Image);
		Image.setIcon(new ImageIcon(new ImageIcon(GroupNameA17Sudoku.class.getResource("/activities/sudoku/image.png")).getImage().getScaledInstance(128, 96,  java.awt.Image.SCALE_SMOOTH)));
		
		
		JLabel copyRight = new JLabel("Ⓒ 2017");
		descriptionCard.add(copyRight);
		copyRight.setAlignmentX(Component.CENTER_ALIGNMENT);
		copyRight.setBounds(298, 0, 171, 15);

		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		centralPanel.add(editorPane, "name_17026790691801");
		java.net.URL creditsURL = GroupNameA17Sudoku.class.getResource("/activities/sudoku/RamJuaA17Credits.html");
		try {
			editorPane.setPage(creditsURL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		centralPanel.add(scrollPane, "name_17713231550199");
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		java.net.URL licenseURL = GroupNameA17Sudoku.class.getResource("/activities/sudoku/RamJuaA11License.html");
		try {
			textPane.setPage(licenseURL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Component verticalGlue = Box.createVerticalGlue();
		add(verticalGlue);
		
		JPanel bottomPanel = new JPanel();
		add(bottomPanel);
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
		
		
		tglbtnLlicencia.setAlignmentX(Component.LEFT_ALIGNMENT);
		bottomPanel.add(tglbtnLlicencia);
		tglbtnLlicencia.addItemListener(this);
		
		Component horizontalStrut = Box.createHorizontalStrut(10);
		bottomPanel.add(horizontalStrut);
		
		
		tglbtnCredits.setAlignmentX(Component.LEFT_ALIGNMENT);
		bottomPanel.add(tglbtnCredits);
		tglbtnCredits.addItemListener(this);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		bottomPanel.add(horizontalGlue_1);
		
		JButton tglbtnTancar = new JButton("Tancar");
		tglbtnTancar.setAlignmentX(Component.RIGHT_ALIGNMENT);
		bottomPanel.add(tglbtnTancar);
		tglbtnTancar.addActionListener(this);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {		
		if (e.getStateChange()== ItemEvent.SELECTED) {
			switch (((JToggleButton) e.getItemSelectable()).getText()) {
			case "Llicència":
				if(tglbtnLlicencia.isSelected()){
				((CardLayout) centralPanel.getLayout()).show(centralPanel,"name_17713231550199");
				tglbtnCredits.setSelected(false);
				}
				
				break;
				
			case "Crèdits":
				if(tglbtnCredits.isSelected()){
					((CardLayout) centralPanel.getLayout()).show(centralPanel,"name_17026790691801");
					tglbtnLlicencia.setSelected(false);
					}
				
				break;
				
			default:
				break;
			}
		}
				
		else if(!tglbtnCredits.isSelected() && !tglbtnLlicencia.isSelected()) {
			((CardLayout) centralPanel.getLayout()).show(centralPanel,"name_16890827109362");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		((Window) getRootPane().getParent()).dispose();
		
	}

	public Icon getProgramIcon() {
		return lblNewLabel.getIcon();
	}
	public void setProgramIcon(Icon icon) {
		lblNewLabel.setIcon(icon);
	}
	public String getProgramName() {
		return lblversion.getText();
	}
	public void setProgramName(String text) {
		lblversion.setText(text);
	}
	public String getProgramDescription() {
		return lbltext.getText();
	}
	public void setProgramDescription(String text_1) {
		lbltext.setText(text_1);
	}
	public String getProgramVersion() {
		return lblNewLabel_2.getText();
	}
	public void setProgramVersion(String text_2) {
		lblNewLabel_2.setText(text_2);
	}
	public String getProgramCopyright() {
		return lblNewLabel_1.getText();
	}
	public void setProgramCopyright(String text_3) {
		lblNewLabel_1.setText(text_3);
	}
}
