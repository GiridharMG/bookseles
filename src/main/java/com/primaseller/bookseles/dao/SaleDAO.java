package com.primaseller.bookseles.dao;

import java.util.List;

import com.primaseller.bookseles.dto.SaleBean;

public interface SaleDAO {
	/**
	 * This method is to get all the sales details from the file and return it as 
	 * {@link List} of {@link SaleBean}. If the given path is wrong then return null.
	 * 
	 * @param saleFilePath
	 * @return {@link List<Sale>}
	 */
	List<SaleBean> getSales(String saleFilePath);
}
