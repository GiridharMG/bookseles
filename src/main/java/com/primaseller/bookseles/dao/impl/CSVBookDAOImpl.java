package com.primaseller.bookseles.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.primaseller.bookseles.dao.BookDAO;
import com.primaseller.bookseles.dao.FileDAO;
import com.primaseller.bookseles.dto.BookBean;
import com.primaseller.bookseles.util.BookSalesFactoryManager;
import com.primaseller.bookseles.util.Constants;

/**
 * This implementation is to read the book details from the given CSV file and
 * convert it to the {@link List} of {@link BookBean} objects
 * 
 * @author taurus
 *
 */
public class CSVBookDAOImpl implements BookDAO {

	@Override
	public List<BookBean> getBooks(String bookFilePath) {
		ArrayList<BookBean> books = null;
		FileDAO dao = BookSalesFactoryManager.getFileDAO();
		List<String> lines = dao.readFile(bookFilePath);
		if (lines != null) {
			books = new ArrayList<BookBean>();
			for (String line : lines) {
				String[] words = line.split(Constants.SPLIT_CSV_REGEX);
				BookBean book = new BookBean();
				book.setId(words[0]);
				book.setTitle(words[1]);
				book.setAuthor(words[2]);
				book.setPrice(Double.parseDouble(words[3]));
				books.add(book);
			}
		}
		return books;
	}
}
