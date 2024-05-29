package com.prince;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class UpdateCheck extends JFrame implements ActionListener{
	Choice ccustomer;
	JTextField crmt, cnmt, cchknt, capdt, calftt;
	JButton check, update, back;

	UpdateCheck() {
		setLayout(null);
		setBounds(300, 200, 980, 500);
		getContentPane().setBackground(Color.gray);
		JLabel us = new JLabel("Update Status");
		us.setFont(new Font("Tohima", Font.PLAIN, 20));
		us.setBounds(90, 10, 200, 30);
		us.setForeground(Color.blue);
		add(us);

		JLabel cid = new JLabel("Customer id");
		cid.setBounds(20, 75, 100, 30);
		add(cid);

		ccustomer = new Choice();
		ccustomer.setBounds(200, 80, 150, 35);
		ccustomer.setBackground(Color.gray);
		add(ccustomer);

		JLabel crm = new JLabel("Room no.");
		crm.setBounds(20, 115, 120, 30);
		add(crm);

		crmt = new JTextField();
		crmt.setBounds(200, 120, 150, 20);
		add(crmt);

		JLabel cnm = new JLabel("Name");
		cnm.setBounds(20, 155, 120, 30);
		add(cnm);

		cnmt = new JTextField();
		cnmt.setBounds(200, 160, 150, 20);
		add(cnmt);

		JLabel cchkn = new JLabel("Checkin Time");
		cchkn.setBounds(20, 195, 120, 30);
		add(cchkn);

		cchknt = new JTextField();
		cchknt.setBounds(200, 200, 150, 20);
		add(cchknt);

		JLabel capd = new JLabel("Amount Paid");
		capd.setBounds(20, 235, 120, 30);
		add(capd);

		capdt = new JTextField();
		capdt.setBounds(200, 240, 150, 20);
		add(capdt);

		JLabel calft = new JLabel("Amount left");
		calft.setBounds(20, 275, 120, 30);
		add(calft);

		calftt = new JTextField();
		calftt.setBounds(200, 280, 150, 20);
		add(calftt);

//		back button
		back = new JButton("Back");
		back.setBackground(Color.black);
		back.setBounds(10, 340, 100, 30);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
//		update update
		update = new JButton("Update");
		update.setBackground(Color.black);
		update.setBounds(140, 340, 100, 30);
		update.setForeground(Color.white);
		update.addActionListener(this);

		add(update);
		
//		check update
		check = new JButton("Check");
		check.setBackground(Color.black);
		check.setBounds(270, 340, 100, 30);
		check.setForeground(Color.white);
		check.addActionListener(this);

		add(check);
		
//		image
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/updatestatus.jpg"));
		
		JLabel il= new JLabel(i1);
		il.setBounds(400,50,500,300);
		add(il);
		try {
			Conn con = new Conn();
			String s = "select * from customer";
			ResultSet rs = con.stmt.executeQuery(s);
			while (rs.next()) {
				ccustomer.add(rs.getString("number"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		setVisible(true);
	}
	  public void actionPerformed(ActionEvent e) {
		  if(e.getSource()==back) {
			  setVisible(false);
			  new Reception();
		  }else if(e.getSource()==update) {
			  String number=ccustomer.getSelectedItem();
			  String room=crmt.getText();
			  String name=cnmt.getText();
			  String checkin=cchknt.getText();
			  String deposit=capdt.getText();
			  
			  try {
				  Conn con= new Conn();
				  con.stmt.executeUpdate("update customer set room='"+room+"',name='"+name+"',chkntym='"+checkin+"',deposit='"+deposit+"' where number='"+number+"'");
				  JOptionPane.showMessageDialog(null, "Data Updated Successfully");
				  setVisible(false);
				  new Reception();
			  }catch(Exception t){
				  t.printStackTrace();
				  
			  }
			  
		  }else if(e.getSource()==check) {
			  try {
			  String id=ccustomer.getSelectedItem();
			  String query="select * from customer where number ='"+id+"'";
					  Conn con= new Conn();
			  ResultSet rs=con.stmt.executeQuery(query);
			  
			  
			  while(rs.next()) {
				  crmt.setText(rs.getString("room"));
				  cnmt.setText(rs.getString("name"));

				  cchknt.setText(rs.getString("chkntym"));
				  capdt.setText(rs.getString("deposit"));

			  }
//			  for pending amount
			  ResultSet rs2=con.stmt.executeQuery("select * from addroom where roomno='"+crmt.getText()+"'");
			  while(rs2.next()) {
				  String price=rs2.getString("price");
						  int amountpaid=Integer.parseInt(price)-Integer.parseInt(capdt.getText());
						 String leftamount=Integer.toString(amountpaid);
						 calftt.setText(leftamount);

			  }
	  }catch(Exception t){
		  t.printStackTrace();
	  
		  }
		  }

	}

	public static void main(String args[]) {
		new UpdateCheck();
	}
}
