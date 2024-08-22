package com.algo.client;

import com.algo.model.ST;
import com.algo.service.SortingService;

public class TestClient {

	public static void main(String[] args) {
		String[] array = SortingService.readFileWithLineSpace("tiny.txt");
		ST<String,Integer> st;
		st =new ST<String, Integer>();
		int i=0;
		
		for(String ch: array) {
			st.put(ch, i);
			i++;
		}
		
		for(String key: st.keys()) {
			System.out.print(key + " " + st.get(key));
			System.out.println();
		}

	}

}
