package com.algo.action;

import com.algo.model.BST;
import com.algo.model.LinearProbingHashST;
import com.algo.model.SeparateChainingHashST;
import com.algo.service.SortingService;

public class HashtableImplementation {

	public static void main(String[] args) {
		String[] array = SortingService.readFileWithLineSpace("tiny.txt");
//		SeparateChainingHashST<String, Integer> st;
//		st = new SeparateChainingHashST<String, Integer>();
		LinearProbingHashST<String, Integer> st;
		st = new LinearProbingHashST<String, Integer>();
		int i = 0;

		for (String ch : array) {
			st.put(ch, i);
			i++;
		}

		for (String key : st.keys()) {
			System.out.print("Key : " + key + " Value : " + st.get(key));
			System.out.println();
		}
	}

}
