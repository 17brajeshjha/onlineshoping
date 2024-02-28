package com.ubuy;

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
/*
 * @NamedQuery(name = "User.checkLogin", query = "SELECT u FROM User u WHERE u.email = ?1 AND password = ?2")
 * String queryName = "User.checkLogin";
	String email = "tom@gmail.com";
	String pass = "tomsecret1";
	 
	Query query = entityManager.createNamedQuery(queryName);
	query.setParameter(1, email);
	query.setParameter(2, pass);
	 
	User user = (User) query.getSingleResult();
*/
@Entity
@Table(name=DBConstants.CUSTOMER_TABLE_NAME)
@NamedQueries({
    @NamedQuery(name = DBConstants.NAMED_QUERY_CUSTOMER_FINDBY_MOBILENO,
            query = "SELECT c FROM Customer c WHERE c.mobileno = :mobileno"),
    @NamedQuery(name = DBConstants.NAMED_QUERY_CUSTOMER_FINDBY_LIKE_MOBILENO,
    		query = "SELECT c FROM Customer c WHERE c.mobileno LIKE CONCAT('%',:mobileno,'%')"),
    @NamedQuery(name = DBConstants.NAMED_QUERY_CUSTOMER_FINDBY_LIKE_NAME,
	query = "SELECT c FROM Customer c WHERE c.name LIKE CONCAT('%',:name,'%')"),
    @NamedQuery(name = DBConstants.NAMED_QUERY_CUSTOMER_FINDBY_LIKE_NAME_AND_MOBILENO,
	query = "SELECT c FROM Customer c WHERE c.name LIKE CONCAT('%',:name,'%') AND c.mobileno LIKE CONCAT('%',:mobileno,'%')"),
    @NamedQuery(name = DBConstants.NAMED_QUERY_CUSTOMER_FINDALL,
            query = "SELECT c FROM Customer c")
})
public class Customer {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //@Column(name = "ID", columnDefinition = "Decimal(10,0)")
	@Column(name = DBConstants.CUSTOMER_TABLE_COLUMN_CUSTNO, precision = 0)
	private int custno;
	@Column(name=DBConstants.CUSTOMER_TABLE_COLUMN_CUSTNAME)
	private String name;
	@Column(name=DBConstants.CUSTOMER_TABLE_COLUMN_MOBILENO)
	private String mobileno;
	@Column(name=DBConstants.CUSTOMER_TABLE_COLUMN_PASSWORD)
	private String password;
	@Column(name=DBConstants.CUSTOMER_TABLE_COLUMN_CUSTTYPE)
	private CUSTOMER_TYPE customertype; // 0 admin, 1 purchaser, 2 goods delivery person
	@Column(name=DBConstants.CUSTOMER_TABLE_COLUMN_EMAILID)
	private String emailid;
	@Column(name=DBConstants.CUSTOMER_TABLE_COLUMN_LOGGEDIN)
	private boolean loggedin;
	@Column(name=DBConstants.CUSTOMER_TABLE_COLUMN_MALEFEMALE)
	private MALEORFEMALE malefemale; // 0 male, 1 female
	@Column(name=DBConstants.CUSTOMER_TABLE_COLUMN_COUNTRYCODE)
	private String country;
	@Column(name=DBConstants.CUSTOMER_TABLE_COLUMN_STATE)
	private String state;
	@Column(name=DBConstants.CUSTOMER_TABLE_COLUMN_CITY)
	private String city;
	@Column(name=DBConstants.CUSTOMER_TABLE_COLUMN_COLONYNAME)
	private String colonyname;
	@Column(name=DBConstants.CUSTOMER_TABLE_COLUMN_STREETNAME)
	private String streetname;
	@Column(name=DBConstants.CUSTOMER_TABLE_COLUMN_PIN)
	private String pin;
	@ManyToOne 
	@JoinColumn(name=DBConstants.ORDERS_TABLE_ADDEDBY)
	private Customer addedBy;
	public enum MALEORFEMALE {
		MALE(0),
		FEMALE(1);
		private final int value;
	    private MALEORFEMALE(int value) {
	        this.value = value;
	    }

	    public int getValue() {
	        return value;
	    }
	}
	public enum CUSTOMER_TYPE {
		ADMIN(0),
		SENIOR_ADMIN(1),
		JUNIOR_ADMIN(2),
		PURCHASER(3),
		GOODS_DELIVERY_PERSON(4);
		private final int value;
	    private CUSTOMER_TYPE(int value) {
	        this.value = value;
	    }

