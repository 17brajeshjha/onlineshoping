package com.ubuy;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * The primary key class for the orderitems database table.
 * 
 */
@Embeddable
public class OrderitemPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int ordno;

	@Column(insertable=false, updatable=false)
	private int itemno;

	public OrderitemPK() {
	}
	public int getOrdno() {
		return this.ordno;
	}
	public void setOrdno(int ordno) {
		this.ordno = ordno;
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
		OrderitemPK castOther = (OrderitemPK)other;
		return 
			(this.ordno == castOther.ordno)
			&& (this.itemno == castOther.itemno);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.ordno;
		hash = hash * prime + this.itemno;
		
		return hash;
	}
}