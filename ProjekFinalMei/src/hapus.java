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

public class hapus extends JFrame implements ActionListener {
	
	JButton confirmbutton = new JButton("Confirm");
	JButton cancelbutton = new JButton("Cancel");
	
	JTextField txtnama;
	JTextField txtharga;
	JTextField txtstok;
	
	JTextField txtid;
	
	public hapus() {
		// TODO Auto-generated constructor stub
		
		initframe();
	}

	
	public void initframe() {
		
//
		setTitle("Delete menu");
		setSize(500, 100);//new dimension juga bisa
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(0,2));//0 menyesuaikan dengan data yang ada

		komponen();
		setLocation(100,100);
		setVisible(true);
	}
	
	public void komponen() {

		JLabel labelid= new JLabel("Massukan ID barang yang ingin dihapus");
		txtid = new JTextField();
		add(labelid);
		add(txtid);
		

		add(confirmbutton);
		add(cancelbutton);
		
		confirmbutton.addActionListener(this);
		cancelbutton.addActionListener(this);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
		if (e.getSource().equals(confirmbutton)) {
			JOptionPane.showMessageDialog(null, "Data anda dengan ID: "+ txtid.getText() + " akan diapus");
			customerDAO CustomerDAO = new customerDAO();
			CustomerDAO.deleteData(txtid.getText());
			
			new main();
			setVisible(false);
		}else if (e.getSource().equals(cancelbutton)) {
			JOptionPane.showMessageDialog(null, "Data tidak jadi dihapus");
			setVisible(false);
			new main();
		}
	}
}
