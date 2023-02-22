package DTO;

public class SellerImpl implements Seller{
	 private int sellerId ;
	 private String sellerName ;
	 private String email ;
	 private String password ;
	 private String location ;
	 
	 public SellerImpl() {}
	 
	public SellerImpl(int sellerId, String sellerName, String email, String password, String location) {
		super();
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.email = email;
		this.password = password;
		this.location = location;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
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
		return "sellerId = " + sellerId + ", sellerName = " + sellerName + ", email= " + email + ", password = "
				+ password + ", location = "  + location + "]";
	}
	 
	 
}
