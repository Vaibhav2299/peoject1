package com;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchEmp extends JFrame {
	private JTextField fname;
	private JTextField lname;
	private JTextField dob;
	private JTextField email;
	private JTextField contact;
	private JTextField address;
	private JTextField pincode;
	private JTextField dept;
	private JTextField desig;
	private JTextField doh;
	private JTextField salary;
	private JTextField textField;
	private JTextField textField_1;
	ResultSet rs=null;
	PreparedStatement ps=null;
	private JTextField textField_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new SearchEmp();
		MyConnection.getConnection();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchEmp frame = new SearchEmp();
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
	public SearchEmp() {
		
		setTitle("SEARCH EMPLOYEE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 905);
		getContentPane().setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFirstName.setBounds(145, 218, 91, 30);
		getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLastName.setBounds(145, 261, 91, 30);
		getContentPane().add(lblLastName);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateOfBirth.setBounds(145, 146, 91, -2);
		getContentPane().add(lblDateOfBirth);
		
		JLabel lblDateOfBirth_1 = new JLabel("Date Of Birth");
		lblDateOfBirth_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateOfBirth_1.setBounds(145, 304, 91, 30);
		getContentPane().add(lblDateOfBirth_1);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGender.setBounds(145, 347, 91, 30);
		getContentPane().add(lblGender);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(145, 390, 91, 23);
		getContentPane().add(lblEmail);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContact.setBounds(145, 462, 91, 30);
		getContentPane().add(lblContact);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddress.setBounds(145, 505, 91, 30);
		getContentPane().add(lblAddress);
		
		JLabel lblPinCode = new JLabel("Pin Code");
		lblPinCode.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPinCode.setBounds(145, 548, 91, 30);
		getContentPane().add(lblPinCode);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDepartment.setBounds(145, 591, 91, 30);
		getContentPane().add(lblDepartment);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDesignation.setBounds(145, 634, 91, 30);
		getContentPane().add(lblDesignation);
		
		JLabel lblDateHired = new JLabel("Date Hired");
		lblDateHired.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateHired.setBounds(145, 677, 91, 30);
		getContentPane().add(lblDateHired);
		
		JLabel lblBasicSalary = new JLabel("Basic Salary");
		lblBasicSalary.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBasicSalary.setBounds(145, 720, 91, 30);
		getContentPane().add(lblBasicSalary);
		
		JLabel label = new JLabel("");
		label.setBounds(340, 128, 56, 16);
		getContentPane().add(label);
		
		fname = new JTextField();
		fname.setBounds(312, 223, 241, 22);
		getContentPane().add(fname);
		fname.setColumns(10);
		
		lname = new JTextField();
		lname.setBounds(312, 266, 241, 22);
		getContentPane().add(lname);
		lname.setColumns(10);
		
		dob = new JTextField();
		dob.setBounds(312, 304, 241, 22);
		getContentPane().add(dob);
		dob.setColumns(10);
		
		email = new JTextField();
		email.setBounds(312, 391, 241, 22);
		getContentPane().add(email);
		email.setColumns(10);
		
		contact = new JTextField();
		contact.setBounds(312, 467, 241, 22);
		getContentPane().add(contact);
		contact.setColumns(10);
		
		address = new JTextField();
		address.setBounds(312, 510, 241, 22);
		getContentPane().add(address);
		address.setColumns(10);
		
		pincode = new JTextField();
		pincode.setBounds(312, 548, 241, 22);
		getContentPane().add(pincode);
		pincode.setColumns(10);
		
		dept = new JTextField();
		dept.setBounds(312, 596, 241, 22);
		getContentPane().add(dept);
		dept.setColumns(10);
		
		desig = new JTextField();
		desig.setBounds(312, 639, 241, 22);
		getContentPane().add(desig);
		desig.setColumns(10);
		
		doh = new JTextField();
		doh.setBounds(312, 682, 241, 22);
		getContentPane().add(doh);
		doh.setColumns(10);
		
		salary = new JTextField();
		salary.setBounds(312, 725, 241, 22);
		getContentPane().add(salary);
		salary.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(145, 426, 91, 23);
		getContentPane().add(lblPassword);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(145, 106, 56, 16);
		getContentPane().add(lblId);
		
		textField = new JTextField();
		textField.setBounds(312, 104, 241, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Untitled (2).png"));
		label_1.setBackground(SystemColor.textHighlight);
		label_1.setBounds(61, 76, 647, 68);
		getContentPane().add(label_1);
		
		JLabel lblSearch = new JLabel("S e a r c h");
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSearch.setBounds(61, 47, 114, 32);
		getContentPane().add(lblSearch);
		
		final JButton btnUpdate = new JButton("UPDATE RECORD");
		btnUpdate.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\update icon.png"));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to update record?","Update Record",JOptionPane.YES_NO_OPTION);
		        if(p==0){
				
				if(e.getSource()==btnUpdate)
				{
					try
					{

		                String value1 = fname.getText();
		                String value2 = lname.getText();
		                String value3 = dob.getText();
		                String value4 = textField_1.getText();
		                String value5 = email.getText();
		                String value6 = textField_2.getText();
		                String value7 = contact.getText();
		                String value8 = address.getText();
		                String value9 = pincode.getText();
		                String value10 = dept.getText();
		                String value11 = desig.getText();
		                String value12 = doh.getText();
		                String value13 = salary.getText();
		                String value14= textField.getText();
		             
		                String sql= "update employee set first_name='"+value1+"', last_name='"+value2+"', "
		                        + "date_of_birth='"+value3+"',gender='"+value4+"',email='"+value5+"',"
		                        + "password='"+value6+"',contact='"+value7+"', address = '"+value8+"', "
		                        + "pin_code = '"+value9+"', department ='"+value10+"', "
		                        + "designation ='"+value11+"', date_hired ='"+value12+"',basic_salary ='"+value13+"' where id=?";

		                Connection con=MyConnection.getConnection();
		                ps=con.prepareStatement(sql);
		                ps.setString(1,textField.getText());
		                ps.execute();
		                JOptionPane.showMessageDialog(null, "Record Updated");

		            }
					catch(Exception e1)
					{
		                JOptionPane.showMessageDialog(null, e1);
		            }
				}
			}
			}
		});
		
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdate.setBounds(166, 776, 186, 32);
		getContentPane().add(btnUpdate);
		
		final JButton btnDeleteRecord = new JButton("DELETE RECORD");
		btnDeleteRecord.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\delete_16x16.gif"));
		btnDeleteRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete record?","Delete Record",JOptionPane.YES_NO_OPTION);
		        if(p==0){
				
				if(e.getSource()==btnDeleteRecord)
				{
					try
					{
						Connection con=MyConnection.getConnection();
						String sql="delete from employee where id=?";
						ps=con.prepareStatement(sql);
						 ps.setString(1,textField.getText());
						 ps.execute();
			                JOptionPane.showMessageDialog(null,"Record Deleted");

			            }
					catch(Exception ae)
					{

			                ae.printStackTrace();
					}
				}
			}
			}
		});
		btnDeleteRecord.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDeleteRecord.setBounds(372, 776, 181, 32);
		getContentPane().add(btnDeleteRecord);
		
		textField_1 = new JTextField();
		textField_1.setBounds(312, 352, 241, 22);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		final JButton btnSearch = new JButton("SEARCH");
		btnSearch.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Search.png"));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==btnSearch)
				{
					try
					{
						Connection con=MyConnection.getConnection();
						String sql ="select * from employee where id=? ";
						ps=con.prepareStatement(sql);
			            ps.setString(1,textField.getText());
			            rs=ps.executeQuery();
			            while(rs.next())
			            {
			            
			             
			                String add2 =rs.getString("first_name");
			                fname.setText(add2);

			                String add3 =rs.getString("last_name");
			                lname.setText(add3);

			                String add4 =rs.getString("date_of_birth");
			                dob.setText(add4);

			                String add5 =rs.getString("gender");
			                textField_1.setText(add5);

			                String add6 =rs.getString("email");
			                email.setText(add6);

			                String add7 =rs.getString("password");
			                textField_2.setText(add7);

			                String add8 =rs.getString("contact");
			                contact.setText(add8);
			                
			                String add9 =rs.getString("address");
			                address.setText(add9);
			                
			                String add10 =rs.getString("pin_code");
			                pincode.setText(add10);

			                String add11 =rs.getString("department");
			                dept.setText(add11);
			                
			                String add12 =rs.getString("designation");
			                desig.setText(add12);
			                
			                String add13 =rs.getString("date_hired");
			                doh.setText(add13);
			                
			                String add14 =rs.getString("basic_salary");
			                salary.setText(add14);
			            }
					}
					catch(Exception e1)
					{
			            JOptionPane.showMessageDialog(null, "Missing Data");
			        }
					
			}
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSearch.setBounds(542, 146, 166, 49);
		getContentPane().add(btnSearch);
		
		textField_2 = new JTextField();
		textField_2.setBounds(312, 426, 241, 22);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				new adminhomepage().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Go-back-icon.png"));
		btnNewButton.setBounds(0, 826, 97, 32);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\abstract_colors_aqua+art_neko.jpg"));
		lblNewLabel.setBounds(0, 0, 760, 858);
		getContentPane().add(lblNewLabel);
		
	}
}
	
		
		
