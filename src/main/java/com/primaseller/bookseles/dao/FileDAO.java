package com.primaseller.bookseles.dao;

import java.util.List;

public interface FileDAO {
	/**
	 * This method is to read the file with the specified path from the file system
	 * and return the content of the file as {@link List<String>}. Each index of the 
	 * {@link List} represents a line in the file.
	 * 
	 * If the file path is wrong then it returns null.
	 *  
	 * @param bookFilePath
	 * @return {@link List<String>}
	*/
	List<String> readFile(String filePath);
}
