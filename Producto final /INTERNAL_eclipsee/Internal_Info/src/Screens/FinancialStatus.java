package Screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

import finance.Profile;

public class FinancialStatus {

	private JFrame frame;
	private JTextField txtIncome;
	private JTextField txtOutcome;
	private JTextField txtAmountMoney;
	
	private Home homeW;
	public Profile perfil = Data.perfil;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinancialStatus window = new FinancialStatus();
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
	public FinancialStatus() {
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
		WindowHelper.centerOnScreen(frame);

		
		JLabel lblFinancialStatus = new JLabel("Financial Status ");
		lblFinancialStatus.setFont(new Font("BM Hanna Pro", Font.PLAIN, 30));
		lblFinancialStatus.setBounds(160, 6, 228, 31);
		frame.getContentPane().add(lblFinancialStatus);
		
		JLabel lblIncome = new JLabel("Income");
		lblIncome.setFont(new Font("BM Hanna Pro", Font.PLAIN, 15));
		lblIncome.setBounds(39, 98, 61, 16);
		frame.getContentPane().add(lblIncome);
		
		JLabel lblOutcome = new JLabel("Outcome");
		lblOutcome.setFont(new Font("BM Hanna Pro", Font.PLAIN, 15));
		lblOutcome.setBounds(39, 126, 61, 16);
		frame.getContentPane().add(lblOutcome);
		
		JLabel lblAmountMoney = new JLabel("Amount of money");
		lblAmountMoney.setFont(new Font("BM Hanna Pro", Font.PLAIN, 20));
		lblAmountMoney.setBounds(19, 194, 161, 31);
		frame.getContentPane().add(lblAmountMoney);
		
		txtIncome = new JTextField();
		txtIncome.setBounds(160, 92, 130, 26);
		frame.getContentPane().add(txtIncome);
		txtIncome.setColumns(10);
		
		txtOutcome = new JTextField();
		txtOutcome.setColumns(10);
		txtOutcome.setBounds(160, 126, 130, 26);
		frame.getContentPane().add(txtOutcome);
		
		txtAmountMoney = new JTextField();
		txtAmountMoney.setColumns(10);
		txtAmountMoney.setBounds(214, 197, 130, 26);
		frame.getContentPane().add(txtAmountMoney);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("BM Hanna Pro", Font.PLAIN, 15));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homeW = new Home();
				WindowHelper.loadNewWindow(homeW.getframe(), frame);
			}
		});
		btnBack.setBounds(6, 12, 117, 29);
		frame.getContentPane().add(btnBack);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setFont(new Font("BM Hanna Pro", Font.PLAIN, 15));
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				perfil.FinancialStatus();
				txtIncome.setText(Double.toString(perfil.TotalIncome));
				txtOutcome.setText(Double.toString(perfil.TotalOutcome));
				txtAmountMoney.setText(Double.toString(perfil.AmountMoney));
			}
		});
		
		btnCalculate.setBounds(191, 235, 117, 29);
		frame.getContentPane().add(btnCalculate);
	}
	public JFrame getframe() {
		return frame;
	}

}
