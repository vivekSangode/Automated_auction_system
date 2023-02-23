package DAO;

import java.time.LocalDate;
import java.util.List;

import DTO.Buyer;
import DTO.SearchBuyer;
import DTO.SoldItems;
import Exception.BuyerException;
import Exception.CredentialException;

public interface BuyerDao {
	public Buyer BuyerLogin(String email, String password) throws CredentialException;

    public String RegisterBuyer(Buyer buyer) throws BuyerException;
    
    public String BuyItem(int buyerId, LocalDate date,String productName) throws BuyerException;
    
    public List<SoldItems> searchItemByCategory(String categoryName) throws BuyerException;
    
    public List<SearchBuyer> ViewAllBuyersDetails(String categoryName) throws BuyerException;
}
