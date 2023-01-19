package com.wsjsistema.wsjdscommerce.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OrdemItemPK {
	
	@ManyToOne
	@JoinColumn(name = "order_id")//mapeado com chave Estrangeira PK order_id
	private Order order;
	
	
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	
	public OrdemItemPK() {
		
		
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}
	
	

}
