package Screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import finance.Profile;

import javax.swing.JTable;

public class AnalyticalRepresentation {

	private JFrame frame;
	
	private Home homeW;
	private JTextField txtDate;
	private JTextField txtMoney;
	private JTextField txtAHW;
	private JTextField txtSearch;

	public Profile perfil = Data.perfil;
	
	public String[] date;
	public String[] money;
	public String[] AHW;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnalyticalRepresentation window = new AnalyticalRepresentation();
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
	public AnalyticalRepresentation() {
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
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(31, 54, 61, 16);
		frame.getContentPane().add(lblDate);
		
		JLabel lblMoney = new JLabel("Money");
		lblMoney.setBounds(31, 108, 61, 16);
		frame.getContentPane().add(lblMoney);
		
		JLabel lblHoursWorked = new JLabel("HoursWorked");
		lblHoursWorked.setBounds(16, 166, 85, 16);
		frame.getContentPane().add(lblHoursWorked);
		
		JLabel lblAnalytics = new JLabel("Analytics");
		lblAnalytics.setFont(new Font("BM Hanna Pro", Font.PLAIN, 30));
		lblAnalytics.setBounds(178, 6, 149, 31);
		frame.getContentPane().add(lblAnalytics);
		
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
		
		txtDate = new JTextField();
		txtDate.setBounds(124, 49, 307, 31);
		frame.getContentPane().add(txtDate);
		txtDate.setColumns(10);
		
		txtMoney = new JTextField();
		txtMoney.setColumns(10);
		txtMoney.setBounds(124, 101, 307, 31);
		frame.getContentPane().add(txtMoney);
		
		txtAHW = new JTextField();
		txtAHW.setColumns(10);
		txtAHW.setBounds(124, 158, 320, 31);
		frame.getContentPane().add(txtAHW);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(83, 227, 130, 26);
		frame.getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("BM Hanna Pro", Font.PLAIN, 13));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] res = perfil.search(txtSearch.getText());
				txtDate.setText(res[0]);
				txtMoney.setText(res[1]);
				txtAHW.setText(res[2]);
			}
		});
		btnSearch.setBounds(249, 228, 117, 29);
		frame.getContentPane().add(btnSearch);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDate.setText(perfil.getDate());
				txtMoney.setText(perfil.getMoney());
				txtAHW.setText(perfil.getAHW());
			}
		});
		btnCalculate.setBounds(314, 12, 117, 29);
		frame.getContentPane().add(btnCalculate);
	}
	public JFrame getframe() {
		return frame;
	}
}
