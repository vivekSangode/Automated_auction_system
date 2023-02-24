package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.Buyer;
import DTO.BuyerImpl;
import DTO.Product;
import DTO.ProductImpl;
import DTO.SearchBuyer;
import DTO.SearchBuyerImpl;
import DTO.Seller;
import DTO.SellerImpl;
import Exception.AdminException;
import Exception.CredentialException;
import utility.DBUtils;

public class AdminDaoImpl implements AdminDao{

	@Override
	public String AdminLogin(String email, String password) throws CredentialException {
		 String result="Invalid email/password";

		 if (email.equals(AdminDao.email) && password.equals(AdminDao.password)) {
			 result="Welcome Admin -Login Successful";
		 }else{
			 throw new CredentialException(result);
		 }
		 return result;
	}

	@Override
	public List<Buyer> ViewBuyers() throws AdminException {
		List<Buyer> list=new ArrayList<>();

        try(Connection conn=DBUtils.connectToDatabase()) {
            PreparedStatement ps=conn.prepareStatement("select * from buyer");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Buyer buyerDTO=new BuyerImpl();
                buyerDTO.setBuyerId(rs.getInt("buyerId"));
                buyerDTO.setBuyerName(rs.getString("buyerName"));
                buyerDTO.setEmail(rs.getString("email"));
                buyerDTO.setLocation(rs.getString("location"));
                list.add(buyerDTO);
            }
            if(list.size()==0){
                throw new AdminException("No data in Buyers List");
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new AdminException(e.getMessage());
        }
        return list;
	}

	@Override
	public List<Seller> ViewSellers() throws AdminException {
		List<Seller> list=new ArrayList<>();

        try(Connection conn=DBUtils.connectToDatabase()) {
            PreparedStatement ps=conn.prepareStatement("select * from seller");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Seller sellerDTO=new SellerImpl();
                sellerDTO.setSellerId(rs.getInt("sellerId"));
                sellerDTO.setSellerName(rs.getString("sellerName"));
                sellerDTO.setEmail(rs.getString("email"));
                sellerDTO.setLocation(rs.getString("location"));
                list.add(sellerDTO);
            }
            if(list.size()==0){
                throw new AdminException("No data in Sellers List");
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new AdminException(e.getMessage());
        }
        return list;
	}

	@Override
	public List<SearchBuyer> DailySellingReport(String date) throws AdminException {
		 List<SearchBuyer> list=new ArrayList<>();

	        try(Connection conn=DBUtils.connectToDatabase()) {

	            PreparedStatement ps=conn.prepareStatement("select b.buyerId,b.buyerName,b.email,p.productName,c.categoryName,s.sellerName,p.price from products p " +
	                    "Inner Join category c Inner Join seller s Inner Join buyer b " +
	                    "On p.categoryId=c.categoryId and p.sellerId=s.sellerId and p.buyerId=b.buyerId " +
	                    "where p.date=?");

	            ps.setString(1, String.valueOf(date));

	            ResultSet rs=ps.executeQuery();
	            while (rs.next()){
	                SearchBuyer searchBuyerDTO=new SearchBuyerImpl();
	                searchBuyerDTO.setBuyerId(rs.getInt("buyerId"));
	                searchBuyerDTO.setBuyerName(rs.getString("buyerName"));
	                searchBuyerDTO.setEmail(rs.getString("email"));
	                searchBuyerDTO.setProductName(rs.getString("productName"));
	                searchBuyerDTO.setSellerId(rs.getInt("sellerId"));
	                searchBuyerDTO.setPrice(rs.getInt("price"));
	                list.add(searchBuyerDTO);
	            }
	            if(list.size()==0){
	                throw new AdminException("No Item Sold on Date- "+date);
	            }
	        }catch (SQLException e){
	            e.printStackTrace();
	            throw new AdminException(e.getMessage());
	        }
	        return list;
	}

	@Override
	public List<Product> DailyDisputeReport(String date) throws AdminException {
		List<Product> list=new ArrayList<>();

        try(Connection conn=DBUtils.connectToDatabase()) {

            PreparedStatement ps=conn.prepareStatement("select * from products where date=?");

            ps.setString(1, String.valueOf(date));

            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Product products = new ProductImpl(0, date, 0, 0, 0, 0, date);
                products.setProductId(rs.getInt("productId"));
                products.setProductName(rs.getString("productName"));
                products.setCategoryId(rs.getInt("categoryId"));
                products.setCategoryId(rs.getInt("buyerId"));
                products.setSellerId(rs.getInt("sellerId"));
                products.setPrice(rs.getInt("price"));
                products.setStatus(rs.getString("status"));
                list.add(products);
            }
            if(list.size()==0){
                throw new AdminException("No Item found n product list on Date- "+date);
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new AdminException(e.getMessage());
        }
        return list;
	}

	@Override
	public String SolveDispute(int categoryId, int productId) throws AdminException {
		 String result;

	        try(Connection conn=DBUtils.connectToDatabase()) {
	            PreparedStatement ps=conn.prepareStatement("update products set categoryId=? where productId=?");

	            ps.setInt(1,categoryId);
	            ps.setInt(2, productId);

	            int x= ps.executeUpdate();
	            if(x>0){
	                result="Dispute Resolved Successfully";
	            }else{
	                throw new AdminException("No Product found with productId- "+productId );
	            }


	        }catch (SQLException e){
	            e.printStackTrace();
	            throw new AdminException(e.getMessage());
	        }

	        return result;
	}

}
