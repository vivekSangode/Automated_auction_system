package DTO;

public class SearchBuyerImpl implements SearchBuyer{
	 private int buyerId;
	 private String buyerName;
	 private String email;
	 private String productName;
	 private int sellerId;
	 private int price;
	  
	 public SearchBuyerImpl() {}
	 
	 public SearchBuyerImpl(int buyerId, String buyerName, String email, String productName, int sellerId, int price) {
		super();
		this.buyerId = buyerId;
		this.buyerName = buyerName;
		this.email = email;
		this.productName = productName;
		this.sellerId = sellerId;
		this.price = price;
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "buyerId = " + buyerId + ", buyerName = " + buyerName + ", email = " + email
				+ ", productName = " + productName + ", sellerId = " + sellerId + ", price = " + price + "\n";
	}
	 
	 
	 
	 
	 
}
