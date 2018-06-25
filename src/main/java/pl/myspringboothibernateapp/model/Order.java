package pl.myspringboothibernateapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name="client_orders")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_order")
	private Long id;
	@Column(name="details",length=512,nullable=false)
	private String order_details;
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;
	
	@ManyToMany(fetch=FetchType.EAGER,
			cascade= CascadeType.PERSIST)
	@Fetch(FetchMode.SELECT)
	@JoinTable(name="order_products",
	joinColumns = {@JoinColumn(name="order_id", referencedColumnName="id_order")},
	inverseJoinColumns = {@JoinColumn(name="product_id", referencedColumnName="id_product")}
	)
	private List<Product> products;
	
	public Order() {
		
	}

	public Order(String order_details) {
		super();
		this.order_details = order_details;
		this.products = new ArrayList();
	}

	public Order(String order_details, Client client, List<Product> products) {
		super();
		this.order_details = order_details;
		this.client = client;
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public String getOrder_details() {
		return order_details;
	}

	public Client getClient() {
		return client;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setOrder_details(String order_details) {
		this.order_details = order_details;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", order_details=" + order_details + ", client name=" + client.getFirstName()+" "+client.getLastName() + ", products=" + products
				+ "]";
	}

	
}
