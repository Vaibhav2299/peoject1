package com;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.*;
import java.awt.Font;

public class Jtableemp extends JDialog
{
	JButton back;
	JTable jt;
	
	Jtableemp()
	{
		
		setSize(1700,753);
		setLocation(100,100);
		getContentPane().setLayout(null);
		setModal(true);
	
		String[]columns=new String[]{"id","first_name","last_name","date_of_birth","gender","email","password","secques","secans","contact","address","pincode","department","designation","date_hired","basic_salary","status"};
		String st="select * from employee";
		Connection con=MyConnection.getConnection();
		try
		{
			int cnt=0,r=0,c=0;
			PreparedStatement ps=con.prepareStatement(st);
			
			ResultSet rs=ps.executeQuery();
			rs.last();
			cnt=rs.getRow();
			rs.beforeFirst();
			String[][]data=new String[cnt][17];
			while(rs.next())
			{
				data[r][c]=String.valueOf(rs.getString("id"));++c;
				data[r][c]=rs.getString("first_name");++c;
				data[r][c]=String.valueOf(rs.getString("last_name"));++c;
				data[r][c]=String.valueOf(rs.getString("date_of_birth"));++c;
				data[r][c]=String.valueOf(rs.getString("gender"));++c;
				data[r][c]=String.valueOf(rs.getString("email"));++c;
				data[r][c]=String.valueOf(rs.getString("password"));++c;
				data[r][c]=String.valueOf(rs.getString("secques"));++c;
				data[r][c]=String.valueOf(rs.getString("secans"));++c;
				data[r][c]=String.valueOf(rs.getString("contact"));++c;
				data[r][c]=String.valueOf(rs.getString("address"));++c;
				data[r][c]=String.valueOf(rs.getString("pin_code"));++c;
				data[r][c]=String.valueOf(rs.getString("department"));++c;
				data[r][c]=String.valueOf(rs.getString("designation"));++c;
				data[r][c]=String.valueOf(rs.getString("date_hired"));++c;
				data[r][c]=String.valueOf(rs.getString("basic_salary"));++c;
				data[r][c]=String.valueOf(rs.getString("status"));++c;
				
			   
			
				c=0;
				++r;
			}
			 
			
			final JTable jt=new JTable(data,columns);
			jt.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			JScrollPane jsp=new JScrollPane(jt, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			jsp.setBounds(12,27,1658,586);
			getContentPane().add(jsp);
			
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
			btnNewButton.setBounds(35, 660, 1635, 33);
			getContentPane().add(btnNewButton);
			
			setVisible(true);
			
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}
	
	public static void main(String ar[])
	{
		new Jtableemp ();
	}
}			
	
