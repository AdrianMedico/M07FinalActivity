package first_menu;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import java.awt.Font;

public class SelectorPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final ButtonGroup buttonGroupDifficult = new ButtonGroup();
	private final ButtonGroup buttonGroupSize = new ButtonGroup();
	private final ButtonGroup buttonGroupMode = new ButtonGroup();
	private JPanel modePanel, difPanel, sizePanel;
	private int size, diff, mode;
	protected boolean isImage;
	/**
	 * Create the panel.
	 */
	public SelectorPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel mainPanel = new JPanel();
		add(mainPanel);
		mainPanel.setLayout(new GridLayout(0, 3, 0, 0));
		
		/* PANEL SELECT MATRIX SIZE  */
		sizePanel = sizeP();
		mainPanel.add(sizePanel);
		sizePanel.setLayout(new GridLayout(5, 0, 0, 0));
		
		
		/* PANEL SELECT DIFFICULT */
		difPanel = diffPanel();
		mainPanel.add(difPanel);
		difPanel.setFont(new Font("Arial", Font.PLAIN, 13));
		difPanel.setLayout(new GridLayout(5, 0, 0, 0));
		
		
		/* PANEL SELECT MODE */
		modePanel = modePanel();
		mainPanel.add(modePanel);
		modePanel.setLayout(new GridLayout(5, 0, 0, 0));
		
		
		
	}
	public JPanel modePanel() {
		JPanel p = new JPanel();
		JLabel lblMode = new JLabel("Select Mode");
		lblMode.setFont(new Font("Dialog", Font.BOLD, 18));
		lblMode.setHorizontalAlignment(SwingConstants.CENTER);
		p.add(lblMode);
		
		JRadioButton rbtnChecking = new JRadioButton("Checking");
		buttonGroupMode.add(rbtnChecking);
		rbtnChecking.setActionCommand("checking");
		rbtnChecking.setHorizontalAlignment(SwingConstants.CENTER);
		rbtnChecking.addActionListener(new ActionModeListener());
		p.add(rbtnChecking);
		
		JRadioButton rdbtnTraining = new JRadioButton("Training");
		buttonGroupMode.add(rdbtnTraining);
		rdbtnTraining.setActionCommand("training");
		rdbtnTraining.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnTraining.addActionListener(new ActionModeListener());
		p.add(rdbtnTraining);
		
		JRadioButton rdbtnStandalone = new JRadioButton("Stand-alone");
		buttonGroupMode.add(rdbtnStandalone);
		rdbtnStandalone.setActionCommand("alone");
		rdbtnStandalone.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnStandalone.addActionListener(new ActionModeListener());
		p.add(rdbtnStandalone);
		
		JRadioButton rdbtnSpeed = new JRadioButton("Speed");
		buttonGroupMode.add(rdbtnSpeed);
		rdbtnSpeed.setActionCommand("speed");
		rdbtnSpeed.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnSpeed.addActionListener(new ActionModeListener());
		p.add(rdbtnSpeed);

		return p;		
	}

	public JPanel diffPanel() {
		JPanel diff = new JPanel();
		
		JLabel lblDiff = new JLabel("Select Difficult");
		lblDiff.setFont(new Font("Dialog", Font.BOLD, 18));
		lblDiff.setHorizontalAlignment(SwingConstants.CENTER);
		diff.add(lblDiff);
		
		JRadioButton rdbtnEasy = new JRadioButton("Easy");
		rdbtnEasy.setFont(new Font("Dialog", Font.PLAIN, 13));
		rdbtnEasy.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroupDifficult.add(rdbtnEasy);
		diff.add(rdbtnEasy);
		
		JRadioButton rdbtnMedium = new JRadioButton("Medium");
		rdbtnMedium.setFont(new Font("Dialog", Font.PLAIN, 13));
		rdbtnMedium.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroupDifficult.add(rdbtnMedium);
		diff.add(rdbtnMedium);
		
		JRadioButton rdbtnHard = new JRadioButton("Hard");
		rdbtnHard.setFont(new Font("Dialog", Font.PLAIN, 13));
		rdbtnHard.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroupDifficult.add(rdbtnHard);
		diff.add(rdbtnHard);
		
		JRadioButton rdbtnWicked = new JRadioButton("Wicked");
		rdbtnWicked.setFont(new Font("Dialog", Font.PLAIN, 13));
		rdbtnWicked.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroupDifficult.add(rdbtnWicked);
		diff.add(rdbtnWicked);
		
		
		return diff;
	}

	public JPanel sizeP() {
		
		JPanel siz = new JPanel();
		
		JLabel lblSize = new JLabel("Select Size");
		lblSize.setHorizontalAlignment(SwingConstants.CENTER);
		lblSize.setFont(new Font("Dialog", Font.BOLD, 18));
		siz.add(lblSize);
		
		JRadioButton rdbtnx = new JRadioButton("9x9");
		buttonGroupSize.add(rdbtnx);
		rdbtnx.setHorizontalAlignment(SwingConstants.CENTER);
		siz.add(rdbtnx);
		
		JRadioButton rdbtnx_1 = new JRadioButton("4x4");
		buttonGroupSize.add(rdbtnx_1);
		rdbtnx_1.setHorizontalAlignment(SwingConstants.CENTER);
		siz.add(rdbtnx_1);
		
		JRadioButton rdbtnx_2 = new JRadioButton("6x6");
		buttonGroupSize.add(rdbtnx_2);
		rdbtnx_2.setHorizontalAlignment(SwingConstants.CENTER);
		siz.add(rdbtnx_2);
		
		JRadioButton rdbtnx_3 = new JRadioButton("4x4");
		buttonGroupSize.add(rdbtnx_3);
		rdbtnx_3.setHorizontalAlignment(SwingConstants.CENTER);
		siz.add(rdbtnx_3);
		
		return siz;
	}
	
	public int getSiz() {
		return size;
	}
	protected void setSize(int size) {
		this.size = size;
	}
	public int getDiff() {
		return diff;
	}
	protected void setDiff(int diff) {
		this.diff = diff;
	}
	public int getMode() {
		return mode;
	}
	protected void setMode(int mode) {
		this.mode = mode;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	class ActionModeListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "checking":
				mode = 1;
				break;
			case "training":
				mode = 2;
				break;
			case "alone":
				mode = 3;
				break;
			case "speed":
				mode = 4;
				break;
			} 
			
		}
		
	}
	
}
