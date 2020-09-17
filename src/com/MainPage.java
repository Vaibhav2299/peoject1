package com;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Color;

public class MainPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
		
		setTitle("MAIN PAGE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 939, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdmin = new JButton("ADMIN");
		btnAdmin.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\administrator-icon.png"));
		btnAdmin.setBackground(Color.WHITE);
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new AdminLogin().setVisible(true);
				dispose();
			}
		});
		btnAdmin.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnAdmin.setBounds(520, 304, 264, 46);
		contentPane.add(btnAdmin);
		
		JButton btnEmployee = new JButton("EMPLOYEE");
		btnEmployee.setBackground(Color.WHITE);
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new EmpLogin().setVisible(true);
				dispose();
				
			}
		});
		btnEmployee.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Preppy-icon.png"));
		btnEmployee.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnEmployee.setBounds(520, 426, 264, 46);
		contentPane.add(btnEmployee);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		button.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Apps-session-logout-icon.png"));
		button.setBounds(837, 48, 39, 32);
		contentPane.add(button);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\users-icon.png"));
		label.setBounds(128, 204, 264, 302);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Computer-Network-icon.png"));
		label_1.setBounds(791, 304, 56, 46);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\Devices-computer-laptop-icon.png"));
		label_2.setBounds(791, 426, 56, 46);
		contentPane.add(label_2);
		
		JLabel lblNewLabel = new JLabel("W E L C O M E");
		lblNewLabel.setBackground(SystemColor.controlHighlight);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(323, 46, 300, 93);
		contentPane.add(lblNewLabel);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("D:\\Eclipse\\EmployeeePayrollManagementSystem\\images\\abstract_colors_aqua+art_neko.jpg"));
		label_3.setBounds(0, 0, 921, 595);
		contentPane.add(label_3);
	}
}
