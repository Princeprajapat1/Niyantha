package com.prince;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddRooms extends JFrame implements ActionListener {
	JButton addbut,cancel;
	JTextField rnt,rpct;
	JComboBox jcba,jcbc,jcbs;
AddRooms(){
	getContentPane().setBackground(Color.gray);
	setLayout(null);
	setBounds(330,200,940,470);
//	heading add room
	JLabel head= new JLabel("Add Rooms");
	
	head.setForeground(Color.black);
	head.setFont(new Font("TOHOMA",Font.BOLD,18));
	head.setBounds(150,20,200,20);
	add(head);
	
//add text fields
	JLabel rn= new JLabel("Room Number");
	rn.setForeground(Color.white);
	rn.setFont(new Font("TOHOMA",Font.PLAIN,16));
	rn.setBounds(60,70,120,20);
	add(rn);
    rnt= new JTextField();
	rnt.setBounds(190,70,150,30);
	add(rnt);
//	AVilable or not
	JLabel avlbl= new JLabel("Available");
	avlbl.setForeground(Color.white);
	avlbl.setFont(new Font("TOHOMA",Font.PLAIN,16));
	avlbl.setBounds(60,130,120,20);
	add(avlbl);
	String avlblopt[]= {"Available","Occupied"};
	jcba = new JComboBox(avlblopt);
	jcba.setForeground(Color.white);
	jcba.setBounds(190,130,150,30);
	jcba.setBackground(Color.WHITE);
	add(jcba);
//	cleaned or not
	JLabel clnd= new JLabel("Cleaning Status");
	clnd.setForeground(Color.white);
	clnd.setFont(new Font("TOHOMA",Font.PLAIN,16));
	clnd.setBounds(60,190,120,20);
	add(clnd);
	String cldon[]= {"Cleaned","Dirty"};
    jcbc = new JComboBox(cldon);
	jcbc.setForeground(Color.white);
    jcbc.setBounds(190,190,150,30);
	jcbc.setBackground(Color.WHITE);
	add(jcbc);
//	room price
	JLabel rpc= new JLabel("Room Price");
	rpc.setForeground(Color.white);
	rpc.setFont(new Font("TOHOMA",Font.PLAIN,16));
	rpc.setBounds(60,250,120,20);
	add(rpc);
    rpct= new JTextField();
	rpct.setForeground(Color.white);
    rpct.setBounds(190,250,150,30);
	add(rpct);
//	Bed Type
	JLabel bt= new JLabel("Bed Type");
	bt.setForeground(Color.white);
	bt.setFont(new Font("TOHOMA",Font.PLAIN,16));
	bt.setBounds(60,310,120,20);
	add(bt);
	String sod[]= {"Single Bed","Double Bed"};
    jcbs = new JComboBox(sod);
	jcbs.setForeground(Color.white);
    jcbs.setBounds(190,310,150,30);
	jcbs.setBackground(Color.WHITE);
	add(jcbs);
//	Button
    addbut= new JButton("Add Room");
    addbut.setBounds(80,370,100,30);
    addbut.setBackground(Color.black);
    addbut.setForeground(Color.white);
	add(addbut);
	addbut.addActionListener(this);
	
	cancel= new JButton("Cancel");
	cancel.setBounds(210,370,100,30);
	cancel.setBackground(Color.black);
	cancel.setForeground(Color.red);
	add(cancel);
	cancel.addActionListener(this);
ImageIcon ari=new ImageIcon(ClassLoader.getSystemResource("icon/addroom.jpg"));

JLabel lari= new JLabel(ari);
lari.setBounds(400,20,500,380);
add(lari);
	setVisible(true);
}
public void actionPerformed(ActionEvent e) {
//	operation will performed after clicking add room button
if(e.getSource()==addbut) {
	String avl_status=(String) jcba.getSelectedItem();
	String price=rpct.getText();
	String roomno=rnt.getText()	;
	
	String cln_status=(String) jcbc.getSelectedItem();
	String bedtype=(String) jcbs.getSelectedItem();
	

	try {
	Conn con= new Conn();
	String q="insert into addroom values('"+roomno+"','"+
	price+"','"+avl_status+"','"+cln_status+"','"+bedtype+"')";
	con.stmt.executeUpdate(q);
	JOptionPane.showMessageDialog(null,"New Room Added Successfully");
	}catch(Exception t) {
		t.printStackTrace();

	}
	
}	
else if(e.getSource()==cancel) {
	setVisible(false);
}
}

public static void main(String args[]) {
	new AddRooms();
}

}
