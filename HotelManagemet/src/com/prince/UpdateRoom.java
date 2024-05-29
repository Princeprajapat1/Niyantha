package com.prince;


import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
public class UpdateRoom extends JFrame implements ActionListener {
	Choice ccustomer;
	JTextField crmt, lavlblt, clnsttst, capdt, calftt;
	JButton check, update, back;

	UpdateRoom() {
		setLayout(null);
		setBounds(300, 200, 980, 500);
		getContentPane().setBackground(Color.gray);
		JLabel us = new JLabel("Update Room Status");
		us.setFont(new Font("Tohima", Font.PLAIN, 20));
		us.setBounds(30, 20, 250, 30);
		us.setForeground(Color.blue);
		add(us);

		JLabel cid = new JLabel("Customer id");
		cid.setBounds(20, 75, 100, 30);
		add(cid);

		ccustomer = new Choice();
		ccustomer.setBackground(Color.gray);
		ccustomer.setBounds(200, 80, 150, 35);
		add(ccustomer);

		JLabel crm = new JLabel("Room no.");
		crm.setBounds(20, 115, 120, 30);
		add(crm);

		crmt = new JTextField();
		crmt.setBounds(200, 120, 150, 20);
		add(crmt);

		JLabel lavlbl = new JLabel("Availaibility");
		lavlbl.setBounds(20, 155, 120, 30);
		add(lavlbl);

		lavlblt = new JTextField();
		lavlblt.setBounds(200, 160, 150, 20);
		add(lavlblt);

		JLabel clnstts = new JLabel("Cleaning Status");
		clnstts.setBounds(20, 195, 120, 30);
		add(clnstts);

		clnsttst = new JTextField();
		clnsttst.setBounds(200, 200, 150, 20);
		add(clnsttst);
ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/updatecln.jpg"));
JLabel image= new JLabel(i1);
image.setBounds(400,0,580,500);
add(image);
		

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
			  String avl=lavlblt.getText();
			  String clean_status=clnsttst.getText();
			  
			  try {
				  Conn con= new Conn();
				  con.stmt.executeUpdate("update addroom set roomno='"+room+"',avl_status='"+avl+"',cln_status='"+clean_status+"' where roomno='"+room+"'");
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


			  }
			  ResultSet rs2=con.stmt.executeQuery("select * from addroom where roomno='"+crmt.getText()+"'");
			  while(rs2.next()) {
				  lavlblt.setText(rs2.getString("avl_status"));
				  clnsttst.setText(rs2.getString("cln_status"));

			  }
	  }catch(Exception t){
		  t.printStackTrace();
	  
		  }
		  }

}
	  public static void main(String args[]) {
		  new UpdateRoom();
	  }
}
