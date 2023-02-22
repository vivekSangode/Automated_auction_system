package DTO;

public class BuyerImpl implements Buyer{
	private int buyerId ;
    private String buyerName ;
    private String email ;
    private String password ;
    private String location ;
    
    public BuyerImpl() {}
    
	public BuyerImpl(int buyerId, String buyerName, String email, String password, String location) {
		super();
		this.buyerId = buyerId;
		this.buyerName = buyerName;
		this.email = email;
		this.password = password;
		this.location = location;
	}

	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	@Override
	public String toString() {
		return "buyerId = " + buyerId + "\n" + "buyerName = " + buyerName + "\n" + "email = " + email + "\n" + "password = "
				+ password + "\n" + "location = " + location + "\n";
	}
    
    
}
