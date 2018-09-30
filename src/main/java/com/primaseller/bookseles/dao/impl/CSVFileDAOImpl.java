package com.primaseller.bookseles.dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.primaseller.bookseles.dao.FileDAO;

/**
 * This implementation class is for reading the CSV file which is present in given path.
 * 
 * @author taurus
 *
 */
public class CSVFileDAOImpl implements FileDAO {

	@Override
	public List<String> readFile(String filePath) {
		ArrayList<String> lines = null;
		try(FileReader fileReader = new FileReader(filePath);
				BufferedReader reader = new BufferedReader(fileReader)) {
			
			lines = new ArrayList<String>();
			while(reader.ready())
				lines.add(reader.readLine());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return lines;
	}
	
}
