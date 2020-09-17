package com;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.*;
import java.awt.Font;

public class JtableLeavemp extends JDialog
{
	JButton back;
	JTable jt;
	
	JtableLeavemp()
	{
		
		setSize(1000,753);
		setLocation(100,100);
		getContentPane().setLayout(null);
		setModal(true);
		setTitle("EMPLOYEE LEAVE");
		String[]columns=new String[]{"Id","Name","Leave_type","Start_date","End_date","No_of_days","Reason","Status","Comment"};
		String st="select * from empleave";
		Connection con=MyConnection.getConnection();
		try
		{
			int cnt=0,r=0,c=0;
			PreparedStatement ps=con.prepareStatement(st);
			
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
			jsp.setBounds(35,27,917,586);
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
			btnNewButton.setBounds(35, 673, 935, 33);
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
		new JtableLeavemp();
	}
}			
	
