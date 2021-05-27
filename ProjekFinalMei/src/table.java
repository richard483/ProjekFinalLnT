import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dao.customerDAO;

public class table extends JFrame implements ActionListener{
	JButton exit;
	
	public table() {
		// TODO Auto-generated constructor stub
		initframe();
	}
	
	public void initframe() {
		setTitle("Lihat Data");
		setSize(500, 500);
		initjtabel();
		komponen();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(0,0);
		setVisible(true);	
	}
	
	public void initjtabel() {
		
		customerDAO CustomerDAO=new customerDAO();
		
		Vector<String> columns = new Vector<>();
		columns.add("ID");
		columns.add("Name");
		columns.add("Harga");
		columns.add("Stok");
		
		JTable table= new JTable(CustomerDAO.getCustomerData(),columns) {
		@Override
		public boolean isCellEditable(int row, int column) {
			// TODO Auto-generated method stub
			return false;
		}	
		};
		
		setLayout(new BorderLayout());
		JScrollPane sp= new JScrollPane(table);//tabel kita bisa di scroll
		add(sp,BorderLayout.NORTH);
	}
	
	public void komponen() {
		exit= new JButton("Exit");
		
		exit.addActionListener(this);
		JPanel bawah= new JPanel();
		bawah.setLayout(new FlowLayout());
		
		bawah.add(exit);
		add(bawah);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(exit)) {
			new main();
			setVisible(false);
		}
		
	}

}
