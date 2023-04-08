package DAO;

import java.util.List;

import DTO.Product;
import DTO.Seller;
import DTO.SoldItems;
import Exception.SellerException;

public interface SellerDao {
	
	/*
	 * Login Method for seller with the help of unique email and password
	 * @return Seller object
	 */
	 public Seller SellerLogin(String email, String password) throws SellerException;

	 /*
	  * A method used for Registered a new Seller
	  * @return String
	  */
	 public String RegisterSeller(Seller seller) throws SellerException;

	 /*
	  * A method use to create a list of project to sell
	  * @return String
	  */
	 public String CreateListofProductstoSell(List<Product> products) throws SellerException;

	 /*
	  * A method use to update product price
	  * @return String
	  */
	 public String UpdateProductPrice(int productId,int price) throws SellerException;

	 /*
	  * A method use to delete product from seller list
	  * @return String
	  */
	 public String DeleteProductItems(int productId) throws SellerException;

	 /*
	  * A method use to get list of sold Item
	  * @return list of sold items
	  */
	 public List<SoldItems> SoldItemHistory(int sellerId) throws SellerException;
}
