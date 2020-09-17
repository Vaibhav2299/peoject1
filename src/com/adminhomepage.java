package com;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class adminhomepage extends JFrame {

	private JPanel contentPane;
	JFrame frame1;
	 static JTable table;
	 String[] columnNames = {"id","first_name","last_name","date_of_birth","gender", "email", "contact", "address","pin_code","department","designation","date_hired","basic_salary","password","secques","secans","status"};
	 String[] columnNames2={"Id","Name","Leave_type","Start_date","End_date","No_of_days","Reason","Status","Comment"};
	 String[] columnNames3 = {"id","first_name","last_name","basic_salary","deduction_amount","salary_after_deduction","reason"};
	 String[] columnNames4 ={"id","first_name","last_name","basic_salary","overtime","medical","bonus","others","rate","total_allowance"};
	 String from;
	 PreparedStatement pst;
	 Connection con;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminhomepage frame = new adminhomepage();
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
	public adminhomepage() {
		
		setTitle("ADMIN HOME PAGE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 939, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdminHomePage = new JLabel("ADMIN HOME PAGE");
		lblAdminHomePage.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAdminHomePage.setBounds(360, 68, 269, 36);
		contentPane.add(lblAdminHomePage);
		
		JButton btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Add_Employee.png"));
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//JOptionPane.showMessageDialog(null,"OK","Project", 1);
				EmpRegister hm=new EmpRegister();
				hm.setVisible(true);
				dispose();		
			}
		});
		btnAddEmployee.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnAddEmployee.setBounds(234, 174, 211, 53);
		contentPane.add(btnAddEmployee);
		
	final	JButton btnUpdateEmployee = new JButton("Update Employee");
	btnUpdateEmployee.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Update.png"));
		btnUpdateEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==btnUpdateEmployee)
				{
					new SearchEmp().setVisible(true);
					dispose();
				}
				
				
			}
		});
		btnUpdateEmployee.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnUpdateEmployee.setBounds(556, 174, 211, 53);
		contentPane.add(btnUpdateEmployee);
		
		JButton btnDeleteEmployee = new JButton("Deduction");
		btnDeleteEmployee.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Deduction.png"));
		btnDeleteEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Deduction().setVisible(true);
				dispose();
			}
		});
		btnDeleteEmployee.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnDeleteEmployee.setBounds(234, 277, 211, 59);
		contentPane.add(btnDeleteEmployee);
		
		JButton btnLeave = new JButton(" Leave Requests");
		btnLeave.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Right3Green.png"));
		btnLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new EmpleaveReq().setVisible(true);
				dispose();
			}
		});
		btnLeave.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnLeave.setBounds(556, 280, 211, 53);
		contentPane.add(btnLeave);
		
		JButton btnAddAdmin = new JButton("ADD ADMIN");
		btnAddAdmin.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Staff.png"));
		btnAddAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				//JOptionPane.showMessageDialog(null,"OK","Project", 1);
				new AdminRegister().setVisible(true);
				dispose();
				
				
				
				
			}
		});
		btnAddAdmin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		btnAddAdmin.setBounds(234, 468, 211, 53);
		contentPane.add(btnAddAdmin);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 921, 26);
		contentPane.add(menuBar);
		
		JMenu mnReports = new JMenu("Reports");
		menuBar.add(mnReports);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Employee RP\r\n");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				showTableData();
				
			}
		});
		
		JMenuItem mntmDeductionRp = new JMenuItem("Deduction RP");
		mntmDeductionRp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				showDeduction();
				
			}
		});
		mnReports.add(mntmDeductionRp);
		
		JMenuItem mntmLeaveRp = new JMenuItem("Leave RP");
		mntmLeaveRp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				showTable();
				
			}
		});
		
		JMenuItem mntmAllowanceRp = new JMenuItem("Allowance RP");
		mntmAllowanceRp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				showtab();
				
			}
		});
		mnReports.add(mntmAllowanceRp);
		mnReports.add(mntmLeaveRp);
		mnReports.add(mntmNewMenuItem);
		
		JButton btnNewButton = new JButton("Update Salary");
		btnNewButton.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\update icon.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new UpdateSalary().setVisible(true);
			dispose();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBounds(556, 378, 211, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Allowance");
		btnNewButton_1.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Allowance.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Allowance().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_1.setBounds(234, 378, 211, 46);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Change Password");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new ChangePasswordAdmin().setVisible(true);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\change-password-icon.png"));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_2.setBounds(556, 467, 211, 53);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new MainPage().setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\logout.png"));
		btnNewButton_3.setBounds(821, 39, 72, 36);
		contentPane.add(btnNewButton_3);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\abstract_colors_aqua+art_neko.jpg"));
		label.setBounds(0, 26, 921, 569);
		contentPane.add(label);
		
	}
		public void showTableData()
		 
		 {
			

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
		        	String es="select * from employee";
		        	con=MyConnection.getConnection();
		            pst = con.prepareStatement(es);
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
		
		public void showTable()
		 
		 {

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
		        model.setColumnIdentifiers(columnNames2);
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
		        String Name = "";
		        String Leave_type = "";
		        String Start_date="";
		        String End_date="";
		        String No_of_days="";
		        String Reason="";
		        String Status="";
		        String Comment="";
		
		       
		        

		        try {
		        	String es="select * from empleave";
		        	con=MyConnection.getConnection();
		            pst = con.prepareStatement(es);
		            ResultSet rs = pst.executeQuery();
		            int i = 0;
		            if (rs.next()) {
		                Id = rs.getString("id");
		                Name = rs.getString("name");
		                Leave_type = rs.getString("leave_type");
		                Start_date=rs.getString("start_date");
	                    End_date= rs.getString("end_date");
	                    No_of_days= rs.getString("no_of_days");
	                    Reason= rs.getString("reason");
	                    Status= rs.getString("status");
	                    Comment= rs.getString("comment");
	                 
	                  
		                model.addRow(new Object[]{Id,Name,Leave_type,Start_date,End_date,No_of_days,Reason,Status,Comment});
		                i++;
		            }
		            if (i < 1) {
		                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
		            }
		            if (i == 1) {
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
		    	public void showDeduction()
				 
				 {

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
				        model.setColumnIdentifiers(columnNames3);
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
				       
				
				        String id = "";
				        String fname = "";
				        String lname = "";
				        String sal="";
				        String da="";
				        String sad="";
				        String rea="";
				       
				        try {
				        	String es="select * from deductions";
				        	con=MyConnection.getConnection();
				            pst = con.prepareStatement(es);
				            ResultSet rs = pst.executeQuery();
				            int i = 0;
				            if (rs.next())
				            {
				                id = rs.getString("id");
				                fname = rs.getString("first_name");
				                lname = rs.getString("last_name");
				                sal= rs.getString("basic_salary");
				                da= rs.getString("deduction_amount");
				                sad= rs.getString("salary_after_deduction");
				                rea= rs.getString("deduction_reason");
				                   
			                 
				                model.addRow(new Object[]{id,fname,lname,sal,da,sad,rea});
				               
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
				        frame1.getContentPane().add(b1, BorderLayout.SOUTH);
				 }
		    	
		    	public void showtab()
				 
				 {

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
				        model.setColumnIdentifiers(columnNames4);
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
				       
				
				        String id = "";
				        String fname = "";
				        String lname = "";
				        String sal="";
				        String over="";
				        String med="";
				        String bon="";
				        String oth="";
				        String rat="";
				        String ta="";
				       
				        try {
				        	String es="select * from allowance";
				        	con=MyConnection.getConnection();
				            pst = con.prepareStatement(es);
				            ResultSet rs = pst.executeQuery();
				            int i = 0;
				            if (rs.next())
				            {
				                id = rs.getString("id");
				                fname = rs.getString("first_name");
				                lname = rs.getString("last_name");
				                sal= rs.getString("basic_salary");
				                over= rs.getString("overtime");
				                med= rs.getString("medical");
				                bon= rs.getString("bonus");
				                oth= rs.getString("others");
				                rat= rs.getString("rate");
				                ta= rs.getString("total_allowance");
				                   
			                 
				                model.addRow(new Object[]{id,fname,lname,sal,over,med,bon,oth,rat,ta});
				               
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
}
	

