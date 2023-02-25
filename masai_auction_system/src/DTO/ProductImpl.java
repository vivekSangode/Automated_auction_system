package DTO;



public class ProductImpl implements Product{
	private int productId;
    private String productName;
    private int categoryId;
    private int buyerId;
    private int sellerId;
    private int price;
    private String status;
	public ProductImpl(int productId, String productName, int categoryId, int buyerId, int sellerId, int price,
			String status) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.categoryId = categoryId;
		this.buyerId = buyerId;
		this.sellerId = sellerId;
		this.price = price;
		this.status = status;
	}
	public ProductImpl() {
		
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "productId = " + productId + ", productName = " + productName + ", categoryId = " + categoryId
				+ ", buyerId = " + buyerId + ", sellerId = " + sellerId + ", price = " + price + ", status = " + status + "\n";
	}
   
}
