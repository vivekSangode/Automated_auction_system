package DTO;

public class SoldItemsImpl implements SoldItems{
	    private int productId;
	    private String productName;
	    private String sellerName;
	    private String categoryName;
	    private int buyerId;
	    private int price;
	    
	    public SoldItemsImpl() {}
	    
		public SoldItemsImpl(int productId, String productName, String sellerName, String categoryName,int buyerId, int price) {
			super();
			this.productId = productId;
			this.productName = productName;
			this.sellerName = sellerName;
			this.categoryName = categoryName;
			this.buyerId = buyerId;
			this.price = price;
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

		public String getSellerName() {
			return sellerName;
		}

		public void setSellerName(String sellerName) {
			this.sellerName = sellerName;
		}

		public String getCategoryName() {
			return categoryName;
		}

		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}

		public int getBuyerId() {
			return buyerId;
		}

		public void setBuyerId(int buyerId) {
			this.buyerId = buyerId;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return "productId = " + productId + ", productName = " + productName + ", sellerName = "
					+ sellerName + ", categoryName = " + categoryName + ", price = " + price + "\n";
		}
	    
	    
	    
}
