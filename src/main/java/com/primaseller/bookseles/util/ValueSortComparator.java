package com.primaseller.bookseles.util;

import java.util.Comparator;
import java.util.Map.Entry;

/**
 * This comparator is used to sort the {@link Entry} value in descending order.
 * 
 * @author taurus
 *
 */
public class ValueSortComparator implements Comparator<Entry<String, Integer>> {

	@Override
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		return o2.getValue()-o1.getValue();
	}
}
