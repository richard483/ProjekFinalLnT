package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Vector;

import connectDatabase.koneksi;

public class customerDAO {
	Random rand = new Random();
	Connection connection;
	
	public customerDAO() {
		// TODO Auto-generated constructor stub
		try {
			initconnection();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	}
	
	public void initconnection() throws SQLException {
		connection=koneksi.connect();
		
		if (connection==null) {
			throw new SQLException("connection");
		}
	}
	
	public Vector<Vector<String>> getCustomerData() {
		Vector<Vector<String>> data = new Vector<>();
		try {
			Statement stmt = connection.createStatement();
			String sql = "select * from datamenu";	
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Vector<String> rows = new Vector<>();
				rows.add(rs.getString(1));
				rows.add(rs.getString(2));
				rows.add(rs.getString(3));
				rows.add(rs.getString(4));
				data.add(rows);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
//	public void insertData() {
//		try {
//			Statement stmt=connection.createStatement();
//			String sql="Insert into datamenu Values('CU-005','Albert','678901234','Batam')";
//			
//			
//			stmt.executeUpdate(sql);//masukkin data,update data, hapus data
//			System.out.println("Sukses Insert Data");
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}
	
	public void updateData(String id, String nama, String harga, String stok) {
		if(id!="") {
			try {
				Statement stmt = connection.createStatement();
				String sql = "UPDATE `datamenu` SET `Nama_Menu`='"+nama+"',`Harga_Menu`='"+harga+"',`Stok_Menu`='"+stok+"' WHERE ID_Menu = '"+id+"'";
				stmt.executeUpdate(sql);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}else {
			System.err.println("Error no ID");
		}
		
	}
	
	
	public void deleteData(String kode) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "DELETE FROM `datamenu` WHERE `ID_Menu` = '"+kode+"'";
			stmt.executeUpdate(sql);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void	insertData(String nama, String harga, String stok) {
		try {
			Statement stmt = connection.createStatement();
			
			
			String sql = "Insert into datamenu values('"+generateNewID()+"', '"+nama+"', '"+harga+"', '"+stok+"')";
			
			stmt.executeUpdate(sql);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String generateNewID() {
		String id = "";
		String newId ="";
		try {
			
			Statement stmt = connection.createStatement();
			String sql = "SELECT ID_Menu from datamenu ORDER BY ID_Menu DESC LIMIT 1";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				id = rs.getString(1);
			}
			if(id == "")
				id = "BC-000";
			int rendom = rand.nextInt(1000);
			newId = String.format("BC-%03d",rendom);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newId;
	}
}
