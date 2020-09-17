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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.SystemColor;

import javax.swing.UIManager;
import javax.swing.ImageIcon;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;

public class EmpHomepg extends JFrame implements ActionListener {

	private JPanel contentPane;
	JFrame frame1;
	 static JTable table;
	 String[] columnNames = {"id","first_name","last_name","date_of_birth","gender", "email", "contact", "address","pin_code","department","designation","date_hired","basic_salary","password","secques","secans"};
	 String[] columnNames2={"Id","Name","Leave_type","Start_date","End_date","No_of_days","Reason","Status","Comment"};
	 String[] columnNames3 = {"id","first_name","last_name","basic_salary","deduction_amount","salary_after_deduction","reason"};
	 String from;
	 PreparedStatement pst;
	 Connection con;
	 JLabel lbl_emp;
	 JLabel id1;
	 JFrame f;
	 private JPasswordField passwordField;
	 
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new EmpHomepg();
		MyConnection.getConnection();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpHomepg frame = new EmpHomepg();
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
	public EmpHomepg() 
	{
		
		setTitle("EMPLOYEE LOGIN PAGE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 599);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JButton btnSignOut = new JButton("Sign Out                  ");
		btnSignOut.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Apps-Dialog-Logout-icon.png"));
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnSignOut){
					dispose();
					new MainPage().setVisible(true);
				}
			}
		});
		btnSignOut.setForeground(SystemColor.desktop);
		btnSignOut.setBackground(SystemColor.inactiveCaption);
		btnSignOut.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSignOut.setBounds(372, 411, 266, 45);
		contentPane.add(btnSignOut);
		
		
	
		
		 
		 
		final JButton btnViewDetails = new JButton("View Details");
		btnViewDetails.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Status-dialog-information-icon.png"));
		btnViewDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnViewDetails)
				{
					showTableData();
				}
			}

			private void showTableData() {
					

				        frame1 = new JFrame("Database Search Result");
				        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				        frame1.getContentPane().setLayout(new BorderLayout());
				        JButton b1=new JButton("Print");
				        b1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								try
								{
									table.print();
								}
								catch(Exception ex)
								{
									ex.printStackTrace();
								}
							}
							});
				//TableModel tm = new TableModel();
				        DefaultTableModel model = new DefaultTableModel();
				        model.setColumnIdentifiers(columnNames);
				//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());
				//table = new JTable(model);
				        table = new JTable();
				        table.setModel(model);
				        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				        table.setFillsViewportHeight(true);
				        JScrollPane scroll = new JScrollPane(table);
				        scroll.setHorizontalScrollBarPolicy(
				                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				        scroll.setVerticalScrollBarPolicy(
				                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				       
				//String textvalue = textbox.getText();
				        String Id = "";
				        String fname = "";
				        String lname = "";
				        String dob="";
				        String gen="";
				        String email="";
				        String cont="";
				        String add="";
				        String pin="";
				        String dept="";
				        String desig="";
				        String doh="";
				        String sal="";
				        String pass="";
				        String sq="";
				        String sa="";
				        String st="";
				       
				       
				        

				        try {
				        	String es="select * from employee where id=?";
				        	con=MyConnection.getConnection();
				            pst = con.prepareStatement(es);
				            pst.setString(1,id1.getText());
				            ResultSet rs = pst.executeQuery();
				            int i = 0;
				            if (rs.next()) {
				                Id = rs.getString("id");
				                fname = rs.getString("first_name");
				                lname = rs.getString("last_name");
				                dob=rs.getString("date_of_birth");
			                   gen= rs.getString("gender");
			                   email= rs.getString("email");
			                   cont= rs.getString("contact");
			                   add= rs.getString("address");
			                   pin= rs.getString("pin_code");
			                   dept= rs.getString("department");
			                   desig= rs.getString("designation");
			                   doh= rs.getString("date_hired");
			                   sal= rs.getString("basic_salary");
			                   pass= rs.getString("password");
			                   sq= rs.getString("secques");
			                   sa= rs.getString("secans");
			                   st=rs.getString("status");
			                   
				                model.addRow(new Object[]{Id,fname,lname,dob,gen,email,cont,add,pin,dept,desig,doh,sal,pass,sq,sa,st});
				               
				               i++;
				            }
				            if (i < 1) {
				                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
				            }
				            if (i <= 1) {
				                System.out.println(i + " Record Found");
				            } else {
				                System.out.println(i + " Records Found");
				            }
				        } catch (Exception ex) {
				            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				        }
				        frame1.getContentPane().add(scroll);
				        frame1.setVisible(true);
				        frame1.setSize(1000, 1000);
				       frame1.getContentPane().add(b1,BorderLayout.SOUTH);
				
			}
		});
		btnViewDetails.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnViewDetails.setBounds(68, 241, 263, 45);
		contentPane.add(btnViewDetails);
		
		final JButton btnRequest = new JButton("Request For Leave");
		btnRequest.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\announcement-icon.png"));
		btnRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnRequest){
					LeaveReq lf=new LeaveReq();
					lf.setVisible(true);
					dispose();
				}
			}
		});
		btnRequest.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRequest.setBounds(68, 329, 263, 45);
		contentPane.add(btnRequest);
		
		final JButton button = new JButton("Change Password");
		button.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\change-password-icon.png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button){
					
					
					new ChangePasswordEmp().setVisible(true);
					dispose();
					}
			}
		});
		button.setForeground(SystemColor.desktop);
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBackground(SystemColor.inactiveCaption);
		button.setBounds(68, 412, 263, 44);
		contentPane.add(button);
		
		JLabel lblWelcome = new JLabel("WELCOME");
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblWelcome.setBounds(290, 57, 155, 45);
		contentPane.add(lblWelcome);
		
		JButton btnNewButton = new JButton("Show Request Status");
		btnNewButton.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Status-user-online-icon.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				showTab();
			}

		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(372, 241, 266, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Deduction Reports");
		btnNewButton_1.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Deduction.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				showTab();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(372, 329, 266, 45);
		contentPane.add(btnNewButton_1);
		
		lbl_emp = new JLabel("");
		lbl_emp.setBounds(37, 57, 56, 16);
		contentPane.add(lbl_emp);
		
		JLabel lblEnterYourPassword = new JLabel("Enter Your Password");
		lblEnterYourPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnterYourPassword.setBounds(158, 178, 173, 19);
		contentPane.add(lblEnterYourPassword);
		
		JLabel lblLoggedInAs = new JLabel("Logged in as:");
		lblLoggedInAs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoggedInAs.setBounds(547, 23, 105, 22);
		contentPane.add(lblLoggedInAs);
		
		id1 = new JLabel("");
		id1.setBounds(642, 23, 37, 22);
		contentPane.add(id1);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try
				{
					con=MyConnection.getConnection();
					String sql ="select id from employee where password=? ";
					pst=con.prepareStatement(sql);
		            pst.setString(1,passwordField.getText());
		            ResultSet rs=pst.executeQuery();
		            while(rs.next())
		            {
		            
		             
		                String add2 =rs.getString("id");
		                id1.setText(add2);
		            }
				}
				catch(Exception e1)
				{
		            e1.printStackTrace();
		        }
				
			}
		});
		passwordField.setBounds(372, 177, 120, 22);
		contentPane.add(passwordField);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\abstract_colors_aqua+art_neko.jpg"));
		label.setBounds(0, 0, 706, 552);
		contentPane.add(label);
		
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
		private void showTable2() {
			
			frame1 = new JFrame("Database Search Result");
	        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frame1.getContentPane().setLayout(new BorderLayout());
			frame1.setSize(1800,1000);
			frame1.setLocation(100,100);
			
			String[]columns=new String[]{"id","first_name","last_name","basic_salary","deduction_amount","salary_after_deduction","deduction_reason"};
			
			Connection con=MyConnection.getConnection();
			try
			{
				int cnt=0,r=0,c=0;
				String st="select * from deductions where id=?";
				PreparedStatement ps=con.prepareStatement(st);
				ps.setString(1,id1.getText());
				ResultSet rs=ps.executeQuery();
				rs.last();
				cnt=rs.getRow();
				rs.beforeFirst();
				String[][]data=new String[cnt][7];
				while(rs.next())
				{
					data[r][c]=String.valueOf(rs.getString("id"));++c;
					data[r][c]=rs.getString("first_name");++c;
					data[r][c]=String.valueOf(rs.getString("last_name"));++c;
					data[r][c]=String.valueOf(rs.getString("basic_salary"));++c;
					data[r][c]=String.valueOf(rs.getString("deduction_amount"));++c;
					data[r][c]=String.valueOf(rs.getString("salary_after_deduction"));++c;
					data[r][c]=String.valueOf(rs.getString("deduction_reason"));++c;
				
					c=0;
					++r;
				}
				 
				
				final JTable jt=new JTable(data,columns);
				jt.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				JScrollPane jsp=new JScrollPane(jt, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				jsp.setBounds(12,25,1187,586);
				frame1.getContentPane().add(jsp);
				
				JButton btnNewButton = new JButton("Print");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							
								try
								{
									jt.print();
								}
								catch(Exception ex)
								{
									ex.printStackTrace();
								}
							}
						});
				btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
				
				frame1.getContentPane().add(btnNewButton,BorderLayout.SOUTH);
				
				frame1.setVisible(true);
				
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			
	}
	public void showTab()
	{
			
			frame1 = new JFrame("Database Search Result");
	        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame1.getContentPane().setLayout(new BorderLayout());
			frame1.setSize(1800,1000);
			frame1.setLocation(100,100);
			
			String[]columns=new String[]{"Id","Name","Leave_type","Start_date","End_date","No_of_days","Reason","Status","Comment"};
			
			Connection con=MyConnection.getConnection();
			try
			{
				int cnt=0,r=0,c=0;
				String st="select * from empleave where id=?";
				PreparedStatement ps=con.prepareStatement(st);
				ps.setString(1,id1.getText());
				ResultSet rs=ps.executeQuery();
				rs.last();
				cnt=rs.getRow();
				rs.beforeFirst();
				String[][]data=new String[cnt][9];
				while(rs.next())
				{
					data[r][c]=String.valueOf(rs.getString("id"));++c;
					data[r][c]=rs.getString("name");++c;
					data[r][c]=String.valueOf(rs.getString("leave_type"));++c;
					data[r][c]=String.valueOf(rs.getString("start_date"));++c;
					data[r][c]=String.valueOf(rs.getString("end_date"));++c;
					data[r][c]=String.valueOf(rs.getString("no_of_days"));++c;
					data[r][c]=String.valueOf(rs.getString("reason"));++c;
					data[r][c]=String.valueOf(rs.getString("status"));++c;
					data[r][c]=String.valueOf(rs.getString("comment"));++c;
				
					c=0;
					++r;
				}
				 
				
				final JTable jt=new JTable(data,columns);
				jt.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				JScrollPane jsp=new JScrollPane(jt, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				jsp.setBounds(12,25,1187,586);
				frame1.getContentPane().add(jsp);
				
				JButton btnNewButton = new JButton("Print");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							
								try
								{
									jt.print();
								}
								catch(Exception ex)
								{
									ex.printStackTrace();
								}
							}
						});
				btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
				
				frame1.getContentPane().add(btnNewButton,BorderLayout.SOUTH);
				
				frame1.setVisible(true);
				
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			
	
	}
}
