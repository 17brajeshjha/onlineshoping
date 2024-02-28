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
@Table(name=DBConstants.CUSTOMER_SELECTED_ITEMS_TABLE_NAME)
@NamedQueries({
    @NamedQuery(name = DBConstants.NAMED_QUERY_CUSTOMER_SELECTED_ITEMS_FIND_BY_CUSTNO,
            query = "SELECT csi FROM CustomerSelectedItem csi WHERE csi.customer = :customer"),
    @NamedQuery(name = DBConstants.NAMED_QUERY_CUSTOMER_SELECTED_ITEMS_DELETE_BY_CUSTNO,
    query = "DELETE FROM CustomerSelectedItem csi WHERE csi.customer = :customer"),
    @NamedQuery(name=DBConstants.NAMED_QUERY_CUSTOMER_SELECTED_ITEMS_FINDALL, query="SELECT csi FROM CustomerSelectedItem csi")
})
public class CustomerSelectedItem {

	@EmbeddedId
	private CustomerSelectedItemPK id;
	@ManyToOne 
	@JoinColumn(name=DBConstants.CUSTOMER_SELECTED_ITEMS_TABLE_CUSTNO)
	private Customer customer;
	@ManyToOne 
	@JoinColumn(name=DBConstants.CUSTOMER_SELECTED_ITEMS_TABLE_ITEMNO)
	private Item item;
	@Column(name = DBConstants.CUSTOMER_SELECTED_ITEMS_TABLE_QUANTITY)
	private double quantity;
	public CustomerSelectedItem()
	{
		
	}
	public CustomerSelectedItem(Item item, double quantity)
	{
		this.item = item;
		this.quantity = quantity;
	}
	public CustomerSelectedItem(Customer customer, Item item, double quantity)
	{
		this.customer = customer;
		this.item = item;
		this.quantity = quantity;
	}
	public CustomerSelectedItemPK getId() {
		return this.id;
	}

	public void setId(CustomerSelectedItemPK id) {
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

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public boolean add() {
		boolean result = false;
		try
		{
			if(customer!=null && item!=null)
			{			
				EntityManager entitymanager = JPA.GetInstance().getEntityManagerFactory().createEntityManager();
				entitymanager.getTransaction( ).begin( );
				entitymanager.persist(new CustomerSelectedItem(customer,item,quantity));
				entitymanager.getTransaction().commit();
		        entitymanager.close();
		        result = true;
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
        
        return result;
	}

}
