package com.ubuy;

import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;

public class Customers {
	private static Customers instance=null;
	public static Customers GetInstance() {
		if(instance == null)
		{
			instance = new Customers();
		}
		return instance;
	}
	public boolean add(String custname,String custType,String malefemale,String mobileNo,String password,String emailid,String streetName,String colonyName,String city,String state,String pin,String country,Customer addedBy)
	{
		if(custType.matches(Constants.GetInstance().admin)||
				custType.matches(Constants.GetInstance().purchaser)||
						custType.matches(Constants.GetInstance().delivery_person))
		{
			Customer customer = new Customer(custname, custType, malefemale, mobileNo, password, emailid, streetName,
					colonyName, city, state, pin, country,addedBy);
			return customer.add();
		}
		return false;
	}
	
	public List<Customer> getAll() {
		
		EntityManager entitymanager = JPA.GetInstance().getEntityManagerFactory().createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createNamedQuery(DBConstants.NAMED_QUERY_CUSTOMER_FINDALL);
		query.setMaxResults(DBConstants.MAX_SELECT);
		@SuppressWarnings("unchecked")
		List<Customer> custList = query.getResultList();
		entitymanager.close();	
		return custList;
	}
	public Customer getByMobileNo(String mobileno)
	{
		if(mobileno!=null && !mobileno.isEmpty())
		{
			EntityManager entitymanager = JPA.GetInstance().getEntityManagerFactory().createEntityManager();
			entitymanager.getTransaction().begin();
			
			Query query = entitymanager.createNamedQuery(DBConstants.NAMED_QUERY_CUSTOMER_FINDBY_MOBILENO);  
			query.setParameter(Constants.GetInstance().mobileno, mobileno);
			Customer cust = (Customer) query.getSingleResult();
			
	        //System.out.println("Customer name "+cust.getCustName());  
	          
			entitymanager.close();	
			return cust;
		}
		else
		{
			System.out.println("----------------------Customer.GetByMobileNo()-blank values-------------------------");
		}
		return null;
	}
	public List<Customer> getByLikeMobileNo(String mobileno)
	{
		if(mobileno!=null && !mobileno.isEmpty())
		{
			EntityManager entitymanager = JPA.GetInstance().getEntityManagerFactory().createEntityManager();
			entitymanager.getTransaction().begin();
			Query query = entitymanager.createNamedQuery(DBConstants.NAMED_QUERY_CUSTOMER_FINDBY_LIKE_MOBILENO);
			query.setParameter(Constants.GetInstance().mobileno, mobileno);
			//query.setMaxResults(DBConstants.MAX_SELECT);
			@SuppressWarnings("unchecked")
			List<Customer> custList = query.getResultList();
			entitymanager.close();	
			return custList;
		}
		else
		{
			System.out.println("----------------------Customer.getByLikeMobileNo()-blank values-------------------------");
		}
		return null;
	}
	public List<Customer> getByLikeName(String name)
	{
		
		if(name!=null && !name.isEmpty())
		{
			EntityManager entitymanager = JPA.GetInstance().getEntityManagerFactory().createEntityManager();
			entitymanager.getTransaction().begin();
			Query query = entitymanager.createNamedQuery(DBConstants.NAMED_QUERY_CUSTOMER_FINDBY_LIKE_NAME);
			query.setParameter(Constants.GetInstance().name, name);
			//query.setMaxResults(DBConstants.MAX_SELECT);
			@SuppressWarnings("unchecked")
			List<Customer> custList = query.getResultList();
			entitymanager.close();	
			return custList;
		}
		else
		{
			System.out.println("----------------------Customer.GetByLikeName()-blank values-------------------------");
		}
		return null;
	}
	public List<Customer> getByLikeNameAndMobile(String name, String mobileno)
	{
		if(name!=null && !name.isEmpty() && mobileno!=null && !mobileno.isEmpty())
		{
			EntityManager entitymanager = JPA.GetInstance().getEntityManagerFactory().createEntityManager();
			entitymanager.getTransaction().begin();
			Query query = entitymanager.createNamedQuery(DBConstants.NAMED_QUERY_CUSTOMER_FINDBY_LIKE_NAME_AND_MOBILENO);
			query.setParameter(Constants.GetInstance().name, name);
			query.setParameter(Constants.GetInstance().mobileno, mobileno);
			//query.setMaxResults(DBConstants.MAX_SELECT);
			@SuppressWarnings("unchecked")
			List<Customer> custList = query.getResultList();
			entitymanager.close();	
			return custList;
		}
		else
		{
			System.out.println("----------------------Customer.GetByLikeName()-blank values-------------------------");
		}
		return null;
	}
}
