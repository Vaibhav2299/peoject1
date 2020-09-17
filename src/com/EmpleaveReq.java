package com;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.CardLayout;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextField;


import com.toedter.calendar.JDateChooser;

import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;

import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class EmpleaveReq extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;
	private JTable table_2;
	private JTextField textField_6;
	private JTextField textField_7;
	private JComboBox comboBox;
	PreparedStatement ps=null;
	Connection con;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpleaveReq frame = new EmpleaveReq();
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
	public EmpleaveReq() {
		
		setTitle("LEAVE PAGE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1253, 802);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblEmployeeLeaveRequest = new JLabel("Employee Leave Management");
		lblEmployeeLeaveRequest.setBounds(473, 44, 385, 41);
		lblEmployeeLeaveRequest.setFont(new Font("Arial", Font.BOLD, 25));
		contentPane.add(lblEmployeeLeaveRequest);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(846, 138, 56, 19);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(846, 188, 56, 24);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblName);
		
		JLabel lblLeaveType = new JLabel("Leave Type");
		lblLeaveType.setBounds(846, 250, 103, 19);
		lblLeaveType.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblLeaveType);
		
		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setBounds(846, 302, 103, 24);
		lblStartDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblStartDate);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setBounds(846, 357, 88, 24);
		lblEndDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblEndDate);
		
		JLabel lblReason = new JLabel("Reason");
		lblReason.setBounds(846, 465, 88, 24);
		lblReason.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblReason);
		
		
		final JButton btnSubmit = new JButton("SAVE");
		btnSubmit.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Save-icon.png"));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to update request?","Update Request",JOptionPane.YES_NO_OPTION);
		        if(p==0){
				
				if(e.getSource()==btnSubmit)
				{
					try
					{
		                String value8 = textField_5.getText();
		                String value9 = comboBox.getSelectedItem().toString();
		                
						
						String sql="update empleave set status='"+value9+"', comment='"+value8+"' where id=?";
						 con=MyConnection.getConnection();
			                ps=(PreparedStatement) con.prepareStatement(sql);
			                ps.setString(1,textField.getText());
			                ps.execute();
			                JOptionPane.showMessageDialog(null, "Request Updated");
						
						
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
		        }	
			}
		});
		btnSubmit.setBounds(934, 629, 116, 30);
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnSubmit);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(995, 135, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(995, 190, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(995, 249, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(995, 413, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(995, 467, 116, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("No. Of Days");
		lblNewLabel.setBounds(846, 414, 103, 19);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel);
		
		JLabel lblComment = new JLabel("Comment");
		lblComment.setBounds(846, 520, 88, 19);
		lblComment.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblComment);
		
		textField_5 = new JTextField();
		textField_5.setBounds(995, 519, 116, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(846, 574, 62, 19);
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblStatus);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(95, 141, 568, 495);
		contentPane.add(scrollPane);
		
		table_2 = new JTable();
		table_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				
				
				try
				{
					int row=table_2.getSelectedRow();
					String click=(table_2.getModel().getValueAt(row, 0).toString());
					Connection con=MyConnection.getConnection();
					String sql="select * from empleave where id='"+click+"'";
					PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
					if(rs.next())
					{
						    String add2 =rs.getString("id");
						    textField.setText(add2);

			                String add3 =rs.getString("name");
			                textField_1.setText(add3);
			                
			                String add8 =rs.getString("leave_type");
			                textField_2.setText(add8);
			                
			                String add4 =rs.getString("start_date");
			                textField_6.setText(add4);

			                String add5 =rs.getString("end_date");
			                textField_7.setText(add5);

			                String add6 =rs.getString("no_of_days");
			                textField_3.setText(add6);

			                String add7 =rs.getString("reason");
			                textField_4.setText(add7);
			              
					}
				}
					catch(Exception ex)
					{
						JOptionPane.showMessageDialog(null,ex);
					}
				
				
				
				}
		});
		scrollPane.setViewportView(table_2);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "name", "start_date", "end_date", "no_of_days", "reason", "status"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
				
			}
		});
		table_2.getColumnModel().getColumn(0).setResizable(false);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(995, 304, 116, 22);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setBounds(995, 359, 116, 22);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Accepted", "Rejected"}));
		comboBox.setBounds(995, 573, 116, 22);
		contentPane.add(comboBox);
		
		
		
		final JButton btnNewButton = new JButton("Click Here To Load Pending Employee Requests");
		btnNewButton.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Button-White-Load-icon.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(187, 681, 404, 36);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new adminhomepage().setVisible(true);
				dispose();
			}
		});
		button.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Go-back-icon.png"));
		button.setBounds(0, 730, 109, 25);
		contentPane.add(button);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\abstract_colors_aqua+art_neko.jpg"));
		label.setBounds(0, 0, 1235, 755);
		contentPane.add(label);
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==btnNewButton)
				{
					try
					{
						Connection con=MyConnection.getConnection();
						String sql="select id,name,leave_type,start_date,end_date,no_of_days,reason,status from empleave where status='pending'";
						PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
						ResultSet rs=ps.executeQuery();
						table_2.setModel(DbUtils.resultSetToTableModel(rs));
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
			}
		});	
		
	}
}
		
	

