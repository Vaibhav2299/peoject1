package com;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.Font;
import javax.swing.ImageIcon;

public class AdminRegister extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MyConnection.getConnection();
		new AdminRegister();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminRegister frame = new AdminRegister();
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
	public AdminRegister() {
		
		setTitle("ADMIN REGISTRATION PAGE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 939, 697);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdminSignup = new JLabel("Admin Signup");
		lblAdminSignup.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAdminSignup.setBounds(533, 38, 193, 44);
		contentPane.add(lblAdminSignup);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(453, 120, 56, 16);
		contentPane.add(lblName);
		
		JLabel lblNewLabel = new JLabel("Email:\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(453, 177, 56, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(453, 233, 97, 32);
		contentPane.add(lblPassword);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGender.setBounds(453, 306, 74, 19);
		contentPane.add(lblGender);
		
		JLabel lblSecurityQuestion = new JLabel("Security Question:");
		lblSecurityQuestion.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSecurityQuestion.setBounds(453, 380, 149, 22);
		contentPane.add(lblSecurityQuestion);
		
		JLabel lblAnswer = new JLabel("Answer:");
		lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAnswer.setBounds(453, 447, 97, 16);
		contentPane.add(lblAnswer);
		
		textField = new JTextField();
		textField.setBounds(685, 118, 149, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(685, 175, 149, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(685, 239, 149, 22);
		contentPane.add(passwordField);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox.setBounds(685, 305, 149, 22);
		contentPane.add(comboBox);
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Which is your favourite anime?", "Which is your favourite series?"}));
		comboBox_1.setBounds(685, 381, 203, 22);
		contentPane.add(comboBox_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(685, 445, 149, 22);
		contentPane.add(passwordField_1);
		
		final JButton btnAddRecord = new JButton("ADD RECORD");
		btnAddRecord.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Staff.png"));
		btnAddRecord.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAddRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to add new admin?","New Admin",JOptionPane.YES_NO_OPTION);
		        if(p==0){
			
			if(e.getSource()==btnAddRecord)
			{
				try
				{
					Connection con=(Connection) MyConnection.getConnection();
					String st="insert into admin(name,email,password,gender,secques,secans)values(?,?,?,?,?,?)";
					PreparedStatement ps=(PreparedStatement) con.prepareStatement(st);
					ps.setString(1,textField.getText());
					ps.setString(2,textField_1.getText());
					ps.setString(3,passwordField.getText());
					ps.setString(4,comboBox.getSelectedItem().toString());
					ps.setString(5,comboBox_1.getSelectedItem().toString());
					ps.setString(6,passwordField_1.getText());
					
					int x=ps.executeUpdate();
					if(x>0)
					{
						String msg="New Admin Added";
						JOptionPane.showMessageDialog(null,msg,"Project",1);
					}
					}
					catch(SQLException se)
					{
						se.printStackTrace();
						dispose();
					}
				}
				}
		
			}
			
		});
		btnAddRecord.setBounds(460, 504, 205, 52);
		contentPane.add(btnAddRecord);
		
		final JButton btnClear = new JButton("CLEAR");
		btnClear.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\erase-128.png"));
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==btnClear)
				{
					textField.setText("");
					textField_1.setText("");
					passwordField.setText("");
					passwordField_1.setText("");
				}
			}
		});
		btnClear.setBounds(677, 504, 186, 52);
		contentPane.add(btnClear);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new MainPage().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Go-back-icon.png"));
		btnNewButton.setBounds(0, 618, 123, 32);
		contentPane.add(btnNewButton);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Admin-icon.png"));
		label_1.setBounds(120, 121, 262, 342);
		contentPane.add(label_1);
		
		JButton btnGoToLogin = new JButton("Go To Login");
		btnGoToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AdminLogin().setVisible(true);
				dispose();
			}
		});
		btnGoToLogin.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Right3Green.png"));
		btnGoToLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGoToLogin.setBounds(772, 618, 149, 32);
		contentPane.add(btnGoToLogin);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\abstract_colors_aqua+art_neko.jpg"));
		label.setBounds(0, 0, 921, 650);
		contentPane.add(label);
		
		
	}
}
