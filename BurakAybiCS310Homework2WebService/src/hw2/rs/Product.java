package hw2.rs;

public class Product {
		
		private int id;
		private String name;
		private double price;
		private int stock;
		
		
		public Product() {
			super();
		}
		
		public Product(String name,double price, int stock) {
			super();
			this.setName(name);
			this.setPrice(price);
			this.setStock(stock);
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public double getPrice() {
			return price;
		}
		
		public void setPrice(double price) {
			this.price=price;
		}
		

		public int getStock() {
			return stock;
		}

		public void setStock(int stock) {
			this.stock = stock;
		}
		
		@Override
	    public String toString() {
	        return "User [id=" + id + ", name=" + name + ", price=" + price + ", stock=" +stock +"]";
	    }

}
