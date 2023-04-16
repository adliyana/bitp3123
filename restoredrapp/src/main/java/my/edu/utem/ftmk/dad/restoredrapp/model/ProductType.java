package my.edu.utem.ftmk.dad.restoredrapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "Producttype")
public class ProductType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="ProductTypeId")
	private int productTypeId;
	
	@Column (name="Name")
	private String name;

	public int getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
