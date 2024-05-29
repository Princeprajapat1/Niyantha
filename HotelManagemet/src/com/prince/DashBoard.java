package com.prince;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class DashBoard extends JFrame implements ActionListener {
	JMenuItem reception,addemp,addrooms,adddriver; 
DashBoard(){
	setLayout(null);
	setBounds(0,0,1550,1000);
	getContentPane().setBackground(Color.black);
	ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/dashB.jpg"));
	Image i2=i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
	ImageIcon i3= new ImageIcon(i2);
	JLabel image= new JLabel(i3);
	image.setBounds(0,0,1550,1000);
	add(image);
//	Hotel Heading
	JLabel text= new JLabel("The KeralaVibes");
	text.setBounds(620,40,1000,50);
	text.setFont(new Font("Tahoma",Font.TYPE1_FONT,45));
	text.setForeground(Color.black);
	image.add(text);
//	menu bar
	JMenuBar jm=new JMenuBar();
	jm.setBounds(0,0,1550,30);
	jm.setBackground(Color.gray);
	image.add(jm);
//	menu
	JMenu hotel= new JMenu("Enter");
	hotel.setForeground(Color.blue);
	jm.add(hotel);
	JMenu admin= new JMenu("ADMIN");
	admin.setForeground(Color.blue);
	jm.add(admin);
//	menu items
	reception= new JMenuItem("RECEPTION");
	reception.setBackground(Color.black);
	reception.setForeground(Color.white);
	hotel.add(reception);
	reception.addActionListener(this);
   
	addemp= new JMenuItem("ADD EMPLOYEE");
	addemp.setBackground(Color.black);
	addemp.setForeground(Color.white);
    addemp.addActionListener(this);
	admin.add(addemp);
  
	
	addrooms= new JMenuItem("ADD ROOMS");
	addrooms.addActionListener(this);
	addrooms.setBackground(Color.black);
	addrooms.setForeground(Color.white);
	admin.add(addrooms);
    adddriver= new JMenuItem("ADD DRIVERS");
    adddriver.setBackground(Color.black);
    adddriver.setForeground(Color.white);
    adddriver.addActionListener(this);
	admin.add(adddriver);
	
	setVisible(true);
}
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==addemp) {
		new AddEmployee();
		
	}else if(e.getSource()==addrooms) {
		new AddRooms();
		
	}else if(e.getSource()==adddriver) {
		new AddDriver();
	}else if(e.getSource()==reception){
		new Reception();
	}
}

public static void main(String args[]) {
	new  DashBoard();
}
}
