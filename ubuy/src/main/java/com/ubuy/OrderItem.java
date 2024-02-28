package com.ubuy;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name=DBConstants.ORDERITEMS_TABLE_NAME)
@NamedQueries({
    @NamedQuery(name = DBConstants.NAMED_QUERY_ORDERITEM_FINDBYORDER,
            query = "SELECT o FROM OrderItem o WHERE o.order = :order"),
    @NamedQuery(name=DBConstants.NAMED_QUERY_ORDERITEM_FINDALL, query="SELECT o FROM OrderItem o")
})

public class OrderItem {
	@EmbeddedId
	private OrderitemPK id;
	@ManyToOne 
	@JoinColumn(name=DBConstants.ORDERITEMS_TABLE_ORDNO)
	private Order order;
	@ManyToOne 
	@JoinColumn(name=DBConstants.ORDERITEMS_TABLE_ITEMNO)
	private Item item;
	@Column(name = DBConstants.ORDERITEMS_TABLE_QUANTITY)
	private double quantity;
	public OrderItem()
	{
		
	}
	public OrderItem(Item item, double quantity)
	{
		this.item = item;
		this.quantity = quantity;
	}
	public OrderItem(Order order, Item item, double quantity)
	{
		this.order = order;
		this.item = item;
		this.quantity = quantity;
	}
	public OrderitemPK getId() {
		return this.id;
	}

	public void setId(OrderitemPK id) {
		this.id = id;
	}
	public double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
