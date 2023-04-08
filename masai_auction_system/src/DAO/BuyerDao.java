package DAO;

import java.time.LocalDate;
import java.util.List;

import DTO.Buyer;
import DTO.SearchBuyer;
import DTO.SoldItems;
import Exception.BuyerException;
import Exception.CredentialException;

public interface BuyerDao {
	
	/*
	 * Login Method for Buyer with the help of unique email and password
	 * @return Buyer object
	 */
	public Buyer BuyerLogin(String email, String password) throws CredentialException;

	/*
	 * A method used for Registered a new Buyer
	 * @return String
	 */
    public String RegisterBuyer(Buyer buyer) throws BuyerException;
    
	/*
	 * A method used to buy items which are added by seller
	 * @return String
	 */
    public String BuyItem(int buyerId, LocalDate date,String productName) throws BuyerException;
    
    /*
	 * A method used to search item by its category
	 * @return list of sold items
	 */
    public List<SoldItems> searchItemByCategory(String categoryName) throws BuyerException;
    
    /*
   	 * A method used to get all registered buyers
   	 * @return list of sold items
   	 */
    public List<SearchBuyer> ViewAllBuyersDetails(String categoryName) throws BuyerException;
}
