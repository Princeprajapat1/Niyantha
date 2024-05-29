package com.prince;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AddEmployee extends JFrame implements ActionListener{
//	declare gobally for further use
	JTextField nt,at,st,pt,et,At;
	JRadioButton male,female;
	JButton sb;
	JComboBox jcb;
AddEmployee(){
	setLayout(null);
//	textField
	JLabel lbn= new JLabel("NAME");
	lbn.setForeground(Color.white);
	lbn.setBounds(60,30,120,30);
	lbn.setFont(new Font("Tohima",Font.PLAIN,17));
	add(lbn);
    nt=new JTextField();
	nt.setBounds(200,30,150,30);
	add(nt);
	
	JLabel lba= new JLabel("AGE");
	lba.setForeground(Color.white);
	lba.setBounds(60,70,120,30);
	lba.setFont(new Font("Tohoma",Font.PLAIN,17));
	add(lba);
	at=new JTextField();
	at.setBounds(200,70,150,30);
	add(at);
	
	JLabel lbg= new JLabel("GENDER");
	lbg.setForeground(Color.white);
	lbg.setBounds(60,110,120,30);
	lbg.setFont(new Font("Tohoma",Font.PLAIN,17));
	add(lbg);
//	radioButton
    male=new JRadioButton("Male");
	male.setBounds(200,110,70,30);
	add(male);
	male.setFont(new Font("Tohoma",Font.PLAIN,14));
	male.setBackground(Color.white);
	add(male);
    female=new JRadioButton("female");
	female.setBounds(270,110,70,30);
	add(female);
	female.setFont(new Font("Tohoma",Font.PLAIN,14));
	female.setBackground(Color.white);
	add(female);
	
//	group radio button cause both are selecting 
  ButtonGroup bg= new ButtonGroup();
  bg.add(male);
  bg.add(female);
	JLabel lbj= new JLabel("JOB");
	lbj.setForeground(Color.white);
	lbj.setBounds(60,150,120,30);
	lbj.setFont(new Font("Tohoma",Font.PLAIN,17));
	add(lbj);
//	pass all dropitems as array of string
	String jcbi[]= {"Front Desk Clerk","Porters",
			"HouseKeeping","Kitchen Staff","Room Service",
			"chefs","Waiter/Waiters","Manager","Accountant"};
    jcb=new JComboBox(jcbi);
	jcb.setBounds(200,150,150,30);
	jcb.setForeground(Color.white);
	jcb.setBackground(Color.gray);
	add(jcb);
	
	JLabel lbs= new JLabel("SALARY");
	lbs.setBounds(60,200,120,30);
	lbs.setForeground(Color.white);
	lbs.setFont(new Font("Tohoma",Font.PLAIN,17));
	add(lbs);
    st=new JTextField();
    st.setForeground(Color.white);
	st.setBounds(200,200,150,30);
	add(st);
	
	JLabel lbp= new JLabel("PHONE NO.");
	lbp.setBounds(60,250,120,30);
	lbp.setFont(new Font("Tohoma",Font.PLAIN,17));
	lbp.setForeground(Color.white);
	add(lbp);
    pt=new JTextField();
	pt.setBounds(200,250,150,30);
	add(pt);
	
	JLabel lbe= new JLabel("EMAIL");
	lbe.setBounds(60,300,120,30);
	lbe.setForeground(Color.white);
	lbe.setFont(new Font("Tohoma",Font.PLAIN,17));
	add(lbe);	
    et=new JTextField();
    et.setForeground(Color.white);
	et.setBounds(200,300,150,30);
	add(et);
	
	JLabel lbA= new JLabel("AADHAR NO.");
	lbA.setBounds(60,350,120,30);
	lbA.setForeground(Color.white);
	lbA.setFont(new Font("Tohoma",Font.PLAIN,17));
	add(lbA);
    At=new JTextField();
	At.setBounds(200,350,150,30);
	add(At);
	
//	Submit button
    sb=new JButton("SUBMIT");
	sb.setBounds(140,400,100,30);
	sb.setForeground(Color.white);
	sb.setBackground(Color.black);
	sb.setForeground(Color.white);
	add(sb);
//	action listener
	sb.addActionListener(this);
	ImageIcon ie=new ImageIcon(ClassLoader.getSystemResource("icon/Employee.jpg"));
	Image si=ie.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
	ImageIcon fsi=new ImageIcon(si);
	JLabel li= new JLabel(fsi);
	li.setBounds(380,60,450,370);
	add(li);
//	to change color of frame
	getContentPane().setBackground(Color.gray);
	setBounds(350,200,850,540);
	setVisible(true);
}
public void actionPerformed(ActionEvent e) {
	String name=nt.getText();
	String age=at.getText();
	String salary=st.getText();
	String phone=pt.getText();
	String email=et.getText();
	String aadhar=At.getText();
String gender=null;
if(male.isSelected()) {
	gender="male";
}else if(female.isSelected()) {
	gender="female";
}
//to getselected item from jcombobox
String job=(String) jcb.getSelectedItem();
if(name.equals("")) {
	JOptionPane.showMessageDialog(null,"please enter the name");
	return;

}
try {
Conn con= new Conn();	
String q="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"
+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
con.stmt.executeUpdate(q);
//to display dilogue box

JOptionPane.showMessageDialog(null,"Employee added Successfully");
setVisible(false);
}catch(Exception s) {
	s.printStackTrace();
}
}

public static void main(String args[]) {
	new AddEmployee();
}
}
