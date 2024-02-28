package com.ubuy;

public class DBConstants {
	static final String PERSISTENCE_UNIT_NAME = "ubuy";
	static final String DB_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/ubuy?allowPublicKeyRetrieval=True&useSSL=false";
	static final String DB_USER = "root";
	static final String DB_PASS = "123456";
	
	static final int MAX_SELECT = 200;
	static final String NAMED_QUERY_CUSTOMER_FINDALL = "Customer.findAll";
	static final String NAMED_QUERY_CUSTOMER_FINDBY_MOBILENO = "Customer.findByMobileno";
	static final String NAMED_QUERY_CUSTOMER_FINDBY_LIKE_MOBILENO = "Customer.findByLikeMobileno";
	static final String NAMED_QUERY_CUSTOMER_FINDBY_LIKE_NAME = "Customer.findByLikeName";
	static final String NAMED_QUERY_CUSTOMER_FINDBY_LIKE_NAME_AND_MOBILENO = "Customer.findByLikeNameAndMobileno";
	static final String NAMED_QUERY_ITEM_FINDALL = "Item.findAll";
	static final String NAMED_QUERY_ITEM_FINDBY_LIKE_NAME = "Item.findByLikeName";
	static final String NAMED_QUERY_ITEM_FINDBY_ITEMNO = "Item.findByItemno";
	
	static final String NAMED_QUERY_ORDER_FINDALL = "Order.findAll";
	static final String NAMED_QUERY_ORDER_FINDBYORDNO = "Order.findByOrdno";
	static final String NAMED_QUERY_ORDERITEM_FINDBYORDER = "Order.findByOrder";
	static final String NAMED_QUERY_ORDERITEM_FINDALL = "Orderitem.findAll";
	static final String NAMED_QUERY_ORDER_FINDBY_CUSTOMER = "Order.findByCustomer";
	
	//Customer table
	static final String CUSTOMER_TABLE_NAME = "customers";
	static final String CUSTOMER_TABLE_COLUMN_CUSTNO = "custno";
	static final String CUSTOMER_TABLE_COLUMN_CUSTNAME = "custname";
	static final String CUSTOMER_TABLE_COLUMN_CUSTTYPE = "custType";
	static final String CUSTOMER_TABLE_COLUMN_MALEFEMALE = "malefemale";
	static final String CUSTOMER_TABLE_COLUMN_MOBILENO = "mobileNo";
	static final String CUSTOMER_TABLE_COLUMN_PASSWORD = "password";
	static final String CUSTOMER_TABLE_COLUMN_EMAILID = "emailid";
	static final String CUSTOMER_TABLE_COLUMN_LOGGEDIN = "loggedin";
	static final String CUSTOMER_TABLE_COLUMN_STREETNAME = "streetName";
	static final String CUSTOMER_TABLE_COLUMN_COLONYNAME = "colonyName";
	static final String CUSTOMER_TABLE_COLUMN_CITY = "city";
	static final String CUSTOMER_TABLE_COLUMN_STATE = "state";
	static final String CUSTOMER_TABLE_COLUMN_PIN = "pin";
	static final String CUSTOMER_TABLE_COLUMN_COUNTRYCODE = "CountryCode";
	
	//Items table
	static final String ITEMS_TABLE_NAME = "items";
	static final String ITEMS_TABLE_COLUMN_ITEMNO = "itemno";
	static final String ITEMS_TABLE_COLUMN_ITEMNAME = "itemname";
	static final String ITEMS_TABLE_COLUMN_RATE = "rate";
	static final String ITEMS_TABLE_COLUMN_UNIT = "unit";
	static final String ITEMS_TABLE_COLUMN_TAXRATE = "taxrate";
	
	//Orders table
	static final String ORDERS_TABLE_NAME = "orders";
	static final String ORDERS_TABLE_ORDNO = "ordno";
	static final String ORDERS_TABLE_ORDDATE = "orddate";
	static final String ORDERS_TABLE_SHIPDATE = "shipdate";
	static final String ORDERS_TABLE_DELIVEREDDATE = "deliveredDate";
	static final String ORDERS_TABLE_DPASSIGNEDDATE = "dpAssignedDate";
	static final String ORDERS_TABLE_CANCELDATE = "cancelDate";
	static final String ORDERS_TABLE_CUSTNO = "custno";
	static final String ORDERS_TABLE_DELIVERYCUSTNO = "deliveryCustNo";
	static final String ORDERS_TABLE_DPASSIGNEDBY = "dpAssignedBy";
	static final String ORDERS_TABLE_DELIVERY_ORDERSTATE = "orderState";
	static final String ORDERS_TABLE_DELIVERY_ADDRESS1 = "address1";
	static final String ORDERS_TABLE_DELIVERY_ADDRESS2 = "address2";
	static final String ORDERS_TABLE_DELIVERY_CITY = "city";
	static final String ORDERS_TABLE_DELIVERY_STATE = "state";
	static final String ORDERS_TABLE_DELIVERY_PIN = "pin";
	static final String ORDERS_TABLE_DELIVERY_PHONE = "phone";
	static final String ORDERS_TABLE_ADDEDBY = "addedBy";
	
	//OrderItems table
	static final String ORDERITEMS_TABLE_NAME = "orderitems";
	static final String ORDERITEMS_TABLE_ORDNO = "ordno";
	static final String ORDERITEMS_TABLE_ITEMNO = "itemno";
	static final String ORDERITEMS_TABLE_QUANTITY = "quantity";
	
	//customer_selected_items table
	static final String CUSTOMER_SELECTED_ITEMS_TABLE_NAME = "customer_selected_items";
	static final String CUSTOMER_SELECTED_ITEMS_TABLE_CUSTNO = "custno";
	static final String CUSTOMER_SELECTED_ITEMS_TABLE_ITEMNO = "itemno";
	static final String CUSTOMER_SELECTED_ITEMS_TABLE_QUANTITY = "quantity";
	static final String NAMED_QUERY_CUSTOMER_SELECTED_ITEMS_FINDALL = "customer_selected_items.findAll";
	static final String NAMED_QUERY_CUSTOMER_SELECTED_ITEMS_FIND_BY_CUSTNO = "customer_selected_items.FindByCustno";
	static final String NAMED_QUERY_CUSTOMER_SELECTED_ITEMS_DELETE_BY_CUSTNO = "customer_selected_items.DeleteByCustno";
}
