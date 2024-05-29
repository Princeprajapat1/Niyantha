package com.prince;

import javax.swing.*;
import net.proteanit.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Rooms extends JFrame implements ActionListener {
	JButton back;
	JTable table;

	Rooms() {
		setLayout(null);
		setBounds(350, 200, 850, 550);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/addcustomer.jpg"));
		Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel fimage = new JLabel(i3);
		fimage.setBounds(400, 0, 450, 550);
		add(fimage);

//		jtable
		table = new JTable();
		table.setBounds(0, 40, 400, 400);
		table.setForeground(Color.white);
		add(table);
		table.setBackground(Color.gray);
//		header
		JLabel hrn = new JLabel("Room No.");
		hrn.setForeground(Color.black);
		hrn.setBounds(10, 10, 100, 20);
		add(hrn);

		JLabel hpr = new JLabel("Price");
		hpr.setForeground(Color.black);
		hpr.setBounds(100, 10, 100, 20);
		add(hpr);

		JLabel hasr = new JLabel("Availability");
		hasr.setForeground(Color.black);
		hasr.setBounds(170, 10, 100, 20);
		add(hasr);

		JLabel hcsr = new JLabel("Clean Status");
		hcsr.setForeground(Color.black);
		hcsr.setBounds(242, 10, 100, 20);
		add(hcsr);
		
		JLabel hbt = new JLabel("Bed Type");
		hbt.setForeground(Color.black);
		hbt.setBounds(330, 10, 100, 20);
		add(hbt);

//		back button
		back = new JButton("Back");
		back.setBounds(200, 470, 100, 30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		add(back);
		back.addActionListener(this);
		try {
			Conn con = new Conn();
			String s = "select * from addroom ";
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
		new Rooms();
	}
}
