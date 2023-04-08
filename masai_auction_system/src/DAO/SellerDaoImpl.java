package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.Product;
import DTO.Seller;
import DTO.SellerImpl;
import DTO.SoldItems;
import DTO.SoldItemsImpl;
import Exception.BuyerException;
import Exception.CredentialException;
import Exception.SellerException;
import utility.DBUtils;

public class SellerDaoImpl implements SellerDao{

	HashingPassword hashingPassword = new HashingPassword();
	
	EmailValidation emailValidation =  new EmailValidation();
	
	
	/*
	 * Login Method for seller with the help of unique email and password
	 * @return Seller object
	 */
	@Override
	public Seller SellerLogin(String email, String password) throws SellerException {
		Seller seller=null;

		if(emailValidation.emailValidation(email)=="Invalid") {
			throw new SellerException("Wrong email address plese provide right syntax of email.");
		}
		password = hashingPassword.hashingAlgorithem(password);
		
        try(Connection conn= DBUtils.connectToDatabase()){

            PreparedStatement ps=conn.prepareStatement("Select * from seller where email=? AND password=?");
            ps.setString(1,email);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                seller =new SellerImpl();
                seller.setSellerId(rs.getInt("sellerID"));
                seller.setSellerName(rs.getString("sellerName"));
                seller.setEmail(rs.getString("email"));
                seller.setPassword(rs.getString("password"));
                seller.setLocation(rs.getString("location"));

            }else{
                throw new SellerException("Invalid email/password");
            }


        }catch (SQLException e){
            e.printStackTrace();
            throw new SellerException(e.getMessage());

        }


        return seller;
	}

	

	 /*
	  * A method used for Registered a new Seller
	  * @return String
	  */
	@Override
	public String RegisterSeller(Seller seller) throws SellerException {
		String result="Not Registered-Bad Details (Enter Unique Email)";
		seller.setPassword(hashingPassword.hashingAlgorithem(seller.getPassword()));
		if(emailValidation.emailValidation(seller.getEmail())=="Invalid") {
			throw new SellerException("Wrong email address plese provide right syntax of email.");
		}
		if(seller.getPassword()==null) {
			throw new SellerException("Password can't be Empty");
		}
        try(Connection conn=DBUtils.connectToDatabase()) {
            PreparedStatement ps=conn.prepareStatement("insert into seller (sellerName,email,password,location) values (?,?,?,?)");

            ps.setString(1, seller.getSellerName());
            ps.setString(2, seller.getEmail());
            ps.setString(3, seller.getPassword());
            ps.setString(4, seller.getLocation());

            int x= ps.executeUpdate();
            if(x>0){
                result="Registered Successfully";
            }else{
                throw new SellerException(result);
            }


        }catch (SQLException e){
            e.printStackTrace();
            throw new SellerException(e.getMessage());
        }

        return result;
	}

	 /*
	  * A method use to create a list of project to sell
	  * @return String
	  */
	@Override
	public String CreateListofProductstoSell(List<Product> products) throws SellerException {
		 String result="Not Listed";

	        try(Connection conn=DBUtils.connectToDatabase()){
	            int count=0;
	            for(int i=0;i<products.size();i++){
	                String productName = products.get(i).getProductName();
	                int categoryId = products.get(i).getCategoryId();
	                int sellerId = products.get(i).getSellerId();
	                int price = products.get(i).getPrice();
	                PreparedStatement ps = null;
	                try {
	                    ps = conn.prepareStatement("insert into products (productName,sellerId,categoryId,price) values(?,?,?,?)");
	                    ps.setString(1, productName);
	                    ps.setInt(2, sellerId);
	                    ps.setInt(3, categoryId);
	                    ps.setInt(4, price);
	                    int x = ps.executeUpdate();
	                    count++;
	                } catch (SQLException e) {
	                    System.out.println("Mismatch in data");
	                }
	            };
	            if(count>0){
	                result="Products Inserted in Auction List Successfully";
	            }else{
	                throw new SellerException(result);
	            }
	        }catch (SQLException e){
	            e.printStackTrace();
	            throw new SellerException(e.getMessage());
	        }
	        return result;
	}

	 /*
	  * A method use to update product price
	  * @return String
	  */
	@Override
	public String UpdateProductPrice(int productId, int price) throws SellerException {
		String result;

        try(Connection conn=DBUtils.connectToDatabase()) {
            PreparedStatement ps=conn.prepareStatement("update products set price=? where productId=?");

            ps.setInt(1,price );
            ps.setInt(2, productId);

            int x= ps.executeUpdate();
            if(x>0){
                result="Updated Successfully";
            }else{
                throw new SellerException("No Product found with productId- "+productId );
            }


        }catch (SQLException e){
            e.printStackTrace();
            throw new SellerException(e.getMessage());
        }

        return result;
	}

	 /*
	  * A method use to delete product from seller list
	  * @return String
	  */
	@Override
	public String DeleteProductItems(int productId) throws SellerException {
		 String result;

	        try(Connection conn=DBUtils.connectToDatabase()) {
	            PreparedStatement ps=conn.prepareStatement("delete from products where productId=?");

	            ps.setInt(1, productId);

	            int x= ps.executeUpdate();
	            if(x>0){
	                result="Deleted Successfully";
	            }else{
	                throw new SellerException("No Product found with productId- "+productId );
	            }


	        }catch (SQLException e){
	            e.printStackTrace();
	            throw new SellerException(e.getMessage());
	        }

	        return result;
	}

	 /*
	  * A method use to get list of sold Item
	  * @return list of sold items
	  */
	@Override
	public List<SoldItems> SoldItemHistory(int sellerId) throws SellerException {
		List<SoldItems> list=new ArrayList<>();

        try(Connection conn=DBUtils.connectToDatabase()) {

            PreparedStatement ps=conn.prepareStatement("select p.productId,p.productName,s.sellerName,c.categoryName,p.price,p.status from products p " +
                    "Inner Join category c Inner Join seller s " +
                    "On p.categoryId=c.categoryId and p.sellerId=s.sellerId " +
                    "where status='sold' and s.sellerId=?");

            ps.setInt(1,sellerId);

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
                throw new SellerException("No Item sold in Product List/ SellerId not found");
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new SellerException(e.getMessage());
        }
        return list;
	}

}
