package com.ubuy;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class Orders {
	private static Orders instance=null;
	public static Orders GetInstance() {
		if(instance == null)
		{
			instance = new Orders();
		}
		return instance;
	}
	public boolean purchaseOrder(List<CustomerSelectedItem> csiList, Customer goodsPurchaser, String address1, String address2, String city,String state, String pin,String phone)
	{
		boolean res = true;
		try
		{
			Order ord = new Order(goodsPurchaser, address1, address2,city, state, pin, phone);
			EntityManager entitymanager = JPA.GetInstance().getEntityManagerFactory().createEntityManager();
			entitymanager.getTransaction( ).begin( );
			entitymanager.persist(ord);
			for(int i=0;i<csiList.size();i++)
			{
				entitymanager.persist(new OrderItem(ord,csiList.get(i).getItem(),csiList.get(i).getQuantity()));
				
				CustomerSelectedItemPK pk = new CustomerSelectedItemPK();
				pk.setCustno(goodsPurchaser.getCustNo());
				pk.setItemno(csiList.get(i).getItem().getItemNo());
				CustomerSelectedItem csi = entitymanager.find(CustomerSelectedItem.class, pk);
				entitymanager.remove(csi);
			}
			entitymanager.getTransaction().commit();
	        entitymanager.close();
	        
	        //CustomerSelectedItems.GetInstance().deleteByCustomer(goodsPurchaser);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			res = false;
		}
		return res;
	}
	public List<Order> getAll() {
		
		EntityManager entitymanager = JPA.GetInstance().getEntityManagerFactory().createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createNamedQuery(DBConstants.NAMED_QUERY_ORDER_FINDALL);
		query.setMaxResults(DBConstants.MAX_SELECT);
		@SuppressWarnings("unchecked")
		List<Order> orderList = query.getResultList();
		entitymanager.close();	
		return orderList;
	}
	public List<Order> getByCustomer(Customer customer)
	{	
		if(customer!=null)
		{
			EntityManager entitymanager = JPA.GetInstance().getEntityManagerFactory().createEntityManager();
			entitymanager.getTransaction().begin();
			Query query = entitymanager.createNamedQuery(DBConstants.NAMED_QUERY_ORDER_FINDBY_CUSTOMER);
			query.setParameter("customer", customer);
			//query.setMaxResults(DBConstants.MAX_SELECT);
			@SuppressWarnings("unchecked")
			List<Order> orderList = query.getResultList();
			entitymanager.close();	
			return orderList;
		}
		else
		{
			System.out.println("----------------------Orders.getByCustomer()-blank values-------------------------");
		}
		return null;
	}	 
}
