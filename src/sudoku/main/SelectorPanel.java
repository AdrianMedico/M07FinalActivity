package sudoku.main;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.Window;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;

public class SelectorPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final ButtonGroup buttonGroupDifficult = new ButtonGroup();
	private final ButtonGroup buttonGroupSize = new ButtonGroup();
	private final ButtonGroup buttonGroupMode = new ButtonGroup();
	private JPanel modePanel, difPanel, sizePanel, cancelOKPanel, cardPanel;
	protected int size, diff, mode;
	protected boolean isImage;

	/*
	 * public static void main(String[] args) { JFrame jf = new JFrame();
	 * SelectorPanel sp = new SelectorPanel(); jf.add(sp);
	 * jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); }
	 */

	/**
	 * Create the panel.
	 */
	public SelectorPanel(JPanel cardPanel) {
		setLayout(new BorderLayout(0, 0));

		JPanel mainPanel = new JPanel();
		add(mainPanel);
		mainPanel.setLayout(new GridLayout(0, 3, 0, 0));

		/* PANEL SELECT MATRIX SIZE */
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

		/* PANEL CONTINUE CANCEL */

//		cancelOKPanel = cancelOKPanel();
//		add(cancelOKPanel, BorderLayout.SOUTH);

	}

	/*
	 * Method that creates the modePanel
	 */
	public JPanel modePanel() {
		JPanel p = new JPanel();
		JLabel lblMode = new JLabel("Select Mode");
		lblMode.setFont(new Font("Dialog", Font.BOLD, 18));
		lblMode.setHorizontalAlignment(SwingConstants.CENTER);
		p.add(lblMode);

		JRadioButton rdbtnChecking = new JRadioButton("Checking");
		rdbtnChecking.setBackground(new Color(51, 153, 204));
		rdbtnChecking.setFont(new Font("Dialog", Font.BOLD, 13));
		buttonGroupMode.add(rdbtnChecking);
		rdbtnChecking.setActionCommand("checking");
		rdbtnChecking.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnChecking.addActionListener(new ActionModeListener());
		rdbtnChecking.addMouseListener(new MouseHoverAdapter());

		JRadioButton rdbtnTraining = new JRadioButton("Training");
		rdbtnTraining.setBackground(new Color(153, 204, 204));
		rdbtnTraining.setFont(new Font("Dialog", Font.BOLD, 13));
		buttonGroupMode.add(rdbtnTraining);
		rdbtnTraining.setActionCommand("training");
		rdbtnTraining.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnTraining.addActionListener(new ActionModeListener());
		rdbtnTraining.addMouseListener(new MouseHoverAdapter());
		p.add(rdbtnTraining);
		p.add(rdbtnChecking);

		JRadioButton rdbtnStandalone = new JRadioButton("Stand-alone");
		rdbtnStandalone.setBackground(new Color(51, 102, 204));
		rdbtnStandalone.setFont(new Font("Dialog", Font.BOLD, 13));
		buttonGroupMode.add(rdbtnStandalone);
		rdbtnStandalone.setActionCommand("alone");
		rdbtnStandalone.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnStandalone.addActionListener(new ActionModeListener());
		rdbtnStandalone.addMouseListener(new MouseHoverAdapter());
		p.add(rdbtnStandalone);

		JRadioButton rdbtnSpeed = new JRadioButton("Speed");
		rdbtnSpeed.setBackground(new Color(51, 102, 153));
		rdbtnSpeed.setFont(new Font("Dialog", Font.BOLD, 13));
		buttonGroupMode.add(rdbtnSpeed);
		rdbtnSpeed.setActionCommand("speed");
		rdbtnSpeed.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnSpeed.addActionListener(new ActionModeListener());
		rdbtnSpeed.addMouseListener(new MouseHoverAdapter());
		p.add(rdbtnSpeed);

		return p;
	}

	/*
	 * Method that creates the difficulty Panel
	 */
	public JPanel diffPanel() {
		JPanel diff = new JPanel();

		JLabel lblDiff = new JLabel("Select Difficult");
		lblDiff.setFont(new Font("Dialog", Font.BOLD, 18));
		lblDiff.setHorizontalAlignment(SwingConstants.CENTER);
		diff.add(lblDiff);

		JRadioButton rdbtnEasy = new JRadioButton("Easy");
		rdbtnEasy.setBackground(new Color(255, 204, 153));
		rdbtnEasy.setFont(new Font("Dialog", Font.BOLD, 13));
		rdbtnEasy.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroupDifficult.add(rdbtnEasy);
		rdbtnEasy.addActionListener(new ActionDiffListener());
		rdbtnEasy.addMouseListener(new MouseHoverAdapter());
		rdbtnEasy.setActionCommand("easy");
		diff.add(rdbtnEasy);

		JRadioButton rdbtnMedium = new JRadioButton("Medium");
		rdbtnMedium.setBackground(new Color(255, 153, 153));
		rdbtnMedium.setFont(new Font("Dialog", Font.BOLD, 13));
		rdbtnMedium.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroupDifficult.add(rdbtnMedium);
		rdbtnMedium.addActionListener(new ActionDiffListener());
		rdbtnMedium.addMouseListener(new MouseHoverAdapter());
		rdbtnMedium.setActionCommand("medium");
		diff.add(rdbtnMedium);

		JRadioButton rdbtnHard = new JRadioButton("Hard");
		rdbtnHard.setBackground(new Color(255, 102, 102));
		rdbtnHard.setFont(new Font("Dialog", Font.BOLD, 13));
		rdbtnHard.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroupDifficult.add(rdbtnHard);
		rdbtnHard.addActionListener(new ActionDiffListener());
		rdbtnHard.addMouseListener(new MouseHoverAdapter());
		rdbtnHard.setActionCommand("hard");
		diff.add(rdbtnHard);

		JRadioButton rdbtnWicked = new JRadioButton("Wicked");
		rdbtnWicked.setBackground(new Color(255, 51, 51));
		rdbtnWicked.setFont(new Font("Dialog", Font.BOLD, 13));
		rdbtnWicked.setHorizontalAlignment(SwingConstants.CENTER);
		buttonGroupDifficult.add(rdbtnWicked);
		rdbtnWicked.addActionListener(new ActionDiffListener());
		rdbtnWicked.addMouseListener(new MouseHoverAdapter());
		rdbtnWicked.setActionCommand("wicked");
		diff.add(rdbtnWicked);

		return diff;
	}

	/*
	 * Method that creates the size Panel
	 */
	public JPanel sizeP() {

		JPanel siz = new JPanel();

		JLabel lblSize = new JLabel("Select Size");
		lblSize.setHorizontalAlignment(SwingConstants.CENTER);
		lblSize.setFont(new Font("Dialog", Font.BOLD, 18));
		siz.add(lblSize);

		JRadioButton rdbtnx_3 = new JRadioButton("4x4 with images");
		rdbtnx_3.setFont(new Font("Dialog", Font.BOLD, 13));
		rdbtnx_3.setBackground(new Color(165, 237, 0));
		buttonGroupSize.add(rdbtnx_3);
		rdbtnx_3.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnx_3.setActionCommand("4x4img");
		rdbtnx_3.addActionListener(new ActionSizeListener());
		rdbtnx_3.addMouseListener(new MouseHoverAdapter());
		siz.add(rdbtnx_3);

		JRadioButton rdbtnx = new JRadioButton("9x9");
		rdbtnx.setFont(new Font("Dialog", Font.BOLD, 13));
		rdbtnx.setBackground(new Color(0,153,0));
		buttonGroupSize.add(rdbtnx);
		rdbtnx.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnx.setActionCommand("9x9");
		rdbtnx.addActionListener(new ActionSizeListener());
		rdbtnx.addMouseListener(new MouseHoverAdapter());

		JRadioButton rdbtnx_2 = new JRadioButton("6x6");
		rdbtnx_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnx_2.setBackground(new Color(0, 204, 0));
		buttonGroupSize.add(rdbtnx_2);
		rdbtnx_2.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnx_2.setActionCommand("6x6");
		rdbtnx_2.addActionListener(new ActionSizeListener());
		rdbtnx_2.addMouseListener(new MouseHoverAdapter());

		JRadioButton rdbtnx_1 = new JRadioButton("4x4");
		rdbtnx_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnx_1.setBackground(new Color(0, 255, 0));
		buttonGroupSize.add(rdbtnx_1);
		rdbtnx_1.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnx_1.setActionCommand("4x4");
		rdbtnx_1.addActionListener(new ActionSizeListener());
		rdbtnx_1.addMouseListener(new MouseHoverAdapter());
		siz.add(rdbtnx_1);
		siz.add(rdbtnx_2);
		siz.add(rdbtnx);

		return siz;
	}

	/*public JPanel cancelOKPanel() {
		JPanel cancelOK = new JPanel();
		
		JButton btCancel = new JButton("Cancel");
		btCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((Window) getRootPane().getParent()).dispose();
			}
		});
		cancelOK.add(btCancel);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalGlue.setPreferredSize(new Dimension(40, 0));
		cancelOK.add(horizontalGlue);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				((Window) getRootPane().getParent()).setVisible(false);
				
				
				
//				((CardLayout) cardPanel.getLayout()).show(cardPanel, matrixPanel));
				
			}
		});
		cancelOK.add(btnContinue);
		
		return cancelOK;
	}*/

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

	class ActionSizeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "9x9":
				size = 9;
				isImage = false;
				break;
			case "6x6":
				size = 6;
				isImage = false;
				break;
			case "4x4":
				size = 4;
				isImage = false;
				break;
			case "4x4img":
				size = 4;
				isImage = true;
			}
		}
	}

	class ActionDiffListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "easy":
				diff = 1;
				break;
			case "medium":
				diff = 2;
				break;
			case "hard":
				diff = 3;
				break;
			case "wicked":
				diff = 4;
				break;
			}
		}
	}

	class MouseHoverAdapter extends MouseAdapter {
		Color c;
		JToggleButton tglbtnX;

		@Override
		public void mouseEntered(MouseEvent e) {
			super.mouseEntered(e);
			tglbtnX = (JToggleButton) e.getSource();
			c = tglbtnX.getBackground();
			tglbtnX.setBackground(Color.BLACK); // You shoud change the color type!!
		}

		@Override
		public void mouseExited(MouseEvent e) {
			super.mouseExited(e);
			tglbtnX.setBackground(c);
		}

	}
}
