package com.prince;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddDriver extends JFrame implements ActionListener {
	JButton addbut,cancel;
	JTextField dnt,agt,cct,cmt,dlt;
	JComboBox jcbg,jcbc,jcba;
AddDriver(){
	getContentPane().setBackground(Color.gray);
	setLayout(null);
	setBounds(350,180,980,510);
//	heading add room
	JLabel head= new JLabel("Add Drivers");
	head.setFont(new Font("TOHOMA",Font.BOLD,18));
	head.setBounds(150,20,200,20);
	add(head);
	
//add text fields
	JLabel dn= new JLabel("Name");
	dn.setFont(new Font("TOHOMA",Font.PLAIN,16));
	dn.setBounds(60,70,120,20);
	add(dn);
	dnt= new JTextField();
	dnt.setBounds(190,70,150,30);
	add(dnt);
//	age
	JLabel ag= new JLabel("Age");
	ag.setFont(new Font("TOHOMA",Font.PLAIN,16));
	ag.setBounds(60,120,120,20);
	add(ag);
	agt= new JTextField();
	agt.setBounds(190,120,150,30);
	add(agt);
//	gender
	JLabel gen= new JLabel("Gender");
	gen.setFont(new Font("TOHOMA",Font.PLAIN,16));
	gen.setBounds(60,170,120,20);
	add(gen);
	String gent[]= {"Male","Female"};
    jcbg = new JComboBox(gent);
	jcbg.setBounds(190,170,150,30);
	jcbg.setBackground(Color.WHITE);
	add(jcbg);
//	 Company
	JLabel cc= new JLabel("Car Company");
	cc.setFont(new Font("TOHOMA",Font.PLAIN,16));
	cc.setBounds(60,220,120,20);
	add(cc);
	cct= new JTextField();
	cct.setBounds(190,220,150,30);
	add(cct);
	
	JLabel cm= new JLabel("Car Model");
	cm.setFont(new Font("TOHOMA",Font.PLAIN,16));
	cm.setBounds(60,270,120,20);
	add(cm);
	cmt= new JTextField();
	cmt.setBounds(190,270,150,30);
	add(cmt);
	
//	Available or not
	JLabel aon= new JLabel("Available");
	aon.setFont(new Font("TOHOMA",Font.PLAIN,16));
	aon.setBounds(60,320,120,20);
	add(aon);
	String aoption[]= {"Available","Busy"};
    jcba= new JComboBox(aoption);
	jcba.setBounds(190,320,150,30);
	add(jcba);
	
	JLabel dl= new JLabel("Location");
	dl.setFont(new Font("TOHOMA",Font.PLAIN,16));
	dl.setBounds(60,370,120,20);
	add(dl);
	dlt= new JTextField();
	dlt.setBounds(190,370,150,30);
	add(dlt);
//	Button
    addbut= new JButton("Add Room");
    addbut.setBounds(80,410,100,30);
    addbut.setBackground(Color.black);
    addbut.setForeground(Color.white);
	add(addbut);
	addbut.addActionListener(this);
	
	cancel= new JButton("Cancel");
	cancel.setBounds(210,410,100,30);
	cancel.setBackground(Color.black);
	cancel.setForeground(Color.red);
	add(cancel);
	cancel.addActionListener(this);
ImageIcon adi=new ImageIcon(ClassLoader.getSystemResource("icon/Driver.jpg"));
Image sadi= adi.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
ImageIcon fadi= new ImageIcon(sadi);
JLabel lari= new JLabel(fadi);
lari.setBounds(400,20,500,430);
add(lari);
	setVisible(true);
}
public void actionPerformed(ActionEvent e) {
//	operation will performed after clicking add room button
if(e.getSource()==addbut) {
	String name=dnt.getText();
	String age=agt.getText();
	String ccompany=cct.getText();
	String cmodel=cmt.getText();
	String location=dlt.getText();
	String avl_status =(String) jcba.getSelectedItem();
	String gender=(String) jcbg.getSelectedItem();
	try {
	Conn con= new Conn();
	String q="insert into driver values('"+name+"','"+
	age+"','"+gender+"','"+ccompany+"','"+cmodel+"','"+avl_status+"','"+location+"')";
	con.stmt.executeUpdate(q);
	JOptionPane.showMessageDialog(null," new Driver added Successfully");
	setVisible(false);
	}catch(Exception t) {
		t.printStackTrace();

	}
	
}	
else if(e.getSource()==cancel) {
	setVisible(false);
}
}

public static void main(String args[]) {
	new AddDriver();
}

}

