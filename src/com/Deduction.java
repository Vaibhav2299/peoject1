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
import javax.swing.JRadioButton;

public class Deduction extends JFrame {
	private JTextField fname;
	private JTextField lname;
	private JTextField dob;
	private JTextField dept;
	private JTextField desig;
	private JTextField salary;
	private JTextField textField;
	ResultSet rs=null;
	PreparedStatement ps=null;
	private JTextField txt_dept1;
	private JTextField txt_dept2;
	JRadioButton rdbtnAmountrs,rdbtnPercentage;
	Connection con;
	private JTextField status;
	private JTextField doh;
	private JTextField textField_2;
	JLabel lbl_total,lbl_sal;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Deduction();
		MyConnection.getConnection();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deduction frame = new Deduction();
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
	public Deduction() {
		
		setTitle("DEDUCTION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 846, 881);
		getContentPane().setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFirstName.setBounds(61, 218, 91, 30);
		getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLastName.setBounds(61, 274, 91, 30);
		getContentPane().add(lblLastName);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateOfBirth.setBounds(145, 146, 91, -2);
		getContentPane().add(lblDateOfBirth);
		
		JLabel lblDateOfBirth_1 = new JLabel("Date Of Birth");
		lblDateOfBirth_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateOfBirth_1.setBounds(61, 327, 91, 30);
		getContentPane().add(lblDateOfBirth_1);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDepartment.setBounds(61, 383, 91, 30);
		getContentPane().add(lblDepartment);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDesignation.setBounds(410, 327, 91, 30);
		getContentPane().add(lblDesignation);
		
		JLabel lblBasicSalary = new JLabel("Basic Salary");
		lblBasicSalary.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBasicSalary.setBounds(410, 383, 91, 30);
		getContentPane().add(lblBasicSalary);
		
		JLabel label = new JLabel("");
		label.setBounds(340, 128, 56, 16);
		getContentPane().add(label);
		
		fname = new JTextField();
		fname.setEditable(false);
		fname.setBounds(189, 223, 181, 22);
		getContentPane().add(fname);
		fname.setColumns(10);
		
		lname = new JTextField();
		lname.setEditable(false);
		lname.setBounds(189, 279, 181, 22);
		getContentPane().add(lname);
		lname.setColumns(10);
		
		dob = new JTextField();
		dob.setEditable(false);
		dob.setBounds(189, 332, 181, 22);
		getContentPane().add(dob);
		dob.setColumns(10);
		
		dept = new JTextField();
		dept.setEditable(false);
		dept.setBounds(189, 388, 181, 22);
		getContentPane().add(dept);
		dept.setColumns(10);
		
		desig = new JTextField();
		desig.setEditable(false);
		desig.setBounds(569, 332, 181, 22);
		getContentPane().add(desig);
		desig.setColumns(10);
		
		salary = new JTextField();
		salary.setEditable(false);
		salary.setBounds(569, 388, 181, 22);
		getContentPane().add(salary);
		salary.setColumns(10);
		
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
		label_1.setBounds(103, 76, 647, 68);
		getContentPane().add(label_1);
		
		JLabel lblSearch = new JLabel("S e a r c h");
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSearch.setBounds(103, 46, 114, 32);
		getContentPane().add(lblSearch);
	
		
		
		final JButton btnSearch = new JButton("SEARCH");
		btnSearch.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Search.png"));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==btnSearch)
				{
					try
					{
						con=MyConnection.getConnection();
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
			                
                            String add11 =rs.getString("department");
			                dept.setText(add11);
			                
			                String add12 =rs.getString("designation");
			                desig.setText(add12);
			                
			                String add13 =rs.getString("date_hired");
			                doh.setText(add13);
			                
			                String add14 =rs.getString("basic_salary");
			                salary.setText(add14);
			                
			                String add15 =rs.getString("status");
			                status.setText(add15);
			            }
					}
					catch(Exception e1)
					{
			            JOptionPane.showMessageDialog(null, "ID NOT CORRECT");
			        }
					
			}
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSearch.setBounds(580, 147, 170, 44);
		getContentPane().add(btnSearch);
		
		JLabel lblUpdateSalaryBy = new JLabel("Deduct Salary By:");
		lblUpdateSalaryBy.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUpdateSalaryBy.setBounds(61, 524, 160, 30);
		getContentPane().add(lblUpdateSalaryBy);
		
		rdbtnPercentage = new JRadioButton("Percentage(%)");
		rdbtnPercentage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rdbtnPercentage.setSelected(true);
				rdbtnAmountrs.setSelected(false);
			        txt_dept2.setEnabled(false);
			        txt_dept1.setEditable(true);
			        txt_dept1.setEnabled(true);
			        txt_dept2.setText("");
			}
		});
		rdbtnPercentage.setBounds(209, 528, 127, 25);
		getContentPane().add(rdbtnPercentage);
		
		rdbtnAmountrs = new JRadioButton("Amount(Rs)");
		rdbtnAmountrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 rdbtnAmountrs.setSelected(true);
				 rdbtnPercentage.setSelected(false);
			        txt_dept1.setEnabled(false);
			        txt_dept2.setEditable(true);
			        txt_dept2.setEnabled(true);
			        txt_dept1.setText("");
			}
		});
		rdbtnAmountrs.setBounds(340, 528, 127, 25);
		getContentPane().add(rdbtnAmountrs);
		
		JLabel lblPercentage = new JLabel("Percentage");
		lblPercentage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPercentage.setBounds(61, 570, 110, 30);
		getContentPane().add(lblPercentage);
		
		txt_dept1 = new JTextField();
		txt_dept1.setBounds(209, 575, 103, 22);
		getContentPane().add(txt_dept1);
		txt_dept1.setColumns(10);
		
		txt_dept2 = new JTextField();
		txt_dept2.setBounds(410, 575, 110, 22);
		getContentPane().add(txt_dept2);
		txt_dept2.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAmount.setBounds(340, 574, 86, 22);
		getContentPane().add(lblAmount);
		
		JButton btnUpdate_1 = new JButton("SAVE");
		btnUpdate_1.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Save-icon.png"));
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to add record?","Add Record",JOptionPane.YES_NO_OPTION);
		        if(p==0)
		        {
		            try {

		                String sql ="insert into deductions (id,first_name,last_name,basic_salary,deduction_amount,salary_after_deduction,deduction_reason) values (?,?,?,?,?,?,?)";
		                ps=con.prepareStatement(sql);
		                ps.setString(1,textField.getText());
		                ps.setString(2,fname.getText());
		                ps.setString(3,lname.getText());
		                ps.setString(4,salary.getText());
		                ps.setString(5,lbl_total.getText());
		                ps.setString(6,lbl_sal.getText());
		                ps.setString(7,textField_2.getText());
		  
		                ps.execute();
		                JOptionPane.showMessageDialog(null,"Data is saved successfully");

		            }
		            catch (Exception e1)

		            {
		                JOptionPane.showMessageDialog(null,e1);
		            }
		        }  
			}
		});
		btnUpdate_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdate_1.setBounds(145, 692, 167, 25);
		getContentPane().add(btnUpdate_1);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStatus.setBounds(410, 226, 56, 16);
		getContentPane().add(lblStatus);
		
		status = new JTextField();
		status.setEditable(false);
		status.setBounds(569, 223, 181, 22);
		getContentPane().add(status);
		status.setColumns(10);
		
		JLabel lblDateHired = new JLabel("Date Hired");
		lblDateHired.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateHired.setBounds(410, 281, 90, 16);
		getContentPane().add(lblDateHired);
		
		doh = new JTextField();
		doh.setEditable(false);
		doh.setBounds(569, 279, 181, 22);
		getContentPane().add(doh);
		doh.setColumns(10);
		
		JLabel lblReason = new JLabel("Reason");
		lblReason.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblReason.setBounds(61, 632, 64, 16);
		getContentPane().add(lblReason);
		
		textField_2 = new JTextField();
		textField_2.setBounds(209, 630, 261, 22);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnCalculate = new JButton("CALCULATE");
		btnCalculate.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Calculate.png"));
		btnCalculate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int sal = Integer.parseInt(salary.getText());
		        
		        
		         if(rdbtnPercentage.isSelected()== true)
		         {
		        int percentage = Integer.parseInt(txt_dept1.getText());
		        int total_percentage_deduction = sal /100 * percentage;
		        String x = String.valueOf(total_percentage_deduction);
		        int sal1 = sal - total_percentage_deduction;
		        lbl_total.setText(x);
		        lbl_sal.setText(String.valueOf(sal1));
		         }
		        
		        if(rdbtnAmountrs.isSelected()== true)
		        {
		        int deduction = Integer.parseInt(txt_dept2.getText());
		        //calculate the total hours of overtime
		        int total_amount_deduction =  sal - deduction;
		        String s = String.valueOf(total_amount_deduction);
		       
		        lbl_sal.setText(s);
		        lbl_total.setText(String.valueOf(deduction));
		        
		        }
		    }
		});
		btnCalculate.setBounds(353, 692, 167, 25);
		getContentPane().add(btnCalculate);
		
		final JButton btnNewButton = new JButton("CLEAR");
		btnNewButton.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\erase-128.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==btnNewButton)
				{
					textField.setText("");
					fname.setText("");
					lname.setText("");
					dob.setText("");
					dept.setText("");
					desig.setText("");
					doh.setText("");
					salary.setText("");
					status.setText("");
					
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(559, 692, 165, 25);
		getContentPane().add(btnNewButton);
		
		JLabel lblTotalDeduction = new JLabel("Total Deduction:");
		lblTotalDeduction.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalDeduction.setBounds(543, 532, 135, 22);
		getContentPane().add(lblTotalDeduction);
		
		JLabel lblSalaryAfterDeduction = new JLabel("Salary After Deduction:");
		lblSalaryAfterDeduction.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSalaryAfterDeduction.setBounds(543, 574, 162, 22);
		getContentPane().add(lblSalaryAfterDeduction);
		
		lbl_total = new JLabel("0.00");
		lbl_total.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_total.setBounds(668, 528, 56, 30);
		getContentPane().add(lbl_total);
		
		lbl_sal = new JLabel("0.00");
		lbl_sal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_sal.setBounds(717, 570, 56, 30);
		getContentPane().add(lbl_sal);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new adminhomepage().setVisible(true);
				dispose();
			}
		});
		button.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Go-back-icon.png"));
		button.setBounds(0, 804, 97, 30);
		getContentPane().add(button);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\abstract_colors_aqua+art_neko.jpg"));
		label_2.setBounds(0, 0, 828, 834);
		getContentPane().add(label_2);
		
	}
}
	
		
		
