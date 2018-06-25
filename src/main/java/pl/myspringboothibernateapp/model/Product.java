package pl.myspringboothibernateapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_product")
	private Long id;
	@Column(name="product_name", nullable=false)
	private String name;
	@Column(name="price")
	private Double price;
	@Column(name="details")
	private String details;
	
	@ManyToMany(mappedBy="products")
	private List<Order> orders;
	
	public Product() {
		
	}

	public Product(String name, Double price, String details) {
		super();
		this.name = name;
		this.price = price;
		this.details = details;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public String getDetails() {
		return details;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", details=" + details + ", number of orders="
				+ orders.size() + "]";
	}

	
	
}
