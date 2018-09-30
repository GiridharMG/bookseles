package com.primaseller.bookseles.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.primaseller.bookseles.dto.BookBean;
import com.primaseller.bookseles.dto.SaleBean;

/**
 * This is used to filter the {@link List} of {@link SaleBean}
 * 
 * @author taurus
 *
 */
public class BookSalesPrinter {
	/**
	 * This method calculates the total price for a particular date in {@link SaleBean}.
	 * 
	 * @param books
	 * @param sale
	 * @return totalPrice
	 */
	private static double calculateTotalPrice(List<BookBean> books, SaleBean sale) {
		double totalPrice = 0.0;
		for (String id : sale.getBookIds().keySet()) {
			BookBean book = new BookBean();
			book.setId(id);
			totalPrice += sale.getBookIds().get(id) * books.get(books.indexOf(book)).getPrice();
		}
		return totalPrice;
	}
	
	/**
	 * This method print the {@link List} of {@link SaleBean} with given date.
	 * 
	 * @param date
	 * @param sales
	 */
	public static void printWithDate(String date, List<SaleBean> sales, List<BookBean> books) {
		double totalPrice = 0.0;
		for (SaleBean sale : sales) {
			if (sale.getDate().equals(date))
				totalPrice += calculateTotalPrice(books, sale);
		}
		System.out.print("\nsales_on_date\t" + date + "\t" + totalPrice);
	}

	/**
	 * This method print the {@link List} of {@link SaleBean} with given sale count.
	 * 
	 * @param topSaleCount
	 * @param sales
	 */
	public static void printWithSaleCount(int topSaleCount, List<SaleBean> sales) {
		HashMap<String, Integer> bookIds = new HashMap<>();
		for (SaleBean saleBean : sales) {
			Set<String> bookIdSet = saleBean.getBookIds().keySet();
			for (String bookId : bookIdSet) {
				if(bookIds.containsKey(bookId))
					bookIds.put(bookId, bookIds.get(bookId)+saleBean.getBookIds().get(bookId));
				else
					bookIds.put(bookId, saleBean.getBookIds().get(bookId));
			}
		}
		List<Entry<String, Integer>> bookIdSortedList = new ArrayList<Entry<String, Integer>>(bookIds.entrySet());
		Collections.sort(bookIdSortedList, new ValueSortComparator());
		System.out.print("top_selling_books\t");
		for (Entry<String, Integer> bookId : bookIdSortedList) {
			if(topSaleCount>0){
				System.out.print(bookId.getKey() + "\t");
				topSaleCount--;
			}
			else
				break;
		}
	}

	/**
	 * This method print the {@link List} of {@link SaleBean} with given customer count.
	 * 
	 * @param topCustomerCount
	 * @param sales
	 */
	public static void printWithCustomerCount(int topCustomerCount, List<SaleBean> sales) {
		HashMap<String, Integer> customers = new HashMap<>();
		for (SaleBean saleBean : sales) {
			for(int noOfBooks : saleBean.getBookIds().values())
			if(customers.containsKey(saleBean.getEmail()))
				customers.put(saleBean.getEmail(), customers.get(saleBean.getEmail())+noOfBooks);
			else
				customers.put(saleBean.getEmail(), noOfBooks);
		}
		List<Entry<String, Integer>> customerSortedList = new ArrayList<Entry<String, Integer>>(customers.entrySet());
		Collections.sort(customerSortedList, new ValueSortComparator());
		System.out.print("\ntop_customers\t");
		for (Entry<String, Integer> email : customerSortedList) {
			if(topCustomerCount>0){
				System.out.print(email.getKey() + "\t");
				topCustomerCount--;
			}
			else
				break;
		}
	}
}
