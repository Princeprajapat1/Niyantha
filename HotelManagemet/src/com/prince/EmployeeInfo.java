package com.prince;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import net.proteanit.sql.*;

public class EmployeeInfo extends JFrame implements ActionListener  {
	JButton back;
	JTable table;

	EmployeeInfo() {
		setLayout(null);
		setBounds(300, 200, 1000, 600);
	

//		jtable
		table = new JTable();
		table.setBounds(0, 40, 1000, 400);
		table.setBackground(Color.gray);
		add(table);
//		header
		JLabel hn = new JLabel("Name");
		hn.setBounds(40, 10, 100, 20);
		add(hn);

		JLabel age = new JLabel("Age");
		age.setBounds(160, 10, 100, 20);
		add(age);

		JLabel hgndr = new JLabel("Gender");
		hgndr.setBounds(280, 10, 100, 20);
		add(hgndr);

		JLabel hjr = new JLabel("Role");
		hjr.setBounds(400, 10, 100, 20);
		add(hjr);
		
		JLabel hslr = new JLabel("Salary");
		hslr.setBounds(520, 10, 100, 20);
		add(hslr);

		JLabel hmbn = new JLabel("Mob. No.");
		hmbn.setBounds(640, 10, 100, 20);
		add(hmbn);
		
		JLabel hmid= new JLabel("Mail");
		hmid.setBounds(780, 10, 100, 20);
		add(hmid);
		
		JLabel hadr= new JLabel("Aadhar");
		hadr.setBounds(880, 10, 100, 20);
		add(hadr);

		
//		back button
		back = new JButton("🔙");
		back.setBounds(430, 470, 100, 30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setFont(new Font("Tohima",Font.PLAIN,30));

		add(back); 
		back.addActionListener(this);
		try {
			Conn con = new Conn();
			String s = "select * from employee ";
			ResultSet rs = con.stmt.executeQuery(s);
//		we have to add obtained data in table so we have to add rs2.xml jar in build path
//			and import net.proteanit.sql.* package

			table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e) {
			e.printStackTrace();
		}
		setVisible(true);
		getContentPane().setBackground(Color.white);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back) {
			new Reception();
			setVisible(false);
		}

	}

	public static void main(String args[]) {
		new EmployeeInfo();
	}
}
