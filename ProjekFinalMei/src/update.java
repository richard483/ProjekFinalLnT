import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import dao.customerDAO;

public class update extends JFrame implements ActionListener {
	
	JButton confirmbutton = new JButton("Confirm");
	JButton cancelbutton = new JButton("Cancel");
	
	JTextField txtnama;
	JTextField txtharga;
	JTextField txtstok;
	
	JTextField txtid;
	
	public update() {
		// TODO Auto-generated constructor stub
		
		initframe();
	}

	
	public void initframe() {
		
//
		setTitle("Update menu");
		setSize(500, 300);//new dimension juga bisa
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(0,2));//0 menyesuaikan dengan data yang ada

		komponen();
		setLocation(100,100);
		setVisible(true);
	}
	
	public void komponen() {

		JLabel labelid= new JLabel("Masukan ID barang yang ingin diupdate");
		txtid = new JTextField();
		add(labelid);
		add(txtid);
		
		JLabel labelnama= new JLabel("Masukan nama barang yang ingin diupdate");
		txtnama = new JTextField();
		add(labelnama);
		add(txtnama);
		
		JLabel labelharga= new JLabel("Masukan harga barang yang ingin diupdate");
		txtharga = new JTextField();
		add(labelharga);
		add(txtharga);
		
		JLabel labelstok= new JLabel("Masukan stok barang yang ingin diupdate");
		txtstok = new JTextField();
		add(labelstok);
		add(txtstok);
		

		add(confirmbutton);
		add(cancelbutton);
		
		confirmbutton.addActionListener(this);
		cancelbutton.addActionListener(this);
	}
	
//baru sampai sini
	@Override
	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
		if (e.getSource().equals(confirmbutton)) {
			JOptionPane.showMessageDialog(null, "Data anda dengan ID: "+ txtid.getText() + " akan diupdate");
			customerDAO CustomerDAO = new customerDAO();
			CustomerDAO.updateData(txtid.getText(), txtnama.getText(), txtharga.getText(), txtstok.getText());
			
			new main();
			setVisible(false);
		}else if (e.getSource().equals(cancelbutton)) {
			JOptionPane.showMessageDialog(null, "Data tidak jadi diupdate");
			setVisible(false);
			new main();
		}
	}
}
