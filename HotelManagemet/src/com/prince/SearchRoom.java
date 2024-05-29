package com.prince;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class SearchRoom extends JFrame implements ActionListener {
	JButton back,submit;
	JCheckBox avlbl;
	JTable table;
	JComboBox bedtype;
	SearchRoom() {
		setLayout(null);
		setBounds(350, 200, 950, 600);
		

//		jtable
		table = new JTable();
		table.setBounds(0,200, 1000, 300);
		table.setBackground(Color.white);
		add(table);
		

		JLabel sfr = new JLabel("Search For Room");
		sfr.setBounds(400,30, 200,30);
		sfr.setForeground(Color.white);

		sfr.setFont(new Font("Tohima",Font.PLAIN,20));
		add(sfr);
		
		JLabel btyp = new JLabel("Bed Type");
		btyp.setForeground(Color.white);

		btyp.setBounds(40,100, 100,25);
		add(btyp);
		
		bedtype= new JComboBox(new String[] {"All","Single bed","Double bed"});
		bedtype.setForeground(Color.black);

		bedtype.setBounds(150,100,150,25); 
		bedtype.setBackground(Color.white);
		add(bedtype);
		
		avlbl=new JCheckBox("Only Display Available");
		avlbl.setForeground(Color.white);
		avlbl.setBackground(Color.black);

		avlbl.setBounds(getBounds());
		avlbl.setBounds(300,100,150,25); 
		add(avlbl);
		
		JLabel hrn = new JLabel("Room No.");
		hrn.setForeground(Color.white);
		hrn.setBounds(70, 180, 100, 20);
		add(hrn);

		JLabel hpr = new JLabel("Price");
		hpr.setForeground(Color.white);
		hpr.setBounds(290,180, 100, 20);
		add(hpr);
		
		JLabel hasr = new JLabel("Availability");
		hasr.setForeground(Color.white);

		hasr.setBounds(470, 180, 100, 20);
		add(hasr);
		JLabel hcsr = new JLabel("Clean Status");
		hcsr.setForeground(Color.white);
		hcsr.setBounds(660, 180, 100, 20);
		add(hcsr);
		
		JLabel hbt = new JLabel("Bed Type");
		hbt.setForeground(Color.white);
		hbt.setBounds(850, 180, 100, 20);
		add(hbt);

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
		getContentPane().setBackground(Color.gray);
				try {
			Conn con = new Conn();
			String s = "select * from addroom";
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
				String q1="select * from addroom where bed_type='"+bedtype.getSelectedItem()+"'";
				
				String q2="select * from addroom where avl_status='Available' and bed_type='"+bedtype.getSelectedItem()+"'";
			ResultSet rs;
				if(avlbl.isSelected()) {
				rs=con.stmt.executeQuery(q2);
			}else {
				rs=con.stmt.executeQuery(q1);

			}
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
		new SearchRoom();
	}
}
