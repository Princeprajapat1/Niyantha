package com.prince;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class HotelManagement extends JFrame implements ActionListener {
//frame
	HotelManagement(){
//		setSize(1366,565);
//		setLocation(100,100);
		setBounds(100,100,1366,565);
		setLayout(null);
//		image
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/Hotel.jpg"));
//		set image according to frame
		Image i2=i1.getImage().getScaledInstance(1366,565,Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,1366,565); //with respect to frame x,y ,length, bredth

		add(image);
//		text
		JLabel text= new JLabel("Hotel Management System");
		text.setBounds(0,430,800,90);
		image.add(text);
		text.setForeground(Color.white);
		text.setFont(new Font("serif",Font.PLAIN,70));
//button
		JButton b1=new JButton("Next");
		b1.setBackground(Color.black);
		b1.setBounds(1150,450,150,50);
		image.add(b1);

b1.setFont(new Font("serif",Font.PLAIN,26));
b1.setForeground(Color.white);
//to add Action Listener 
b1.addActionListener(this);

		setVisible(true);
//		for deeper functionality;
		while(true) {
			text.setVisible(false);
			try {
				Thread.sleep(500);
			}catch(Exception e) {
				e.printStackTrace();
			}
			text.setVisible(true);
			try {
				Thread.sleep(500);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

		
	}
	
    public void actionPerformed(ActionEvent e) {
//    	after clicling on button current frame will be closed
    	setVisible(false);
//    	object of login class;
    	new Login();
	}

	public static void main(String args[]) {
		new HotelManagement();
}
}
