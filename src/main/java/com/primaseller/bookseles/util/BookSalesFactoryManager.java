package com.primaseller.bookseles.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.primaseller.bookseles.dao.BookDAO;
import com.primaseller.bookseles.dao.FileDAO;
import com.primaseller.bookseles.dao.SaleDAO;

/**
 * This class is used to create the objects of type {@link BookDAO}, {@link SaleDAO}
 * and {@link FileDAO} interfaces. This class uses factory design pattern to achieve
 * dependency injection design pattern.
 * 
 * @author taurus
 *
 */
public class BookSalesFactoryManager {
	/**
	 * Since all the methods are public and static no need to create the objects.
	 */
	private BookSalesFactoryManager() {}
	private static final Properties PROPERTIES;
	
	static {
		PROPERTIES = new Properties();
		try {
			PROPERTIES.load(new FileReader(Constants.BOOK_SALE_CONFIG_PATH));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This method is to create the object of type {@link FileDAO} by reading the 
	 * properties file
	 * 
	 * @return {@link FileDAO}
	 */
	public static FileDAO getFileDAO() {
		try {
			return (FileDAO)Class
						.forName(PROPERTIES.getProperty(Constants.FILE_CONFIG))
						.newInstance();
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * This method is to create the object of type {@link BookDAO} by reading the 
	 * properties file
	 * 
	 * @return {@link BookDAO}
	 */
	public static BookDAO getBookDAO() {
		try {
			return (BookDAO)Class
						.forName(PROPERTIES.getProperty(Constants.BOOK_CONFIG))
						.newInstance();
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * This method is to create the object of type {@link SaleDAO} by reading the 
	 * properties file
	 * 
	 * @return {@link SaleDAO}
	 */
	public static SaleDAO getSaleDAO() {
		try {
			return (SaleDAO)Class
						.forName(PROPERTIES.getProperty(Constants.SALE_CONFIG))
						.newInstance();
		} catch (Exception e) {
			return null;
		}
	}
}
