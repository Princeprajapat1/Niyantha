package com.prince;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class Pickup extends JFrame implements ActionListener{
	JButton back,submit;
	JCheckBox avlbl;
	JTable table;
	Choice cartype;
	Pickup() {
		setLayout(null);
		setBounds(350, 200, 950, 600);
		

//		jtable
		table = new JTable();
		table.setBounds(0,200, 1000, 300);
		table.setBackground(Color.gray);
		add(table);
		

		JLabel sfr = new JLabel("Pickup Service");
		sfr.setBounds(400,30, 200,30);
		sfr.setFont(new Font("Tohima",Font.PLAIN,20));
		add(sfr);
		
		JLabel btyp = new JLabel("Car Name");
		btyp.setBounds(40,100, 100,25);
		add(btyp);
		
		cartype= new Choice();
		cartype.setBackground(Color.pink);
		cartype.setBounds(150,102,150,25);
		add(cartype);
		
		try {
			Conn con = new Conn();
			String q= "select * from driver";
			ResultSet rs= con.stmt.executeQuery(q);
			while(rs.next()) {
				cartype.add(rs.getString("brand"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		JLabel hdn = new JLabel("Name");
		hdn.setBounds(50, 180, 100, 20);
		add(hdn);

		JLabel hej = new JLabel("Age");
		hej.setBounds(190,180, 100, 20);
		add(hej);
		

		JLabel hcsr = new JLabel("Gender");
		hcsr.setBounds(340, 180, 100, 20);
		add(hcsr);
		
		JLabel hbt = new JLabel("Company");
		hbt.setBounds(480, 180, 100, 20);
		add(hbt);
		
		JLabel hbd = new JLabel("Brand");
		hbd.setBounds(630, 180, 100, 20);
		add(hbd);
		
		JLabel havlbl = new JLabel("Available");
		havlbl.setBounds(760, 180, 100, 20);
		add(havlbl);
		
		JLabel hld = new JLabel("Location");
		hld.setBounds(870, 180, 100, 20);
		add(hld);

//		back button
		back = new JButton("🔙");
		back.setBounds(300, 520, 100, 30);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.setFont(new Font("Tohima",Font.PLAIN,30));
        add(back);
        back.addActionListener(this);

//		submit button
		submit = new JButton("submit");
		submit.setBounds(520, 520, 100, 30);
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.addActionListener(this);
        add(submit);
        setVisible(true);
		getContentPane().setBackground(Color.pink);
				try {
			Conn con = new Conn();
			String s = "select * from driver";
			ResultSet rs = con.stmt.executeQuery(s);
//		we have to add obtained data in table so we have to add rs2.xml jar in build path
//			and import net.proteanit.sql.* package

			table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == submit) {
			try {
				Conn con= new Conn();
				String q1="select * from driver where brand='"+cartype.getSelectedItem()+"'";
				
			ResultSet rs;
			rs= con.stmt.executeQuery(q1);
				table.setModel(DbUtils.resultSetToTableModel(rs));

			}catch(Exception q) {
				q.printStackTrace();
			}
			
			
		}else if (e.getSource() == back) {
			new Reception();
			setVisible(false);
		}

	}

public static void main(String args[]) {
	new Pickup();
}
}
