package pl.myspringboothibernateapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="client_orders")
public class Order implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_order")
	private Long id;
	@Column(nullable=false)
	private String product;
	@Column(name="details",length=512,nullable=false)
	private String order_details;

	public Order() {
		super();
	}

	public Order(String product, String order_details) {
		super();
		this.product = product;
		this.order_details = order_details;
	}

	public Long getId() {
		return id;
	}

	public String getProduct() {
		return product;
	}

	public String getOrder_details() {
		return order_details;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public void setOrder_details(String order_details) {
		this.order_details = order_details;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", product=" + product + ", order_details=" + order_details + "]";
	}

}
