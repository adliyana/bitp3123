package my.edu.utem.ftmk.dad.restoredrapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


	@Entity 
	@Table(name = "product")

	public class Product{
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column (name="ProductId")
		private int ProductId;
		
		@Column (name="Name")
		private String Name;
		
		@Column (name="Price")
		private double Price;
		
		@ManyToOne
		@JoinColumn(name="ProductType")
		private  ProductType productType;

		public int getProductId() {
			return ProductId;
		}

		public void setProductId(int productId) {
			ProductId = productId;
		}

		public String getName() {
			return Name;
		}

		public void setName(String name) {
			Name = name;
		}

		public double getPrice() {
			return Price;
		}

		public void setPrice(double price) {
			Price = price;
		}

		public ProductType getProductType() {
			return productType;
		}

		public void setProductType(ProductType productType) {
			this.productType = productType;
		}
		
		
		}
	
