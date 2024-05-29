package com.prince;
import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener {
	JTextField not, namet, roomt,chknt,depot;
	JComboBox doc, gendert;
	JButton done,back;
	AddCustomer() {

		setLayout(null);
		
		setBounds(350, 200, 900, 500);
		getContentPane().setBackground(Color.gray);

		JLabel head = new JLabel("Add Customer");
		head.setBounds(100, 20, 150, 20);
		head.setFont(new Font("Tohima", Font.BOLD, 20));
		head.setForeground(Color.blue);
		add(head);

		JLabel cdoc = new JLabel("Document Type");
		cdoc.setBounds(20, 60, 100, 30);
		add(cdoc);

		String docarr[] = { "aadhar", "phone" };
		doc = new JComboBox(docarr);
		doc.setBounds(200, 70, 100, 20);
		add(doc);
		doc.setBackground(Color.white);

		JLabel no = new JLabel("no.");
		no.setBounds(20, 110, 100, 20);
		add(no);
		not = new JTextField();
		not.setBounds(200, 110, 100, 20);
		add(not);

		JLabel name = new JLabel("Name");
		name.setBounds(20, 150, 100, 20);
		add(name);
		namet = new JTextField();
		namet.setBounds(200, 150, 100, 20);
		add(namet);

		JLabel gender = new JLabel("Gender");
		gender.setBounds(20, 190, 100, 20);
		add(gender);
		String genarr[] = { "male", "female" };
		gendert = new JComboBox(genarr);
		gendert.setBounds(200, 190, 100, 20);
		add(gendert);

//Image
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/sai bus.jpg"));
		JLabel image= new JLabel(i1);
		image.setBounds(400,0,500,500);
		add(image);
		JLabel room = new JLabel("room no.");
		room.setBounds(20, 230, 100, 20);
		add(room);
		roomt = new JTextField();
		roomt.setBounds(200, 230, 100, 20);
		add(roomt);
		
		JLabel chkn = new JLabel("Check in time");
		chkn.setBounds(20, 270, 100, 20);
		add(chkn);
		Date date= new Date();
		chknt = new JTextField();
		chknt.setBounds(200, 270, 100, 20);
		add(chknt);
		chknt.setText(""+date);
		
		JLabel depo = new JLabel("deposit");
		depo.setBounds(20,310, 100, 20);
		add(depo);
		depot = new JTextField();
		depot.setBounds(200,310, 100, 20);
		add(depot);
		
		back= new JButton("Back");
		back.setBackground(Color.BLACK);
		 back.setForeground(Color.white);
		 back.setBounds(30,350,100,30);
		 add(back);
		 back.addActionListener(this);
		 
			done= new JButton("Done");
			done.setBackground(Color.BLACK);
			done.setForeground(Color.white);
			done.setBounds(150,350,100,30);
			add(done);
			done.addActionListener(this);
			
			
			
			setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
if(e.getSource()==back) {
	setVisible(false);
	new Reception();
}else if(e.getSource()==done) {
	try {
		Conn con=new Conn();
		String s="insert into customer values('"+doc.getSelectedItem()+"','"+not.getText()+"','"+namet.getText()+"','"+
				gendert.getSelectedItem()+"','"+roomt.getText()+"','"+chknt.getText()+"','"+depot.getText()+"')";
		con.stmt.executeUpdate(s);
		
		String s1="update addroom set avl_status='Occupied' where roomno='"+roomt.getText()+"'";
		con.stmt.executeUpdate(s1);
		JOptionPane.showMessageDialog(null,"Data Inserted Successfully");
	}catch(Exception a){
		a.printStackTrace();
	}
}
	}

	public static void main(String args[]) {
		new AddCustomer();
	}
}
