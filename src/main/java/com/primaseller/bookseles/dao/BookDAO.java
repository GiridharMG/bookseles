package com.primaseller.bookseles.dao;

import java.util.List;

import com.primaseller.bookseles.dto.BookBean;

public interface BookDAO {
	/**
	 * This method is to get all the book details from the file and return it as 
	 * {@link List} of {@link BookBean}. If the given path is wrong then return null.
	 * 
	 * @param bookFilePath
	 * @return
	 */
	List<BookBean> getBooks(String bookFilePath);
}
