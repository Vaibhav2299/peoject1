package com;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class forgotpassadm extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField_1;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MyConnection.getConnection();
		new forgotpassadm();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					forgotpassadm frame = new forgotpassadm();
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
	public forgotpassadm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRetrieval = new JLabel("RETRIEVAL");
		lblRetrieval.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblRetrieval.setBounds(443, 35, 169, 29);
		contentPane.add(lblRetrieval);
		
		JLabel lblEmailid = new JLabel("Emailid:");
		lblEmailid.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEmailid.setBounds(362, 113, 97, 29);
		contentPane.add(lblEmailid);
		
		JLabel lblSecurityQuestion = new JLabel("Security Question:");
		lblSecurityQuestion.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSecurityQuestion.setBounds(359, 171, 169, 51);
		contentPane.add(lblSecurityQuestion);
		
		JLabel lblAnswer = new JLabel("Answer:");
		lblAnswer.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAnswer.setBounds(355, 246, 126, 29);
		contentPane.add(lblAnswer);
		
		final JButton btnGetPassword = new JButton("Get Password");
		btnGetPassword.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\change-password-icon.png"));
		btnGetPassword.setForeground(Color.BLACK);
		btnGetPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnGetPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				if(e.getSource()==btnGetPassword)
				{
					String user=textField.getText();
					String ques=comboBox.getSelectedItem().toString();
					String ans=passwordField_1.getText();
					
					boolean b=check(user,ques,ans);
					
					if(b)	
					{				
					String st="select password from admin where email=? and secques=? and secans=?";
					try
					{
						Connection con=MyConnection.getConnection();
						PreparedStatement ps=con.prepareStatement(st);
						ps.setString(1,user);
						ps.setString(2,ques);
						ps.setString(3,ans);
						ResultSet rs=ps.executeQuery();
	                    while(rs.next())
						{
							String pass=rs.getString("password");
							textField_1.setText(pass);
						}
					}
					
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
					
				}
				}
			}
			

			boolean check(String user,String tques,String passwordField )
			{
				
				if((user).isEmpty() || tques.isEmpty() || passwordField.isEmpty() )
				{
					JOptionPane.showMessageDialog(null, "please enter all the fields", "project",0);
					return false;
				}
				String st="select * from admin where email=?;";
				try{
						Connection con=(Connection) MyConnection.getConnection();
						PreparedStatement ps=(PreparedStatement) con.prepareStatement(st);
						ps.setString(1,user);
						ResultSet rs=ps.executeQuery();
						if(rs.next())
						{
							while(rs.next())
							{
								String a=rs.getString("secans");
								String q=rs.getString("secques");
								if(!textField.equals(a) || !tques.equals(q))
								{
									JOptionPane.showMessageDialog(null,"Either question or answer is incorrect!!!","MIMS",0);
									return false;
								}
						     }
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Username incorrect","MIMS",0);
							return false;
						}
					}
					catch(SQLException se)
					{
						se.printStackTrace();
					}
				
				return true;
				
				
		
			}
		});
		btnGetPassword.setBounds(417, 336, 208, 35);
		contentPane.add(btnGetPassword);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPassword.setBounds(362, 424, 116, 35);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(540, 118, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Which is your favourite anime?", "Which is your favourite series?"}));
		comboBox.setBounds(540, 187, 230, 22);
		contentPane.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(540, 432, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(540, 251, 116, 22);
		contentPane.add(passwordField_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Apps-preferences-desktop-user-password-icon.png"));
		label.setBounds(61, 97, 253, 326);
		contentPane.add(label);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				new AdminLogin().setVisible(true);
				dispose();
			}
		});
		button.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Go-back-icon.png"));
		button.setBounds(0, 528, 97, 25);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\abstract_colors_aqua+art_neko.jpg"));
		label_1.setBounds(0, 0, 782, 553);
		contentPane.add(label_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
