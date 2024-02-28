package com.ubuy;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * The primary key class for the orderitems database table.
 * 
 */
@Embeddable
public class CustomerSelectedItemPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int custno;

	@Column(insertable=false, updatable=false)
	private int itemno;

	public CustomerSelectedItemPK() {
	}
	public int getCustno() {
		return this.custno;
	}
	public void setCustno(int custno) {
		this.custno = custno;
	}
	public int getItemno() {
		return this.itemno;
	}
	public void setItemno(int itemno) {
		this.itemno = itemno;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OrderitemPK)) {
			return false;
		}
		CustomerSelectedItemPK castOther = (CustomerSelectedItemPK)other;
		return 
			(this.custno == castOther.custno)
			&& (this.itemno == castOther.itemno);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.custno;
		hash = hash * prime + this.itemno;
		
		return hash;
	}
}