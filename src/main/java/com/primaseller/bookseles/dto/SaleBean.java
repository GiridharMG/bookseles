package com.primaseller.bookseles.dto;

import java.util.Map;

/**
 * This class is used to transfer the sale data of {@link BookBean} 
 * 
 * @author taurus
 *
 */
public class SaleBean {
	private String date;
	private String email;
	private String paymentMethod;
	private int itemCount;
	private Map<String, Integer> bookIds;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	public Map<String, Integer> getBookIds() {
		return bookIds;
	}
	public void setBookIds(Map<String, Integer> bookIds) {
		this.bookIds = bookIds;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + itemCount;
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
		SaleBean other = (SaleBean) obj;
		if (itemCount != other.itemCount)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SaleBean [date=" + date + ", email=" + email + ", paymentMethod=" + paymentMethod + ", itemCount="
				+ itemCount + ", bookIds=" + bookIds + "]";
	}
}
