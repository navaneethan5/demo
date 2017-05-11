package myretail.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	private Long id;
	@Column(name="sku")
	private String sku;
	@Column(name="name")
	private String name;
	@Column(name="category")
	private String category;
	@Column(name="price")
	private Double price;	
	@Column(name="last_updated")
	private String lastUpdated;
	
	public Product() {}
	
	public Product(Long id, String sku, String name, String category, Double price, String lastUpdated) {	
    	this.id = id;
    	this.sku = sku;
        this.price = price;
        this.name = name;
        this.category = category;
        this.lastUpdated = lastUpdated;
    }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
}
