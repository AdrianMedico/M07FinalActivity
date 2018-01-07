package sudoku.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import java.awt.CardLayout;

public class GroupNameA17Sudoku extends JFrame implements ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPanel;
	private JTextField fields[][];
	private List<JTextField[][]> record = new ArrayList<JTextField[][]>();
	private List<JTextField[][]> redoRecord = new ArrayList<JTextField[][]>();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private GroupNameA17SudokuSelectorPanel selectorPanel;
	protected JPanel cardPanel;
	protected JPanel matrixPanel;
	
	private int MATRIX_SIZE;
	private int FIELD_SIZE;
	private int MATRIX_WIDTH;
	private int MATRIX_HEIGHT;
	private JRadioButton rdbtnEasy;
	private JRadioButton rdbtnMedium;
	private JRadioButton rdbtnHard;
	private JRadioButton rdbtnWicked;
	private JRadioButton rdbtnChecking;
	private JRadioButton rdbtnTraining;
	private JRadioButton rdbtnStandalone;
	private JRadioButton rdbtnSpeed;
	private JRadioButton rdbtn9;
	private JRadioButton rdbtn6;
	private JRadioButton rdbtn4;
	private JRadioButton rdbtnImg;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GroupNameA17Sudoku frame = new GroupNameA17Sudoku();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public GroupNameA17Sudoku() {
		//Content Pane
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPanel = new JPanel();
		contentPanel.setPreferredSize(new Dimension(500, 500));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPanel);
		
		JPanel northPanel = new JPanel();
		FlowLayout fl_northPanel = (FlowLayout) northPanel.getLayout();
		fl_northPanel.setAlignment(FlowLayout.LEFT);
		contentPanel.add(northPanel, BorderLayout.NORTH);
		
		JToolBar toolBar = new JToolBar();
		northPanel.add(toolBar);
		
		JButton btnNew = new JButton("");
		btnNew.setActionCommand("Open");
		btnNew.addActionListener(this);
		btnNew.setIcon(new ImageIcon(new ImageIcon(GroupNameA17Sudoku.class.getResource("/activities/sudoku/New.png")).getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH)));
		toolBar.add(btnNew);
		
		JButton btnUndo = new JButton("");
		btnUndo.setActionCommand("Undo");
		btnUndo.addActionListener(this);
		btnUndo.setIcon(new ImageIcon(new ImageIcon(GroupNameA17Sudoku.class.getResource("/activities/sudoku/Undo.png")).getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH)));
		toolBar.add(btnUndo);
		
		JButton btnSave = new JButton("");
		btnUndo.setActionCommand("Save");
		btnUndo.addActionListener(this);
		btnSave.setIcon(new ImageIcon(new ImageIcon(GroupNameA17Sudoku.class.getResource("/activities/sudoku/save.png")).getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH)));
		toolBar.add(btnSave);
		
		
		JButton btnRedo = new JButton("");
		btnRedo.setActionCommand("Redo");
		btnRedo.addActionListener(this);
		btnRedo.setIcon(new ImageIcon(new ImageIcon(GroupNameA17Sudoku.class.getResource("/activities/sudoku/redo.png")).getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH)));
		toolBar.add(btnRedo);
		
		JButton btnClear = new JButton("");
		btnClear.setActionCommand("Clear");
		btnClear.addActionListener(this);
		btnClear.setIcon(new ImageIcon(new ImageIcon(GroupNameA17Sudoku.class.getResource("/activities/sudoku/clean.png")).getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH)));
		toolBar.add(btnClear);
		
		JButton btnHint = new JButton("");
		btnHint.setActionCommand("Hint");
		btnHint.addActionListener(this);
		btnHint.setIcon(new ImageIcon(new ImageIcon(GroupNameA17Sudoku.class.getResource("/activities/sudoku/question.png")).getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH)));
		toolBar.add(btnHint);
		
		JButton btnCheck = new JButton("");
		btnCheck.setActionCommand("Check");
		btnCheck.addActionListener(this);
		btnCheck.setIcon(new ImageIcon(new ImageIcon(GroupNameA17Sudoku.class.getResource("/activities/sudoku/check.png")).getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH)));
		toolBar.add(btnCheck);
		
		JButton btnExit = new JButton("");
		btnExit.setActionCommand("Exit");
		btnExit.addActionListener(this);
		btnExit.setIcon(new ImageIcon(new ImageIcon(GroupNameA17Sudoku.class.getResource("/activities/sudoku/exit.png")).getImage().getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH)));
		toolBar.add(btnExit);
		
		cardPanel = new JPanel();
		contentPanel.add(cardPanel, BorderLayout.CENTER);
		cardPanel.setLayout(new CardLayout(0, 0));
		
		JPanel selection = new JPanel();
		cardPanel.add(selection, "name_15763132194302");
		selection.setLayout(new BorderLayout(0, 0));
		
		selectorPanel = new GroupNameA17SudokuSelectorPanel(cardPanel);
		selection.add(selectorPanel);
		
		JPanel buttonPanel = cancelOKPanel();
		selection.add(buttonPanel, BorderLayout.SOUTH);
		
		// matrixPanel = new JPanel();
		// cardPanel.add(matrixPanel, "matrixPanel");
		
		// Menu Pane
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("Game");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewGame = new JMenuItem("New");
		mntmNewGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnFile.add(mntmNewGame);
		mntmNewGame.setIcon(new ImageIcon(new ImageIcon(GroupNameA17Sudoku.class.getResource("/activities/sudoku/New.png")).getImage().getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH)));
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnFile.add(mntmSave);
		mntmSave.setIcon(new ImageIcon(new ImageIcon(GroupNameA17Sudoku.class.getResource("/activities/sudoku/save.png")).getImage().getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH)));
		mntmSave.setActionCommand("Save");
		mntmSave.addActionListener(this);
		
		JMenuItem mntmOpenOldGame = new JMenuItem("Open");
		mntmOpenOldGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnFile.add(mntmOpenOldGame);
		mntmOpenOldGame.setIcon(new ImageIcon(new ImageIcon(GroupNameA17Sudoku.class.getResource("/activities/sudoku/open.png")).getImage().getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH)));
		mntmOpenOldGame.setActionCommand("Open");
		mntmOpenOldGame.addActionListener(this);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmPrint = new JMenuItem("Print");
		mntmPrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mnFile.add(mntmPrint);
		mntmPrint.setIcon(new ImageIcon(new ImageIcon(GroupNameA17Sudoku.class.getResource("/activities/sudoku/print.png")).getImage().getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH)));
		
		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mnFile.add(mntmClose);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		mntmExit.setIcon(new ImageIcon(new ImageIcon(GroupNameA17Sudoku.class.getResource("/activities/sudoku/exit.png")).getImage().getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH)));
		mntmExit.setActionCommand("Exit");
		mntmExit.addActionListener(this);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmUndo = new JMenuItem("Undo");
		mntmUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		mnEdit.add(mntmUndo);
		mntmUndo.setIcon(new ImageIcon(new ImageIcon(GroupNameA17Sudoku.class.getResource("/activities/sudoku/Undo.png")).getImage().getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH)));
		mntmUndo.setActionCommand("Undo");
		mntmUndo.addActionListener(this);
		
		JMenuItem mntmRedo = new JMenuItem("Redo");
		mntmRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_MASK));
		mnEdit.add(mntmRedo);
		mntmRedo.setIcon(new ImageIcon(new ImageIcon(GroupNameA17Sudoku.class.getResource("/activities/sudoku/redo.png")).getImage().getScaledInstance(16, 16, java.awt.Image.SCALE_SMOOTH)));
		mntmRedo.setActionCommand("Redo");
		mntmRedo.addActionListener(this);
		
		JMenu mnNewMenu = new JMenu("Variants");
		menuBar.add(mnNewMenu);
		
		rdbtn9 = new JRadioButton("9x9");
		rdbtn9.setActionCommand("9x9");
		rdbtn9.addActionListener(this);
		buttonGroup.add(rdbtn9);
		mnNewMenu.add(rdbtn9);
		
		rdbtn6 = new JRadioButton("6x6");
		rdbtn6.setActionCommand("6x6");
		rdbtn6.addActionListener(this);
		buttonGroup.add(rdbtn6);
		mnNewMenu.add(rdbtn6);
		
		rdbtn4 = new JRadioButton("4x4");
		rdbtn4.setActionCommand("4x4");
		rdbtn4.addActionListener(this);
		buttonGroup.add(rdbtn4);
		mnNewMenu.add(rdbtn4);
		
		rdbtnImg = new JRadioButton("4x4 img");
		rdbtnImg.setActionCommand("4x4 img");
		rdbtnImg.addActionListener(this);
		buttonGroup.add(rdbtnImg);
		mnNewMenu.add(rdbtnImg);
		
		JMenu mnNewMenu_1 = new JMenu("Difficulty");
		menuBar.add(mnNewMenu_1);
		
		rdbtnEasy = new JRadioButton("Easy");
		buttonGroup_2.add(rdbtnEasy);
		mnNewMenu_1.add(rdbtnEasy);
		
		rdbtnMedium = new JRadioButton("Medium");
		buttonGroup_2.add(rdbtnMedium);
		mnNewMenu_1.add(rdbtnMedium);
		
		rdbtnHard = new JRadioButton("Hard");
		buttonGroup_2.add(rdbtnHard);
		mnNewMenu_1.add(rdbtnHard);
		
		rdbtnWicked = new JRadioButton("Wicked");
		buttonGroup_2.add(rdbtnWicked);
		mnNewMenu_1.add(rdbtnWicked);
		
		JMenu mnNewMenu_2 = new JMenu("Mode");
		menuBar.add(mnNewMenu_2);
		
		rdbtnChecking = new JRadioButton("Checking");
		buttonGroup_1.add(rdbtnChecking);
		mnNewMenu_2.add(rdbtnChecking);
		
		rdbtnTraining = new JRadioButton("Training");
		buttonGroup_1.add(rdbtnTraining);
		mnNewMenu_2.add(rdbtnTraining);
		
		rdbtnStandalone = new JRadioButton("Stand-alone");
		buttonGroup_1.add(rdbtnStandalone);
		mnNewMenu_2.add(rdbtnStandalone);
		
		rdbtnSpeed = new JRadioButton("Speed");
		buttonGroup_1.add(rdbtnSpeed);
		mnNewMenu_2.add(rdbtnSpeed);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmRules = new JMenuItem("Rules");
		mnHelp.add(mntmRules);
		mntmRules.setIcon(new ImageIcon(new ImageIcon(GroupNameA17Sudoku.class.getResource("/activities/sudoku/rules.png")).getImage().getScaledInstance(16, 16,  java.awt.Image.SCALE_SMOOTH)));
		mntmRules.setActionCommand("Rules");
		mntmRules.addActionListener(this);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.ALT_MASK));
		mnHelp.add(mntmAbout);
		mntmAbout.setIcon(new ImageIcon(new ImageIcon(GroupNameA17Sudoku.class.getResource("/activities/sudoku/info.png")).getImage().getScaledInstance(16, 16,  java.awt.Image.SCALE_SMOOTH)));
		mntmAbout.setActionCommand("About");
		mntmAbout.addActionListener(this);
		
		pack();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser selector = new JFileChooser();
		
		switch (e.getActionCommand()) {
			case "Open":
				selector.showOpenDialog(contentPanel);
			break;
			
			case "Save":
				selector.showSaveDialog(contentPanel);
				
				for(int i=0; i<9;i++){
					for(int j=0; j<9;j++){
						//And then i save the value of every cell on a file.
					}
				}
			break;
			
			case "Undo":
				redoRecord.add(fields);
				fields = record.get(record.size());
				record.remove(record.size());
			break;
			
			case "Redo":
				fields = redoRecord.get(redoRecord.size());
				redoRecord.remove(redoRecord.size());
			break;
			
			case "Clear":
				/*
				for(int i=0; i<9;i++){
					for(int j=0; j<9;j++){
						if(fields[i][j].isEnabled()){
							fields[i][j].setText("");
						}
					}
				}
				*/
			break;
			
			case "Hint":
			/*
			for(int i=0; i<9;i++){
				for(int j=0; j<9;j++){
					esCorrecto(fields [i][j]);
					
					if(fields[i][j].isEnabled() && ){
						fields[i][j].setText("");
					}
				}
			}
			*/
			break;
			
			case "Check":
				
			break;
			
			case "Rules":
				GroupNameA17SudokuRulesDialog rules = new GroupNameA17SudokuRulesDialog();
				
				/*JEditorPane editorPane = new JEditorPane();
				rules.getContentPane().add(editorPane);
				
				editorPane.setEditable(false);
				
				java.net.URL creditsURL = GroupNameA17Sudoku.class.getResource("/activities/sudoku/RamJuaA17Rules.html");
				
				try {
					editorPane.setPage(creditsURL);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				rules.add(editorPane);
				rules.setSize(500,800);
				rules.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);*/
				rules.setVisible(true);
			break;
			
			case "About":
				try {
					GroupNameA17SudokuDialog dialog = new GroupNameA17SudokuDialog();
					
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			break;
			
			case "Exit":
				dispose();
			break;
			
			default:
				
			break;
			
			case "9x9":
				MATRIX_SIZE = 9;
				createMatrix();
			break;
			
			case "6x6":
				MATRIX_SIZE = 6;
				createMatrix();
			break;
			
			case "4x4":
				MATRIX_SIZE = 4;
				createMatrix();
			break;
			
			case "4x4 img":
				MATRIX_SIZE = 4;
				createMatrix();
			break;
			
			case "continue":
				switch (selectorPanel.getSiz()) {
					case 9:
						System.out.println("HOLA");
						rdbtn9.setSelected(true);
						MATRIX_SIZE = 9;
					break;
					
					case 6:
						rdbtn6.setSelected(true);
						MATRIX_SIZE = 6;
					break;
					
					case 4:
						MATRIX_SIZE = 4;
						
						if (selectorPanel.isImage) {
							rdbtnImg.setSelected(true);
						} else {
							rdbtn4.setSelected(true);
						}
					break;
				}
				
				switch (selectorPanel.getDiff()) {
					case 1:
						rdbtnEasy.setSelected(true);
					break;
					
					case 2:
						rdbtnMedium.setSelected(true);
					break;
					
					case 3:
						rdbtnHard.setSelected(true);
					break;
					
					case 4:
						rdbtnWicked.setSelected(true);
					break;
				}
				
				switch (selectorPanel.getMode()) {
					case 1:
						rdbtnChecking.setSelected(true);
					break;
					
					case 2:
						rdbtnTraining.setSelected(true);
					break;
					
					case 3:
						rdbtnStandalone.setSelected(true);
					break;
					
					case 4:
						rdbtnSpeed.setSelected(true);
					break;
				}
				
				createMatrix(); 
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		record.add(fields);
		//if (record.isEmpty())
			//undoButton disable
		//if (redoRecord.isEmpty())
			//redoButton disable
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	public JPanel cancelOKPanel() {
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
		btnContinue.setActionCommand("continue");
		btnContinue.addActionListener(this);
		btnContinue.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
	//			((Window) getRootPane().getParent()).setVisible(false);
				
				
				
	//			((CardLayout) cardPanel.getLayout()).show(cardPanel, matrixPanel));
				
			}
		});
		cancelOK.add(btnContinue);
		
		return cancelOK;
	}
	
	public void createMatrix() {
		FIELD_SIZE = 400 / MATRIX_SIZE;
		MATRIX_WIDTH = MATRIX_SIZE / (int) Math.sqrt(MATRIX_SIZE);
		MATRIX_HEIGHT = (int) Math.sqrt(MATRIX_SIZE);
		
		matrixPanel = new JPanel();
		FlowLayout fl_matrixPanel = (FlowLayout) matrixPanel.getLayout();
		fl_matrixPanel.setVgap(0);
		fl_matrixPanel.setHgap(0);
		
		fields = new JTextField[MATRIX_SIZE][MATRIX_SIZE];
		
		for (int i = 0; i < MATRIX_SIZE; i++) {
			JPanel auxiliarPanel = new JPanel();
			auxiliarPanel.setPreferredSize(new Dimension(FIELD_SIZE * (MATRIX_WIDTH) + 4, FIELD_SIZE * (MATRIX_HEIGHT) + 4));
			auxiliarPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			FlowLayout flowLayout = (FlowLayout) auxiliarPanel.getLayout();
			flowLayout.setVgap(0);
			flowLayout.setHgap(0);
			matrixPanel.add(auxiliarPanel);
			
			for (int j = 0; j < MATRIX_SIZE; j++) {
				JTextField auxiliarTextField = new JTextField();
				auxiliarTextField.setHorizontalAlignment(SwingConstants.CENTER);
				auxiliarTextField.setPreferredSize(new Dimension(FIELD_SIZE, FIELD_SIZE));
				auxiliarTextField.setBorder(new LineBorder(new Color(0, 0, 0)));
				fields[i][j] = auxiliarTextField;
				auxiliarPanel.add(auxiliarTextField);
			}
		}
		
		fields[0][0].setText(String.valueOf(1));
		fields[0][1].setText(String.valueOf(2));
		fields[0][2].setText(String.valueOf(3));
		fields[1][0].setText(String.valueOf(4));
		fields[1][1].setText(String.valueOf(5));
		fields[1][2].setText(String.valueOf(6));
		fields[2][0].setText(String.valueOf(7));
		fields[2][1].setText(String.valueOf(8));
		fields[2][2].setText(String.valueOf(9));
		
		cardPanel.add(matrixPanel, "matrixPanel");
		((CardLayout) cardPanel.getLayout()).show(cardPanel,"matrixPanel");
	}

}