package com.ubuy;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class CustomerSelectedItems {

	private static CustomerSelectedItems instance=null;
	public static CustomerSelectedItems GetInstance() {
		if(instance == null)
		{
			instance = new CustomerSelectedItems();
		}
		return instance;
	}
	public List<CustomerSelectedItem> getAll() {
		
		EntityManager entitymanager = JPA.GetInstance().getEntityManagerFactory().createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createNamedQuery(DBConstants.NAMED_QUERY_CUSTOMER_SELECTED_ITEMS_FINDALL);
		query.setMaxResults(DBConstants.MAX_SELECT);
		@SuppressWarnings("unchecked")
		List<CustomerSelectedItem> customerSelItemsList = query.getResultList();
		entitymanager.close();	
		return customerSelItemsList;
	}
	public List<CustomerSelectedItem> getByCustomer(Customer customer)
	{	
		if(customer!=null)
		{
			EntityManager entitymanager = JPA.GetInstance().getEntityManagerFactory().createEntityManager();
			entitymanager.getTransaction().begin();
			Query query = entitymanager.createNamedQuery(DBConstants.NAMED_QUERY_CUSTOMER_SELECTED_ITEMS_FIND_BY_CUSTNO);
			query.setParameter("customer", customer);
			//query.setMaxResults(DBConstants.MAX_SELECT);
			@SuppressWarnings("unchecked")
			List<CustomerSelectedItem> CustomerSelectedItemList = query.getResultList();
			entitymanager.close();	
			return CustomerSelectedItemList;
		}
		else
		{
			System.out.println("----------------------CustomerSelectedItem.getByCustomer()-blank values-------------------------");
		}
		return null;
	}	 
}
