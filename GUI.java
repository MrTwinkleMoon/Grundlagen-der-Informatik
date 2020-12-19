import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.BitSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.DropMode;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;

public class GUI {

	private JFrame frame;
	private JPanel panelBool;
	private JPanel panelExc;
	private JPanel panelBCD;
	private JPanel panelBin;
	private JPanel panelMain;
	private JLayeredPane layeredPane;
	private int selectedBin;
	private static int selectedBool;
	private static JTextField textFieldBCD1;
	private static JTextField textFieldBCD2;
	private static JTextField textFieldExc1;
	private static JTextField textFieldExc2;
	private static String Bin16;
	private static String Bin32;
	public static JTable table;
	/**
	 * Launch the application.
	 */
	
	public static int getvar() {
		int var = selectedBool+1;
		return var;
	}
	
	public static String getBCDx() {
		String s = textFieldBCD1.getText();
		return s;
	}
	
	public static String getBCDy() {
		String s = textFieldBCD2.getText();
		return s;
	}
	
	public static String getExcx() {
		String s = textFieldExc1.getText();
		return s;
	}
	
	public static String getExcy() {
		String s = textFieldExc2.getText();
		return s;
	}
	
	public static String getBin16(){
		String s = Bin16;
		return s;
	}
	
	public static String getBin32(){
		String s = Bin32;
		return s;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public void switchPanels(JPanel panel) {
		
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
		
	}
	
	/*public void updateBinTextField() throws ParseException {
		 
		MaskFormatter mask = null;
		if(selectedBin == 0) {
    		try {
				mask = new MaskFormatter("#### #### #### ####");
			} catch (ParseException e) {
				e.printStackTrace();
			}
    		mask.setPlaceholderCharacter('_');
    	}
    	if(selectedBin == 1) {
    		mask = new MaskFormatter("#### #### #### #### #### #### #### ####");
            mask.setPlaceholderCharacter('_');
    	}
		
		JFormattedTextField formattedTextField = new JFormattedTextField(mask);
		formattedTextField.setBounds(120, 87, 200, 30);
		panelBin.add(formattedTextField);
		
	}*/
	
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 617, 382);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		MaskFormatter mask16 = null;
		MaskFormatter mask32 = null;
        try {
        	mask16 = new MaskFormatter("#### #### #### ####");
        	mask16.setPlaceholderCharacter('_');
        	mask32 = new MaskFormatter("#### #### #### #### #### #### #### ####");
        	mask32.setPlaceholderCharacter('_');
        } catch (ParseException e) {
            e.printStackTrace();
        }
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 10, 593, 334);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panelMain = new JPanel();
		layeredPane.add(panelMain, "name_467697402622000");
		panelMain.setLayout(null);
		
		JButton btnMainBin = new JButton("Bin\u00E4rstring");
		btnMainBin.setFont(new Font("Arial", Font.PLAIN, 25));
		btnMainBin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanels(panelBin);
			}
		});
		btnMainBin.setBounds(96, 115, 180, 70);
		panelMain.add(btnMainBin);
		
		JButton btnMainBCD = new JButton("BCD Zahlen");
		btnMainBCD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanels(panelBCD);
			}
		});
		btnMainBCD.setFont(new Font("Arial", Font.PLAIN, 25));
		btnMainBCD.setBounds(327, 115, 180, 70);
		panelMain.add(btnMainBCD);
		
		JButton btnMainExc = new JButton("Excess 3");
		btnMainExc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanels(panelExc);
			}
		});
		btnMainExc.setFont(new Font("Arial", Font.PLAIN, 25));
		btnMainExc.setBounds(96, 213, 180, 70);
		panelMain.add(btnMainExc);
		
		JButton btnMainBool = new JButton("Bool. Fkt.");
		btnMainBool.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanels(panelBool);
			}
		});
		btnMainBool.setFont(new Font("Arial", Font.PLAIN, 25));
		btnMainBool.setBounds(327, 213, 180, 70);
		panelMain.add(btnMainBool);
		
		JLabel lblMain = new JLabel("W\u00E4hlen Sie ihren Input");
		lblMain.setFont(new Font("Arial", Font.PLAIN, 35));
		lblMain.setBounds(116, 29, 354, 41);
		panelMain.add(lblMain);
		
		panelBin = new JPanel();
		layeredPane.add(panelBin, "name_467715493692900");
		panelBin.setLayout(null);
		
		JButton btnBinHome = new JButton("");
		btnBinHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanels(panelMain);
			}
		});
		btnBinHome.setIcon(new ImageIcon(GUI.class.getResource("/icon/IconHome.png")));
		btnBinHome.setBounds(10, 10, 30, 30);
		panelBin.add(btnBinHome);
		
		JLabel lblBin1 = new JLabel("Geben Sie einen Bin\u00E4rstring ein");
		lblBin1.setFont(new Font("Arial", Font.PLAIN, 25));
		lblBin1.setBounds(120, 28, 359, 30);
		panelBin.add(lblBin1);
		
		JLabel lblBin2 = new JLabel("W\u00E4hlen Sie die Art der Interpretation");
		lblBin2.setFont(new Font("Arial", Font.PLAIN, 25));
		lblBin2.setBounds(96, 136, 411, 30);
		panelBin.add(lblBin2);
		
		JFormattedTextField formattedTextField16 = new JFormattedTextField(mask16);
		formattedTextField16.setFont(new Font("Arial", Font.PLAIN, 15));
		formattedTextField16.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField16.setBounds(96, 82, 320, 30);
		panelBin.add(formattedTextField16);
		
		JFormattedTextField formattedTextField32 = new JFormattedTextField(mask32);
		formattedTextField32.setFont(new Font("Arial", Font.PLAIN, 15));
		formattedTextField32.setHorizontalAlignment(SwingConstants.CENTER);
		formattedTextField32.setBounds(96, 82, 320, 30);
		panelBin.add(formattedTextField32);
		formattedTextField32.setVisible(false);
		
		JComboBox<String> comboBoxBin = new JComboBox<>();
		comboBoxBin.setFont(new Font("Arial", Font.PLAIN, 15));
		comboBoxBin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedBin = comboBoxBin.getSelectedIndex();
				if(selectedBin == 0) {
					formattedTextField32.setVisible(false);
					formattedTextField16.setVisible(true);
				}
				if(selectedBin == 1) {
					formattedTextField16.setVisible(false);
					formattedTextField32.setVisible(true);
				}
			}
		});
		comboBoxBin.setModel(new DefaultComboBoxModel<String>(new String[] {"16 Bit", "32 Bit"}));
		comboBoxBin.setBounds(438, 81, 69, 30);
		panelBin.add(comboBoxBin);
		
		JButton btnBinBCD = new JButton("BCD");
		btnBinBCD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(selectedBin == 0) {
					Bin16 = formattedTextField16.getText();
				}else {
					Bin32 = formattedTextField32.getText();
				}
				BinaryString BinBCD = new BinaryString();
				BinBCD.getBinBCD(selectedBin);
			}
		});
		btnBinBCD.setFont(new Font("Arial", Font.PLAIN, 25));
		btnBinBCD.setBounds(73, 190, 120, 50);
		panelBin.add(btnBinBCD);
		
		JButton btnBinBasis2 = new JButton("Basis 2");
		btnBinBasis2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(selectedBin == 0) {
					Bin16 = formattedTextField16.getText();
				}else {
					Bin32 = formattedTextField32.getText();
				}
				BinaryString BinZwei = new BinaryString();
				BinZwei.getBinZwei(selectedBin);
			}
		});
		btnBinBasis2.setFont(new Font("Arial", Font.PLAIN, 25));
		btnBinBasis2.setBounds(236, 190, 120, 50);
		panelBin.add(btnBinBasis2);
		
		JButton btnBinDualVBD = new JButton("");
		btnBinDualVBD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(selectedBin == 0) {
					Bin16 = formattedTextField16.getText();
				}else {
					Bin32 = formattedTextField32.getText();
				}
				BinaryString BinVor = new BinaryString();
				BinVor.getBinVor(selectedBin);
			}
		});
		btnBinDualVBD.setIcon(new ImageIcon(GUI.class.getResource("/icon/DualVBD.png")));
		btnBinDualVBD.setBounds(397, 190, 120, 50);
		panelBin.add(btnBinDualVBD);
		
		JButton btnBinDualEKD = new JButton("");
		btnBinDualEKD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(selectedBin == 0) {
					Bin16 = formattedTextField16.getText();
				}else {
					Bin32 = formattedTextField32.getText();
				}
				BinaryString BinEKD = new BinaryString();
				BinEKD.getBinEKD(selectedBin);
			}
		});
		btnBinDualEKD.setIcon(new ImageIcon(GUI.class.getResource("/icon/DualEKD.png")));
		btnBinDualEKD.setBounds(73, 263, 120, 50);
		panelBin.add(btnBinDualEKD);
		
		JButton btnBinDualZKD = new JButton("");
		btnBinDualZKD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(selectedBin == 0) {
					Bin16 = formattedTextField16.getText();
				}else {
					Bin32 = formattedTextField32.getText();
				}
				BinaryString BinZKD = new BinaryString();
				BinZKD.getBinZKD(selectedBin);
			}
		});
		btnBinDualZKD.setIcon(new ImageIcon(GUI.class.getResource("/icon/DualZKD.png")));
		btnBinDualZKD.setBounds(236, 263, 120, 50);
		panelBin.add(btnBinDualZKD);
		
		JButton btnBinGleit = new JButton("");
		btnBinGleit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(selectedBin == 0) {
					Bin16 = formattedTextField16.getText();
				}else {
					Bin32 = formattedTextField32.getText();
				}
				BinaryString BinGleit = new BinaryString();
				BinGleit.getBinGleit(selectedBin);
			}
		});
		btnBinGleit.setIcon(new ImageIcon(GUI.class.getResource("/icon/Gleitpunktzahl.png")));
		btnBinGleit.setBounds(397, 263, 120, 50);
		panelBin.add(btnBinGleit);
		
		panelBCD = new JPanel();
		layeredPane.add(panelBCD, "name_467718888622000");
		panelBCD.setLayout(null);
		
		JButton btnBCDHome = new JButton("");
		btnBCDHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanels(panelMain);
			}
		});
		btnBCDHome.setIcon(new ImageIcon(GUI.class.getResource("/icon/IconHome.png")));
		btnBCDHome.setBounds(10, 10, 30, 30);
		panelBCD.add(btnBCDHome);
		
		JLabel lblBCD1 = new JLabel("Geben Sie zwei BCD Zahlen ein");
		lblBCD1.setFont(new Font("Arial", Font.PLAIN, 25));
		lblBCD1.setBounds(120, 28, 366, 30);
		panelBCD.add(lblBCD1);
		
		JLabel lblBCD2 = new JLabel("W\u00E4hlen Sie die Art der Interpretation");
		lblBCD2.setFont(new Font("Arial", Font.PLAIN, 25));
		lblBCD2.setBounds(96, 147, 411, 30);
		panelBCD.add(lblBCD2);
		
		textFieldBCD1 = new JTextField();
		textFieldBCD1.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldBCD1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldBCD1.setBounds(96, 88, 180, 30);
		panelBCD.add(textFieldBCD1);
		textFieldBCD1.setColumns(10);
		
		textFieldBCD2 = new JTextField();
		textFieldBCD2.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldBCD2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldBCD2.setBounds(327, 88, 180, 30);
		panelBCD.add(textFieldBCD2);
		textFieldBCD2.setColumns(10);
		
		JButton btnBCDAdd = new JButton("Addition");
		btnBCDAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BCD add = new BCD();
				add.getBCDAdd();
			}
		});
		btnBCDAdd.setFont(new Font("Arial", Font.PLAIN, 25));
		btnBCDAdd.setBounds(96, 213, 180, 70);
		panelBCD.add(btnBCDAdd);
		
		JButton btnBCDSub = new JButton("Subtraktion");
		btnBCDSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BCD sub = new BCD();
				sub.getBCDSub();
			}
		});
		btnBCDSub.setFont(new Font("Arial", Font.PLAIN, 25));
		btnBCDSub.setBounds(327, 213, 180, 70);
		panelBCD.add(btnBCDSub);
		
		panelExc = new JPanel();
		layeredPane.add(panelExc, "name_467722017360700");
		panelExc.setLayout(null);
		
		JButton btnExcHome = new JButton("");
		btnExcHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanels(panelMain);
			}
		});
		btnExcHome.setIcon(new ImageIcon(GUI.class.getResource("/icon/IconHome.png")));
		btnExcHome.setBounds(10, 10, 30, 30);
		panelExc.add(btnExcHome);
		
		JLabel lblExc1 = new JLabel("Geben Sie zwei Excess-3 Zahlen ein");
		lblExc1.setFont(new Font("Arial", Font.PLAIN, 25));
		lblExc1.setBounds(89, 29, 418, 30);
		panelExc.add(lblExc1);
		
		JLabel lblExc2 = new JLabel("W\u00E4hlen Sie die Art der Interpretation");
		lblExc2.setFont(new Font("Arial", Font.PLAIN, 25));
		lblExc2.setBounds(96, 147, 411, 30);
		panelExc.add(lblExc2);
		
		textFieldExc1 = new JTextField();
		textFieldExc1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldExc1.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldExc1.setColumns(10);
		textFieldExc1.setBounds(95, 88, 180, 30);
		panelExc.add(textFieldExc1);
		
		textFieldExc2 = new JTextField();
		textFieldExc2.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldExc2.setFont(new Font("Arial", Font.PLAIN, 15));
		textFieldExc2.setColumns(10);
		textFieldExc2.setBounds(326, 88, 180, 30);
		panelExc.add(textFieldExc2);
		
		JButton btnExcAdd = new JButton("Addition");
		btnExcAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Excess add = new Excess();
				add.getExcAdd();
			}
		});
		btnExcAdd.setFont(new Font("Arial", Font.PLAIN, 25));
		btnExcAdd.setBounds(96, 213, 180, 70);
		panelExc.add(btnExcAdd);
		
		JButton btnExcSub = new JButton("Subtraktion");
		btnExcSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Excess sub = new Excess();
				sub.getExcSub();
			}
		});
		btnExcSub.setFont(new Font("Arial", Font.PLAIN, 25));
		btnExcSub.setBounds(326, 213, 180, 70);
		panelExc.add(btnExcSub);
		
		panelBool = new JPanel();
		layeredPane.add(panelBool, "name_467915063581400");
		panelBool.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchPanels(panelMain);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(GUI.class.getResource("/icon/IconHome.png")));
		btnNewButton_1.setBounds(10, 10, 30, 30);
		panelBool.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(128, 137, 323, 187);
		panelBool.add(scrollPane);
		
		JLabel lblBool1 = new JLabel("F\u00FCllen Sie die Wahrheitstafel aus");
		lblBool1.setFont(new Font("Arial", Font.PLAIN, 25));
		lblBool1.setBounds(111, 10, 375, 30);
		panelBool.add(lblBool1);
		
		JLabel lblNewLabel = new JLabel("Anzahl der Variabeln");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 25));
		lblNewLabel.setBounds(128, 64, 237, 30);
		panelBool.add(lblNewLabel);
		
		JComboBox comboBoxBool = new JComboBox();
		comboBoxBool.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedBool = comboBoxBool.getSelectedIndex();
				table = new JTable(new TableModel());
				scrollPane.setViewportView(table);
			}
		});
		comboBoxBool.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		comboBoxBool.setFont(new Font("Arial", Font.PLAIN, 20));
		comboBoxBool.setBounds(408, 64, 43, 30);
		panelBool.add(comboBoxBool);
		
		JButton btnNewButton = new JButton("DNF");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Normalformen norm = new Normalformen();
				norm.getDNF();
			}
		});
		btnNewButton.setBounds(478, 169, 85, 21);
		panelBool.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("KNF");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Normalformen norm = new Normalformen();
				norm.getKNF();
			}
		});
		btnNewButton_2.setBounds(478, 225, 85, 21);
		panelBool.add(btnNewButton_2);
	}
}
