package com.prince;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener {
	JButton rooms, lgt, dptmt, Aemp, Mi,Ci,Sr,updt,Rstts,pks,nc,ckot;

	Reception() {
		setBounds(350, 200, 800, 570);
		getContentPane().setBackground(Color.gray);

		setLayout(null);
//		Buttons
		 nc = new JButton("New Customer");
		nc.setBounds(10, 30, 200, 30);
		nc.setBackground(Color.black);
		nc.setForeground(Color.white);
		nc.addActionListener(this);
		add(nc);

		rooms = new JButton("Rooms");
		rooms.setBounds(10, 70, 200, 30);
		rooms.setBackground(Color.black);
		rooms.setForeground(Color.white);
		rooms.addActionListener(this);
		add(rooms);

		dptmt = new JButton("Department");
		dptmt.setBounds(10, 110, 200, 30);
		dptmt.setBackground(Color.black);
		dptmt.setForeground(Color.white);
		dptmt.addActionListener(this);
		add(dptmt);

		Aemp = new JButton("All Employee");
		Aemp.setBounds(10, 150, 200, 30);
		Aemp.setBackground(Color.black);
		Aemp.setForeground(Color.white);
		Aemp.addActionListener(this);
		add(Aemp);

		 Ci = new JButton("Customer Info");
		Ci.setBounds(10, 190, 200, 30);
		Ci.setBackground(Color.black);
		Ci.setForeground(Color.white);
		Ci.addActionListener(this);
		add(Ci);

		Mi = new JButton("Manager Info");
		Mi.setBounds(10, 230, 200, 30);
		Mi.setBackground(Color.black); 
		Mi.setForeground(Color.white);
		Mi.addActionListener(this);
		add(Mi);

		 ckot = new JButton("CheckOut");
		ckot.setBounds(10, 270, 200, 30);
		ckot.setBackground(Color.black);
		ckot.setForeground(Color.white);
		ckot.addActionListener(this);
		add(ckot);

		updt = new JButton("Update Status");
		updt.setBounds(10, 310, 200, 30);
		updt.setBackground(Color.black);
		updt.setForeground(Color.white);
		updt.addActionListener(this);
		add(updt);

		 Rstts = new JButton("Update Room Status");
		Rstts.setBounds(10, 350, 200, 30);
		Rstts.setBackground(Color.black);
		Rstts.setForeground(Color.white);
		Rstts.addActionListener(this);
		add(Rstts);

		 pks = new JButton("Pickup Service");
		pks.setBounds(10, 390, 200, 30);
		pks.setBackground(Color.black);
		pks.setForeground(Color.white);
		pks.addActionListener(this);
		add(pks);

	    Sr = new JButton("Search Rooms");
		Sr.setBounds(10, 430, 200, 30);
		Sr.setBackground(Color.black);
		Sr.setForeground(Color.white);
		Sr.addActionListener(this);
		add(Sr);

		lgt = new JButton("Log Out");
		lgt.setBounds(10, 470, 200, 30);
		lgt.setBackground(Color.white);
		lgt.setForeground(Color.red);
		lgt.addActionListener(this);
		add(lgt);

		ImageIcon rcpsnimg = new ImageIcon(ClassLoader.getSystemResource("icon/reception.jpg"));
//		Image seti= rcpsnimg.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
//		ImageIcon si = new ImageIcon(seti);

		JLabel img = new JLabel(rcpsnimg);
		img.setBounds(250, 0, 500, 500);
		add(img);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == rooms) {
			setVisible(false);
			new Rooms();
		} else if (e.getSource() == lgt) {
			setVisible(false);
			new Login();

		} else if (e.getSource() == dptmt) {
			setVisible(false);

			new Department();

		} else if (e.getSource() == Aemp) {
			setVisible(false);

			new EmployeeInfo();

		} else if (e.getSource() == Mi) {
			setVisible(false);

			new ManagerInfo();

		} else if (e.getSource() == Ci) {
			setVisible(false);

			new CustomerInfo();

		}else if (e.getSource() == Sr ) {
			setVisible(false);

			new SearchRoom();

		}else if (e.getSource() == updt ) {
			setVisible(false);

			new UpdateCheck();

		}else if (e.getSource() == Rstts ) {
			setVisible(false);

			new UpdateRoom();

		}else if (e.getSource() == pks ) {
			setVisible(false);

			new Pickup();

		}else if (e.getSource() == nc ) {
			setVisible(false);

			new AddCustomer();

		}else if (e.getSource() == ckot ) {
			setVisible(false);

			new CheckOut();

		}
		
	}

	public static void main(String args[]) {
		new Reception();
	}
}
