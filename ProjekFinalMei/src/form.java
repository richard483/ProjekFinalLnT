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

public class form extends JFrame implements ActionListener {
	
	JButton savebutton = new JButton("Save");
	JButton cancelbutton = new JButton("Cancel");
	
	JTextField txtname;
	JTextField txtphone ;
	
//	JTextField txtid;
	JTextField txtnama;
	JTextField txtharga;
	JTextField txtstok;
	
	JComboBox combocity;
	
	JRadioButton radiomale;
	JRadioButton radiofemale;
	ButtonGroup buttongroup ;
	
	
	
	
	public form() {
		// TODO Auto-generated constructor stub
		
		initframe();
	}

	
	public void initframe() {
		
//		frame=new JFrame("This is my GUI"); apus frame nya aja karena kita pake extends disini
		setTitle("Masukkin Data");
		setSize(300, 500);//new dimension juga bisa
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(0,2));//0 menyesuaikan dengan data yang ada
//		initevent();
		
//		frame.setResizable(false);
		komponen();
		setLocation(0,0);
		setVisible(true);
		
		
	}
	
	public void komponen() {
//		JLabel labelnama= new JLabel("Tuliskan Nama Anda:");
//		txtname= new JTextField();
//		add(labelnama);
//		add(txtname);
//		
//		JLabel labelphone= new JLabel("Masukkan No.Hp Anda");
//		txtphone = new JTextField();
//		add(labelphone);
//		add(txtphone);
		
		JLabel labelnama= new JLabel("Tuliskan Nama menu:");
		txtnama= new JTextField();
		add(labelnama);
		add(txtnama);
		
		JLabel labelharga = new JLabel("Tuliskan Harga Barang: ");
		txtharga = new JTextField();
		add(labelharga);
		add(txtharga);
		
		JLabel labelstok = new JLabel("Tuliskan jumlah stok: ");
		txtstok = new JTextField();
		add(labelstok);
		add(txtstok);
		
		
//		JLabel labelcity=new JLabel("Asal Kota Anda");
//		combocity= new  JComboBox(initcombobox());
//		add(labelcity);
//		add(combocity);
		
//		JLabel gender= new JLabel("Apa gender anda?");
//		JLabel kosong=new JLabel(); 
//		add(gender);
	
//		initradiobutton();
	
		add(savebutton);
		add(cancelbutton);
		
		savebutton.addActionListener(this);
		cancelbutton.addActionListener(this);
	}
	
//	public Vector<String> initcombobox() {
//		Vector<String> datakota= new Vector();
//		datakota.add("Jakarta");
//		datakota.add("Bandung");
//		datakota.add("Surabaya");
//		datakota.add("Bali");
//		datakota.add("Medan");
//		datakota.add("Batam");
//		return datakota;
//		
//	}
//	
//	public void initradiobutton() {
//		JPanel panel= new JPanel();
//		panel.setLayout(new FlowLayout());
//		buttongroup=new ButtonGroup();
//		radiomale= new JRadioButton("Male");
//		radiomale.setActionCommand("Male");
//		radiofemale= new JRadioButton("Female");
//		radiofemale.setActionCommand("Female");
//		add(radiomale);
//		add(radiofemale);
//		buttongroup.add(radiofemale);
//		buttongroup.add(radiomale);
//		add(panel);
//	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
		if (e.getSource().equals(savebutton)) {
			JOptionPane.showMessageDialog(null, "Data anda dengan format nama: "+ txtnama.getText()+" dengan harga "+ txtharga.getText() + " dan jumalh stok sejumlah "+ txtstok.getText() + " berhasil dimasukkan");

			
			customerDAO CustomerDAO = new customerDAO();
			CustomerDAO.insertData(txtnama.getText(), txtharga.getText(), txtstok.getText());
			
			new main();
			setVisible(false);
		}else if (e.getSource().equals(cancelbutton)) {
			JOptionPane.showMessageDialog(null, "Data tidak jadi dimasukkan");
			setVisible(false);
			new main();
		}
	}
}
