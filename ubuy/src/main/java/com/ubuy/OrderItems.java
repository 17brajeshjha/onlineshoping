package com.ubuy;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class OrderItems {
	private static OrderItems instance=null;
	public static OrderItems GetInstance() {
		if(instance == null)
		{
			instance = new OrderItems();
		}
		return instance;
	}
	public List<OrderItem> getAll() {
		
		EntityManager entitymanager = JPA.GetInstance().getEntityManagerFactory().createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createNamedQuery(DBConstants.NAMED_QUERY_ORDERITEM_FINDALL);
		query.setMaxResults(DBConstants.MAX_SELECT);
		@SuppressWarnings("unchecked")
		List<OrderItem> orderITemsList = query.getResultList();
		entitymanager.close();	
		return orderITemsList;
	}
	
	public List<OrderItem> getByOrder(Order order)
	{	
		if(order!=null)
		{
			EntityManager entitymanager = JPA.GetInstance().getEntityManagerFactory().createEntityManager();
			entitymanager.getTransaction().begin();
			Query query = entitymanager.createNamedQuery(DBConstants.NAMED_QUERY_ORDERITEM_FINDBYORDER);
			query.setParameter("order", order);
			//query.setMaxResults(DBConstants.MAX_SELECT);
			@SuppressWarnings("unchecked")
			List<OrderItem> orderItemList = query.getResultList();
			entitymanager.close();	
			return orderItemList;
		}
		else
		{
			System.out.println("----------------------OrderItems.getByOrder()-blank values-------------------------");
		}
		return null;
	}	 
}
