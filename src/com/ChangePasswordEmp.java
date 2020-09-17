package com;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFormattedTextField;

import java.awt.event.ActionEvent;



public class ChangePasswordEmp extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_2;
	ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePasswordEmp frame = new ChangePasswordEmp();
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
	public ChangePasswordEmp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 663);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EMAIL ID:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(171, 354, 116, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblOldPassword = new JLabel("Old Password:");
		lblOldPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblOldPassword.setBounds(171, 411, 130, 16);
		contentPane.add(lblOldPassword);
		
		textField = new JTextField();
		textField.setBounds(446, 353, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(446, 410, 116, 22);
		contentPane.add(passwordField);
		
		final JButton btnNewButton = new JButton("Submit");
		btnNewButton.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Ok-icon.png"));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(e.getSource()==btnNewButton)
				{
					String user=textField.getText();
					String opass=passwordField.getText();
				
					String cpass=passwordField_2.getText();
					
					
					
						String st="update employee set password=? where email=? and password=?";
						try
						{
						Connection con=MyConnection.getConnection();
						PreparedStatement ps=con.prepareStatement(st);
						ps.setString(2,user);
						ps.setString(1,cpass);
						ps.setString(3,opass);
						int x=ps.executeUpdate();
						if(x>0)
						{
							String msg="Password changed";
							JOptionPane.showMessageDialog(null,msg,"MIMS",1);
							dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Either username or oldpassword is incorrect!!!","MIMS",0);
						}
						}
						catch(SQLException se)
						{
							se.printStackTrace();
						}
					}
				}

		});
		btnNewButton.setBounds(221, 531, 142, 39);
		contentPane.add(btnNewButton);
		
		final JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\erase-128.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(e.getSource()==btnNewButton_1)
				{
				textField.setText("");
				passwordField.setText("");
				passwordField_2.setText("");
				}
				
			}
			
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton_1.setBounds(404, 531, 116, 39);
		contentPane.add(btnNewButton_1);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblConfirmPassword.setBounds(171, 462, 161, 16);
		contentPane.add(lblConfirmPassword);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(446, 461, 116, 22);
		contentPane.add(passwordField_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Apps-preferences-desktop-user-password-icon.png"));
		label.setBounds(221, 46, 288, 256);
		contentPane.add(label);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new EmpHomepg().setVisible(true);
				dispose();
				
			}
		});
		button.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Go-back-icon.png"));
		button.setBounds(0, 577, 97, 39);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\abstract_colors_aqua+art_neko.jpg"));
		label_1.setBounds(0, 0, 685, 616);
		contentPane.add(label_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
