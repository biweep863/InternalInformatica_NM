package Screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import database.PaymentDatabase;
import finance.Profile;

public class Data {
	
	public static Profile perfil; 
	public String name;
	public double income;
	public double outcome;
	private double AHW;
	private double BasicSaving;

	private JFrame frame;
	private JTextField txtIncome;
	private JTextField txtOutcome;
	private JTextField txtAHW;
	private JTextField txtBasicSavings;

	private Home homeW; 
	private JTextField txtName;
	
	File selectedFile;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Data window = new Data();
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
	public Data() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblIncome = new JLabel("Income");
		lblIncome.setFont(new Font("BM Hanna Pro", Font.PLAIN, 15));
		lblIncome.setBounds(56, 107, 61, 16);
		frame.getContentPane().add(lblIncome);
		
		JLabel lblOutcome = new JLabel("Outcome");
		lblOutcome.setFont(new Font("BM Hanna Pro", Font.PLAIN, 15));
		lblOutcome.setBounds(56, 135, 61, 16);
		frame.getContentPane().add(lblOutcome);
		
		JLabel lblAHW = new JLabel("Average Hours Worked");
		lblAHW.setFont(new Font("BM Hanna Pro", Font.PLAIN, 15));
		lblAHW.setBounds(18, 163, 170, 16);
		frame.getContentPane().add(lblAHW);
		
		JLabel lblBasicSavings = new JLabel("Basic Savings");
		lblBasicSavings.setFont(new Font("BM Hanna Pro", Font.PLAIN, 15));
		lblBasicSavings.setBounds(52, 191, 100, 16);
		frame.getContentPane().add(lblBasicSavings);
		
		JLabel lblINI = new JLabel("Input the next information...");
		lblINI.setFont(new Font("BM Hanna Pro", Font.PLAIN, 20));
		lblINI.setBounds(129, 19, 263, 16);
		frame.getContentPane().add(lblINI);
		
		JButton btnUpdate = new JButton("Update ");
		btnUpdate.setFont(new Font("BM Hanna Pro", Font.PLAIN, 15));
		btnUpdate.setBounds(161, 237, 117, 29);
		frame.getContentPane().add(btnUpdate);
		
		txtIncome = new JTextField();
		txtIncome.setBounds(212, 101, 130, 26);
		frame.getContentPane().add(txtIncome);
		txtIncome.setColumns(10);
		
		txtOutcome = new JTextField();
		txtOutcome.setBounds(212, 129, 130, 26);
		frame.getContentPane().add(txtOutcome);
		txtOutcome.setColumns(10);
		
		txtAHW = new JTextField();
		txtAHW.setBounds(212, 157, 130, 26);
		frame.getContentPane().add(txtAHW);
		txtAHW.setColumns(10);
		
		txtBasicSavings = new JTextField();
		txtBasicSavings.setBounds(212, 185, 130, 26);
		frame.getContentPane().add(txtBasicSavings);
		txtBasicSavings.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("BM Hanna Pro", Font.PLAIN, 15));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homeW = new Home();
				WindowHelper.loadNewWindow(homeW.getframe(), frame);
			}
		});
		btnBack.setBounds(0, 16, 117, 29);
		frame.getContentPane().add(btnBack);
		
		JLabel lblFile = new JLabel("File Directory");
		lblFile.setFont(new Font("BM Hanna Pro", Font.PLAIN, 15));
		lblFile.setBounds(33, 47, 99, 16);
		frame.getContentPane().add(lblFile);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("BM Hanna Pro", Font.PLAIN, 15));
		lblName.setBounds(56, 79, 46, 16);
		frame.getContentPane().add(lblName);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(212, 72, 130, 26);
		frame.getContentPane().add(txtName);
		
		
		JButton btnChooser = new JButton("Chooser");
		btnChooser.setBounds(209, 41, 117, 29);
		btnChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setBounds(100, 100, 525, 137);

				chooser.setAcceptAllFileFilterUsed(false);
                /*FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter();
                chooser.addChoosableFileFilter(fileNameExtensionFilter);*/

                int checkInput = chooser.showOpenDialog(null);

                selectedFile = chooser.getSelectedFile();
                
                WindowHelper.loadFile(selectedFile);
			}
		});
		frame.getContentPane().add(btnChooser);
		
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				income = Double.parseDouble(txtIncome.getText());
				outcome = Double.parseDouble(txtOutcome.getText());
				AHW = Double.parseDouble(txtAHW.getText());
				BasicSaving = Double.parseDouble(txtBasicSavings.getText());
				name = txtName.getText();
				
				perfil = new Profile(name, income, outcome, AHW, BasicSaving, selectedFile.getPath());
				
			}
		});
	}
	public JFrame getframe() {
		return frame;
	}

}
