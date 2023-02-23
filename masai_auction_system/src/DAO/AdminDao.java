package DAO;

import java.util.List;

import DTO.Buyer;
import DTO.Product;
import DTO.SearchBuyer;
import DTO.Seller;
import Exception.AdminException;
import Exception.CredentialException;

public interface AdminDao {
	 public final String email="admin";
	    public final String password="admin";

	    public String AdminLogin(String email,String password) throws CredentialException;

	    public List<Buyer> ViewBuyers() throws AdminException;

	    public List<Seller> ViewSellers() throws AdminException;

	    public List<SearchBuyer>DailySellingReport(String date) throws AdminException;

	    public List<Product> DailyDisputeReport(String date) throws AdminException;

	    public String SolveDispute(int categoryId,int productId) throws AdminException;
}
