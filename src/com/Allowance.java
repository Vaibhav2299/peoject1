package com;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;

public class Allowance extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField fname;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField lname;
	private JTextField dob;
	private JTextField sal;
	private JTextField dept;
	private JTextField textField_11;
	private JTextField textField_12;
	Connection con=null;
	ResultSet rs=null;
	PreparedStatement ps=null;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Allowance frame = new Allowance();
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
	public Allowance() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1101, 794);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmployeeId = new JLabel("First Name");
		lblEmployeeId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmployeeId.setBounds(125, 205, 115, 25);
		contentPane.add(lblEmployeeId);
		
		fname = new JTextField();
		fname.setBounds(283, 207, 176, 22);
		contentPane.add(fname);
		fname.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Last Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(125, 242, 115, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDateOfBirth.setBounds(125, 283, 115, 35);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalary.setBounds(125, 321, 115, 35);
		contentPane.add(lblSalary);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDepartment.setBounds(125, 358, 115, 35);
		contentPane.add(lblDepartment);
		
		JLabel lblOvetTime = new JLabel("Over Time");
		lblOvetTime.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOvetTime.setBounds(526, 242, 115, 35);
		contentPane.add(lblOvetTime);
		
		JLabel lblMedical = new JLabel("Medical");
		lblMedical.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMedical.setBounds(526, 283, 115, 35);
		contentPane.add(lblMedical);
		
		JLabel lblBonus = new JLabel("Bonus");
		lblBonus.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBonus.setBounds(526, 321, 115, 35);
		contentPane.add(lblBonus);
		
		JLabel lblOthers = new JLabel("Others");
		lblOthers.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOthers.setBounds(526, 358, 115, 35);
		contentPane.add(lblOthers);
		
		JLabel lblPleaseEnterThe = new JLabel("Please Enter The Amount");
		lblPleaseEnterThe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPleaseEnterThe.setBounds(663, 205, 239, 20);
		contentPane.add(lblPleaseEnterThe);
		
		JLabel lblTotalOverTime = new JLabel("Total Over Time");
		lblTotalOverTime.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotalOverTime.setBounds(776, 242, 125, 35);
		contentPane.add(lblTotalOverTime);
		
		JLabel lblRatePerHour = new JLabel("Rate Per Hour");
		lblRatePerHour.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRatePerHour.setBounds(776, 292, 131, 16);
		contentPane.add(lblRatePerHour);
		
		textField_1 = new JTextField();
		textField_1.setBounds(634, 249, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(634, 290, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(634, 328, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(634, 365, 116, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(913, 249, 116, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(913, 290, 116, 22);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		lname = new JTextField();
		lname.setBounds(283, 249, 176, 22);
		contentPane.add(lname);
		lname.setColumns(10);
		
		dob = new JTextField();
		dob.setBounds(283, 290, 176, 22);
		contentPane.add(dob);
		dob.setColumns(10);
		
		sal = new JTextField();
		sal.setBounds(283, 328, 176, 22);
		contentPane.add(sal);
		sal.setColumns(10);
		
		dept = new JTextField();
		dept.setBounds(283, 365, 176, 22);
		contentPane.add(dept);
		dept.setColumns(10);
		
		JLabel lblTotalAmount = new JLabel("Total Amount");
		lblTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotalAmount.setBounds(776, 381, 115, 35);
		contentPane.add(lblTotalAmount);
		
		final JButton btnSave = new JButton("Save");
		btnSave.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Save-icon.png"));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to save record?","Add Record",JOptionPane.YES_NO_OPTION);
		        if(p==0)
		        {
				if(e.getSource()==btnSave)
				{
					   
				        try {

				           
				            String over =  textField_1 .getText();
				            String med =  textField_2 .getText();
				            String bon =  textField_3 .getText();
				            String oth =  textField_4 .getText();
				            String rat =  textField_6 .getText();
				            String fnam =  fname.getText();
				            String lnam =  lname.getText();  
				            String sala =  sal.getText();
				            String ta =  textField_11.getText();
				            String id = textField_12.getText();
				     
				           String sql= "insert into Allowance (id,first_name,last_name,basic_salary,overtime,medical,bonus,others,rate,total_allowance) values ('"+id+"','"+fnam+"','"+lnam+"','"+sala+"','"+over+"','"+med+"','"+bon+"','"+oth+"','"+rat+"','"+ta+"')";
				                  
				                 
				            ps=con.prepareStatement(sql);
				            ps.execute();
				            JOptionPane.showMessageDialog(null, "Allowance Added");
				           
				                  
				        } 
				        catch (Exception e1)
				            
				        {
				            JOptionPane.showMessageDialog(null,e1);
				        }
				}
			}
             Update_table();
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSave.setBounds(813, 483, 185, 35);
		contentPane.add(btnSave);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Calculate.png"));
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int salary = Integer.parseInt(sal.getText());
		        int overtime = Integer.parseInt(textField_1.getText());

		        double eight = 8;
		        double days = 25;
		        double dbop = 0;
		        double overtimeRate = 1.5;
		        
		        //calculate the total hours of overtime
		        double Total_Overtime = overtime * overtimeRate;
		        String x = String.valueOf(Total_Overtime);
		        textField_5.setText(x);

		        //calculate overall overtime 
		        dbop = salary /days/eight;
		        String s = String.valueOf(dbop);
		        textField_6.setText(s);
		        
		        int med = Integer.parseInt(textField_2.getText());
		        int bonus = Integer.parseInt(textField_3.getText());
		        int other = Integer.parseInt(textField_4.getText());
		        int f = med+bonus+other;
		        double calc = Total_Overtime * dbop+f;
		        String c = String.valueOf(calc);
		        textField_11.setText(c);
				
			}
		});
		btnCalculate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCalculate.setBounds(813, 549, 185, 35);
		contentPane.add(btnCalculate);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\erase-128.png"));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			textField_5.setText("");
			textField_6.setText("");
			textField_11.setText("");
			textField_12.setText("");
			fname.setText("");
			lname.setText("");
			dob.setText("");
			dept.setText("");
			sal.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClear.setBounds(813, 606, 185, 35);
		contentPane.add(btnClear);
		
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setBounds(913, 388, 131, 22);
		contentPane.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(334, 72, 441, 22);
		contentPane.add(textField_12);
		textField_12.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblId.setBounds(216, 71, 56, 21);
		contentPane.add(lblId);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Untitled (2).png"));
		label.setBounds(183, 39, 657, 80);
		contentPane.add(label);
		
		JLabel lblSEA = new JLabel("S e a r c h");
		lblSEA.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSEA.setBounds(183, 13, 115, 25);
		contentPane.add(lblSEA);
		
		final JButton btnSearch = new JButton("Search");
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
			            ps.setString(1,textField_12.getText());
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
			                
			                String add12 =rs.getString("basic_salary");
			                sal.setText(add12);
			                
			            }
					}
					catch(Exception e1)
					{
			            JOptionPane.showMessageDialog(null, "ID NOT CORRECT");
			        }
					
			}
				
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSearch.setBounds(674, 119, 166, 50);
		contentPane.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 415, 675, 319);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new adminhomepage().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Go-back-icon.png"));
		btnNewButton.setBounds(974, 699, 109, 35);
		contentPane.add(btnNewButton);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\abstract_colors_aqua+art_neko.jpg"));
		label_1.setBounds(0, 0, 1083, 747);
		contentPane.add(label_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	 private void Update_table() {
		    try{
		        String sql ="select * from allowance";
		        ps=con.prepareStatement(sql);
		        rs=ps.executeQuery();
		        table.setModel(DbUtils.resultSetToTableModel(rs));
		    }
		    catch(Exception e){
		    JOptionPane.showMessageDialog(null, e);
		    }
	 }
}
