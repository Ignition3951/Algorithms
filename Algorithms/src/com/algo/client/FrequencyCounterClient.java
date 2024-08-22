package com.algo.client;

import com.algo.model.ST;
import com.algo.service.SortingService;

public class FrequencyCounterClient {

	public static void main(String[] args) {
		String[] array = SortingService.readFileWithLineSpace("tale.txt");
		int minLength = Integer.parseInt(args[0]);
		ST<String, Integer> st;
		st = new ST<String, Integer>();
		int distinct = 0, frequency = 0;
		String maxWord="tale";

		for (String ch : array) {
			if (ch.length() > minLength) {
				if (st.get(ch) != null) {
					st.put(ch, st.get(ch) + 1);
				} else {
					st.put(ch, 1);
					distinct++;
				}
			}
		}
		for(String key: st.keys()) {
			if(st.get(key)>frequency) {
				maxWord=key;
				frequency=st.get(key);
			}
		}

		System.out.print("Frequency for the word (according to length provided) "+maxWord
				+ " occuring the most is : "+frequency);
	}

}
