package com.algo.client;

import com.algo.model.BST;
import com.algo.model.ST;
import com.algo.service.SortingService;

public class TestClient {

	public static void main(String[] args) {
		String[] array = SortingService.readFileWithLineSpace("tiny.txt");
		BST<String,Integer> st;
		st =new BST<String, Integer>();
		int i=0;
		
		for(String ch: array) {
			st.put(ch, i);
			i++;
		}
		
		for(String key: st.keys()) {
			System.out.print("Key : " +key + "Value : " + st.get(key)+ " Size : "+st.size());
			System.out.println();
		}

		System.out.println(st.ceiling("G"));
	}

}
