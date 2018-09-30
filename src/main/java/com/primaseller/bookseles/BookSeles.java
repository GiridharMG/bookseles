package com.primaseller.bookseles;

import java.util.List;

import com.primaseller.bookseles.dao.BookDAO;
import com.primaseller.bookseles.dao.SaleDAO;
import com.primaseller.bookseles.dto.BookBean;
import com.primaseller.bookseles.dto.SaleBean;
import com.primaseller.bookseles.exception.ResourceNotFoundException;
import com.primaseller.bookseles.util.BookSalesFactoryManager;
import com.primaseller.bookseles.util.BookSalesPrinter;
import com.primaseller.bookseles.util.Constants;

/**
 * {@link BookSeles} is the class which has the main method. This is the entry
 * class for the project.
 * 
 * @author taurus
 */
public class BookSeles {
	/**
	 * This method verifies required resource present in the argument list or
	 * not.
	 * 
	 * If required resource present returns the index. If not throws
	 * {@link ResourceNotFoundException}
	 * 
	 * If non required resource present returns the index. If not return -1
	 * 
	 * @param resource,
	 *            args, required
	 * @return int
	 */
	public static int verifyResource(String resource, String[] args, boolean required) {
		if(args==null)
			throw new ResourceNotFoundException();
		for (int i = 0; i < args.length; i++) {
			if (args[i].contains(resource))
				return i;
		}
		if (required)
			throw new ResourceNotFoundException(resource);
		else
			return -1;
	}

	public static void main(String[] args) {
		int bookIndex = verifyResource(Constants.BOOK_ARG, args, true);
		int saleIndex = verifyResource(Constants.SALE_ARG, args, true);
		int topSaleIndex = verifyResource(Constants.TOP_SALE_ARG, args, false);
		int topCustomerIndex = verifyResource(Constants.TOP_CUSTOMER_ARG, args, false);
		int saleDateIndex = verifyResource(Constants.SALE_DATE_ARG, args, false);

		BookDAO bookDAO = BookSalesFactoryManager.getBookDAO();
		SaleDAO saleDAO = BookSalesFactoryManager.getSaleDAO();

		String bookResource = args[bookIndex].split(Constants.SPLIT_ARG_REGEX)[1];
		String saleResource = args[saleIndex].split(Constants.SPLIT_ARG_REGEX)[1];

		List<BookBean> books = bookDAO.getBooks(bookResource);
		List<SaleBean> sales = saleDAO.getSales(saleResource);

		String topSaleCount = null;
		String topCustomerCount = null;
		String salesDate = null;
		if (topSaleIndex != -1)
			topSaleCount = args[topSaleIndex].split(Constants.SPLIT_ARG_REGEX)[1];
		else
			topSaleCount = "" + sales.size();

		if (topCustomerIndex != -1)
			topCustomerCount = args[topCustomerIndex].split(Constants.SPLIT_ARG_REGEX)[1];
		else
			topCustomerCount = "" + sales.size();

		if (saleDateIndex != -1)
			salesDate = args[saleDateIndex].split(Constants.SPLIT_ARG_REGEX)[1];

		BookSalesPrinter.printWithSaleCount(Integer.parseInt(topSaleCount), sales);
		BookSalesPrinter.printWithCustomerCount(Integer.parseInt(topCustomerCount), sales);
		if (salesDate != null)
			BookSalesPrinter.printWithDate(salesDate, sales, books);
	}
}
