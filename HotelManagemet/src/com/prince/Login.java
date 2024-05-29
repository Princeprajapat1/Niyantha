package com.prince;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Login extends JFrame implements ActionListener {
	JTextField ut;
	JPasswordField pt;
	JButton login;
	JButton cancel;
Login(){
	setBounds(500,200,600,300);
	getContentPane().setBackground(Color.gray);
	setLayout(null);
//	for uname and pass
	JLabel user= new JLabel("Username");
	user.setBounds(40,20,100,30);
	add(user);
	JLabel pass= new JLabel("Password");
	pass.setBounds(40,70,100,30);
	add(pass);
//	for textfield 
	 ut=new JTextField();
	ut.setBounds(150,20,150,30);
	add(ut);
	 pt=new JPasswordField();
	pt.setBounds(150,70,150,30);
	add(pt);
//	button
    login=new JButton("Login");
	login.setBounds(40,150,120,30);
	login.setBackground(Color.black);
	login.setForeground(Color.white);
	login.addActionListener(this);
	add(login);
	
    cancel=new JButton("Cancel");
	cancel.setBounds(180,150,120,30);
	cancel.setBackground(Color.black);
	cancel.setForeground(Color.red);
	cancel.addActionListener(this);
	add(cancel);
	ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/login.jpg"));
	Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
	ImageIcon i3= new ImageIcon(i2);
	JLabel image= new JLabel(i3);
	image.setBounds(350,10,200,200);	
	add(image);

	setVisible(true);
	
}
public void actionPerformed(ActionEvent e) {
//	from where action is performed
	if(e.getSource()==login) {
		String username=ut.getText();
		String pass=pt.getText();
		try {
			Conn c= new Conn();
			String q="select * from login where username ='"+username+"' and pass ='"+pass+"'";
		 ResultSet rs=Conn.stmt.executeQuery(q);
			if(rs.next()) {
				setVisible(false);
				new DashBoard();
			}else {
//to display popup
				JOptionPane.showMessageDialog(null, "Inavlid Username or Password!");
				setVisible(false);
			}
		}catch(Exception o) {
			o.printStackTrace();
		}
	}
if(e.getSource()==cancel) {
	
		setVisible(false);
	}
}

public static void main(String args[]) {
	new Login();

	
	
	
}
}
