package com.training.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class KeyObject implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1984067781320099307L;

	private String x;
	
	private String y;

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
		         * result
		         + ((x == null) ? 0 : x.hashCode());
		result = prime
		         * result
		         + ((y == null) ? 0 : y.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KeyObject other = (KeyObject) obj;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}
	
	
}
