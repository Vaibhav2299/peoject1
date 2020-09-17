package com;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;





import java.text.DateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;






import com.toedter.calendar.JDateChooser;

public class EmpRegister extends JFrame {
	private JTextField fname;
	private JTextField lname;
	private JTextField email;
	private JTextField contact;
	private JTextField address;
	private JTextField pincode;
	private JTextField dept;
	private JTextField desig;
	private JTextField salary;
	private JComboBox comboBox;
	private JComboBox comboBox_1; 
	private JPasswordField passwordField;
	private JTextField textField;
	private JPasswordField passwordField_2;
	JLabel label_1;
	JDateChooser dateChooser,dateChooser_1;
	
	public static void main(String[] args) {
		new EmpRegister();
		MyConnection.getConnection();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpRegister frame = new EmpRegister();
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
	public EmpRegister() {
		
		setTitle("EMPLOYEE REGISTRATION PAGE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1304, 795);
		getContentPane().setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFirstName.setBounds(145, 145, 91, 30);
		getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLastName.setBounds(145, 188, 91, 30);
		getContentPane().add(lblLastName);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateOfBirth.setBounds(145, 146, 91, -2);
		getContentPane().add(lblDateOfBirth);
		
		JLabel lblDateOfBirth_1 = new JLabel("Date Of Birth");
		lblDateOfBirth_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateOfBirth_1.setBounds(145, 238, 91, 30);
		getContentPane().add(lblDateOfBirth_1);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGender.setBounds(145, 281, 91, 30);
		getContentPane().add(lblGender);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(145, 333, 91, 23);
		getContentPane().add(lblEmail);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContact.setBounds(750, 353, 91, 30);
		getContentPane().add(lblContact);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddress.setBounds(750, 396, 91, 30);
		getContentPane().add(lblAddress);
		
		JLabel lblPinCode = new JLabel("Pin Code");
		lblPinCode.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPinCode.setBounds(750, 439, 91, 30);
		getContentPane().add(lblPinCode);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDepartment.setBounds(750, 482, 91, 30);
		getContentPane().add(lblDepartment);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDesignation.setBounds(750, 525, 91, 30);
		getContentPane().add(lblDesignation);
		
		JLabel lblDateHired = new JLabel("Date Hired");
		lblDateHired.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDateHired.setBounds(750, 568, 91, 30);
		getContentPane().add(lblDateHired);
		
		JLabel lblBasicSalary = new JLabel("Basic Salary");
		lblBasicSalary.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBasicSalary.setBounds(750, 611, 91, 30);
		getContentPane().add(lblBasicSalary);
		
		final JButton add = new JButton("ADD RECORD");
		add.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Add_Employee.png"));
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Object ob=e.getSource();
				if(ob==add)
				{
				java.util.Date date =dateChooser.getDate();
				String strDate = DateFormat.getDateInstance().format(date);
				java.util.Date d1=dateChooser_1.getDate();
				String strDate1 = DateFormat.getDateInstance().format(d1);
				
				int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to add new employee?","New Employee",JOptionPane.YES_NO_OPTION);
		        if(p==0){
				
				{	
						try
						{
						Connection con=(Connection) MyConnection.getConnection();
						String st="insert into employee(id,first_name,last_name,date_of_birth,gender,email,contact,address,pin_code,department,designation,date_hired,basic_salary,password,secques,secans)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
						PreparedStatement ps=(PreparedStatement) con.prepareStatement(st);
						ps.setString(1,textField.getText());
						ps.setString(2,fname.getText());
						ps.setString(3,lname.getText());
						ps.setString(4,strDate);
						ps.setString(5,comboBox.getSelectedItem().toString());
						ps.setString(6,email.getText());
						ps.setString(7,contact.getText());
						ps.setString(8,address.getText());
						ps.setString(9,pincode.getText());
						ps.setString(10,dept.getText());
						ps.setString(11,desig.getText());
						ps.setString(12,strDate1);
						ps.setString(13,salary.getText());
						ps.setString(14,passwordField.getText());
						ps.setString(15,comboBox_1.getSelectedItem().toString());
						ps.setString(16,passwordField_2.getText());
						
						
						int x=ps.executeUpdate();
						if(x>0)
						{
							String msg="New Employee Added";
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
		add.setFont(new Font("Tahoma", Font.BOLD, 14));
		add.setBounds(437, 557, 205, 53);
		getContentPane().add(add);
		
		final JButton Clear = new JButton("CLEAR");
		Clear.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\erase-128.png"));
		Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==Clear)
				{
					textField.setText("");
					fname.setText("");
					lname.setText("");
					//dob.setText("");
					email.setText("");
					contact.setText("");
					address.setText("");
					pincode.setText("");
					dept.setText("");
					desig.setText("");
					//doh.setText("");
					salary.setText("");
					passwordField.setText("");
					passwordField_2.setText("");
				}
			}
		});
		Clear.setFont(new Font("Tahoma", Font.BOLD, 14));
		Clear.setBounds(437, 644, 205, 53);
		getContentPane().add(Clear);
		
		JLabel label = new JLabel("");
		label.setBounds(340, 128, 56, 16);
		getContentPane().add(label);
		
		fname = new JTextField();
		fname.setBounds(312, 150, 241, 22);
		getContentPane().add(fname);
		fname.setColumns(10);
		
		lname = new JTextField();
		lname.setBounds(312, 193, 241, 22);
		getContentPane().add(lname);
		lname.setColumns(10);
		
		
		
		email = new JTextField();
		email.setBounds(312, 334, 241, 22);
		getContentPane().add(email);
		email.setColumns(10);
		
		contact = new JTextField();
		contact.setBounds(937, 358, 241, 22);
		getContentPane().add(contact);
		contact.setColumns(10);
		
		address = new JTextField();
		address.setBounds(937, 401, 241, 22);
		getContentPane().add(address);
		address.setColumns(10);
		
		pincode = new JTextField();
		pincode.setBounds(937, 444, 241, 22);
		getContentPane().add(pincode);
		pincode.setColumns(10);
		
		dept = new JTextField();
		dept.setBounds(937, 487, 241, 22);
		getContentPane().add(dept);
		dept.setColumns(10);
		
		desig = new JTextField();
		desig.setBounds(937, 530, 241, 22);
		getContentPane().add(desig);
		desig.setColumns(10);
		
		salary = new JTextField();
		salary.setBounds(937, 616, 241, 22);
		getContentPane().add(salary);
		salary.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox.setBounds(312, 286, 241, 22);
		getContentPane().add(comboBox);
		
		JLabel lblNewEmployee = new JLabel("NEW EMPLOYEE");
		lblNewEmployee.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewEmployee.setBounds(600, 26, 205, 30);
		getContentPane().add(lblNewEmployee);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(145, 492, 91, 23);
		getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(312, 493, 241, 22);
		getContentPane().add(passwordField);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(145, 110, 56, 16);
		getContentPane().add(lblId);
		
		textField = new JTextField();
		textField.setBounds(312, 108, 241, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblSecurtiyQuestion = new JLabel("Securtiy Question");
		lblSecurtiyQuestion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSecurtiyQuestion.setBounds(145, 383, 146, 22);
		getContentPane().add(lblSecurtiyQuestion);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAnswer.setBounds(145, 442, 56, 16);
		getContentPane().add(lblAnswer);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(312, 440, 241, 22);
		getContentPane().add(passwordField_2);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Which is your favourite series?", "Which is your favourite anime?"}));
		comboBox_1.setBounds(312, 384, 241, 22);
		getContentPane().add(comboBox_1);
		
		final JButton btnBrowse = new JButton("Browse");
		btnBrowse.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\attach.png"));
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
						
						if(e.getSource()==btnBrowse){
						JFileChooser file=new JFileChooser();
						file.setCurrentDirectory(new File(System.getProperty("user.home")));
						FileNameExtensionFilter filter=new FileNameExtensionFilter("*.images","jpg","gif","png");
						file.addChoosableFileFilter(filter);
						int result=file.showSaveDialog(null);
						if(result==JFileChooser.APPROVE_OPTION){
							File selectedFile=file.getSelectedFile();
							String path=selectedFile.getAbsolutePath();
							label_1.setIcon(ResizeImage(path));
							
						}
						else if(result==JFileChooser.CANCEL_OPTION){
							System.out.println("No File Select");
						}
						}	
					}

					private ImageIcon ResizeImage(String ImagePath) {
						// TODO Auto-generated method stub
						
							ImageIcon Myimage=new ImageIcon(ImagePath);
							Image img=Myimage.getImage();
							Image newImg=img.getScaledInstance(label_1.getWidth(),label_1.getHeight(),Image.SCALE_SMOOTH);
							ImageIcon image=new ImageIcon(newImg);
							return image;
						}
		});
		btnBrowse.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBrowse.setBounds(895, 281, 152, 37);
		getContentPane().add(btnBrowse);
		
		label_1 = new JLabel("");
		label_1.setBounds(856, 70, 231, 203);
		getContentPane().add(label_1);
		
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(312, 238, 241, 22);
		getContentPane().add(dateChooser);
		
		
		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(937, 568, 241, 22);
		getContentPane().add(dateChooser_1);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new adminhomepage().setVisible(true);
				dispose();
			}
		});
		button.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Go-back-icon.png"));
		button.setBounds(0, 697, 97, 25);
		getContentPane().add(button);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\abstract_colors_aqua+art_neko.jpg"));
		label_2.setBounds(0, 0, 1286, 722);
		getContentPane().add(label_2);
		
		 
	}
}
	
		
		
		