package com.pm05.Model;

public class Product {
	  private int id;
	    private String name;
	    private String image;
	    private double price;
        private String description;
        private String title;
         
	    public Product() {
	    	
	    }
	    public Product(int id, String name, String image, double price,String description,String title) {
	        this.id = id;
	        this.name = name;
	        this.image = image;
	        this.price = price;
	        
	        this.description =description;
	        this.title =title;
	    }
		public int getId() {
			return id;
		}
		public String getName() {
			return name;
		}
		public String getImage() {
			return image;
		}
		public double getPrice() {
			return price;
		}

		public void setId(int id) {
			this.id = id;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getdescription() {
			return description;
		}
		public void setdescription(String describe) {
			this.description = describe;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
	    
}
