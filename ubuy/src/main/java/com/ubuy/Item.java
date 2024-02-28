package com.ubuy;

import java.sql.SQLException;

import com.ubuy.Database.DBResultSet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
@Entity
@Table(name=DBConstants.ITEMS_TABLE_NAME)
@NamedQueries({
	@NamedQuery(name = DBConstants.NAMED_QUERY_ITEM_FINDBY_LIKE_NAME,
			query = "SELECT i FROM Item i WHERE i.itemname LIKE CONCAT('%',:itemname,'%')"),
	@NamedQuery(name = DBConstants.NAMED_QUERY_ITEM_FINDBY_ITEMNO,
	query = "SELECT i FROM Item i WHERE i.itemno = :itemno"),
    @NamedQuery(name = DBConstants.NAMED_QUERY_ITEM_FINDALL,
            query = "SELECT i FROM Item i")
})
public class Item {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = DBConstants.ITEMS_TABLE_COLUMN_ITEMNO, precision = 0)
	private int itemno;
	@Column(name = DBConstants.ITEMS_TABLE_COLUMN_ITEMNAME)
	private String itemname;
	@Column(name = DBConstants.ITEMS_TABLE_COLUMN_RATE)
	private double rate; // price rate
	@Column(name = DBConstants.ITEMS_TABLE_COLUMN_UNIT)
	private ITEM_UNIT unit; // measurement unit
	@Column(name = DBConstants.ITEMS_TABLE_COLUMN_TAXRATE)
	private double taxrate;
	
	public enum ITEM_UNIT {
		PACKET(0),
		KG(1),
		LITTER(2);	
		private final int value;
	    private ITEM_UNIT(int value) {
	        this.value = value;
	    }

	    public int getValue() {
	        return value;
	    }
	}
	public Item() {
	}
	public Item(String itemname, double rate, ITEM_UNIT unit, double taxrate) {
		this.itemname = itemname;
		this.rate = rate;
		this.unit = unit;
		this.taxrate = taxrate;
	}
	public Item(int itemno, String itemname, double rate, ITEM_UNIT unit, double taxrate) {
		this.itemno = itemno;
		this.itemname = itemname;
		this.rate = rate;
		this.unit = unit;
		this.taxrate = taxrate;
	}
	public void setItemNo(int value)
	{
		this.itemno=value;
	}
	public int getItemNo()
	{
		return this.itemno;
	}
	public void setItemName(String value)
	{
		this.itemname=value;
	}
	public String getItemName()
	{
		return this.itemname;
	}
	public void setRate(double value)
	{
		this.rate=value;
	}
	public double getRate()
	{
		return this.rate;
	}
	public void setUnit(ITEM_UNIT value)
	{
		this.unit=value;
	}
	public ITEM_UNIT getUnit()
	{
		return this.unit;
	}
	public void setTaxRate(double value)
	{
		this.taxrate=value;
	}
	public double getTaxRate()
	{
		return this.taxrate;
	}
	public boolean add() {
		boolean result = false;
		try
		{
			if(itemname!=null && !itemname.isEmpty())
			{
				Item item = new Item();
				item.setItemName(itemname);
				item.setRate(rate);
				item.setUnit(unit);
				item.setTaxRate(taxrate);
				
				EntityManager entitymanager = JPA.GetInstance().getEntityManagerFactory().createEntityManager();
				entitymanager.getTransaction( ).begin( );
				entitymanager.persist(item);
				entitymanager.getTransaction().commit();
		        entitymanager.close();
		        result = true;
			}
			else
			{
				System.out.println("---------------------Customer.Add()--blank values-------------------------");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
        
        return result;
	}
}
