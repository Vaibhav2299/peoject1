package com;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.*;
import java.awt.Font;

public class Jtableallowance extends JDialog
{
	JButton back;
	JTable jt;
	
	Jtableallowance()
	{
		
		setSize(1221,753);
		setLocation(100,100);
		getContentPane().setLayout(null);
		setModal(true);
		
		String[]columns=new String[]{"id","first_name","last_name","basic_salary","overtime","medical","bonus","others","rate","total_allowance"};
		String st="select * from allowance";
		Connection con=MyConnection.getConnection();
		try
		{
			int cnt=0,r=0,c=0;
			PreparedStatement ps=con.prepareStatement(st);
			
			ResultSet rs=ps.executeQuery();
			rs.last();
			cnt=rs.getRow();
			rs.beforeFirst();
			String[][]data=new String[cnt][10];
			while(rs.next())
			{
				data[r][c]=String.valueOf(rs.getString("id"));++c;
				data[r][c]=rs.getString("first_name");++c;
				data[r][c]=String.valueOf(rs.getString("last_name"));++c;
				data[r][c]=String.valueOf(rs.getString("basic_salary"));++c;
				data[r][c]=String.valueOf(rs.getString("overtime"));++c;
				data[r][c]=String.valueOf(rs.getString("medical"));++c;
				data[r][c]=String.valueOf(rs.getString("bonus"));++c;
				data[r][c]=String.valueOf(rs.getString("others"));++c;
				data[r][c]=String.valueOf(rs.getString("rate"));++c;
				data[r][c]=String.valueOf(rs.getString("total_allowance"));++c;
			
				c=0;
				++r;
			}
			 
			
			final JTable jt=new JTable(data,columns);
			jt.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			JScrollPane jsp=new JScrollPane(jt, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			jsp.setBounds(12,25,1187,586);
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
			btnNewButton.setBounds(24, 660, 1156, 33);
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
		new Jtableallowance();
	}
}			
	
