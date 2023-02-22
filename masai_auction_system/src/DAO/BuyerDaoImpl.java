package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import DTO.Buyer;
import DTO.BuyerImpl;
import Exception.BuyerException;
import Exception.CredentialException;
import utility.DBUtils;

public class BuyerDaoImpl implements BuyerDao{

	@Override
	public Buyer BuyerLogin(String email, String password) throws CredentialException {
		Buyer b = null;
		try {
			Connection conn = DBUtils.connectToDatabase();
			PreparedStatement ps = conn.prepareStatement("select * from Buyer where email = ? and password = ?");
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int buyerId = rs.getInt("buyerId");
				String buyerName = rs.getString("BuyerName");
				String buyeremail = rs.getString("email");
				String buyerpassword = "********";
				String location = rs.getString("location");
				b = new BuyerImpl(buyerId,buyerName,buyeremail,buyerpassword,location);
			}else {
				throw new CredentialException("Couldn't find the Buyer!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public String RegisterBuyer(Buyer buyer) throws BuyerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String BuyItem(int buyerId, LocalDate date, String productName) throws BuyerException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		BuyerDaoImpl b = new BuyerDaoImpl();
		try {
			Buyer s = b.BuyerLogin("binod@gmail.com", "Binod123");
			System.out.println(s);
		} catch (CredentialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
