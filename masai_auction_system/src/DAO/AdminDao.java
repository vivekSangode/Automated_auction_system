package DAO;

import java.util.List;

import DTO.Buyer;
import DTO.Product;
import DTO.SearchBuyer;
import DTO.SearchBuyerImpl;
import DTO.Seller;
import Exception.AdminException;
import Exception.CredentialException;

public interface AdminDao {
	    public final String email="admin";
	    public final String password="admin";

	    
	    /*
	     * The login method use for signin admin with the help of 
	     * default admin,admin email and password.
	     * argument are: email, string. 
	     */
	    public String AdminLogin(String email,String password) throws CredentialException;

	    /*
	     * The get method use to see all the Buyers present in database
	     * no argument passed
	     */
	    public List<Buyer> ViewBuyers() throws AdminException;

	    /*
	     * The get method use to see all the Buyers present in database
	     * no argument passed
	     */
	    public List<Seller> ViewSellers() throws AdminException;
	    
	    /*
	     * The get Buyer Method use to see Daily Sellig Report
	     * if date passed as argument. 
	     */
	    public List<SearchBuyerImpl> DailySellingReport(String date) throws AdminException;
	   
	    /*
	     * The get Product Method use to see Daily Dispute Report
	     * if date passed as argument. 
	     */
	    public List<Product> DailyDisputeReport(String date) throws AdminException;
	    
	    /*
	     * The method use to Solve Dispute
	     * if categoryId and productId passed as argument. 
	     */
	    public String SolveDispute(int categoryId,int productId) throws AdminException;
}
