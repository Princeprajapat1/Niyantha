package com.prince;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class CheckOut extends JFrame implements ActionListener {
	Choice idt;
	JTextField rnt, chknt, chkout;
	JButton checkout, back, enter;

	CheckOut() {

		setVisible(true);

		setLayout(null);
		setBounds(300, 200, 900, 500);
		getContentPane().setBackground(Color.white);
		;

		JLabel head = new JLabel("Check Out");
		head.setBounds(100, 20, 100, 30);
		head.setFont(new Font("Tohima", Font.BOLD, 20));
		head.setForeground(Color.darkGray);
		add(head);

		JLabel id = new JLabel("Customer Id");
		id.setBounds(30, 80, 100, 30);
		add(id);

		idt = new Choice();
		idt.setBounds(200, 85, 150, 35);
		add(idt);

		JLabel rn = new JLabel("Room no");
		rn.setBounds(30, 130, 100, 30);
		add(rn);
		rnt = new JTextField();
		rnt.setBounds(200, 130, 120, 25);
		add(rnt);

		JLabel lchknt = new JLabel("Checkin Time");
		lchknt.setBounds(30, 180, 100, 30);
		add(lchknt);

		chknt = new JTextField();
		chknt.setBounds(200, 180, 120, 25);
		add(chknt);

		JLabel lchkot = new JLabel("CheckOut Time");
		lchkot.setBounds(30, 230, 100, 30);
		add(lchkot);

		Date date = new Date();
		chkout = new JTextField("" + date);
		chkout.setBounds(200, 230, 150, 30);
		chkout.setFont(new Font("Tohima", Font.BOLD, 15));
		chkout.setForeground(Color.GRAY);
		add(chkout);

//	  Button
		checkout = new JButton("Check out");
		checkout.setForeground(Color.white);
		checkout.setBackground(Color.black);
		checkout.setBounds(170, 280, 100, 30);
		add(checkout);
		checkout.addActionListener(this);

		back = new JButton("Back");
		back.setForeground(Color.white);
		back.setBackground(Color.black);
		back.setBounds(30, 280, 100, 30);
		add(back);
		back.addActionListener(this);

		enter = new JButton("Enter");
		enter.setForeground(Color.white);
		enter.setBackground(Color.black);
		enter.setBounds(310, 280, 100, 30);
		add(enter);
		enter.addActionListener(this);

//	  ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/CheckOut2.jpg"));
//	  Image i2= i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
//	  ImageIcon i3= new ImageIcon(i2);
//	  JLabel image= new JLabel(i3);
//	  image.setBounds(550,50,400,250);
//	  add(image);
		try {
			Conn con= new Conn();
			String s = "select * from customer";
			ResultSet rs = con.stmt.executeQuery(s);
			while (rs.next()) {
				idt.add(rs.getString("number"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back) {
			setVisible(false);
			new Reception();
		} else if (e.getSource() == checkout) {
			
			String q1 = "delete from customer where number='" + idt.getSelectedItem() + "'";
			String q2 = "update addroom set avl_status='Avialable' where roomno='" + rnt.getText() + "'";
			
			try {
				Conn con= new Conn();
				con.stmt.executeUpdate(q1);
				con.stmt.executeUpdate(q2);
				JOptionPane.showMessageDialog(null, "Checkout Done");
				setVisible(false);
				new Reception();
			} catch (Exception g) {
				g.printStackTrace();
			}

		} else if (e.getSource() == enter) {
			try {
				String str=""+idt.getSelectedItem();
				Conn con= new Conn();
				String q3 = "select * from customer where number='"+str+"'";
				ResultSet rs2 = con.stmt.executeQuery(q3);

				rnt.setText(rs2.getString("room"));
				chknt.setText(rs2.getString("chkntym"));
			} catch (SQLException y) {
				y.printStackTrace();
			}
		}
	}

	public static void main(String args[]) {
		new CheckOut();
	}
}
