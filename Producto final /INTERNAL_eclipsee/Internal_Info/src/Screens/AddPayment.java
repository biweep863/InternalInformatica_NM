package Screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JTextField;

import finance.Profile;

import javax.swing.JButton;

public class AddPayment {

	private JFrame frame;
	private JTextField txtDate;
	private JTextField txtAmount;
	private JTextField txtDaysWorked;
	private JTextField txtHoursWorked;
	
	private Home homeW; 
	
	private Profile perfil = Data.perfil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPayment window = new AddPayment();
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
	public AddPayment() {
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

		
		JLabel lblAddPayment = new JLabel("Add Payment ");
		lblAddPayment.setFont(new Font("BM Hanna Pro", Font.PLAIN, 30));
		lblAddPayment.setBounds(137, 6, 205, 34);
		frame.getContentPane().add(lblAddPayment);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("BM Hanna Pro", Font.PLAIN, 20));
		lblDate.setBounds(30, 62, 48, 16);
		frame.getContentPane().add(lblDate);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("BM Hanna Pro", Font.PLAIN, 20));
		lblAmount.setBounds(30, 112, 76, 16);
		frame.getContentPane().add(lblAmount);
		
		JLabel lblDaysWorked = new JLabel("Days Worked");
		lblDaysWorked.setFont(new Font("BM Hanna Pro", Font.PLAIN, 13));
		lblDaysWorked.setBounds(21, 163, 100, 16);
		frame.getContentPane().add(lblDaysWorked);
		
		JLabel lblHoursWorked = new JLabel("Hours Worked");
		lblHoursWorked.setFont(new Font("BM Hanna Pro", Font.PLAIN, 13));
		lblHoursWorked.setBounds(21, 197, 100, 16);
		frame.getContentPane().add(lblHoursWorked);
		
		txtDate = new JTextField();
		txtDate.setBounds(137, 52, 198, 26);
		frame.getContentPane().add(txtDate);
		txtDate.setColumns(10);
		
		txtAmount = new JTextField();
		txtAmount.setText(Double.toString(perfil.income));
		txtAmount.setColumns(10);
		txtAmount.setBounds(137, 108, 198, 26);
		frame.getContentPane().add(txtAmount);
		
		txtDaysWorked = new JTextField();
		txtDaysWorked.setColumns(10);
		txtDaysWorked.setBounds(137, 157, 198, 26);
		frame.getContentPane().add(txtDaysWorked);
		txtDaysWorked.setText(Double.toString(perfil.ADW));
		
		txtHoursWorked = new JTextField();
		txtHoursWorked.setColumns(10);
		txtHoursWorked.setBounds(137, 191, 198, 26);
		frame.getContentPane().add(txtHoursWorked);
		txtHoursWorked.setText(Double.toString(perfil.AHW));
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("BM Hanna Pro", Font.PLAIN, 15));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
			try {
				perfil.AddPayment(txtDate.getText(), txtAmount.getText(), txtHoursWorked.getText());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
					
			}
		});
		btnSubmit.setBounds(164, 237, 117, 29);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("BM Hanna Pro", Font.PLAIN, 15));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homeW = new Home();
				WindowHelper.loadNewWindow(homeW.getframe(), frame);
			}
		});
		btnBack.setBounds(6, 11, 117, 29);
		frame.getContentPane().add(btnBack);
	}
	public JFrame getframe() {
		return frame;
	}

}
