package com;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.*;
import java.awt.Font;


public class Jtabledeductions extends JDialog
{
	JButton back;
	JTable jt;
	
	Jtabledeductions()
	{
		
		setSize(1082,724);
		setLocation(100,100);
		getContentPane().setLayout(null);
		setModal(true);
		
		String[]columns=new String[]{"id","first_name","last_name","basic_salary","deduction_amount","salary_after_deduction","deduction_reason"};
		String st="select * from deductions";
		Connection con=MyConnection.getConnection();
		try
		{
			int cnt=0,r=0,c=0;
			PreparedStatement ps=con.prepareStatement(st);
			
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
			jsp.setBounds(29,13,1008,551);
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
			btnNewButton.setBounds(29, 629, 1008, 35);
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
		new Jtabledeductions();
	}
}			
	
