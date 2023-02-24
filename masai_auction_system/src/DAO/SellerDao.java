package DAO;

import java.util.List;

import DTO.Product;
import DTO.Seller;
import DTO.SoldItems;
import Exception.SellerException;

public interface SellerDao {
	 public Seller SellerLogin(String email, String password) throws SellerException;

	 public String RegisterSeller(Seller seller) throws SellerException;

	 public String CreateListofProductstoSell(List<Product> products) throws SellerException;

	 public String UpdateProductPrice(int productId,int price) throws SellerException;

	 public String DeleteProductItems(int productId) throws SellerException;

	 public List<SoldItems> SoldItemHistory(int sellerId) throws SellerException;
}
