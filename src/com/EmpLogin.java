package com;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class EmpLogin extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField passwordField;
	final JButton btnSubmit;
	ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new EmpLogin();
		MyConnection.getConnection();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpLogin frame = new EmpLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmpLogin() {
		
		
		setTitle("EMPLOYEE LOGIN PAGE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmployeeLogin = new JLabel("Employee Login");
		lblEmployeeLogin.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblEmployeeLogin.setBounds(483, 54, 211, 39);
		contentPane.add(lblEmployeeLogin);
		
		JLabel lblEmailid = new JLabel("Email:");
		lblEmailid.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEmailid.setBounds(426, 175, 95, 39);
		contentPane.add(lblEmailid);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPassword.setBounds(426, 247, 116, 39);
		contentPane.add(lblPassword);
		
		txtUser = new JTextField();
		txtUser.setBounds(573, 185, 142, 22);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Ok-icon.png"));
		btnSubmit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				Object ob=e.getSource();
				if(ob==btnSubmit)
				{
					
					try
					{
						
						String st="SELECT * FROM employee WHERE email=? and password=?";
						Connection con=MyConnection.getConnection();
						PreparedStatement ps=con.prepareStatement(st);
						ps.setString(1,txtUser.getText());
						ps.setString(2,passwordField.getText());
						rs=ps.executeQuery();
						if(rs.next())
					   
						{
							
							JOptionPane.showMessageDialog(null,"Login Successful","Project", 1);
							EmpHomepg nf= new EmpHomepg();
							nf.setVisible(true);
							dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null,"INVALID ID OR PASSWORD","MIMS",0);
						}
					}
					catch(SQLException se)
						{
						se.printStackTrace();
						}
				}
			}
		});
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSubmit.setBounds(426, 359, 135, 41);
		contentPane.add(btnSubmit);
		
		final JButton btnReset = new JButton("Reset");
		btnReset.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\erase-128.png"));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==btnReset)
				{
					txtUser.setText("");
					passwordField.setText("");
				}
			
			}
		});
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnReset.setBounds(591, 359, 124, 41);
		contentPane.add(btnReset);
		
		JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new forgotpassEmp().setVisible(true);
				dispose();
			}
		});
		btnForgotPassword.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Emoticon-Realize-Shock-Forgot-icon.png"));
		btnForgotPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnForgotPassword.setBounds(451, 444, 243, 47);
		contentPane.add(btnForgotPassword);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				new MainPage().setVisible(true);
				dispose();
			}
		});
		button.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Go-back-icon.png"));
		button.setBounds(0, 520, 116, 33);
		contentPane.add(button);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(577, 257, 138, 22);
		contentPane.add(passwordField);
		
		JLabel label = new JLabel("");
		label.setToolTipText("");
		label.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\engineer-icon.png"));
		label.setBounds(96, 112, 263, 288);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\abstract_colors_aqua+art_neko.jpg"));
		label_1.setBounds(0, 0, 782, 553);
		contentPane.add(label_1);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

	public JTextField getTextField() {
		return txtUser;
	}
}
