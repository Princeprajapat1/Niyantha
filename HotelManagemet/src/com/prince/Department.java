package com.prince;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Department extends JFrame implements ActionListener {
	JTable table;
	JButton back;
	Department(){
		setLayout(null);
		setBounds(350, 200, 850, 550);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/addcustomer.jpg"));

//		jtable
		table = new JTable();
		table.setBounds(160, 40, 500, 400);
		table.setBackground(Color.white);
		add(table);
//		header
		JLabel hdn = new JLabel("Department");
		hdn.setBounds(260, 10, 100, 20);
		add(hdn);

		JLabel hb = new JLabel("Budget");
		hb.setBounds(500, 10, 100, 20);
		add(hb);

//		back button
		back = new JButton("Back");
		back.setBounds(350, 470, 100, 30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		add(back);
		back.addActionListener(this);
		try {
			Conn con = new Conn();
			String s = "select * from department ";
			ResultSet rs = con.stmt.executeQuery(s);
//		we have to add obtained data in table so we have to add rs2.xml jar in build path
//			and import net.proteanit.sql.* package

			table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e) {
			e.printStackTrace();
		}
		setVisible(true);
		getContentPane().setBackground(Color.gray);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back) {
			new Reception();
			setVisible(false);
		}

	}
	
	
	
	
	
	

public static void main(String rags[]) {
	new Department();
}
}