	    public int getValue() {
	        return value;
	    }
	}
	public Customer() {
		
	}
	public Customer(int custno,String mobileNo) {
		this.custno = custno;
		this.mobileno=mobileNo;
	}
	public Customer(String mobileno, String password) {
		this.mobileno= mobileno;
		this.password=password;
	}
	public Customer(String custname,String custType,String malefemale,String mobileNo,String password,String emailid,String streetName,String colonyName,String city,String state,String pin,String country,Customer addedBy)
	{
		this.name=custname;
		//System.out.println("Customer.Customer name: " + this.name+" password: "+password);
		this.mobileno=mobileNo;
		this.password=password;
		
		if(custType.matches(Constants.GetInstance().admin))
			customertype=CUSTOMER_TYPE.ADMIN;
		else if(custType.matches(Constants.GetInstance().senior_admin))
			customertype=CUSTOMER_TYPE.SENIOR_ADMIN;
		else if(custType.matches(Constants.GetInstance().junior_admin))
			customertype=CUSTOMER_TYPE.JUNIOR_ADMIN;
		else if(custType.matches(Constants.GetInstance().purchaser))
			customertype=CUSTOMER_TYPE.PURCHASER;
		else if(custType.matches(Constants.GetInstance().delivery_person))
			customertype=CUSTOMER_TYPE.GOODS_DELIVERY_PERSON;
		
		this.emailid=emailid;
		this.loggedin=true;
		
		//System.out.println("Customer.Customer malefemale: " + malefemale);
			
		this.malefemale = (malefemale.matches(Constants.GetInstance().male))?MALEORFEMALE.MALE:MALEORFEMALE.FEMALE;
		 
		//System.out.println("Customer.Customer malefemale: " + this.malefemale);
		
		this.country=country;
		this.state=state;
		this.city=city;
		this.colonyname=colonyName;
		this.streetname=streetName;
		this.pin=pin;
		this.addedBy = addedBy;
	}

	public int getCustNo()
	{
		return this.custno;
	}
	public void setCustNo(int value)
	{
		this.custno = value;
	}
	public String getCustName()
	{
		return this.name;
	}
	public void setCustName(String value)
	{
		this.name = value;
	}
	public CUSTOMER_TYPE getCustType()
	{
		return this.customertype;
	}
	public void setCustType(CUSTOMER_TYPE value)
	{
		this.customertype = value;
	}
	public MALEORFEMALE getMaleFemale()
	{
		return this.malefemale;
	}
	public void setMaleFemale(MALEORFEMALE value)
	{
		this.malefemale = value;
	}

	public String getMobileNo()
	{
		return this.mobileno;
	}
	public void setMobileNo(String value)
	{
		this.mobileno = value;
	}

	public String getPassword()
	{
		return this.password;
	}
	public void setPassword(String value)
	{
		this.password = value;
	}
	public String getEmailid()
	{
		return this.emailid;
	}
	public void setEmailid(String value)
	{
		this.emailid = value;
	}

	public boolean getLoggedin()
	{
		return this.loggedin;
	}
	public void setLoggedin(boolean value)
	{
		this.loggedin = value;
	}
	public String getStreetName()
	{
		return this.streetname;
	}
	public void setStreetName(String value)
	{
		this.streetname = value;
	}
	public String getColonyName()
	{
		return this.colonyname;
	}
	public void setColonyName(String value)
	{
		this.colonyname = value;
	}
	public String getCity()
	{
		return this.city;
	}
	public void setCity(String value)
	{
		this.city = value;
	}
	public String getState()
	{
		return this.state;
	}
	public void setState(String value)
	{
		this.state = value;
	}
	public String getPin()
	{
		return this.pin;
	}
	public void setPin(String value)
	{
		this.pin = value;
	}
	public String getCountry()
	{
		return this.country;
	}
	public void setCountry(String value)
	{
		this.country = value;
	}
	public Customer getAddedBy()
	{
		return this.addedBy;
	}
	public void setAddedBy(Customer value)
	{
		this.addedBy = value;
	}
	public boolean add() {
		boolean result = false;
		try
		{
			if(name!=null && mobileno!=null && password!=null && !name.isEmpty()&&!mobileno.isEmpty()&&!password.isEmpty())
			{
				Customer cust = new Customer();
				cust.setCustName(name);
				cust.setMobileNo(mobileno);
				cust.setPassword(password);
				cust.setCustType(customertype);
				cust.setEmailid(emailid);
				cust.setLoggedin(false);
				cust.setMaleFemale(malefemale); 
				//System.out.println("Customer.GetByMobileNo malefemale: " + cust.malefemale);
				cust.setCountry(country);
				cust.setState(state);
				cust.setCity(city);
				cust.setColonyName(colonyname);
				cust.setStreetName(streetname);
				cust.setPin(pin);
				cust.setAddedBy(addedBy);
				
				EntityManager entitymanager = JPA.GetInstance().getEntityManagerFactory().createEntityManager();
				entitymanager.getTransaction( ).begin( );
				entitymanager.persist(cust);
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
