package DAO;

import java.time.LocalDate;
import java.util.List;

import DTO.Buyer;
import Exception.BuyerException;
import Exception.CredentialException;

public interface BuyerDao {
	public Buyer BuyerLogin(String email, String password) throws CredentialException;

    public String RegisterBuyer(Buyer buyer) throws BuyerException;
    
    public String BuyItem(int buyerId, LocalDate date,String productName) throws BuyerException;
    
//    public List<SoldItemsDTO> searchItemByCategory(String categoryName) throws ByerException;
//    
//    public List<SearchBuyerDTO> ViewAllBuyersDetails(String categoryName) throws ByerException;
}
