package com.ubuy;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name=DBConstants.ORDERS_TABLE_NAME)
@NamedQueries({
    @NamedQuery(name = DBConstants.NAMED_QUERY_ORDER_FINDBYORDNO,
            query = "SELECT o FROM Order o WHERE o.ordno = :ordno"),
    @NamedQuery(name = DBConstants.NAMED_QUERY_ORDER_FINDBY_CUSTOMER,
    query = "SELECT o FROM Order o WHERE o.goodsPurchaser = :customer"),
    @NamedQuery(name = DBConstants.NAMED_QUERY_ORDER_FINDALL,
            query = "SELECT o FROM Order o")
})
public class Order {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = DBConstants.ORDERS_TABLE_ORDNO, precision = 0)
	private int ordno; 
	@Column(name = DBConstants.ORDERS_TABLE_ORDDATE)
	private LocalDateTime orddate;
	@Column(name = DBConstants.ORDERS_TABLE_SHIPDATE)
	private LocalDateTime shipdate;
	@Column(name = DBConstants.ORDERS_TABLE_DELIVEREDDATE)
	private LocalDateTime deliveredDate;
	@Column(name = DBConstants.ORDERS_TABLE_CANCELDATE)
	private LocalDateTime cancelDate;
	
	@ManyToOne 
	@JoinColumn(name=DBConstants.ORDERS_TABLE_CUSTNO)
	private Customer goodsPurchaser;
	@ManyToOne 
	@JoinColumn(name=DBConstants.ORDERS_TABLE_DELIVERYCUSTNO)
	private Customer goodsDeliveryPerson;
	@Column(name = DBConstants.ORDERS_TABLE_DELIVERY_ORDERSTATE)
	private ORDERSTATE orderState; //'0-pending, 1 - dispatched, 2 - delivered, 3 - canceled',
	@Column(name = DBConstants.ORDERS_TABLE_DELIVERY_ADDRESS1)
	private String address1;
	@Column(name = DBConstants.ORDERS_TABLE_DELIVERY_ADDRESS2)
	private String address2;
	@Column(name = DBConstants.ORDERS_TABLE_DELIVERY_CITY)
	private String city;
	@Column(name = DBConstants.ORDERS_TABLE_DELIVERY_STATE)
	private String state;
	@Column(name = DBConstants.ORDERS_TABLE_DELIVERY_PIN)
	private String pin;
	@Column(name = DBConstants.ORDERS_TABLE_DELIVERY_PHONE)
	private String phone;
	@ManyToOne 
	@JoinColumn(name=DBConstants.ORDERS_TABLE_DPASSIGNEDBY)
	private Customer dpAssignedBy; // dp delivery person
	@Column(name = DBConstants.ORDERS_TABLE_DPASSIGNEDDATE)
	private LocalDateTime dpAssignedDate;
	public enum ORDERSTATE {
		PENDING(0),
		DISPATCHED(1),
		DELIVERED(2),
		CANCELED(3),	
		DPASSIGNED(4);
		private final int value;
	    private ORDERSTATE(int value) {
	        this.value = value;
	    }
	    public int getValue() {
	        return value;
	    }
	}
	
	public Order()
	{
		
	}
	public Order(Customer goodsPurchaser, String address1, String address2,String city, String state, String pin, String phone)
	{
		this.orddate = LocalDateTime.now();
		this.goodsPurchaser = goodsPurchaser;
		this.orderState = ORDERSTATE.PENDING;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.phone = phone;
	}
	public void setOrderNo(int value)
	{
		this.ordno=value;
	}
	public int getOrderNo()
	{
		return this.ordno;
	}
	public void setOrderDate(LocalDateTime value)
	{
		this.orddate=value;
	}
	public LocalDateTime getOrderDate()
	{
		return this.orddate;
	}	
	public void setShipDate(LocalDateTime value)
	{
		this.shipdate=value;
	}
	public LocalDateTime getShipDate()
	{
		return this.shipdate;
	}
	public void setDeliveredDate(LocalDateTime value)
	{
		this.deliveredDate=value;
	}
	public LocalDateTime getDeliveredDate()
	{
		return this.deliveredDate;
	}
	public void setCancelDate(LocalDateTime value)
	{
		this.cancelDate=value;
	}
	public LocalDateTime getCancelDate()
	{
		return this.cancelDate;
	}
	public void setGoodsPurchaser(Customer value)
	{
		this.goodsPurchaser = value;
	}
	public Customer getGoodsPurchaser()
	{
		return this.goodsPurchaser;
	}
	public void setGoodsDeliveryPerson(Customer value)
	{
		this.goodsDeliveryPerson = value;
	}
	public Customer getGoodsDeliveryPerson()
	{
		return this.goodsDeliveryPerson;
	}	
	public void setOrderState(ORDERSTATE value)
	{
		this.orderState = value;
	}
	public ORDERSTATE getOrderState()
	{
		return this.orderState;
	}
	public void setAddress1(String value)
	{
		this.address1=value;
	}
	public String getAddress1()
	{
		return this.address1;
	}
	public void setAddress2(String value)
	{
		this.address2=value;
	}
	public String getAddress2()
	{
		return this.address2;
	}
	public void setCity(String value)
	{
		this.city=value;
	}
	public String getCity()
	{
		return this.city;
	}
	public void setState(String value)
	{
		this.state=value;
	}
	public String getState()
	{
		return this.state;
	}
	public void setPin(String value)
	{
		this.pin=value;
	}
	public String getPin()
	{
		return this.pin;
	}
	public void setPhone(String value)
	{
		this.phone=value;
	}
	public String getPhone()
	{
		return this.phone;
	}
	public void setDPAssignedBy(Customer value)
	{
		this.dpAssignedBy = value;
	}
	public Customer getDPAssignedBy()
	{
		return this.dpAssignedBy;
	}
	public void setDPAssignedDate(LocalDateTime value)
	{
		this.dpAssignedDate=value;
	}
	public LocalDateTime getDPAssignedDate()
	{
		return this.dpAssignedDate;
	}
	public void assignDeliveryPerson(Customer deliveryPerson, Customer dpAssignedBy)
	{
		this.dpAssignedDate = LocalDateTime.now();
		this.goodsDeliveryPerson = deliveryPerson;
		this.orderState = ORDERSTATE.DPASSIGNED;
		this.dpAssignedBy = dpAssignedBy;
	}
}
