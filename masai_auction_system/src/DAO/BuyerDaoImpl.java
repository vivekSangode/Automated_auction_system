package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import DTO.Buyer;
import DTO.BuyerImpl;
import DTO.SearchBuyer;
import DTO.SearchBuyerImpl;
import DTO.SoldItems;
import DTO.SoldItemsImpl;
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
		String result="Not Registered-Bad Details (Enter Unique Email)";

        try(Connection conn=DBUtils.connectToDatabase()) {
            PreparedStatement ps=conn.prepareStatement("insert into buyer (buyerName,email,password,location) values (?,?,?,?)");

            ps.setString(1, buyer.getBuyerName());
            ps.setString(2, buyer.getEmail());
            ps.setString(3, buyer.getPassword());
            ps.setString(4, buyer.getLocation());

           int x= ps.executeUpdate();
           if(x>0){
               result="Registered Successfully";
           }else{
               throw new BuyerException(result);
           }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return result;
	}

	@Override
	public String BuyItem(int buyerId, LocalDate date, String productName) throws BuyerException {
		String result = null;

        try(Connection conn=DBUtils.connectToDatabase()) {
            PreparedStatement ps=conn.prepareStatement("update products set status='sold',buyerId=?,date=? where productName=?");

            ps.setInt(1, buyerId);
            ps.setDate(2, Date.valueOf(date));
            ps.setString(3, productName);


            int x= ps.executeUpdate();
            if(x>0){
                result="Item Bought Successfully- Will be delivered shortly";
            }else{
                throw new BuyerException("No Product found with productName- "+productName );
            }


        }catch (SQLException e){
            e.printStackTrace();
        }

        return result;
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

	@Override
	public List<SoldItems> searchItemByCategory(String categoryName) throws BuyerException {
		List<SoldItems> list=new ArrayList<>();

        try(Connection conn=DBUtils.connectToDatabase()) {

            PreparedStatement ps=conn.prepareStatement("select p.productId,p.productName,s.sellerName,c.categoryName,p.price,p.status from products p " +
                    "Inner Join category c Inner Join seller s " +
                    "On p.categoryId=c.categoryId and p.sellerId=s.sellerId " +
                    "where status='available' and c.categoryName=?");

            ps.setString(1,categoryName);

            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                SoldItems soldItemsDTO=new SoldItemsImpl();
                soldItemsDTO.setProductId(rs.getInt("productId"));
                soldItemsDTO.setProductName(rs.getString("productName"));
                soldItemsDTO.setSellerName(rs.getString("sellerName"));
                soldItemsDTO.setCategoryName(rs.getString("categoryName"));
                soldItemsDTO.setPrice(rs.getInt("price"));
                list.add(soldItemsDTO);
            }
            if(list.size()==0){
                throw new BuyerException("No Item found in Product List/ Category not found");
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new BuyerException(e.getMessage());
        }
        return list;
	}

	@Override
	public List<SearchBuyer> ViewAllBuyersDetails(String categoryName) throws BuyerException {
		 List<SearchBuyer> list=new ArrayList<>();

	        try(Connection conn=DBUtils.connectToDatabase()) {

	            PreparedStatement ps=conn.prepareStatement("select b.buyerId,b.buyerName,b.email,p.productName,c.categoryName,s.sellerName,p.price from products p " +
	                    "Inner Join category c Inner Join seller s Inner Join buyer b " +
	                    "On p.categoryId=c.categoryId and p.sellerId=s.sellerId and p.buyerId=b.buyerId " +
	                    "where c.categoryName=? and status='sold'");

	            ps.setString(1,categoryName);

	            ResultSet rs=ps.executeQuery();
	            while (rs.next()){
	                SearchBuyer searchBuyerDTO = new SearchBuyerImpl();
	                searchBuyerDTO.setBuyerId(rs.getInt("buyerId"));
	                searchBuyerDTO.setBuyerName(rs.getString("buyerName"));
	                searchBuyerDTO.setEmail(rs.getString("email"));
	                searchBuyerDTO.setProductName(rs.getString("productName"));
	                searchBuyerDTO.setPrice(rs.getInt("price"));
	                list.add(searchBuyerDTO);
	            }
	            if(list.size()==0){
	                throw new BuyerException("No Item found in Bought Items List/ Category not found");
	            }
	        }catch (SQLException e){
	            e.printStackTrace();
	            throw new BuyerException(e.getMessage());
	        }
	        return list;
	}

	

}
