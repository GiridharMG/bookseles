package com.primaseller.bookseles.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.primaseller.bookseles.dao.FileDAO;
import com.primaseller.bookseles.dao.SaleDAO;
import com.primaseller.bookseles.dto.SaleBean;
import com.primaseller.bookseles.util.BookSalesFactoryManager;
import com.primaseller.bookseles.util.Constants;

/**
 * This implementation is to read the book details from the given CSV file and
 * convert it to the {@link List} of {@link SaleBean} objects
 * 
 * @author taurus
 *
 */

public class CSVSaleDAOImpl implements SaleDAO {

	@Override
	public List<SaleBean> getSales(String saleFilePath) {
		ArrayList<SaleBean> sales = null;
		FileDAO dao = BookSalesFactoryManager.getFileDAO();
		List<String> lines = dao.readFile(saleFilePath);
		if (lines != null) {
			sales = new ArrayList<SaleBean>();
			for (String line : lines) {
				String[] words = line.split(Constants.SPLIT_CSV_REGEX);
				SaleBean sale = new SaleBean();
				sale.setDate(words[0]);
				sale.setEmail(words[1]);
				sale.setPaymentMethod(words[2]);
				sale.setItemCount(Integer.parseInt(words[3]));
				HashMap<String, Integer> bookIds = new HashMap<String, Integer>();
				for(int i = 4; i < words.length; i++){
					bookIds.put(words[i].split(Constants.SPLIT_ARG_BOOKID_REGEX)[0],
							Integer.parseInt(words[i].split(Constants.SPLIT_ARG_BOOKID_REGEX)[1]));
				}
				sale.setBookIds(bookIds);
				sales.add(sale);
			}
		}
		return sales;
	}

}
