package com.prince;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;


import javax.swing.*;

import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener{
	JButton back;
	JTable table;

    CustomerInfo() {
		setLayout(null);
		setBounds(300, 200, 1000, 600);
	getContentPane().setBackground(Color.gray);

//		jtable
		table = new JTable();
		table.setBounds(0, 40, 1000, 400);
		table.setBackground(Color.gray);
		add(table);
//		header
		JLabel hn = new JLabel("Document Type");
		hn.setBounds(30, 10, 100, 20);
		add(hn);

		JLabel age = new JLabel("Document Number");
		age.setBounds(170, 10, 100, 20);
		add(age);

		JLabel hgndr = new JLabel("Name");
		hgndr.setBounds(330, 10, 100, 20);
		add(hgndr);

		JLabel hjr = new JLabel("Gender");
		hjr.setBounds(470, 10, 100, 20);
		add(hjr);
		
		JLabel hslr = new JLabel("Room");
		hslr.setBounds(620, 10, 100, 20);
		add(hslr);

		JLabel hmbn = new JLabel("Checkin Time");
		hmbn.setBounds(750, 10, 100, 20);
		add(hmbn);
		
		JLabel hmid= new JLabel("Deposit");
		hmid.setBounds(890, 10, 100, 20);
		add(hmid);
		
		
		
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
			String s = "select * from customer ";
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
		new CustomerInfo();
	}
}
