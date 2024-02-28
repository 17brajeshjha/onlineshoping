//JPA tutorial: https://www.javaguides.net/p/jpa-tutorial-java-persistence-api.html
package com.ubuy;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPA {
	private static final String PERSISTENCE_UNIT_NAME = "ubuy";
	private EntityManagerFactory factory;
	private static JPA instance=null;
	public JPA()
	{
		try
		{
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		catch(Exception e)
		{
			System.out.println("JPA()------------------"+e+"---------------JPA()");
		}
	}
	public static JPA GetInstance() {
		if(instance == null)
		{
			instance = new JPA();
		}
		return instance;
	}	
	public EntityManagerFactory getEntityManagerFactory()
	{
		return factory;
	}
}
