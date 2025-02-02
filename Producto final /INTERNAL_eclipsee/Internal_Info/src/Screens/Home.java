package Screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import database.PaymentDatabase;

public class Home {

	private JFrame frame;
	private AddPayment AddpaymentW; 
	private Data dataW; 
	private AnalyticalRepresentation AnalyticalW; 
	private FinancialStatus FinancialW; 


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
		
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

		JLabel lblHome = new JLabel("Home");
		lblHome.setFont(new Font("BM Hanna Pro", Font.PLAIN, 20));
		lblHome.setBounds(191, 6, 57, 16);
		frame.getContentPane().add(lblHome);
		
		JLabel lblWB = new JLabel("Welcome Back");
		lblWB.setFont(new Font("Silom", Font.PLAIN, 40));
		lblWB.setBounds(84, 49, 329, 42);
		frame.getContentPane().add(lblWB);
		
		JButton btnPayment = new JButton("Payment ");
		btnPayment.setFont(new Font("BM Hanna Pro", Font.PLAIN, 20));
		btnPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddpaymentW = new AddPayment();
				WindowHelper.loadNewWindow(AddpaymentW.getframe(), frame);
			}
		});
		btnPayment.setBounds(167, 147, 129, 42);
		frame.getContentPane().add(btnPayment);
		
		JButton btnSetup = new JButton("Set up ");
		btnSetup.setFont(new Font("BM Hanna Pro", Font.PLAIN, 15));
		btnSetup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dataW = new Data();
				WindowHelper.loadNewWindow(dataW.getframe(), frame);
			}
		});
		btnSetup.setBounds(6, 3, 117, 29);
		frame.getContentPane().add(btnSetup);
		
		JButton btnAnalytics = new JButton("Analytics");
		btnAnalytics.setFont(new Font("BM Hanna Pro", Font.PLAIN, 15));
		btnAnalytics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnalyticalW = new AnalyticalRepresentation();
				WindowHelper.loadNewWindow(AnalyticalW.getframe(), frame);
			}
		});
		btnAnalytics.setBounds(327, 237, 117, 29);
		frame.getContentPane().add(btnAnalytics);
		
		JButton btnFinancialStatus = new JButton("Financial Status");
		btnFinancialStatus.setFont(new Font("BM Hanna Pro", Font.PLAIN, 15));
		btnFinancialStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FinancialW = new FinancialStatus();
				WindowHelper.loadNewWindow(FinancialW.getframe(), frame);
			}
		});
		btnFinancialStatus.setBounds(6, 237, 151, 29);
		frame.getContentPane().add(btnFinancialStatus);
	}
	public JFrame getframe() {
		return frame;
	}
}
