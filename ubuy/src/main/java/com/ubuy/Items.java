package com.ubuy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ubuy.Item.ITEM_UNIT;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class Items {
	private static Items instance=null;
	public static Items GetInstance() {
		if(instance == null)
		{
			instance = new Items();
		}
		return instance;
	}
	public boolean add(String itemname, double rate, ITEM_UNIT unit, double taxrate)
	{
		if(!itemname.isEmpty())
		{
			return new Item(itemname,rate, unit,taxrate).add();
		}
		return false;
	}
	public List<Item> getAll() {
		
		EntityManager entitymanager = JPA.GetInstance().getEntityManagerFactory().createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createNamedQuery(DBConstants.NAMED_QUERY_ITEM_FINDALL);
		query.setMaxResults(DBConstants.MAX_SELECT);
		@SuppressWarnings("unchecked")
		List<Item> itemList = query.getResultList();
		entitymanager.close();	
		return itemList;
	}
	
	public Item getByItemNo(int itemno) {
		
		EntityManager entitymanager = JPA.GetInstance().getEntityManagerFactory().createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createNamedQuery(DBConstants.NAMED_QUERY_ITEM_FINDBY_ITEMNO);
		query.setParameter(Constants.GetInstance().itemno, itemno);
		Item item = (Item) query.getSingleResult();
		entitymanager.close();	
		return item;
	}
	public List<Item> getItemsByName(String itemname) {
		
		EntityManager entitymanager = JPA.GetInstance().getEntityManagerFactory().createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createNamedQuery(DBConstants.NAMED_QUERY_ITEM_FINDBY_LIKE_NAME);
		query.setParameter(Constants.GetInstance().itemname, itemname);
		query.setMaxResults(DBConstants.MAX_SELECT);
		@SuppressWarnings("unchecked")
		List<Item> itemList = query.getResultList();
		entitymanager.close();	
		return itemList;
	}
}
