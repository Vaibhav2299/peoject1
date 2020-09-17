package com;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.CardLayout;
import com.toedter.calendar.JDateChooser;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextField;


import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import javax.swing.ImageIcon;

public class LeaveReq extends JFrame {

	private JPanel contentPane;
	private JTextField id1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	JDateChooser dateChooser,dateChooser_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeaveReq frame = new LeaveReq();
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
	public LeaveReq() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 690);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblEmployeeLeaveRequest = new JLabel("Employee Leave Request");
		lblEmployeeLeaveRequest.setBounds(407, 45, 348, 36);
		lblEmployeeLeaveRequest.setFont(new Font("Arial", Font.BOLD, 25));
		contentPane.add(lblEmployeeLeaveRequest);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId.setBounds(407, 151, 56, 19);
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(407, 200, 56, 24);
		contentPane.add(lblName);
		
		JLabel lblLeaveType = new JLabel("Leave Type");
		lblLeaveType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLeaveType.setBounds(407, 250, 103, 19);
		contentPane.add(lblLeaveType);
		
		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStartDate.setBounds(407, 300, 103, 24);
		contentPane.add(lblStartDate);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEndDate.setBounds(407, 355, 88, 24);
		contentPane.add(lblEndDate);
		
		JLabel lblReason = new JLabel("Reason");
		lblReason.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblReason.setBounds(407, 465, 88, 24);
		contentPane.add(lblReason);
		
		final JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setIcon(new ImageIcon("C:\\Users\\Lenovo\\Workspaces\\MyEclipse Professional 2014\\project3\\images\\Ok-icon.png"));
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to add new request?","Leave Request",JOptionPane.YES_NO_OPTION);
		        if(p==0){
				
				if(e.getSource()==btnSubmit)
				{
					 java.util.Date date =dateChooser.getDate();
						String strDate = DateFormat.getDateInstance().format(date);
						java.util.Date d1=dateChooser_1.getDate();
						String strDate1 = DateFormat.getDateInstance().format(d1);
						{
				try
				{
					String sa="insert into empleave(id,name,leave_type,start_date,end_date,no_of_days,reason)values(?,?,?,?,?,?,?)";
				    Connection con=MyConnection.getConnection();
				    PreparedStatement ps=(PreparedStatement) con.prepareStatement(sa);
				   
					ps.setString(1,id1.getText());
					ps.setString(2,textField_1.getText());
					ps.setString(3,textField_2.getText());
					ps.setString(4,strDate);
					ps.setString(5,strDate1);
					ps.setString(6,textField_3.getText());
					ps.setString(7,textField_4.getText());
					
					
					
					
					
					int x=ps.executeUpdate();
					if(x>0)
					{
						String msg="Request Sent";
						JOptionPane.showMessageDialog(null,msg,"Project",1);
						//new Login2();
						
					}
					}
					catch(SQLException se)
					{
						se.printStackTrace();
					}
				}
			}
			}
			}
		});
		btnSubmit.setBounds(491, 545, 137, 36);
		contentPane.add(btnSubmit);
		
		id1 = new JTextField();
		id1.setBounds(571, 150, 154, 22);
		contentPane.add(id1);
		id1.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(571, 202, 154, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(571, 249, 154, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(571, 302, 154, 22);
		contentPane.add(dateChooser);
		
		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(571, 357, 154, 22);
		contentPane.add(dateChooser_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(571, 413, 154, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(571, 467, 154, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("No. Of Days");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(407, 414, 103, 19);
		contentPane.add(lblNewLabel);
		
		JButton btnGoBack = new JButton("");
		btnGoBack.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Go-back-icon.png"));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new EmpHomepg().setVisible(true);
			}
		});
		btnGoBack.setBounds(0, 612, 97, 36);
		contentPane.add(btnGoBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\engineer-icon.png"));
		label.setBounds(92, 142, 265, 358);
		contentPane.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\abstract_colors_aqua+art_neko.jpg"));
		lblNewLabel_1.setBounds(0, 0, 798, 643);
		contentPane.add(lblNewLabel_1);
		
		
	}
}
