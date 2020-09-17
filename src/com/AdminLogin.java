package com;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPasswordField;
import java.awt.SystemColor;

public class AdminLogin extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPasswordField passwordField;
	
	public static void main(String[] args) {
		new AdminLogin();
		MyConnection.getConnection();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		
		setTitle("ADMIN LOGIN PAGE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 939, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		
		JLabel lblEmployeeLogin = new JLabel("Admin Login");
		lblEmployeeLogin.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblEmployeeLogin.setBounds(515, 63, 211, 39);
		contentPane.add(lblEmployeeLogin);
		
		JLabel lblEmailid = new JLabel("Emailid:");
		lblEmailid.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEmailid.setBounds(405, 167, 95, 39);
		contentPane.add(lblEmailid);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPassword.setBounds(405, 251, 116, 39);
		contentPane.add(lblPassword);
		
		final JTextField textField = new JTextField();
		textField.setBounds(629, 177, 191, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		final JButton btnSubmit = new JButton("Submit");
		btnSubmit.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Ok-icon.png"));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				Object ob=e.getSource();
				if(ob==btnSubmit)
				{
					
					try
					{
						
						String st="SELECT * FROM admin WHERE email=? and password=?";
						Connection con=MyConnection.getConnection();
						PreparedStatement ps=con.prepareStatement(st);
						ps.setString(1,textField.getText());
						ps.setString(2,passwordField.getText());
						ResultSet rs=ps.executeQuery();
						if(rs.next())
						{
							//JOptionPane.showMessageDialog(null,"Login Successful","Project", 1);
							new adminhomepage().setVisible(true);
							dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null,"INVALID EMAIL OR PASSWORD","MIMS",0);
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
		btnSubmit.setBounds(448, 381, 127, 39);
		contentPane.add(btnSubmit);
		
		final JButton btnReset = new JButton("Reset");
		btnReset.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\update icon.png"));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==btnReset)
				{
					textField.setText("");
					passwordField.setText("");
				}
			}
		});
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnReset.setBounds(640, 381, 124, 39);
		contentPane.add(btnReset);
		
		final JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Emoticon-Realize-Shock-Forgot-icon.png"));
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==btnForgotPassword)
				{
					forgotpassadm fpa=new forgotpassadm();
					fpa.setVisible(true);
					dispose();
				}
			}
		});
		btnForgotPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnForgotPassword.setBounds(484, 478, 242, 47);
		contentPane.add(btnForgotPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(629, 261, 191, 22);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new MainPage().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Go-back-icon.png"));
		btnNewButton.setBounds(0, 562, 116, 33);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Admin-icon.png"));
		label.setBounds(85, 122, 251, 298);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\abstract_colors_aqua+art_neko.jpg"));
		label_1.setBounds(0, 0, 921, 595);
		contentPane.add(label_1);
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
