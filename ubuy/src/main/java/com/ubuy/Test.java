package com.ubuy;

import java.util.List;

import jakarta.persistence.EntityManager;

public class Test {
	public void testCustomer() {
		List<Customer> custlist = Customers.GetInstance().getAll();
		for (Customer c : custlist) {
			System.out.println(c.getMobileNo());
			System.out.println(Customers.GetInstance().getByMobileNo(c.getMobileNo()).getCustName());
		}
	}

	public void testItem() {
		new Item("saktibhog besan",45.0, Item.ITEM_UNIT.PACKET,0.0).add();
		
		List<Item> itlist = Items.GetInstance().getAll();
		for (Item i : itlist) {
			System.out.println("Item no: "+i.getItemNo()+" Item name: "+i.getItemName());
		}
	}
	
	public void testOrders() {
		/*
		 * new Order(Customers.GetInstance().getByMobileNo("8130274916"),"gali no 16"
		 * ,"25 futta road","mukundpur","delhi","110042","8130274916").add();
		 * 
		 * List<Order> orderlist = Orders.GetInstance().getAll(); for (Order order :
		 * orderlist) {
		 * System.out.println("Order no: "+order.getOrderNo()+" Customer name: "+order.
		 * getGoodsPurchaser().getCustName()); }
		 */
	}
	
	public void testOrderItems()
	{
		//System.out.println("testOrderItems");
		
		EntityManager entitymanager = JPA.GetInstance().getEntityManagerFactory().createEntityManager();
		entitymanager.getTransaction().begin();
		Order order = new Order(Customers.GetInstance().getByMobileNo("8130274916"), "gali no 16", "25 futta road",
				"mukundpur", "delhi", "110042", "8130274916");
		entitymanager.persist(order);
		entitymanager.persist(new OrderItem(order, Items.GetInstance().getAll().get(0), 10));
		entitymanager.getTransaction().commit();
		entitymanager.close();
		
		List<OrderItem> orderitemlist = OrderItems.GetInstance().getAll();
		for (OrderItem orderitem : orderitemlist) {
			System.out.println(orderitem.getOrder().getGoodsPurchaser().getCustName()+" Placed Order no: "+orderitem.getOrder().getOrderNo()+" Item name: "+orderitem.getItem().getItemName()+" Rate: "+orderitem.getItem().getRate()+" per "+orderitem.getItem().getUnit().toString()+" Quantity:"+orderitem.getQuantity());
		}
		 
	}
	public static void main(String[] args) {
	  
	  //new Test().testOrderItems();
	  
	  //JPA.GetInstance().getEntityManagerFactory().close(); 
	}	 
}